package com.hyman.common.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.hyman.common.constant.CommonConstants;
import com.hyman.common.enums.RedisKeyEnum;
import com.hyman.common.exception.BaseException;
import com.hyman.common.feign.IBaseFeign;
import com.hyman.common.model.dto.base.UserDTO;
import com.hyman.common.model.dto.common.ConvertDTO;
import com.hyman.common.model.dto.common.RedisQueryParamDTO;
import com.hyman.common.model.dto.line.AreaItemDTO;
import com.hyman.common.model.vo.base.DictDataVO;
import com.hyman.common.model.vo.base.DutyRoleInfo;
import com.hyman.common.model.vo.base.RedisUserInfoVO;
import com.hyman.common.model.vo.base.StaffInfoVO;
import com.hyman.common.msg.Result;
import com.hyman.common.service.GlobalBaseService;
import com.hyman.common.util.qiyuesuosdk.lang.CollectionUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.hyman.common.constant.CommonConstants.REDIS_BASE_DICT_PREFIX;

/**
 * @author:
 * @create: 2019-03-22
 * @description: 编码转成中文工具类
 **/
@Component
public class ConvertCodeIntoChnUtil {

    private final Logger logger = LoggerFactory.getLogger(ConvertCodeIntoChnUtil.class);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private IBaseFeign iBaseFeign;

    /**
     * 编码转成中文
     *
     * @param traget    对象
     * @param type      redis中的字典 key.  完整 redis字典 key = "base:dict:"+type
     * @param fieldName 对象 traget 中给要给赋值的属性名称
     * @param value     对象 traget 中给该属性赋的值
     * @throws NoSuchFieldException
     */
    public void convert(@NotNull Object traget, @NotBlank String type, @NotBlank String fieldName,
                        @NotNull Object value) {
        if (Objects.isNull(value)) return;
        Assert.notNull(traget, "目标对象[{}]不能为null", traget.getClass().getName());
        Assert.notBlank(type, "字典类型不能为空");
        Assert.notBlank(fieldName, "赋值对象属性不能为空");
//        Assert.notNull(value, "字典值不能为null");

        final String cnValue = getNameByCode(type, value);
        setValue(traget, fieldName, cnValue);
    }


    /**
     * 根据编码获取中文
     * 根据键值得标签
     *
     * @param type
     * @param value
     * @return
     */
    public String getNameByCode(@NotBlank String type, @NotNull Object value) {
        String key = RedisKeyEnum.BASE_DICT_VALUE_LABEL_INFO.getKey().concat(type);
        String result = redisUtil.hget(key, Convert.toStr(value));
        if (Objects.isNull(result)) {
            Result<List<DictDataVO>> dictResult = iBaseFeign.qryDictByType(type);
            if (Objects.isNull(dictResult) || !dictResult.getSuccess() || CollectionUtil.isEmpty(dictResult.getData())) {
                return StringUtils.EMPTY;
            }
            Optional<DictDataVO> first =
                    dictResult.getData().stream().filter(e -> value.equals(e.getDictValue())).findFirst();
            return first.isPresent() ? first.get().getDictLabel() : StringUtils.EMPTY;
        }
        return result;
    }

    /**
     * 根据中文获取编码
     * 根据标签得到键值
     *
     * @param type
     * @param getValueFromObject
     * @return
     */
    public String getCodeByName(String type, Object getValueFromObject) {
        String key = REDIS_BASE_DICT_PREFIX + type;
        Map<Object, Object> hmget = redisUtil.hmget(key);
        if (Objects.isNull(hmget) || Objects.isNull(hmget.get(getValueFromObject instanceof String ?
                getValueFromObject : String.valueOf
                (getValueFromObject)))) {
            Result<List<DictDataVO>> dictResult = iBaseFeign.qryDictByType(type);
            if (Objects.isNull(dictResult) || !dictResult.getSuccess() || CollectionUtil.isEmpty(dictResult.getData())) {
                return StringUtils.EMPTY;
            }
            Optional<DictDataVO> first =
                    dictResult.getData().stream().filter(e -> getValueFromObject.equals(e.getDictLabel())).findFirst();
            return first.isPresent() ? first.get().getDictValue() : StringUtils.EMPTY;
        }
        final Object v = hmget.get(getValueFromObject instanceof String ? getValueFromObject :
                String.valueOf(getValueFromObject));
        return Objects.isNull(v) ? null : v.toString();
    }


