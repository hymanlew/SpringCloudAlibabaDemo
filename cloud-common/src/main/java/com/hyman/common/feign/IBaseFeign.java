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
@FeignClient(value = "microservice-provider-base", fallbackFactory = IBaseFeignFallback.class, primary = false)
public interface IBaseFeign {

    @RequestMapping(value = "base/dict/qryDict", method = RequestMethod.GET)
    Result<List<SysCode>> qryDict();

    /**
     * 根据 type 类型获取字典数据
     */
    @RequestMapping(value = "/v1/base/dict/back/dictData/list", method = RequestMethod.POST)
    Result<List<DictDataVO>> getDictByType(@RequestBody DictDataListFORM dictDataListFORM);

    @GetMapping("/user/area/getAreaNameByCityCode/{cityCodes}")
    Result<HashMap<String, String>> getAreaNameByCityCode(@PathVariable("cityCodes") int[] cityCodes);

    @RequestMapping(value = "user/bss/getSyncUserInfoToRedis", method = RequestMethod.GET)
    void getSyncUserInfoToRedis();

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

    @ApiOperation(value = "根据角色id查询角色的相关权限信息")
    @GetMapping("/v1/base/role/getRoleAuthorityByRoleId")
    Result<List<RoleAuthorityDTO>> getRoleAuthorityByRoleId(@RequestParam("roleId") Long roleId);

    @ApiOperation(value = "查询相关角色的用户列表[加盟经理，外线销售...]，支持根据产品线、城市编码、角色类型查询")
    @PostMapping("/v2/base/user/getSpecifiedUserListByCondition")
    Result<List<StaffInfoVO>> querySpecifiedUserList(@Validated @RequestBody QuerySpecifiedUserListForm form);

    @ApiOperation(value = "查询相关角色的已启用状态下的用户列表[加盟经理，外线销售...]，支持根据产品线、城市编码、角色类型查询。开发者：胡长亮")
    @PostMapping("/v2/base/user/getSpecifiedActiveUserList")
    Result<List<StaffActiveInfoVO>> querySpecifiedActiveUserList(@Validated @RequestBody QuerySpecifiedUserListForm form);

    @ApiOperation("根据roleId查询用户信息s 开发者：苏长远")
    @PostMapping(value = "/v2/base/user/getUserInfoByRoleId")
    Result<List<BasicUserInfoVO>> getUserInfosByRoleIds(@NotEmpty(message = "必传角色") @Size(min = 1, message = "角色不能为空") @RequestBody Set<String> roleIds);

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