package com.hyman.common.msg;

import com.hyman.common.vo.BooleanResult;
import com.github.pagehelper.Page;

/**
 * @Author: tianchong
 * @Date: 2018/5/16 16:41
 * @Description:
 */
public final class ResultUtils {

    public static <T> T getResultData(Result<T> result) {
        if (result == null) {
            return null;
        }
        T data = result.getData();
        return data;
    }

    public static <T> Result<T> getSuccess(T data) {
        if (data instanceof Page) {
            Page<T> p = (Page<T>) data;
            com.hyman.common.msg.Page page = new com.hyman.common.msg.Page();
            page.setLimit(p.getPageSize());
            page.setPage(p.getPageNum());
            page.setTotal(p.getTotal());
            return new Result<T>(data, null, null, true, page, true);
        }
        return new Result<T>(data, null, null, true, null, false);
    }

    /**
     * 无分页
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data, null, null, true, null, false);
    }

    public static <T> Result<T> success() {
        return new Result<T>().success();
    }

    /**
     * 返回失败响应
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result fail(int code, String msg) {
        return new Result().fail(code, msg);
    }

    /*public static <T> Result<T> getFault(Integer code,String message) {
        return new Result<T>(code,message);
    }*/

    public static Result<BooleanResult> getBooleanResult(boolean result) {
        int code = result ? 1000 : 500;
        String msg = result ? "操作成功" : "操作失败";
        BooleanResult br = new BooleanResult(result);
        return new Result<BooleanResult>(br, code, msg, result, null, false);
    }

    /*public static Result<BooleanResult> getBooleanResult(boolean result,String msg) {
        int code = result?Result.RESULT_SUCCESS:Result.RESULT_FAULT;
        BooleanResult br = new BooleanResult(result,msg);
        return new Result<BooleanResult>(br,code,msg,null,false);
    }*/

    /***
     * 继承pageQuery实现分页的结果集
     * @param data
     * @param pageQuery
     * @param <T>
     * @return
     */
    public static <T> Result<T> getPageSuccess(T data, com.hyman.common.msg.Page page) {
        return new Result<T>(data, null, null, true, page, true);
    }

    public static Result<BooleanResult> getBooleanListResult(boolean result) {
        int code = result ? 1000 : 500;
        String msg = result ? "操作成功" : "此线路创建的标书已撮合成功，线路无法失效，请操作标书下线";
        BooleanResult br = new BooleanResult(result);
        return new Result<BooleanResult>(br, code, msg, result, null, false);
    }

}
