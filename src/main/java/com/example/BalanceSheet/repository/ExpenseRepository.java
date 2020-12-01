package com.example.BalanceSheet.repository;

import com.example.BalanceSheet.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