    /**
     * 根据属性，拿到set方法，并把值set到对象中
     *
     * @param obj       对象
     * @param clazz     对象的class
     * @param filedName 需要设置值得属性
     * @param typeClass
     * @param value
     */
    public void setValue(Object obj, Class<?> clazz, String filedName, Class<?> typeClass, Object value) {
        filedName = removeLine(filedName);
        String methodName = "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1) + "Name";
        try {
            Method method = clazz.getDeclaredMethod(methodName, typeClass);
            method.invoke(obj, getClassTypeValue(typeClass, value));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 设置属性值，不通过setter方法
     *
     * @param target          目标对象
     * @param fieldNamePrefix 属性值前缀,不包含Name后缀
     * @param value           属性值
     */
    private void setValue(Object target, String fieldNamePrefix, Object value) {
        final String tFieldName = fieldNamePrefix.concat("Name");
        if (!ReflectionUtils.hasField(target, tFieldName)) {
            // 抛出异常不合理，仅仅一个属性错误不应当导致其他程序执行
            // throw new NoSuchFieldException(String.format("类[%s]不存在[%s]属性", target.getClass().getName(), tFieldName));
            logger.error("类[{}]不存在[{}]属性", target.getClass().getName(), tFieldName);
            return;
        }
        ReflectionUtils.setFieldValue(target, tFieldName, value);
    }

    /**
     * 处理字符串  如：  abc_dex ---> abcDex
     *
     * @param str
     * @return
     */
    public String removeLine(String str) {
        if (null != str && str.contains("_")) {
            int i = str.indexOf("_");
            char ch = str.charAt(i + 1);
            char newCh = (ch + "").substring(0, 1).toUpperCase().toCharArray()[0];
            String newStr = str.replace(str.charAt(i + 1), newCh);
            String newStr2 = newStr.replace("_", "");
            return newStr2;
        }
        return str;
    }

    /**
     * 通过class类型获取获取对应类型的值
     *
     * @param typeClass class类型
     * @param value     值
     * @return Object
     */
    private Object getClassTypeValue(Class<?> typeClass, Object value) {
        if (typeClass == int.class || value instanceof Integer) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == short.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == byte.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == double.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == long.class) {
            if (null == value) {
                return 0;
            }
            return value;
        } else if (typeClass == String.class) {
            if (null == value) {
                return "";
            }
            return value;
        } else if (typeClass == boolean.class) {
            if (null == value) {
                return true;
            }
            return value;
        } else if (typeClass == BigDecimal.class) {
            if (null == value) {
                return new BigDecimal(0);
            }
            return new BigDecimal(value + "");
        } else {
            return typeClass.cast(value);
        }
    }


    /**
     * 获取创建者姓名
     *
     * @param userId
     * @return
     */
    public String getCreaterNameFromRedis(@NotNull Long userId) {
        if (Objects.isNull(userId) || userId.equals(0L)) {
            return StringUtils.EMPTY;
        }
        final RedisUserInfoVO redisUserInfoVO = getUserBaseInfo(userId);


        return Objects.nonNull(redisUserInfoVO) ? redisUserInfoVO.getName() : null;
    }


    /**
     * 根据角色id获取 对应的uri权限和数据可视范围（0全部，1大区，2城市，3小组，4个人）
     * key: prefix + roleId
     * field: uri
     * member: dataScope
     *
     * @param roleId
     */
    public Map<String, Integer> getRoleDataScopeByRoleId(@NotNull Integer roleId) {
        String key = StrUtil.format("{}{}", RedisKeyEnum.BASE_ROLE_ROLE_ID_KEY.getKey(), roleId);

        Map<String, Integer> result = redisUtil.hmget(key);
        if (CollectionUtil.isNotEmpty(result)) {
            return result;
        }
        Result<Map<String, Integer>> mapResult = iBaseFeign.syncPermissionAndDataScopeCache(roleId);
        if (Objects.isNull(mapResult) || !mapResult.getSuccess()) {
            return null;
        }
        return mapResult.getData();
    }

    /**
     * key -> base:user:dataScopeType:userId
     * field -> dataScopeType
     * value -> UserList
     *
     * @param userId
     * @return child user list
     */
    public Map<String, List<Integer>> getUserListByUserId(@NotNull Long userId) {
        String key = StrUtil.format("{}{}", RedisKeyEnum.BASE_USER_DATA_SCOPE_INFO.getKey(), userId);

        Map<String, List<Integer>> result = redisUtil.hmget(key);
        if (CollectionUtil.isNotEmpty(result)) {
            return result;
        }
        Result<Map<String, List<Integer>>> mapResult = iBaseFeign.getAndSyncDataScopeByUserId(userId);
        if (Objects.isNull(mapResult) || !mapResult.getSuccess()) {
            return null;
        }
        return mapResult.getData();
    }

    /**
     * 根据userId获取用户的基础数据，注意：返回数据必须进行判空
     *
     * @param userId 用户id
     * @return {@link UserDTO}
     * @see GlobalBaseService#getUserBaseInfo(java.lang.Long)
     */
    //TODO 待测试
    public RedisUserInfoVO getUserBaseInfo(@NotNull Long userId) {
        if (Objects.isNull(userId)) {
            return new RedisUserInfoVO();
        }
        final String key = StrUtil.format("{}{}", RedisKeyEnum.BASE_USER_USERINFO.getKey(), userId);
        final RedisUserInfoVO result = redisUtil.get(key);
        if (Objects.nonNull(result)) {
            return result;
        }
        Result<RedisUserInfoVO> userInfoVOResult = iBaseFeign.getUserBaseInfoWithCache(userId);
        if (Objects.isNull(userInfoVOResult) || !userInfoVOResult.getSuccess()) {
            return null;
        }
        return userInfoVOResult.getData();
    }

    /**
     * 根据userIds获取用户的基础数据，注意：返回数据必须进行判空
     *
     * @param userIds 用户id
     * @return {@link UserDTO}
     */
    public List<RedisUserInfoVO> getUserBaseList(@NotEmpty List<Long> userIds) {
        if (CollectionUtil.isEmpty(userIds)) {
            return new ArrayList<>();
        }
        List<String> keys = userIds.stream().map(o->{
            return StrUtil.format("{}{}", RedisKeyEnum.BASE_USER_USERINFO.getKey(), o);
        }).collect(Collectors.toList());
        List<RedisUserInfoVO> result = redisUtil.getList(keys).stream().map(o->{
            RedisUserInfoVO user = BeanUtil.toBean(o, RedisUserInfoVO.class);
            return user;
        }).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(result) && userIds.size() == result.size()) {
            return result;
        }
        Result<List<RedisUserInfoVO>> userInfoVOResult = iBaseFeign.getUserBaseListWithCache(userIds);
        if (Objects.isNull(userInfoVOResult)|| !userInfoVOResult.getSuccess() || CollectionUtil.isEmpty(userInfoVOResult.getData())) {
            return null;
        }
        return userInfoVOResult.getData();
    }

