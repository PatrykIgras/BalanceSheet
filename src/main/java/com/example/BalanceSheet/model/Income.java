package com.example.BalanceSheet.model;

import com.example.BalanceSheet.enums.IncomeType;

import javax.persistence.Entity;

@Entity
public class Income extends FinanceActivity {
    private IncomeType incomeType;

    public IncomeType getIncomeType() {
        return incomeType;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id = " + getId() +
                ", date = " + getDate() +
                ", value = " + getValue() +
                ", incomeType = " + incomeType.getiType() +
                '}';
    }
}
