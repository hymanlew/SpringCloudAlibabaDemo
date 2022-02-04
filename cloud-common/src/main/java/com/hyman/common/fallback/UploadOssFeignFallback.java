package com.hyman.common.fallback;

import com.hyman.common.feign.UploadOssFeign;
import com.hyman.common.model.dto.core.WechatSendSubscribeMessageDTO;
import com.hyman.common.model.form.core.ExportDownRecordAddForm;
import com.hyman.common.msg.Result;
import com.hyman.common.vo.AliyunOSSResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@Slf4j
public class UploadOssFeignFallback implements UploadOssFeign {

    @Override
    public Result<Object> sendSms(String mobiles, String smsParam, String smsTemplateCode) {
        return null;
    }

    @Override
    public Result<Object> postSendWechatSubscribeMessage(List<WechatSendSubscribeMessageDTO> messageBodys) {
        return null;
    }

    @Override
    public Result<AliyunOSSResult> uploadOSS(MultipartFile file, String folder, boolean isEncode, int expire) {
        log.warn("/v1/upload/uploadOSS/{}/{}/{}调用失败了", folder, isEncode, expire);
        return new Result<>(false);
    }

    @Override
    public Result<Object> addExportDownRecordWithRecordId(String recordId, ExportDownRecordAddForm form, Long userId) {
        return null;
    }
}