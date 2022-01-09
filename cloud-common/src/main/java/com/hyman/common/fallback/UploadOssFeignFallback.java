package com.hyman.common.fallback;

import com.hyman.common.feign.UploadOssFeign;
import com.hyman.common.model.form.core.ExportDownRecordAddForm;
import com.hyman.common.model.form.core.ExportDownRecordUpdateForm;
import com.hyman.common.msg.Result;
import com.hyman.common.vo.AliyunOSSResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Slf4j
public class UploadOssFeignFallback implements UploadOssFeign {

    @Override
    public Result<AliyunOSSResult> uploadOSS(MultipartFile file, String folder, boolean isEncode, int expire) {
        log.warn("/v1/upload/uploadOSS/{}/{}/{}调用失败了", folder, isEncode, expire);
        return new Result<>(false);
    }
    
    @Override
    public Result<String> addExportDownRecord(ExportDownRecordAddForm exportDownRecordAddForm, Long userId) {
        return new Result<>(false);
    }
    
    @Override
    public Result<Object> updateExportDownRecord(ExportDownRecordUpdateForm exportDownRecordUpdateForm, Long userId) {
        return new Result<>(false);
    }
}