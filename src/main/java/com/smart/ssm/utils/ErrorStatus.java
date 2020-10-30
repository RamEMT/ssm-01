package com.smart.ssm.utils;

import lombok.Getter;

/**
 * @Author: Ram
 * @Since: 2020.10.30 15:50
 */
@Getter
public enum ErrorStatus {
    /**
     *  成功
     */
    SUCCESS(200,"success"),
    /**
     * 系统异常
     */
    SYS_ERROR(4001,"系统异常"),
    /**
     * 服务器异常
     */
    SERVICE_ERROR(404,"服务器异常")
    ;
    /**
     * 状态码
     */
    private final int status;
    /**
     * 状态信息
     */
    private final String message;

    ErrorStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
