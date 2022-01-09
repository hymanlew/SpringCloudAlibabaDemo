package com.hyman.common.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.hyman.common.enums.DriverBusiTypeEnum;
import com.hyman.common.model.vo.base.RedisUserInfoVO;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yantao
 * @Date 2021/3/19 14:38
 * @Describe 梧桐用户业务校验
 */
@Component
public class UserBusiValidator {

    public Integer getWtBusiType(RedisUserInfoVO userInfo) {
        AssertUtil.isTrue(Objects.nonNull(userInfo), "用户信息为空");

        AssertUtil.isTrue(CollectionUtil.isNotEmpty(userInfo.getDutyRoleInfos()), "用户角色为空");

        boolean b = userInfo.getDutyRoleInfos().parallelStream().anyMatch(e -> {
            Integer gmBusiType = e.getBusiType();
            return DriverBusiTypeEnum.FIRMIANA.getCode()
                    .equals(gmBusiType) || DriverBusiTypeEnum.PARTNER.getCode()
                    .equals(gmBusiType);
        });
        AssertUtil.isTrue(b, StrUtil.format("不支持非梧桐业务人员"));

        AtomicReference<Integer> a = new AtomicReference<>(0);
        userInfo.getDutyRoleInfos().forEach(e -> {
            if (Objects.equals(DriverBusiTypeEnum.FIRMIANA.getCode(), e.getBusiType())) {
                a.set(DriverBusiTypeEnum.FIRMIANA.getCode());
            }
            if (Objects.equals(DriverBusiTypeEnum.PARTNER.getCode(), e.getBusiType())) {
                a.set(DriverBusiTypeEnum.PARTNER.getCode());
            }
        });
        return a.get();
    }

    public String getWtDutyName(RedisUserInfoVO userInfo) {
        AssertUtil.isTrue(Objects.nonNull(userInfo), "用户信息为空");

        AssertUtil.isTrue(CollectionUtil.isNotEmpty(userInfo.getDutyRoleInfos()), "用户角色为空");

        boolean b = userInfo.getDutyRoleInfos().parallelStream().anyMatch(e -> {
            Integer gmBusiType = e.getBusiType();
            return DriverBusiTypeEnum.FIRMIANA.getCode()
                    .equals(gmBusiType) || DriverBusiTypeEnum.PARTNER.getCode()
                    .equals(gmBusiType);
        });
        AssertUtil.isTrue(b, StrUtil.format("不支持非梧桐业务人员"));

        AtomicReference<String> a = new AtomicReference<>("");
        userInfo.getDutyRoleInfos().forEach(e -> {
            if (Objects.equals(DriverBusiTypeEnum.FIRMIANA.getCode(), e.getBusiType())
                    || Objects.equals(DriverBusiTypeEnum.PARTNER.getCode(), e.getBusiType())) {
                a.set(e.getDutyName());
            }
        });
        return a.get();
    }
}
