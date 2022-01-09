package com.hyman.common.cache;

import com.hyman.common.feign.IDriverFeign;
import com.hyman.common.msg.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

/**
 * @author Changyuan Su
 * @date 2020/12/2 下午5:36
 * @Description: 使用feign方式获取源数据
 */
@Slf4j
public class FeignDriverDbCache extends AbstractDriverDbCache {

    private IDriverFeign driverFeign;

    protected FeignDriverDbCache(IDriverFeign driverFeign) {
        this.driverFeign = driverFeign;
    }

    @Override
    public Collection<DriverCacheInfo> doGet(@NotEmpty Collection<String> keys) {
        keys.remove(null);
        Result<Collection<DriverCacheInfo>> infoResult = null;
        if (!CollectionUtils.isEmpty(keys) && (infoResult = driverFeign.getDriverBasicInfoByIdsForCache(keys)).getSuccess()) {
            Collection<DriverCacheInfo> cacheInfos = infoResult.getData();
            return cacheInfos;
        }
        return null;
    }

    @Override
    public int getSize() {
        log.warn("获取数量接口非常耗费性能，暂时不做实现");
        return super.getSize();
    }
}
