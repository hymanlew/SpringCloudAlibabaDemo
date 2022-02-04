package com.hyman.common.feign;

import com.hyman.common.fallback.UploadOssFeignFallback;
import com.hyman.common.model.dto.core.WechatSendSubscribeMessageDTO;
import com.hyman.common.model.form.core.ExportDownRecordAddForm;
import com.hyman.common.msg.Result;
import com.hyman.common.vo.AliyunOSSResult;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@FeignClient(value = "file-core", fallback = UploadOssFeignFallback.class, configuration = UploadOssFeign.MultipartSupportConfig.class)
public interface UploadOssFeign {

    /**
     * 短信发送统一接口
     *
     * @param mobiles         电话
     * @param smsParam        短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致。
     * @param smsTemplateCode 短信模板ID
     */

    @RequestMapping(value = "/sim/sendSms", method = RequestMethod.POST)
    Result<Object> sendSms(@RequestParam("mobiles") String mobiles, @RequestParam("smsParam") String smsParam, @RequestParam("smsTemplateCode") String smsTemplateCode);

    /**
     * 发送微信订阅消息
     *
     * @param messageBodys
     * @return
     */
    //@ApiOperation("微信发送订阅消息")
    @PostMapping("/wx/msg/send")
    Result<Object> postSendWechatSubscribeMessage(@Validated @RequestBody List<WechatSendSubscribeMessageDTO> messageBodys);

    /**
     * 图片上传
     *
     * @param file
     * @param folder
     * @param isEncode
     * @param expire
     * @return
     */
    @RequestMapping(value = "/upload/uploadOSS/{folder}/{isEncode}/{expire}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<AliyunOSSResult> uploadOSS(@RequestPart("file") MultipartFile file,
                                      @PathVariable("folder") String folder,
                                      @PathVariable("isEncode") boolean isEncode,
                                      @PathVariable("expire") int expire);

    //@ApiOperation(value = "添加导出下载记录")
    @RequestMapping(value = "/exportDownRecord/addWithRecordId", method = RequestMethod.POST)
    Result<Object> addExportDownRecordWithRecordId(@RequestParam("recordId") String recordId,
                                                   @RequestBody @Validated ExportDownRecordAddForm form,
                                                   @RequestHeader("userId") Long userId);

    class MultipartSupportConfig {

        @Resource
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }
    }
}
