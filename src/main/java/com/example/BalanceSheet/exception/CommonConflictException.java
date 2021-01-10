package com.example.BalanceSheet.exception;

import com.example.BalanceSheet.common.ConstErrorMsg;

public class CommonConflictException extends CommonException {

    public CommonConflictException(ConstErrorMsg constErrorMsg) {
        super(constErrorMsg);
    }
}
