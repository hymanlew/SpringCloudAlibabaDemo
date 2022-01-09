package com.hyman.common.feign;

import com.hyman.common.cache.DriverCacheInfo;
import com.hyman.common.fallback.DriverFeignFallbackFactory;
import com.hyman.common.model.form.driver.DriverInterViewSearchFORM;
import com.hyman.common.model.form.driver.DriverLabelInfoFORM;
import com.hyman.common.model.form.driver.DriverPageFORM;
import com.hyman.common.model.form.driver.EditDriverMatchFORM;
import com.hyman.common.model.vo.driver.DriverEmailIdNoAddressVO;
import com.hyman.common.model.vo.driver.DriverLabelInfoVO;
import com.hyman.common.model.vo.driver.DriverMatchVO;
import com.hyman.common.model.vo.driver.InterviewInfoVO;
import com.hyman.common.msg.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static com.hyman.common.constant.CommonConstants.JWT_KEY_USER_ID;

/**
 * @author suchangyuan
 * @date 2020/12/2 13:32
 */
@FeignClient(value = "szjw-firmiana-domain-driver", fallbackFactory = DriverFeignFallbackFactory.class, primary = false)
public interface IDriverFeign {
    /**
     * 根据司机编号集合查询司机基础信息
     */
    @ApiOperation("根据司机编号集合查询司机基础信息，开发：苏长远")
    @GetMapping("/v2/driver/info/cache/byids")
    Result<Collection<DriverCacheInfo>> getDriverBasicInfoByIdsForCache(@RequestParam("ids") @NotEmpty Collection<String> ids);

    @ApiOperation(value = "根据司机id集合查询司机的邮箱、身份证号、居住地址信息 开发者：吕荣宇")
    @GetMapping(value = "/v2/driver/selectEmailIdNOAddressListByDriverIds")
    Result<List<DriverEmailIdNoAddressVO>> selectEmailIdNOAddressListByDriverIds(@RequestParam(value = "driverIds") Set<String> driverIds);

    @GetMapping(value = "/v2/driver/getDriverMatchByDriverId")
    Result<DriverMatchVO> getDriverMatchByDriverId(@RequestParam(value = "driverId")  @NotNull(message = "司机id不能为空") String driverId);

    @ApiOperation(value = "根据司机编号分页获取司机信息 开发者：欧俊廷")
    @PostMapping(value = {"/v2/driver/getDriverPageByDriverId"})
    Result getDriverPageByDriverId(@RequestBody @Validated DriverPageFORM form);

    @ApiOperation(value = "批量获取司机面试信息,开发者：欧俊廷")
    @PostMapping("/v2/driver/selectDriverInterviews")
    Result<List<InterviewInfoVO>> getDriverInterviews(@RequestBody @Validated DriverInterViewSearchFORM form);

    @ApiOperation(value = "根据driverIds批量查询司机标签  开发者:欧俊廷")
    @PostMapping("/v2/driver/label-sync/listByIds")
    Result<List<DriverLabelInfoVO>> queryDriverLabelSyncList(@RequestBody @Validated DriverLabelInfoFORM form);

    @ApiOperation("撮合-编辑面试表单 开发者：高艳涛")
    @PostMapping("/v2/driver/edit/interviewToMatch")
    public Result<String> editDriverInterviewToMatch(@RequestBody @Validated EditDriverMatchFORM form, @RequestHeader(JWT_KEY_USER_ID) Long userId);
}
