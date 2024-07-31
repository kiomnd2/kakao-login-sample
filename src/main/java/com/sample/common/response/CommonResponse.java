package com.sample.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonResponse<T> {
    private String code;
    private String message;
    private T body;

    public CommonResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public static <T> CommonResponse<T> success(T body) {
        return new CommonResponse<>("SUCCESS", "처리성공", body);
    }

    public static <T> CommonResponse<T> failed(String errorCode, String message) {
        return new CommonResponse<>(errorCode, message, null);
    }
}
