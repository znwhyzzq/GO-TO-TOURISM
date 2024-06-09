package com.zzq.exception;

import com.zzq.comon.ResponseResult;
import com.zzq.constant.CommonConstants;

public class GlobalExceptionMyHandler extends RuntimeException {
    private static String customMessage;

    public GlobalExceptionMyHandler(String message) {
        super(message);
        customMessage = message;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public ResponseResult handleException() {
        return new ResponseResult(CommonConstants.FAIL, getCustomMessage());
    }

}
