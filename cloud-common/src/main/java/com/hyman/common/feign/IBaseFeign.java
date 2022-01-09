package com.hyman.common.feign;

import com.hyman.common.fallback.IBaseFeignFallback;
import com.hyman.common.model.dto.base.RoleAuthorityDTO;
import com.hyman.common.model.dto.base.SysCode;
import com.hyman.common.model.dto.driver.CustomerServicePhoneDTO;
import com.hyman.common.model.dto.match.UserDTO;
import com.hyman.common.model.form.base.QuerySpecifiedLowerUserListFORM;
import com.hyman.common.model.form.base.QuerySpecifiedUserListForm;
import com.hyman.common.model.form.order.DictDataListFORM;
import com.hyman.common.model.vo.base.*;
import com.hyman.common.model.vo.driver.UserVO;
import com.hyman.common.msg.Result;
import com.hyman.common.vo.BooleanResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.hyman.common.constant.CommonConstants.JWT_KEY_USER_ID;

/**
 * @Author:
 * @Date: 2019-03-18
 * @Description:
 */
@FeignClient(value = "szjw-firmiana-domain-base", fallbackFactory = IBaseFeignFallback.class, primary = false)
public interface IBaseFeign {
    @RequestMapping(value = "base/dict/qryDict", method = RequestMethod.GET)
    Result<List<SysCode>> qryDict();

    /**
     * 根据 type 类型获取字典数据
     */
    @RequestMapping(value = "/v1/base/dict/back/dictData/list", method = RequestMethod.POST)
    Result<List<DictDataVO>> getDictByType(@RequestBody DictDataListFORM dictDataListFORM);

    /**
     * 提供给前台查询 具体 type 类型的字典数据
     *
     * @param dictType
     * @return
     */
    @RequestMapping(value = "/v1/base/dict/back/getDictData/list", method = RequestMethod.GET)
    Result<List<DictDataVO>> qryDictByType(@RequestParam("dictType") String dictType);

    @RequestMapping(value = "user/bss/getALLUserToRedis", method = RequestMethod.GET)
    void getALLUserToRedis();

    @GetMapping("/user/area/getAreaNameByCityCode/{cityCodes}")
    Result<HashMap<String, String>> getAreaNameByCityCode(@PathVariable("cityCodes") int[] cityCodes);

    @RequestMapping(value = "user/bss/getSyncUserInfoToRedis", method = RequestMethod.GET)
    void getSyncUserInfoToRedis();

    @RequestMapping(value = "/user/bss/getUserOnlineCity", method = RequestMethod.GET)
    void getUserOnlineCity();

    @ApiOperation("根据省市区名称查询对应的code值，封装在map中：key是名称，value是code值")
    @GetMapping("/user/area/getAreaCodeByName")
    Result<HashMap<String, Integer>> getAreaCodeByName(@RequestParam("provinceName") String provinceName, @RequestParam(value = "cityName", required = false) String cityName, @RequestParam(value = "regionName", required = false) String regionName);

    @ApiOperation("根据城市名获取code值")
    @GetMapping("base/dict/getCityCode")
    Result<String> getCityCode(@RequestParam("cityName") @NotBlank String cityName);

    /**
     * 同步用户对应的信息
     *
     * @return
     */
    @ApiOperation("同步用户对应的信息")
    @GetMapping(value = "/user/bss/getUserIdAndName/{userId}")
    Result<BooleanResult> syncUserIdAndName(@PathVariable("userId") @NotNull Long userId);

    @ApiOperation("根据用户手机号获取对应角色集合")
    @GetMapping(value = "/v2/base/user/getUserRolesByUserPhone")
    Result<Set<String>> getUserRolesByUserPhone(@RequestParam("userPhone") String userPhone);

    @ApiOperation("根据用户id获取对应角色集合")
    @GetMapping(value = "/user/bss/getUserRolesByUserId")
    Result<Set<String>> getUserRolesByUserId(@RequestParam("userId") Long userId);

    @ApiOperation("根据用户角色获取用户信息")
    @GetMapping(value = "/user/bss/getUserInfoByRoles")
    Result<List<UserIdAndNameAndPhoneVO>> getUserInfoByRoles(@RequestParam("roleEnNames") List<String> roleEnNames);

    @ApiOperation("根据用户id获取用户基本信息")
    @GetMapping(value = "/user/bss/getUserBasicInfo")
    Result<UserBasicInfoVO> getUserBasicInfo(@RequestParam("userId") Long userId);

