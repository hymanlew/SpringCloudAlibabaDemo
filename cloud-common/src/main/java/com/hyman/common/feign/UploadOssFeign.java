package com.hyman.common.feign;

import com.hyman.common.fallback.UploadOssFeignFallback;
import com.hyman.common.model.form.core.ExportDownRecordAddForm;
import com.hyman.common.model.form.core.ExportDownRecordUpdateForm;
import com.hyman.common.msg.Result;
import com.hyman.common.vo.AliyunOSSResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "szjw-firmiana-domain-core", configuration = ICoreFeign.MultipartSupportConfig.class, fallback = UploadOssFeignFallback.class)
public interface UploadOssFeign {
    @ApiOperation(value = "上传文件到oss")
    @RequestMapping(value = "/v1/upload/uploadOSS/{folder}/{isEncode}/{expire}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Result<AliyunOSSResult> uploadOSS(@RequestPart("file") MultipartFile file,
                                      @PathVariable("folder") String folder,
                                      @PathVariable("isEncode") boolean isEncode,
                                      @PathVariable("expire") int expire);

    @ApiOperation(value = "添加导出下载记录")
    @RequestMapping(value = "/v1/core/exportDownRecord/add", method = RequestMethod.POST)
    Result<String> addExportDownRecord(@RequestBody @Validated ExportDownRecordAddForm exportDownRecordAddForm, @RequestHeader("userId") Long userId);

    @ApiOperation(value = "更新导出下载记录")
    @RequestMapping(value = "/v1/core/exportDownRecord/update", method = RequestMethod.POST)
    Result<Object> updateExportDownRecord(@RequestBody @Validated ExportDownRecordUpdateForm exportDownRecordUpdateForm, @RequestHeader("userId") Long userId);

}
