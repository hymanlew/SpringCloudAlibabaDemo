package com.hyman.common.fallback;

import com.hyman.common.feign.IBaseFeign;
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
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author:
 * @create: 2019-03-18
 * @description:
 **/
@Service
@Slf4j
public class IBaseFeignFallback implements FallbackFactory<IBaseFeign> {

    @Override
    public IBaseFeign create(Throwable cause) {
        return new IBaseFeign() {
            @Override
            public Result<Map<String, String>> getAllDutyMappingAndIntoCache() {
                return null;
            }

            @Override
            public Result<OfficeVoWitchSelected> queryUserIdUnderCityOffice(Long userId) {
                return null;
            }

            @Override
            public Result<OfficeVO> queryOfficeById(Integer officeId) {
                return null;
            }

            @Override
            public Result<OfficeVoNewWitchSelected> queryUserIdUnderCityOfficeWithAreaCode(Long userId) {
                return null;
            }

            @Override
            public Result<List<StaffInfoVO>> getUserInfoByMobile(Set<String> mobiles) {
                return null;
            }

            @Override
            public Result<String> getCityCode(@NotBlank String cityName) {
                return null;
            }

            @Override
            public Result<List<SysCode>> qryDict() {
                return null;
            }

            @Override
            public Result<List<DictDataVO>> getDictByType(DictDataListFORM dictDataListFORM) {
                return null;
            }

            @Override
            public Result<List<DictDataVO>> qryDictByType(String dictType) {
                return null;
            }

            @Override
            public void getALLUserToRedis() {

            }

            @Override
            public Result<HashMap<String, String>> getAreaNameByCityCode(int[] cityCodes) {
                return null;
            }

            @Override
            public void getSyncUserInfoToRedis() {

            }

            @Override
            public void getUserOnlineCity() {

            }

            @Override
            public Result<HashMap<String, Integer>> getAreaCodeByName(String provinceName, String cityName, String regionName) {
                return null;
            }

            @Override
            public Result<BooleanResult> syncUserIdAndName(@NotNull Long userId) {
                return null;
            }

            @Override
            public Result<Set<String>> getUserRolesByUserPhone(String userPhone) {
                return null;
            }

            @Override
            public Result<Set<String>> getUserRolesByUserId(Long userId) {
                return null;
            }

            @Override
            public Result<List<UserIdAndNameAndPhoneVO>> getUserInfoByRoles(List<String> roleEnNames) {
                return null;
            }

            @Override
            public Result<UserBasicInfoVO> getUserBasicInfo(Long userId) {
                return null;
            }

            @Override
            public Result<UserBasicInfoVO> getUserBasicInfoByPhone(String userPhone) {
                return null;
            }

            @Override
            public Result<Long> getIdByName(String name) {
                return null;
            }

            @Override
            public Result<UserVO> getUserByLoginName(String loginName) {
                return null;
            }

            @Override
            public Result<List<String>> getOnlineCityByUserId(String userid) {
                return null;
            }

            @Override
            public Result<Map<String, String>> getCityNameById(List<String> cityIds) {
                return null;
            }

            @Override
            public Result<UserVO> getUserByCorpUserId(String corpUserId) {
                return null;
            }

            @Override
            public Result<List<UserDTO>> getSponsorListByCitysAuth(Long userId, Set<Object> userIds, List<Object> cities, Set<Integer> busiTypes) {
                return null;
            }

            @Override
            public Result<List<CustomerServicePhoneDTO>> getWtSpecialBGLPhonesByCity(Integer city, @NotBlank String ename) {
                return null;
            }

            @Override
            public Result<List<Long>> getUserDataPermission(Long userId) {
                return null;
            }

            @Override
            public Result<RedisUserInfoVO> getUserBaseInfoWithCache(Long userId) {
                return null;
            }

            @Override
            public Result<List<RedisUserInfoVO>> getUserBaseListWithCache(List<Long> userIds) {
                return null;
            }

            @Override
            public Result<Set<String>> getUserPermissionURI(Long userId) {
                return null;
            }

            @Override
            public Result<Map<String, Integer>> syncPermissionAndDataScopeCache(Integer roleId) {
                return null;
            }

            @Override
            public Result<Map<String, List<Integer>>> getAndSyncDataScopeByUserId(Long userId) {
                return null;
            }

            @Override
            public Result<List<UserBasicInfoVO>> selectUserListByIds(@NotNull(message = "Ids不能为空") Set<Long> ids) {
                return null;
            }

            @Override
            public Result<List<RedisUserInfoVO>> getAllUserInfoAndIntoCache() {
                return null;
            }

            @Override
            public Result<List<RoleAuthorityDTO>> getRoleAuthorityByRoleId(Long roleId) {
                return null;
            }

            @Override
            public Result<List<StaffInfoVO>> querySpecifiedUserList(QuerySpecifiedUserListForm form) {
                return null;
            }

            @Override
            public Result<List<StaffInfoVO>> getUserListByRoleTypeWithoutDataPermission(int roleType) {
                return null;
            }

            @Override
            public Result<List<StaffInfoVO>> querySpecifiedLowerUserList(Long userId, QuerySpecifiedLowerUserListFORM form) {
                return null;
            }

            @Override
            public Result<List<OpenCityVO>> getOpenCityData(String keyword) {
                return null;
            }

            @Override
            public Result<List<StaffActiveInfoVO>> querySpecifiedActiveUserList(QuerySpecifiedUserListForm form) {
                return null;
            }

            @Override
            public Result<List<UserIdAndOfficeIdAndStatusVO>> getUserInfoByCityAndBusiLine(String cityCode, Integer busiType, Set<Integer> roleTypes) {
                log.warn("【根据城市和产品线查询指定的用户信息】查询失败，请求参数=[{},{},{}], 异常信息=[{}]", cityCode, busiType, roleTypes, cause.getMessage());
                return new Result<>(false);
            }

            @Override
            public Result<List<BasicUserInfoVO>> getUserInfosByRoleIds(@NotEmpty(message = "必传角色") @Size(min = 1, message = "角色不能为空") Set<String> roleIds) {
                log.warn("根据roleIds=[{}]查询用户信息s失败, 异常信息=[{}]", roleIds, cause);
                return null;
            }

            @Override
            public Result<List<AreaVO>> getReginByCityCode(String city) {
                log.warn("根据城市编号{}查询区域编号失败, 异常信息=[{}]", city, cause);
                return new Result<>(false);
            }

//            @Override
//            public Result<List<UserBasicInfoVO>> getUserBasicInfoList(@Size(min = 1) Set<Long> userId) {
//                return null;
//            }


        };
    }
}
