package com.hyman.common.feign;

import com.hyman.common.fallback.IBaseFeignFallback;
import com.hyman.common.model.dto.base.SysCode;
import com.hyman.common.model.form.order.DictDataListFORM;
import com.hyman.common.model.vo.base.DictDataVO;
import com.hyman.common.msg.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;

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

    @GetMapping("base/dict/getCityCode")
    Result<String> getCityCode(@RequestParam("cityName") @NotBlank String cityName);

}