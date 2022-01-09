package com.hyman.common.fallback;

import com.hyman.common.feign.LabelFeign;
import com.hyman.common.model.form.waybill.DriverLabelSynFORM;
import com.hyman.common.model.vo.driver.DriverLabelPartInfoVO;
import com.hyman.common.msg.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: zhaocongcong
 * @date: 2021年05月11日 9:45
 */
@Service
@Slf4j
public class LabelFeignFallbackFactory implements FallbackFactory<LabelFeign> {

    @Override
    public LabelFeign create(Throwable throwable) {
        return new LabelFeign() {

            @Override
            public Result<DriverLabelPartInfoVO> getLastRunDateAndDriverSituationAndDealDate(@NotBlank(message = "司机编号不能为空") String driverId) {
                return null;
            }

            @Override
            public Result sendMatchLabelMsg(DriverLabelSynFORM form) {
                return null;
            }

            @Override
            public Result<Map<String, Boolean>> getDriverRentalHide(List<String> driverIds) {
                return null;
            }
        };
    }
}
