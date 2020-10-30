package com.smart.ssm.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: Ram
 * @Since: 2020.10.30 15:55
 *
 *  构建者模式
 */
@Data
@Builder
public class ResponseEntity<T> {
    private int status;
    private String message;
    private T data;

    public ResponseEntity() {
    }

    public static <T> ResponseEntity<T> success(T data) {
        return ResponseEntity
                .<T>builder()
                .data(data)
                .status(ErrorStatus.SUCCESS.getStatus())
                .message(ErrorStatus.SUCCESS.getMessage())
                .build();
    }

    public static <T> ResponseEntity<T> success(ErrorStatus errorStatus, T data) {
        return ResponseEntity
                .<T>builder()
                .data(data)
                .status(errorStatus.getStatus())
                .message(errorStatus.getMessage())
                .build();
    }

    public static <T> ResponseEntity<T> error() {
        return ResponseEntity
                .<T>builder()
                .status(ErrorStatus.SYS_ERROR.getStatus())
                .message(ErrorStatus.SYS_ERROR.getMessage())
                .build();
    }

    public static <T> ResponseEntity<T> error(ErrorStatus errorStatus) {
        return ResponseEntity
                .<T>builder()
                .status(errorStatus.getStatus())
                .message(errorStatus.getMessage())
                .build();
    }
}
