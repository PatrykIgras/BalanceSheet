package com.example.BalanceSheet.api.response;

import com.example.BalanceSheet.api.BasicResponse;

import java.time.LocalDateTime;

public class GetFinanceActivityResponse extends BasicResponse {
    private int id;
    private LocalDateTime date;
    private double value;
    private String type;

    public GetFinanceActivityResponse() {
    }

    public GetFinanceActivityResponse(String responseMsg, int id, LocalDateTime date, double value, String type) {
        super(responseMsg);
        this.id = id;
        this.date = date;
        this.value = value;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
