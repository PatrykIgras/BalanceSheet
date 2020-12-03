package com.example.BalanceSheet.model;

import com.example.BalanceSheet.enums.IncomeType;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Income extends FinanceActivity {
    private IncomeType incomeType;

    public Income() {
    }

    public Income(Integer id, LocalDateTime date, double value, IncomeType incomeType) {
        super(id, date, value);
        this.incomeType = incomeType;
    }

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
