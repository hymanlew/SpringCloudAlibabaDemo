package com.hyman.common.msg.sms;

/**
 * @author Changyuan Su
 * @date 2020/12/7 下午1:56
 * @Description:
 */
public interface Callback<R extends Response> {


    /**
     * 发送成功时调用
     *
     * @param response
     */
    default void onSuccess(R response) {
        try {
            onResponse(response);
        } finally {
            onComplete(response);
        }
    }


    /**
     * 发送失败时调用
     *
     * @param response
     * @param e
     */
    default void onFail(R response, Exception e) {
        try {
            onFailure(response, e);
        } finally {
            onComplete(response);
        }
    }

    /**
     * 消息发送成功
     *
     * @param response
     */
    void onResponse(R response);

    /**
     * 消息发送失败
     *
     * @param response
     * @param e
     */
    void onFailure(R response, Exception e);


    /**
     * 消息发送完成，无论成功或失败，都会调用
     *
     * @param response
     */
    void onComplete(R response);
}
