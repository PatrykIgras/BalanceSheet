package com.example.BalanceSheet.exception;

import com.example.BalanceSheet.common.ConstErrorMsg;

public class CommonException extends RuntimeException{
    private final ConstErrorMsg constErrorMsg;

    public CommonException(ConstErrorMsg constErrorMsg) {
        this.constErrorMsg = constErrorMsg;
    }

    public ConstErrorMsg getConstErrorMsg() {
        return constErrorMsg;
    }
}
