package com.example.BalanceSheet.model;

import com.example.BalanceSheet.enums.ExpenseType;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Expense extends FinanceActivity {
    private ExpenseType expenseType;

    public Expense() {
    }

    public Expense(Integer id, LocalDateTime date, double value, ExpenseType expenseType) {
        super(id, date, value);
        this.expenseType = expenseType;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id = " + getId() +
                ", date = " + getDate() +
                ", value = " + getValue() +
                ", expenseType = " + expenseType.geteType() +
                '}';
    }
}
