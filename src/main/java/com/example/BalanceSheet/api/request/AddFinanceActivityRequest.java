package com.example.BalanceSheet.api.request;

import java.time.LocalDateTime;

public class AddFinanceActivityRequest {
    private LocalDateTime date;
    private double value;
    private String type;

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
