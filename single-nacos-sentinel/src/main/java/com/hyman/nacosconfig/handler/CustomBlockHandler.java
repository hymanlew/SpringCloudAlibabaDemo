package com.hyman.nacosconfig.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomBlockHandler {

    public static String handlerException(BlockException e){
        return "自定义全局限流，返回响应 --- normal";
    }

    public static String handlerExceptionSelf(BlockException e){
        return "自定义全局限流，返回响应 --- self";
    }
}
