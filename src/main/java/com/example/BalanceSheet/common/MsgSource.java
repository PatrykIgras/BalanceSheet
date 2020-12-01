package com.example.BalanceSheet.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MsgSource {
    public final ConstErrorMsg ERR001;
    public final ConstErrorMsg ERR002;

    public MsgSource(
            @Value("common.const.error.msg.err001") String err001MsgValue,
            @Value("common.const.error.msg.err002") String err002MsgValue
    ){
        ERR001 = new ConstErrorMsg("ERR001", err001MsgValue);
        ERR002 = new ConstErrorMsg("ERR002", err002MsgValue);
    }
}
