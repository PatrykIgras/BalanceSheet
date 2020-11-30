package com.example.BalanceSheet.model;

import com.example.BalanceSheet.enums.*;
import javax.persistence.Entity;

@Entity
public class Expense extends FinanceActivity {
    private ExpenseType expenseType;

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id = " + getId() +
                ", date = " + getDate() +
                ", value = " + getValue() +
                ", expenseType = " + expenseType +
                '}';
    }
}