    /**
     * 根据地区code获取中文
     *
     * @param code
     * @return
     */
    public String getAreaNameFromRedis(@NotNull Integer code) {
        return getAreaNameFromRedis(Objects.isNull(code) ? null : Convert.toStr(code, StrUtil.EMPTY));
    }


    /**
     * 根据地区code获取中文
     *
     * @param codes
     * @return
     */
    public List<AreaItemDTO> getAreaListNameFromRedis(@NotNull List<Integer> codes) {
        if(CollectionUtil.isEmpty(codes)){
            return null;
        }
        return getAreaNameFromRedis(codes.stream().map(m->{
            return Convert.toStr(m, StrUtil.EMPTY);
        }).collect(Collectors.toList()));
    }

    /**
     * 根据城市编码 获取城市名称
     *
     * @param code 城市编码
     * @return
     */
    //TODO 待测试
    public String getAreaNameByCode(@NotNull String code) {
        String key = RedisKeyEnum.BASE_AREA_WITHOUT_TOWN_INFO.getKey();
        final String result = redisUtil.hget(key, code);
        if (Objects.nonNull(result)) {
            return result;
        }
        Result<Map<String, String>> mapResult = iBaseFeign.getCityNameById(Arrays.asList(code));
        if (Objects.isNull(mapResult)) {
            return null;
        }
        Map<String, String> cityNameById = mapResult.getData();
        if (Objects.isNull(cityNameById)) {
            return null;
        }
        return cityNameById.get(code);
    }

