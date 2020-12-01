package com.example.BalanceSheet.api;

import com.example.BalanceSheet.api.type.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicResponse {
    private String responseMsg;
    private String errorCode;
    private String errorMsg;
    private ResponseStatus responseStatus;

    public BasicResponse() {
    }

    public BasicResponse(String responseMsg) {
        this.responseMsg = responseMsg;
        this.responseStatus = ResponseStatus.SUCCESS;
    }

    public BasicResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.responseStatus = ResponseStatus.ERROR;
    }

    public static BasicResponse of(String responseMsg){
        return new BasicResponse(responseMsg);
    }
    public static BasicResponse ofError(String errorCode, String errorMsg){
        return new BasicResponse(errorCode, errorMsg);
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
