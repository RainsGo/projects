package com.rainsgo.server.api;

/**
 * Created by Rain on 17-7-31.
 */
public class ApiResultInfoException extends Exception{
    private ApiResultInfoInterface exceptInfo;

    ApiResultInfoException(ApiResultInfoInterface exceptInfo){
        this.exceptInfo = exceptInfo;
    }

    public ApiResultInfoInterface getExceptInfo() {
        return exceptInfo;
    }

    public void setExceptInfo(ApiResultInfoInterface exceptInfo) {
        this.exceptInfo = exceptInfo;
    }
}
