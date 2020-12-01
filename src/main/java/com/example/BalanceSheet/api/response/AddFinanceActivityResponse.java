package com.example.BalanceSheet.api.response;

import com.example.BalanceSheet.api.BasicResponse;

public class AddFinanceActivityResponse extends BasicResponse {
    private Integer id;

    public AddFinanceActivityResponse() {
    }

    public AddFinanceActivityResponse(String responseMsg, Integer id) {
        super(responseMsg);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