    @ApiOperation("根据用户手机号获取用户基本信息")
    @GetMapping(value = "/user/bss/getUserBasicInfoByPhone")
    Result<UserBasicInfoVO> getUserBasicInfoByPhone(@RequestParam("userPhone") String userPhone);

    @ApiOperation(value = "根据用户姓名查询id")
    @GetMapping(value = "/user/bss/getIdByName")
    Result<Long> getIdByName(@RequestParam("name") String name);

    @ApiOperation(value = "根据loginName查询用户信息")
    @GetMapping(value = "/user/bss/getUserByLoginName")
    Result<UserVO> getUserByLoginName(@RequestParam("loginName") String loginName);

    @GetMapping(value = "/user/bss/getOnlineCityByUserId")
    Result<List<String>> getOnlineCityByUserId(@RequestParam("userId") String userid);

    @PostMapping(value = "/v1/base/area/getAreaNameByCityCode")
    Result<Map<String, String>> getCityNameById(@RequestBody List<String> cityIds);

    @ApiOperation(value = "根据corpUserId查询用户信息")
    @GetMapping(value = "/user/bss/getUserByCorpUserId")
    Result<UserVO> getUserByCorpUserId(@RequestParam("corpUserId") String corpUserId);

    @ApiOperation("获取用户城市")
    @RequestMapping(value = "/user/bss/sponsorListByCitysAuth", method = RequestMethod.POST)
    Result<List<UserDTO>> getSponsorListByCitysAuth(@RequestParam("userId") Long userId, @RequestParam("userIds") Set<Object> userIds,
                                                    @RequestParam(value = "cities", required = false) List<Object> cities, @RequestParam(value = "busiTypes", required = false) Set<Integer> busiTypes);

    @ApiOperation("根据城市获取专车/共享（BGL/加盟经理）")
    @PostMapping("user/bss/getWtSpecialBGLPhonesByCity")
    Result<List<CustomerServicePhoneDTO>> getWtSpecialBGLPhonesByCity(@RequestParam("city") Integer city,
                                                                      @RequestParam("ename") @NotBlank String ename);

    @ApiOperation("获取指定用户的数据权限")
    @PostMapping("/base/user/getUserDataPermission")
    Result<List<Long>> getUserDataPermission(Long userId);

    @ApiOperation("根据UserId获取指定用户的数据信息")
    @PostMapping("/v1/base/user/cache/getUserBaseInfo")
    Result<RedisUserInfoVO> getUserBaseInfoWithCache(@RequestParam("userId") Long userId);

    @ApiOperation("根据UserIds获取指定用户的数据信息")
    @PostMapping("/v1/base/user/cache/getUserBaseList")
    Result<List<RedisUserInfoVO>> getUserBaseListWithCache(@RequestBody List<Long> userIds);

    @ApiOperation(value = "根据用户id获取拥有的权限url")
    @GetMapping("/v1/base/authority/getAuthoritiesForTheUser")
    Result<Set<String>> getUserPermissionURI(@RequestParam("userId") Long userId);

    @ApiOperation(value = "同步当前角色的权限和数据可视范围缓存")
    @GetMapping("/v1/base/role/cache/syncByRoleId")
    Result<Map<String, Integer>> syncPermissionAndDataScopeCache(@RequestParam("roleId") Integer roleId);

    @ApiOperation(value = "同步当前角色的权限和数据可视范围缓存")
    @PostMapping("/v1/base/user/cache/syncUserDataScopeInfoByUserId")
    Result<Map<String, List<Integer>>> getAndSyncDataScopeByUserId(@RequestParam("userId") Long userId);

    @ApiOperation("根据用户Id集合获取用户列表信息")
    @PostMapping("/v1/base/user/getUserListByIds")
    Result<List<UserBasicInfoVO>> selectUserListByIds(@RequestBody @Validated @NotNull(message = "Ids不能为空") Set<Long> ids);

    @ApiOperation("查询所有的用户信息，并插入缓存")
    @GetMapping("/v1/base/user/getAllUserInfoAndIntoCache")
    Result<List<RedisUserInfoVO>> getAllUserInfoAndIntoCache();
//    @ApiOperation("根据用户id获取用户基本信息列表")
//    @PostMapping(value = "/user/bss/getUserBasicInfoList")
//    Result<List<UserBasicInfoVO>> getUserBasicInfoList(@RequestParam @Size(min = 1)  Set<Long> userId);

