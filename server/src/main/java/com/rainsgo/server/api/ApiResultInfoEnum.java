package com.rainsgo.server.api;

/**
 * Created by Rain on 17-7-31.
 */
public enum ApiResultInfoEnum implements ApiResultInfoInterface {
    SUCCESS(200L, "OK"),
    NOT_FOUND(204L, "Not Found");

    private Long code;

    private String message;

    ApiResultInfoEnum(Long code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
