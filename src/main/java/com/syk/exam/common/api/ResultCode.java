package com.syk.exam.common.api;

/**
* @author: syk
* @date: 2019-07-04
* @description: 定义接口实现
**/
public enum ResultCode implements IErrorCode {

    SUCCESS(200,"success"),
    FAILED(500, "failed"),
    VALIDATE_FAILED(404, "validate failed"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden"),
    DUPLICATE(8401,"duplicate");

    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
