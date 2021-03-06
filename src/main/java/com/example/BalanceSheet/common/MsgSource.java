package com.example.BalanceSheet.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MsgSource {
    public final String OK001;
    public final String OK002;
    public final String OK003;
    public final String OK004;
    public final String OK005;
    public final String OK006;

    public final ConstErrorMsg ERR001;
    public final ConstErrorMsg ERR002;
    public final ConstErrorMsg ERR003;
    public final ConstErrorMsg ERR004;

    public MsgSource(
            @Value("${common.ok.msg.ok001}") String ok001MsgValue,
            @Value("${common.ok.msg.ok002}") String ok002MsgValue,
            @Value("${common.ok.msg.ok003}") String ok003MsgValue,
            @Value("${common.ok.msg.ok004}") String ok004MsgValue,
            @Value("${common.ok.msg.ok005}") String ok005MsgValue,
            @Value("${common.ok.msg.ok006}") String ok006MsgValue,

            @Value("${common.const.error.msg.err001}") String err001MsgValue,
            @Value("${common.const.error.msg.err002}") String err002MsgValue,
            @Value("${common.const.error.msg.err003}") String err003MsgValue,
            @Value("${common.const.error.msg.err004}") String err004MsgValue
    ){
        OK001 = ok001MsgValue;
        OK002 = ok002MsgValue;
        OK003 = ok003MsgValue;
        OK004 = ok004MsgValue;
        OK005 = ok005MsgValue;
        OK006 = ok006MsgValue;

        ERR001 = new ConstErrorMsg("ERR001", err001MsgValue);
        ERR002 = new ConstErrorMsg("ERR002", err002MsgValue);
        ERR003 = new ConstErrorMsg("ERR003", err003MsgValue);
        ERR004 = new ConstErrorMsg("ERR004", err004MsgValue);
    }
}