    @ApiOperation(value = "根据角色id查询角色的相关权限信息")
    @GetMapping("/v1/base/role/getRoleAuthorityByRoleId")
    Result<List<RoleAuthorityDTO>> getRoleAuthorityByRoleId(@RequestParam("roleId") Long roleId);

    @ApiOperation(value = "查询相关角色的用户列表[加盟经理，外线销售...]，支持根据产品线、城市编码、角色类型查询")
    @PostMapping("/v2/base/user/getSpecifiedUserListByCondition")
    Result<List<StaffInfoVO>> querySpecifiedUserList(@Validated @RequestBody QuerySpecifiedUserListForm form);

    @ApiOperation("根据roleType查询所有的用户信息 开发者：胡长亮")
    @GetMapping(value = "/v2/base/user/getUserListByRoleTypeWithoutDataPermission")
    Result<List<StaffInfoVO>> getUserListByRoleTypeWithoutDataPermission(@RequestParam("roleType") int roleType);

    @ApiOperation(value = "公共方法->根据数据权限获取登录人相关角色的用户列表[加盟经理，外线销售...]，支持根据中文名模糊、产品线、城市编码、角色类型查询")
    @PostMapping("/v2/base/user/getSpecifiedLowerUserListByCondition")
    Result<List<StaffInfoVO>> querySpecifiedLowerUserList(@RequestHeader(JWT_KEY_USER_ID) Long userId, @RequestBody QuerySpecifiedLowerUserListFORM form);

    @GetMapping("/v1/base/area/getOpenCityData")
    Result<List<OpenCityVO>> getOpenCityData(String keyword);

    @ApiOperation(value = "查询相关角色的已启用状态下的用户列表[加盟经理，外线销售...]，支持根据产品线、城市编码、角色类型查询。开发者：胡长亮")
    @PostMapping("/v2/base/user/getSpecifiedActiveUserList")
    Result<List<StaffActiveInfoVO>> querySpecifiedActiveUserList(@Validated @RequestBody QuerySpecifiedUserListForm form);

    @ApiOperation("根据城市和产品线查询指定的用户信息 开发者：张金峰")
    @GetMapping("/v2/base/user/getUserInfoByCityAndBusiLine")
    Result<List<UserIdAndOfficeIdAndStatusVO>> getUserInfoByCityAndBusiLine(@RequestParam("cityCode") String cityCode,
                                                                            @RequestParam("busiType") Integer busiType,
                                                                            @RequestParam("roleTypes") Set<Integer> roleTypes);

    @ApiOperation("根据roleId查询用户信息s 开发者：苏长远")
    @PostMapping(value = "/v2/base/user/getUserInfoByRoleId")
    Result<List<BasicUserInfoVO>> getUserInfosByRoleIds(@NotEmpty(message = "必传角色") @Size(min = 1, message = "角色不能为空") @RequestBody Set<String> roleIds);

    @ApiOperation("根据城市编号查询城市所辖区域的编号")
    @GetMapping(value = "/v1/base/area/getReginByCityCode")
    Result<List<AreaVO>> getReginByCityCode(@RequestParam String city);

    @ApiOperation("获取所有的职责映射信息并放入缓存 开发者：张金峰")
    @GetMapping("/v2/base/duty/getAllDutyMappingAndIntoCache")
    Result<Map<String, String>> getAllDutyMappingAndIntoCache();

    @ApiOperation("查询用户下的城市组织")
    @GetMapping("/v3/base/office/queryUserIdUnderCityOffice")
    Result<OfficeVoWitchSelected> queryUserIdUnderCityOffice(@RequestHeader(JWT_KEY_USER_ID) Long userId);

    @GetMapping("/v3/base/office/queryOfficeById")
    @ApiOperation("根据组织Id查询组织信息")
    Result<OfficeVO> queryOfficeById(@RequestParam("officeId") @Validated Integer officeId);

    @ApiOperation("查询用户下的城市组织")
    @GetMapping("/v3/base/office/queryUserIdUnderCityOfficeWithAreaCode")
    Result<OfficeVoNewWitchSelected> queryUserIdUnderCityOfficeWithAreaCode(@RequestHeader(JWT_KEY_USER_ID) Long userId);

    @ApiOperation("根据手机号获取用户信息，没有权限过滤 开发者：胡长亮")
    @PostMapping("/v3/base/user/getUserInfoByMobile")
    Result<List<StaffInfoVO>> getUserInfoByMobile(@RequestBody Set<String> mobiles);
}