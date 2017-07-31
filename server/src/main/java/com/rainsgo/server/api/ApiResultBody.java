package com.rainsgo.server.api;

public class ApiResultBody {
    /**
     * 响应代码
     */
    private Long code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ApiResultBody(Exception exception) {
        this.code = 0L;
        this.message = exception.getMessage();
        this.result = exception;
    }

    public ApiResultBody(Exception exception, int valueHttpStatus) {
        this.code = Long.valueOf(valueHttpStatus);
        this.message = exception.getMessage();
        this.result = exception;
    }

    public ApiResultBody(Exception exception, int valueHttpStatus, String stringHttpStatus) {
        this.code = Long.valueOf(valueHttpStatus);
        this.message = stringHttpStatus;
        this.result = exception;
    }

    public ApiResultBody(ApiException exception) {
        this.code = exception.getErrorCode();
        this.message = exception.getMessage();
        this.result = exception;
    }

    public ApiResultBody(Object result) {
        this.code = 200L;
        this.message = "OK";
        this.result = result;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
