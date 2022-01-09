package com.hyman.common.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Assert;
import com.hyman.common.biz.BaseBiz;
import com.hyman.common.enums.GlobalResultEnum;
import com.hyman.common.enums.RedisKeyEnum;
import com.hyman.common.exception.ServiceException;
import com.hyman.common.feign.IBaseFeign;
import com.hyman.common.mapper.BusiOperLogMapper;
import com.hyman.common.model.dao.log.BusiOperLogDAO;
import com.hyman.common.model.dao.log.BusiOperLogDO;
import com.hyman.common.model.vo.base.RedisUserInfoVO;
import com.hyman.common.util.RedisUtil;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

import static com.hyman.common.constant.CommonConstants.REDIS_BASE_DICT_PREFIX;

/**
 * @author Changyuan Su
 * @date 2019/3/19 16:48
 * @Description: 全局基础 service
 */
@Slf4j
public class GlobalBaseService<M extends Mapper<DAO>, DAO> extends BaseBiz<M, DAO> {

    @Resource
    public BusiOperLogMapper busiOperLogMapper;
    @Resource
    public RedisUtil redisUtil;
    @Resource
    public IBaseFeign iBaseFeign;

    /**
     * 保存操作日志
     *
     * @param logDO
     * @return
     */
    protected int saveBusiOperLog(@Validated final BusiOperLogDO logDO) {
        BusiOperLogDAO busiOperLogDao = new BusiOperLogDAO();
        BeanUtils.copyProperties(logDO, busiOperLogDao);
        busiOperLogDao.setModule(logDO.getModule().getModule());
        busiOperLogDao.setCreateDate(new Date());
        int row = busiOperLogMapper.insertSelective(busiOperLogDao);
        Assert.isTrue(row == 1, "保存操作日志异常,businessId=[%s]", logDO.getBusinessId());
        return row;
    }


    /**
     * 批量保存操作日志
     *
     * @param logDOS
     * @return
     */
    protected int batchSaveBusiOperLog(@Validated @Size(min = 1) final Collection<BusiOperLogDO> logDOS) {
        final BeanCopier copier = BeanCopier.create(BusiOperLogDO.class, BusiOperLogDAO.class, false);
        final Date createDate = new Date();
        final List<BusiOperLogDAO> collect = logDOS.parallelStream().map(e -> {
            BusiOperLogDAO busiOperLogDao = new BusiOperLogDAO();
            copier.copy(e, busiOperLogDao, null);
            busiOperLogDao.setModule(e.getModule().getModule());
            busiOperLogDao.setCreateDate(createDate);
            return busiOperLogDao;
        }).collect(Collectors.toList());
        int row = busiOperLogMapper.batchInsertSelective(collect);
        Assert.isTrue(row == logDOS.size(), "批量保存操作日志异常");
        return row;
    }


    /**
     * 创建查询条件
     *
     * @param queryMap
     * @param clazz
     * @return
     */
    protected <V extends Object> Example createEqualExampleByMap(@NotNull Map<String, V> queryMap, @NotNull Class<?> clazz) {
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        queryMap.entrySet().iterator().forEachRemaining(e -> {
            criteria.andEqualTo(e.getKey(), e.getValue());
        });
        return example;
    }


    protected <K extends String, V extends Object> Example createEqualExampleByMap(K k1, V v1, @NotNull Class<?> clazz) {
        return createEqualExampleByMap(ImmutableMap.of(k1, v1), clazz);
    }

    protected <K extends String, V extends Object> Example createEqualExampleByMap(K k1, V v1, K k2, V v2, @NotNull Class<?> clazz) {
        return createEqualExampleByMap(ImmutableMap.of(k1, v1, k2, v2), clazz);
    }

    protected <K extends String, V extends Object> Example createEqualExampleByMap(K k1, V v1, K k2, V v2, K k3, V v3, @NotNull Class<?> clazz) {
        return createEqualExampleByMap(ImmutableMap.of(k1, v1, k2, v2, k3, v3), clazz);
    }

