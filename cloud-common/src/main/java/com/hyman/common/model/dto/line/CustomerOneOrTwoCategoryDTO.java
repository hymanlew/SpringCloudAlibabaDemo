package com.hyman.common.model.dto.line;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Changyuan Su
 * @description: 一二级客户分类实体
 */

@ApiModel("一二级客户分类实体")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOneOrTwoCategoryDTO implements Serializable {

    private static final long serialVersionUID = 3832411728861839152L;

    private Integer code;

    private String name;

    @Singular
    private List<CustomerOneOrTwoCategoryDTO> nextCategorys;
}