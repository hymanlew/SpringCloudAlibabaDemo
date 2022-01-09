package com.hyman.common.fallback;

import com.hyman.common.feign.ICoreFeign;
import com.hyman.common.model.dto.core.WechatSendSubscribeMessageDTO;
import com.hyman.common.model.form.core.ExportDownRecordAddForm;
import com.hyman.common.model.form.core.ExportDownRecordUpdateForm;
import com.hyman.common.msg.Result;
import com.hyman.common.vo.AliyunOSSResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:yanwei
 * @Date: 2020/9/11 - 16:51
 */
@Service
@Slf4j
public class ICoreFallBackFactory implements FallbackFactory<ICoreFeign> {
    @Override
    public ICoreFeign create(Throwable throwable) {
        return new ICoreFeign() {
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
                return null;
            }

            @Override
            public Result<String> addExportDownRecord(ExportDownRecordAddForm addForm, Long userId) {
                return null;
            }

            @Override
            public Result<Object> addExportDownRecordWithRecordId(String recordId, ExportDownRecordAddForm form, Long userId) {
                return null;
            }

            @Override
            public Result<Object> updateExportDownRecord(ExportDownRecordUpdateForm updateForm, Long userId) {
                return null;
            }
        };
    }
}
