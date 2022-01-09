package com.hyman.common.model.form.waybill;

import com.hyman.common.vo.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

/**
 * @author Changyuan Su
 * @date 2019/3/7 12:00
 * @Description:
 */
@Data
public class KeyQuery extends PageQuery implements Serializable {

    private static final long serialVersionUID = 5727288270601018731L;
    @Nullable
    @ApiModelProperty(value = "搜索关键字")
    private String key;

    @ApiModelProperty(value = "集合ids")
    private List selectIds;

    @ApiModelProperty(value = "项目id集合")
    private List projectIds;


}