    /**
     * 根据城市编码 获取城市名称
     *
     * @param codes 城市编码
     * @return
     */
    //TODO 待测试
    public List<AreaItemDTO> getAreaNameListByCode(@NotNull List<String> codes) {
        String key = RedisKeyEnum.BASE_AREA_WITHOUT_TOWN_INFO.getKey();
        List<AreaItemDTO> list = new ArrayList<>();
        List<String> noExistCodes = new ArrayList<>();
        List<RedisQueryParamDTO> params = codes.stream().map(m->{
            RedisQueryParamDTO p = new RedisQueryParamDTO();
            p.setKey(key);
            p.setField(m);
            return p;
        }).collect(Collectors.toList());
        List<String> result = redisUtil.batchHGet(params);
        for (int i=0;i<result.size();i++){
            if(StrUtil.isNotEmpty(result.get(i))){
                AreaItemDTO areaItem = new AreaItemDTO();
                areaItem.setId(Integer.valueOf(codes.get(i)));
                areaItem.setName(result.get(i));
                list.add(areaItem);
            }else{
                noExistCodes.add(codes.get(i));
            }
        }
        if (CollectionUtil.isNotEmpty(list) && list.size() == codes.size()) {
            return list;
        }
        Result<Map<String, String>> mapResult = iBaseFeign.getCityNameById(noExistCodes);
        if (Objects.isNull(mapResult)) {
            return list;
        }
        Map<String, String> cityNameById = mapResult.getData();
        if (Objects.isNull(cityNameById)) {
            return list;
        }
        //遍历值
        for(String code: noExistCodes){
            AreaItemDTO areaItem = new AreaItemDTO();
            areaItem.setId(Integer.valueOf(code));
            areaItem.setName(cityNameById.get(code));
            list.add(areaItem);
        }
        return list;
    }

