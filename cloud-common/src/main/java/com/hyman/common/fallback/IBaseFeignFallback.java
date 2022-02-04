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
            public Result<BooleanResult> syncUserIdAndName(@NotNull Long userId) {
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
            public Result<HashMap<String, String>> getAreaNameByCityCode(int[] cityCodes) {
                return null;
            }

            @Override
            public void getSyncUserInfoToRedis() {

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
            public Result<List<StaffActiveInfoVO>> querySpecifiedActiveUserList(QuerySpecifiedUserListForm form) {
                return null;
            }

            @Override
            public Result<List<BasicUserInfoVO>> getUserInfosByRoleIds(@NotEmpty(message = "必传角色") @Size(min = 1, message = "角色不能为空") Set<String> roleIds) {
                log.warn("根据roleIds=[{}]查询用户信息s失败, 异常信息=[{}]", roleIds, cause);
                return null;
            }
        };
    }
}
