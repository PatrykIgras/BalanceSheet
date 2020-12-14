package com.example.BalanceSheet.model;

import com.example.BalanceSheet.enums.IncomeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDateTime date;
    private double value;
    private IncomeType incomeType;

    public Income() {
    }

    public Income(Integer id, LocalDateTime date, double value, IncomeType incomeType) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.incomeType = incomeType;
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

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id = " + id +
                ", date = " + date +
                ", value = " + value +
                ", incomeType = " + incomeType.getiType() +
                '}';
    }
}
