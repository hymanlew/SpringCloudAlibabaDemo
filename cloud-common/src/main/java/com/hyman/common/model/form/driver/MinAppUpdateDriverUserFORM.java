package com.hyman.common.model.form.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Changyuan Su
 * @date 2020/8/5 下午4:41
 * @Description:
 */
@ApiModel("小程序修改司机用户")
@Data
public class MinAppUpdateDriverUserFORM implements Serializable {

    private static final long serialVersionUID = 6904212532320573807L;

    @NotBlank
    private String userId;


    /**
     * 手机号
     */
    @NotNull(message = "手机号有误")
    @Range(min = 13000000001L, max = 19999999999L, message = "手机号有误")
    @ApiModelProperty(value = "手机号")
    private Long phone;


}
