package com.hyman.common.feign;

import com.hyman.common.fallback.LabelFeignFallbackFactory;
import com.hyman.common.model.form.waybill.DriverLabelSynFORM;
import com.hyman.common.model.vo.driver.DriverLabelPartInfoVO;
import com.hyman.common.msg.Result;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @author: zhaocongcong
 * @date: 2021年05月11日 9:44
 */

@FeignClient(value = "szjw-firmiana-domain-label", fallbackFactory = LabelFeignFallbackFactory.class, primary = false)
public interface LabelFeign {

    @GetMapping("/v3/driver-label/getLastRunDateAndDriverStatusAndDealDate")
    Result<DriverLabelPartInfoVO> getLastRunDateAndDriverSituationAndDealDate(@RequestParam("driverId")
                                                                              @NotBlank(message = "司机编号不能为空") String driverId);

    @ApiOperation(value = "(增量、全量)同步司机标签数据 开发者：欧俊廷")
    @PostMapping("/v3/driver-label/synDriverLabel")
    Result sendMatchLabelMsg(@RequestBody DriverLabelSynFORM form);

    @ApiOperation(value = "根据司机Id批量获取司机的租赁全藏标签 开发者：金永洋")
    @PostMapping("/v3/driver-label/getDriverRentalHide")
    Result<Map<String, Boolean>> getDriverRentalHide(@RequestBody List<String> driverIds);
}