    protected <K extends String, V extends Object> Example createEqualExampleByMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, @NotNull Class<?> clazz) {
        return createEqualExampleByMap(ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4), clazz);
    }

    protected <K extends String, V extends Object> Example createEqualExampleByMap(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, @NotNull Class<?> clazz) {
        return createEqualExampleByMap(ImmutableMap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5), clazz);
    }

    /**
     * 获取字典信息
     * String 类型
     *
     * @return
     */
    public Map<Object, Object> getBaseDictByKeyStr(String suffixKey) {
        String key = REDIS_BASE_DICT_PREFIX + suffixKey;

        if (!redisUtil.hasKey(key)) {
            iBaseFeign.qryDict();
        }

        if (!redisUtil.hasKey(key)) {
            throw new ServiceException(GlobalResultEnum.FEIGN_BASE_ERROR.getErrorCode(), GlobalResultEnum.FEIGN_BASE_ERROR.getErrorMsg());
        }
        return redisUtil.hmget(key);

    }

    /**
     * 根据userId获取用户的基础数据，注意：返回数据必须进行判空
     *
     * @param userId 用户id
     * @return {@link RedisUserInfoVO}
     */
    public RedisUserInfoVO getUserBaseInfo(@NotNull Long userId) {
        if (Objects.isNull(userId)) {
            return new RedisUserInfoVO();
        }
        String key = RedisKeyEnum.BASE_USER_USERINFO.getKey() + userId;
        if (!redisUtil.hasKey(key)) {
            return iBaseFeign.getUserBaseInfoWithCache(userId).getData();
        }
        return redisUtil.get(key);

    }

    /**
     * 根据城市编码 获取城市名称
     *
     * @param code 城市编码
     * @return
     */
    public String getAreaNameByCode(@NotNull String code) {
        if (StringUtils.equals("-99", code)) {
            return "全区域";
        } else if (StringUtils.equals("0", code)) {
            return StringUtils.EMPTY;
        }

        String key = RedisKeyEnum.BASE_AREA_WITHOUT_TOWN_INFO.getKey();
        if (!redisUtil.hHasKey(key, code)) {
            Map<String, String> cityNameById = iBaseFeign.getCityNameById(Arrays.asList(code)).getData();
            return cityNameById.get(code);
        }
        return redisUtil.hget(key, code);
    }

    protected String getAreaNameByCode(@NotNull Integer cityCode) {
        return getAreaNameByCode(Convert.toStr(cityCode));
    }

    /**
     * 根据字典类型dict_label, 获取对应的dict_value
     *
     * @param dictType  字典类型
     * @param dictLabel 字典标签
     * @return 字典value
     */
    public String getDictValueByDictLabel(String dictType, String dictLabel) {
        String key = RedisKeyEnum.BASE_DICT_LABEL_VALUE_INFO.getKey() + dictType;
        if (!redisUtil.hHasKey(key, dictLabel)) {
            iBaseFeign.qryDictByType(dictType);
        }
        return redisUtil.hget(key, dictLabel);
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
    public String getDictLabelByDictValue(String dictType, String dictValue) {
        String key = RedisKeyEnum.BASE_DICT_VALUE_LABEL_INFO.getKey() + dictType;
        if (!redisUtil.hHasKey(key, dictValue)) {
            iBaseFeign.qryDictByType(dictType);
        }
        return redisUtil.hget(key, dictValue);
    }

    /**
     * 根据dictType 获取列表
     *
     * @param dictType 字典类型
     * @return Map<dictValue, dictLabel>
     */
    public Map<String, String> getDictByDictType(String dictType) {
        String key = RedisKeyEnum.BASE_DICT_VALUE_LABEL_INFO.getKey() + dictType;
        if (!redisUtil.hasKey(key)) {
            iBaseFeign.qryDictByType(dictType);
        }
        return redisUtil.hmget(key);
    }

    /**
     * 获取指定用户的数据权限
     *
     * @param userId
     * @return
     */
    public List<Object> getUserDataPermission(Long userId) {

        //以下为示例代码

        //1.从redis获取数据
        List<Object> userIds = redisUtil.lGet(RedisKeyEnum.BASE_USER_DATA_PERMISSION_INFO + String.valueOf(userId), 0, -1);
        if (ObjectUtils.isEmpty(userIds)) {
            //2.如果从redis拿到的数据为空，则调用base服务拿数据（base服务负责生成数据并同步到redis）
            userIds = Collections.singletonList(iBaseFeign.getUserDataPermission(userId).getData());
        }
        return userIds;
    }

}
