package com.hyman.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: tianchong
 * @Date: 2018/5/16 16:38
 * @Description:
 */
@ApiModel("返回对象")
@Getter
@Setter
@SuppressWarnings("unchecked")
public class Result<T> extends IResult<T> {

    protected static final Boolean RESULT_SUCCESS = Boolean.TRUE;
    protected static final Boolean RESULT_FAIL = Boolean.FALSE;

    @ApiModelProperty(value = "错误码, 成功返回时为null", example = "错误码")
    private Integer errorCode;
    @ApiModelProperty(value = "错误描述, 成功返回时为null", example = "错误描述")
    private String errorMsg;
    @ApiModelProperty(value = "是否成功, 成功为true, 失败为false", dataType = "boolean")
    private Boolean success = true;
    @ApiModelProperty(value = "分页对象")
    protected Page page;
    // 分页  true:分页   false:不分页
    @ApiModelProperty(value = "是否分页 分页为true, 不分页为false")
    private Boolean paging = false;

    public Result(T data, Integer errorCode, String errorMsg, Boolean success, Page page, boolean notPaging) {
        super(data);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.success = success;
        this.page = page;
        this.paging = notPaging;
    }

    public Result(Boolean success, T data) {
        this(data, (Integer) null, (String) null, success, (Page) new Page(), false);
    }

    public Result(Boolean success, T data, Page page) {
        this(data, (Integer) null, (String) null, success, page, true);
    }

    public Result(Boolean success, T data, Page page, String errorMsg) {
        this(data, (Integer) null, errorMsg, success, page, true);
    }

    public Result(Boolean success) {
        this((T) null, (Integer) null, (String) null, success, (Page) null, false);
    }

    public Result(Boolean success, Integer errorCode, String errorMsg) {
        this(null, errorCode, errorMsg, success, (Page) null, false);
    }

    public Result() {
        this(true);
    }

    /* 成功返回,无返回数据 */
    public Result<T> success() {
        return new Result(RESULT_SUCCESS);
    }

    /* 成功返回,有返回数据 */
    public Result<T> success(T data) {
        return new Result<T>(RESULT_SUCCESS, data, this.page, null);
    }

    public Result<T> success(T data, String errorMsg) {
        return new Result<T>(RESULT_SUCCESS, data, this.page, errorMsg);
    }

    /* 成功返回,有返回数据,有分页 */
    public Result<T> success(Object data, Page page) {
        return new Result(RESULT_SUCCESS, data, page, null);
    }

    /* 成功返回,有返回数据,有分页 */
    public Result<T> success(Object data, Page page, String errorMsg) {
        return new Result(RESULT_SUCCESS, data, page, errorMsg);
    }

    /* 失败返回 */
    public Result<T> fail(int errorCode, String errorMsg) {
        return new Result(RESULT_FAIL, errorCode, errorMsg);
    }
}
