package com.example.BalanceSheet.exception;

import com.example.BalanceSheet.common.ConstErrorMsg;

public class CommonBadRequestException extends CommonException{

    public CommonBadRequestException(ConstErrorMsg constErrorMsg) {
        super(constErrorMsg);
    }
}
