package com.hyman.common.model.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;

/**
 * @author xiefujiang
 * @Classname GetUserMessageDTO
 * @Description
 * @Date 2021/4/21
 */
@Data
@AllArgsConstructor
public class GetUserMessageDTO implements Serializable {
    @NotNull(message = "用户集合为空")
    @Size(min = 1)
    private HashSet<Long> userIds;
    @NotNull(message = "角色id集合为空")
    @Size(min = 1)
    private HashSet<Integer> roleIds;
}
