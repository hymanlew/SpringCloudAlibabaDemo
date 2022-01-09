package com.hyman.common.fallback;

import com.hyman.common.cache.DriverCacheInfo;
import com.hyman.common.feign.IDriverFeign;
import com.hyman.common.model.form.driver.DriverInterViewSearchFORM;
import com.hyman.common.model.form.driver.DriverLabelInfoFORM;
import com.hyman.common.model.form.driver.DriverPageFORM;
import com.hyman.common.model.form.driver.EditDriverMatchFORM;
import com.hyman.common.model.vo.driver.DriverEmailIdNoAddressVO;
import com.hyman.common.model.vo.driver.DriverLabelInfoVO;
import com.hyman.common.model.vo.driver.DriverMatchVO;
import com.hyman.common.model.vo.driver.InterviewInfoVO;
import com.hyman.common.msg.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Changyuan Su
 * @date 2020/12/2 下午1:37
 * @Description:
 */
@Slf4j
@Component(value = "driverBaseInfoFeignFallbackFactory")
public class DriverFeignFallbackFactory implements FallbackFactory<IDriverFeign> {
    @Override
    public IDriverFeign create(Throwable cause) {
        return new IDriverFeign() {
            @Override
            public Result<Collection<DriverCacheInfo>> getDriverBasicInfoByIdsForCache(@NotEmpty Collection<String> ids) {
                log.info("获取司机基础信息失败，ids=[{}], ex=[{}]", ids, cause.toString());
                return null;
            }

            @Override
            public Result<List<DriverEmailIdNoAddressVO>> selectEmailIdNOAddressListByDriverIds(Set<String> driverIds) {
                log.info("根据司机id集合查询司机的邮箱、身份证号、居住地址信息失败，ids=[{}], ex=[{}]", driverIds, cause.toString());
                return new Result<>(false);
            }

            @Override
            public Result<DriverMatchVO> getDriverMatchByDriverId(@NotNull(message = "司机id不能为空") String driverId) {
                return null;
            }

            @Override
            public Result getDriverPageByDriverId(DriverPageFORM form) {
                log.info("分页查询司机信息失败，driverIds=[{}], ex=[{}]", form.getDriverIds(), cause.toString());
                return null;
            }

            @Override
            public Result<List<InterviewInfoVO>> getDriverInterviews(DriverInterViewSearchFORM form) {
                log.info("批量查询司机面试信息失败，data=[{}], ex=[{}]", form.getData(), cause.toString());
                return null;
            }

            @Override
            public Result<List<DriverLabelInfoVO>> queryDriverLabelSyncList(DriverLabelInfoFORM form) {
                log.info("根据driverIds批量查询司机标签失败，data=[{}], ex=[{}]", form.getDriverIds(), cause.toString());
                return null;
            }

            @Override
            public Result<String> editDriverInterviewToMatch(EditDriverMatchFORM form, Long userId) {
                return null;
            }
        };
    }
}
