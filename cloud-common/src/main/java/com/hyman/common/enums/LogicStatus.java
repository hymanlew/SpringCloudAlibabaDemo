package com.hyman.common.enums;

import lombok.Getter;

/**
 * @description: 逻辑删除键
 * @author: hyman
 * @date: 2020/5/9
 */
@Getter
public enum LogicStatus {
	// 逻辑真
	LTRUE(1),
	// 逻辑假
	LFALSE(0);
	private int status;

	LogicStatus(int status) {
		this.status = status;
	}
}
