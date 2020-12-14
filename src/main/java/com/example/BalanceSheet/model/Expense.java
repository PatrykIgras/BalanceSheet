package com.example.BalanceSheet.model;

import com.example.BalanceSheet.enums.ExpenseType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDateTime date;
    private double value;
    private ExpenseType expenseType;

    public Expense() {
    }

    public Expense(Integer id, LocalDateTime date, double value, ExpenseType expenseType) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.expenseType = expenseType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id = " + id +
                ", date = " + date +
                ", value = " + value +
                ", expenseType = " + expenseType.geteType() +
                '}';
    }
}