    /**
     * 根据地区code获取中文
     * @param codes
     * @return
     */
    public List<AreaItemDTO> getAreaNameFromRedis(@NotNull List<String> codes) {
        List<AreaItemDTO> list = new ArrayList<>();
        List<String> chinaCodes = codes.stream().filter(c->StringUtils.isBlank(c) || "0".equals(c)).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(chinaCodes)) {
            list.addAll(chinaCodes.stream().map(m->{
                AreaItemDTO area = new AreaItemDTO();
                area.setId(Integer.parseInt(m));
                area.setName("中国");
                return area;
            }).collect(Collectors.toList()));
        }
        List<String> globalCodes = codes.stream().filter(c->"-99".equals(c)).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(globalCodes)) {
            list.addAll(globalCodes.stream().map(m->{
                AreaItemDTO area = new AreaItemDTO();
                area.setId(Integer.parseInt(m));
                area.setName("全区域");
                return area;
            }).collect(Collectors.toList()));
        }
        List<String> otherCodes = codes.stream().filter(c->!"-99".equals(c) && StringUtils.isNotBlank(c) && !"0".equals(c)).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(otherCodes)) {
            List<AreaItemDTO> otherList = getAreaNameListByCode(otherCodes);
            if(CollectionUtil.isNotEmpty(otherList)){
                list.addAll(otherList);
            }
        }
        return list;
    }

    /**
     * 根据地区code获取中文
     *
     * @param code
     * @return
     */
    public String getAreaNameFromRedis(@NotNull String code) {
        if (StringUtils.isBlank(code) || "0".equals(code)) {
            return "中国";
        } else if ("-99".equals(code)) {
            return "全区域";
        } else {
            return getAreaNameByCode(Convert.toStr(code));
        }
    }

    public Map<String, String> getAllAreaInfoFromRedis() {
        return redisUtil.hmget(RedisKeyEnum.BASE_AREA_WITHOUT_TOWN_INFO.getKey());
    }

    /**
     * 获取用户指定权限的可视范围对应的userIds，空集合表示全部
     * 1.根据userId获取roleId
     * 2.根据roleId及url获取指定权限的可视范围id
     * 3.根据userId及可视范围id获取可视范围内的userIds
     *
     * @param userId 用户id
     * @param uri    权限uri
     * @return child user ids
     */
    public List<Integer> getUserListByURI(Long userId, String uri) {
        List<Integer> userIdList = Lists.newArrayList();
        // 从缓存中获取roleId
        RedisUserInfoVO userBaseInfo = getUserBaseInfo(userId);
        AssertUtil.isFalse(Objects.isNull(userBaseInfo),"当前用户不存在，用户ID：{}",userId);
        List<DutyRoleInfo> dutyRoleInfos = userBaseInfo.getDutyRoleInfos();
        Set<Integer> dataScopeSet = Sets.newHashSet();
        if (CollectionUtil.isNotEmpty(dutyRoleInfos)) {
            dutyRoleInfos.stream()
                    .filter(Objects::nonNull)
                    .forEach(e -> {
                        if (Objects.isNull(e.getRoleId())) {
                           return;
                        }
                        Map<String, Integer> uriDataScopeMap = getRoleDataScopeByRoleId(e.getRoleId());
                        Integer dataScope = uriDataScopeMap.get(uri);
                        if (Objects.nonNull(dataScope)){
                            dataScopeSet.add(dataScope);
                        }
                    });
        }
        if (CollectionUtil.isEmpty(dataScopeSet)) {
            userIdList.add(userId.intValue());
            return userIdList;
        }
        // 根据dataScope获取用户子列表
        Map<String, List<Integer>> userListByUserId = getUserListByUserId(userId);
        //为空fegin调用失败
        if (userListByUserId == null) {
            throw new BaseException("缓存中未取到当前用户的信息，通过feign调用查询失败");
        }
        for (Integer dataScope : dataScopeSet){
            List<Integer> userIds = userListByUserId.get(String.valueOf(dataScope));
            //如果为空集合，则有全部用户的权限
            if (CollectionUtil.isEmpty(userIds)){
                return Lists.emptyList();
            }
            userIdList.removeAll(userIds);
            userIdList.addAll(userIds);
        }
        return userIdList;
    }

    /**
     * field -> dictValue
     * value -> dictLabel
     * <p>
     * 根据字典类型dictValue, 获取对应的dictLabel
     *
     * @param dictType 字典类型
     * @return dictLabel
     */
    //TODO 待测试
    public String getDictLabelByDictValue(String dictType, String dictValue) {
        String key = RedisKeyEnum.BASE_DICT_VALUE_LABEL_INFO.getKey() + dictType;
        String result = redisUtil.hget(key, dictValue);
        if (Objects.nonNull(result)) {
            return result;
        }

        Result<List<DictDataVO>> listResult = iBaseFeign.qryDictByType(dictType);
        if (!listResult.getSuccess()) {
            return null;
        }
        List<DictDataVO> data = listResult.getData();
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        return data.stream().filter(Objects::nonNull).filter(dict -> dict.getDictValue().equals(dictValue))
                .findFirst().orElse(new DictDataVO()).getDictLabel();
    }

    /**
     * @description 删除用户的登录标识<br>
     * @Param: [userId]
     * @Return: boolean
     * @Date: 2020/7/22 14:05
     */
    public void clearLoginFlag(Long userId) {
        String key = RedisKeyEnum.AUTH_USER_LOGIN_FLAG.getKey().concat(String.valueOf(userId));
        redisUtil.del(key);
    }

    /**
     * @description 传入Uri 和 userId 返回 当前用户组织权限范围内的人员列表<br>
     * @Param: [userId, uri]
     * @Return: java.util.List<com.hyman.common.model.vo.base.StaffInfoVO>
     * @Date: 2020/7/22 16:24
     */
    public List<StaffInfoVO> getDataScopeUserListByUserIdAndUri(Long userId, String uri) {
        List<Integer> userListByURI = getUserListByURI(userId, uri);
        //为空则feign调用失败，默认返回自己
        if (null == userListByURI) {
            return CodeFormatUtil.returnSelf(getUserBaseInfo(userId));
        }
        //判断是否有空集合，空集合代表全部数据
        if (CollectionUtils.isEmpty(userListByURI)) {
            Set<String> keys = redisUtil.getKeys(RedisKeyEnum.BASE_USER_USERINFO.getKey());
            //缓存中key为空，则进库查询
            if (CollectionUtils.isEmpty(keys)) {
                Result<List<RedisUserInfoVO>> allUserInfoAnfIntoCache = iBaseFeign.getAllUserInfoAndIntoCache();
                if (Objects.isNull(allUserInfoAnfIntoCache.getData())) {
                    return CodeFormatUtil.returnSelf(getUserBaseInfo(userId));
                }
                List<RedisUserInfoVO> redisUserInfoVOList = allUserInfoAnfIntoCache.getData();
                if (CollectionUtils.isEmpty(redisUserInfoVOList)) {
                    return CodeFormatUtil.returnSelf(getUserBaseInfo(userId));
                }
                redisUserInfoVOList.removeAll(Collections.singleton(null));
                return redisUserInfoVOList
                        .stream().map(data -> {
                            return CodeFormatUtil.redisUserInfoVOToStaffInfoVO(data);
                        }).collect(Collectors.toList());
            }
            List<RedisUserInfoVO> list = redisUtil.multiGet(keys);
            //为空则直接返回他自己
            if (CollectionUtils.isEmpty(list)) {
                return CodeFormatUtil.returnSelf(getUserBaseInfo(userId));
            }
            list.removeAll(Collections.singleton(null));
            return list.stream().map(data -> {
                return CodeFormatUtil.redisUserInfoVOToStaffInfoVO(data);
            }).collect(Collectors.toList());
        }
        //keys不为空则拼接key进行批量查询
        Set<String> keys = userListByURI.stream().map(id -> {
            return RedisKeyEnum.BASE_USER_USERINFO.getKey().concat(String.valueOf(id));
        }).collect(Collectors.toSet());
        //如果keys和查询出来的数据对不上，则有部分数据丢失,尽可能的补充缓存数据
        List<RedisUserInfoVO> list = redisUtil.multiGet(keys);
        //为空则直接返回他自己
        if (CollectionUtils.isEmpty(list)) {
            return CodeFormatUtil.returnSelf(getUserBaseInfo(userId));
        }
        return list.stream().map(data -> {
            return CodeFormatUtil.redisUserInfoVOToStaffInfoVO(data);
        }).collect(Collectors.toList());
    }


    /**
     * @description 获取缓存中所有的用户信息，如果个别用户信息被删除可能造成缓存和数据库的数据不一致<br>
     * @Param: []
     * @Return: java.util.List<com.hyman.common.model.vo.base.RedisUserInfoVO>
     * @Date: 2020/7/29 16:11
     */
    public List<RedisUserInfoVO> getAllRedisUserInfo() {
        try {
            Set<String> keys = redisUtil.getKeys(RedisKeyEnum.BASE_USER_USERINFO.getKey());
            if (CollectionUtils.isEmpty(keys)) {
                Result<List<RedisUserInfoVO>> allUserInfoAnfIntoCache = iBaseFeign.getAllUserInfoAndIntoCache();
                if (Objects.isNull(allUserInfoAnfIntoCache)) {
                    return null;
                }
                if (!allUserInfoAnfIntoCache.getSuccess()) {
                    return null;
                }
                return allUserInfoAnfIntoCache.getData();
            }
            List<RedisUserInfoVO> redisUserInfoVOList = redisUtil.multiGet(keys);
            if (Objects.isNull(redisUserInfoVOList)) {
                return null;
            }
            return redisUserInfoVOList;
        } catch (Exception e) {
            logger.info("redis连接发生异常，异常信息：{}", e);
            Result<List<RedisUserInfoVO>> allUserInfoAnfIntoCache = iBaseFeign.getAllUserInfoAndIntoCache();
            if (Objects.isNull(allUserInfoAnfIntoCache)) {
                return null;
            }
            if (!allUserInfoAnfIntoCache.getSuccess()) {
                return null;
            }
            return allUserInfoAnfIntoCache.getData();
        }

    }

    /**
     * 根据用户ID查询用户名称
     *
     * @param userId 用户ID
     * @return 用户名称，可能为空字符串
     */
    public String getUserNameByUserId(Long userId) {
        RedisUserInfoVO userInfo = getUserBaseInfo(userId);
        if (ObjectUtil.isNotNull(userInfo)) {
            return userInfo.getName();
        } else {
            return "";
        }
    }

    public String getUserNameByUserId(Integer userId) {
        if (userId == null) {
            return "";
        }
        return getUserNameByUserId(Long.valueOf(userId));
    }

    /**
     * @description 返回所有的用户Id和name<br>
     * @Param: []
     * @Return: java.util.Map<java.lang.Long, java.lang.String>
     * @Date: 2021/1/20 11:47
     */
    public Map<Long, String> getAllUserMap() {
        Set<String> keys = redisUtil.getKeys(RedisKeyEnum.BASE_USER_USERINFO.getKey());
        if (CollectionUtils.isEmpty(keys)) {
            Result<List<RedisUserInfoVO>> allUserInfoAnfIntoCache = iBaseFeign.getAllUserInfoAndIntoCache();
            if (Objects.isNull(allUserInfoAnfIntoCache)) {
                return Maps.newHashMap();
            }
            if (!allUserInfoAnfIntoCache.getSuccess()) {
                return Maps.newHashMap();
            }
            List<RedisUserInfoVO> data = allUserInfoAnfIntoCache.getData();
            if (CollectionUtil.isEmpty(data)) {
                return Maps.newHashMap();
            }
            return data.parallelStream().filter(Objects::nonNull).collect(Collectors.toMap(RedisUserInfoVO::getId,
                    RedisUserInfoVO::getName, (key1, key2) -> key2));
        }
        List<RedisUserInfoVO> redisUserInfoVOList = redisUtil.multiGet(keys);
        if (Objects.isNull(redisUserInfoVOList)) {
            return Maps.newHashMap();
        }
        return redisUserInfoVOList.parallelStream().filter(Objects::nonNull).collect(Collectors.toMap(RedisUserInfoVO::getId, RedisUserInfoVO::getName, (key1, key2) -> key2));
    }

    /**
     * 根据userId集合批量获取指定的用户信息
     * 参数：Set<Long>  --> 用户Id
     * 出参：Map<Long, RedisUserInfoVO> --> key 用户Id，value 用户信息 ，返回的不可能为null,至少是个空Map
     */
    public Map<Long, RedisUserInfoVO> batchGetRedisUserInfoVO(Set<Long> userIds) {
        if (CollectionUtil.isEmpty(userIds)) {
            return Maps.newHashMap();
        }
        //使用字符串的concat
        Set<String> ids = userIds.stream()
                .map(e -> RedisKeyEnum.BASE_USER_USERINFO.getKey().concat(String.valueOf(e)))
                .collect(Collectors.toSet());
        List<RedisUserInfoVO> userList = redisUtil.batchGet(ids);
        Map<Long, RedisUserInfoVO> userMap = userList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(RedisUserInfoVO::getId, v -> v, (v1, v2) -> v1));

        //校验是否有没取到数据的Id
        if (userIds.size() == userMap.size()) {
            return userMap;
        }
        //取差集
        userIds.removeAll(userMap.keySet());
        //存在用户没查询到，需要再次获取
        userIds.stream().forEach(id -> {
            if (CommonConstants.LONG_ZERO.equals(id)) {
                userMap.put(id, new RedisUserInfoVO());
                return;
            }
            Result<RedisUserInfoVO> userInfoVOResult = iBaseFeign.getUserBaseInfoWithCache(id);
            if (Objects.isNull(userInfoVOResult) || !userInfoVOResult.getSuccess() ||
                    Objects.isNull(userInfoVOResult.getData())) {
                userMap.put(id, new RedisUserInfoVO());
                return;
            }
            userMap.put(id, userInfoVOResult.getData());
        });
        return userMap;
    }

    /**
     * 编码转成中文
     * <p>
     * traget    对象
     * convertDTO.dictType      redis中的字典 key.  完整 redis字典 key = "base:dict:"+type
     * convertDTO.fieldName 对象 traget 中给要给赋值的属性名称
     * convertDTO.dictValue     对象 traget 中给该属性赋的值
     *
     * @throws NoSuchFieldException
     */
    public void convert(@NotNull Object traget, @NotNull List<ConvertDTO> dtoList) {
        if (CollectionUtil.isEmpty(dtoList)) {
            return;
        }
        //构建查询参数
        List<RedisQueryParamDTO> params = dtoList.stream()
                .map(e -> {
                    AssertUtil.isFalse(Objects.isNull(e), "存在空元素");
                    return RedisQueryParamDTO.of(RedisKeyEnum.BASE_DICT_VALUE_LABEL_INFO.getKey().concat(e.getDictType()),
                            Objects.isNull(e.getDictValue()) ? StrUtil.EMPTY : Convert.toStr(e.getDictValue()));
                }).collect(Collectors.toList());
        //获取返回值
        List result = redisUtil.batchHGet(params);
        //设置值
        boolean isEmpty = CollectionUtil.isEmpty(result);
        for (int i = 0; i < dtoList.size(); i++) {
            ConvertDTO dto = dtoList.get(i);
            if (isEmpty) {
                convert(traget, dto.getDictType(), dto.getFieldName(), dto.getDictValue());
                continue;
            }
            Object dictName = null;
            if (Objects.isNull(dictName = result.get(i))) {
                convert(traget, dto.getDictType(), dto.getFieldName(), dto.getDictValue());
                continue;
            }
            setValue(traget, dto.getFieldName(), dictName);
        }
    }

    /**
     * @description 根据areaCode批量查询areaName信息<br>
     * @Param: [codes] String 类型
     * @Return: java.util.Map<java.lang.String, java.lang.String>  key-> areaCode  value->areaName
     * @Date: 2021/1/20 10:52
     */
    public Map<String, String> batchGetAreaNameByCodes(List<String> codes) {
        Map<String, String> result = Maps.newHashMap();
        result.put("-99", "全区域");
        result.put("0", "中国");
        if (CollectionUtil.isEmpty(codes)) {
            return result;
        }
        //构建查询参数
        String key = RedisKeyEnum.BASE_AREA_WITHOUT_TOWN_INFO.getKey();
        List<RedisQueryParamDTO> params =
                codes.stream().map(e -> RedisQueryParamDTO.of(key, e)).collect(Collectors.toList());
        List<String> areaNames = redisUtil.batchHGet(params);
        //校验数据
        boolean isEmpty = CollectionUtil.isEmpty(areaNames);
        if (isEmpty) {
            Result<Map<String, String>> cityNams = iBaseFeign.getCityNameById(codes);
            if (Objects.isNull(cityNams) || !cityNams.getSuccess()) {
                return result;
            }
            Map<String, String> data = cityNams.getData();
            if (CollectionUtil.isNotEmpty(data)) {
                data.remove("-99");
                data.remove("0");
                result.putAll(data);
            }
            return result;
        }

        for (int i = 0; i < codes.size(); i++) {
            String areaName = areaNames.get(i);
            if (StringUtils.isBlank(areaName) && Objects.nonNull(codes.get(i))) {
                if (CommonConstants.AREA_CODE_INIT.contains(codes.get(i))) {
                    continue;
                }
                Result<Map<String, String>> cityNameById = iBaseFeign.getCityNameById(Lists.newArrayList(codes.get(i)));
                if (Objects.isNull(cityNameById) || !cityNameById.getSuccess() ||
                        CollectionUtil.isEmpty(cityNameById.getData())) {
                    continue;
                }
                Map<String, String> data = cityNameById.getData();
                if (CollectionUtil.isNotEmpty(data)) {
                    result.putAll(data);
                }
                continue;
            }
            result.put(codes.get(i), areaName);
        }
        return result;
    }

    /**
     * @description <br>
     * @Param: []
     * @Return: java.util.Map<String, String>
     * key:传入的职责id. 1加盟经理，2外线销售 3上岗经理 等
     * value:对应真实的职责id 逗号分隔
     * @Date: 2021/3/10 9:36
     */
    public Map<String, String> getAllDutyMapping() {
        Map<String, String> dutyMappingMap = redisUtil.hmget(RedisKeyEnum.BASE_DUTY_MAPPING_CACHE.getKey());
        if (CollectionUtil.isEmpty(dutyMappingMap)) {
            Result<Map<String, String>> result = iBaseFeign.getAllDutyMappingAndIntoCache();
            if (Objects.isNull(result) || !result.getSuccess()) {
                return result.getData();
            }
        }
        return dutyMappingMap;
    }

    /**
     * @description <br>
     * @Param: [roleTypes]
     * @Return: java.util.Set<java.lang.Long>  角色Id集合
     * @Date: 2021/3/10 13:32
     */
    public Set<Integer> findRealDutyIdByRoleTypes(Set<Integer> roleTypes) {
        Set<Integer> roleIds = Sets.newHashSet();
        if (CollectionUtil.isEmpty(roleTypes)) {
            return roleIds;
        }
        Map<String, String> dutyMappingMap = getAllDutyMapping();
        roleTypes.forEach(e -> {
            String realRoleIds = dutyMappingMap.get(String.valueOf(e));
            if (StringUtils.isNotBlank(realRoleIds)) {
                String[] split = realRoleIds.split(",");
                if (split.length < 1) {
                    return;
                }
                for (String s : split) {
                    roleIds.add(Convert.toInt(s));
                }
            }
        });
        return roleIds;
    }
}
