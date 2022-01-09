package com.hyman.common.util;

import cn.hutool.core.lang.Assert;
import com.hyman.common.model.vo.base.RedisUserInfoVO;
import com.hyman.common.model.vo.base.StaffInfoVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * description: CodeFormatUtil <br>
 * date: 2020/7/27 9:20 <br>
 * author: hyman <br>
 */
public class CodeFormatUtil {

    //Vo类转换
    public static StaffInfoVO redisUserInfoVOToStaffInfoVO(RedisUserInfoVO vo){
        if (Objects.isNull(vo)){
            return null;
        }
        StaffInfoVO staffInfoVO = new StaffInfoVO();
        staffInfoVO.setCorpUserId(vo.getCorpUserId());
        staffInfoVO.setId(vo.getId());
        staffInfoVO.setMobile(vo.getMobile());
        staffInfoVO.setName(vo.getName());
        staffInfoVO.setStatus(vo.getStatus());
        return staffInfoVO;
    }


    public static List<StaffInfoVO> returnSelf(RedisUserInfoVO userBaseInfo){
        List<StaffInfoVO> self = new ArrayList<>();
        Assert.isNull(userBaseInfo,"用户Id不存在，或者通过feign调用查询用户信息失败");
        self.add(new StaffInfoVO(userBaseInfo.getId(),userBaseInfo.getMobile(),userBaseInfo.getName(),userBaseInfo.getCorpUserId(),userBaseInfo.getStatus()));
        return self;
    }
}
