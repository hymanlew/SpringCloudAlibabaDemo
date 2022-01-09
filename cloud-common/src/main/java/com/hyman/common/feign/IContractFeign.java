package com.hyman.common.feign;

import com.hyman.common.model.form.order.ContractReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: hyman
 * @date: 2020/5/11
 */
@FeignClient(value = "szjw-firmiana-domain-order", primary = false)
public interface IContractFeign {
    /**
     * 回调更新合同状态
     *
     * @param contractReponse
     * @return
     */
    @RequestMapping(value = "contract/updateContractStatus", method = RequestMethod.GET)
    String updateContractStatus(ContractReponse contractReponse);

}
