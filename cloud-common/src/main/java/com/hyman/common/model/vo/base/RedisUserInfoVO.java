package com.hyman.common.model.vo.base;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * description: RedisUserInfoVo <br>
 * date: 2020/7/18 16:11 <br>
 * author: hyman <br>
 */
@Data
@NoArgsConstructor
public class RedisUserInfoVO implements Serializable {

    private static final long serialVersionUID = 1770231897548872997L;
    
    @ApiModelProperty("用户ID")
    private Long id;
    
    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("用户的姓名")
    private String name;

    @ApiModelProperty("组织名")
    private String officeName;

    @ApiModelProperty("组织id")
    private Integer officeId;

    @ApiModelProperty("企业唯一id")
    private String corpUserId;

    @ApiModelProperty("密码设置标识")
    private Integer settingFlag;
    
    @ApiModelProperty("状态：1启用，2禁用")
    private Integer status;
    
    @ApiModelProperty("角色信息，包含职责信息")
    private List<DutyRoleInfo> dutyRoleInfos;

    /**
     * 用户组织架构信息
     */
    private OfficeRelationInfo officeRelationInfo;


    public RedisUserInfoVO(String mobile, String name) {
        this.mobile = mobile;
        this.name = name;
    }

    @ApiModel("用户组织架构信息")
    @Data
    public static class OfficeRelationInfo implements Serializable {

        private static final long serialVersionUID = 3432120489524654595L;

        @ApiModelProperty("城市")
        private Integer city;

        /**
         * 双亲节点数据
         */
        @ApiModelProperty("组织树-双亲数据")
        private List<Node> parents;
    
        
        
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Node implements Serializable {

            private static final long serialVersionUID = -2789860791495636846L;

            @ApiModelProperty("组织树节点id")
            private Integer id;

            @ApiModelProperty("中文")
            private String name;

            @ApiModelProperty("层")
            private Integer level;

        }

        public static final int GROUP_LEVEL = 5;

        public String getUserGroupName() {
            if (CollUtil.isEmpty(this.parents)) {
                return StrUtil.EMPTY;
            }
            for (Node parent : this.parents) {
                if (GROUP_LEVEL == parent.level) {
                    return parent.name;
                }
            }
            return StrUtil.EMPTY;
        }
    }
}
