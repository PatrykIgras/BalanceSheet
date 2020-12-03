package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.common.MsgSource;
import com.example.BalanceSheet.enums.ExpenseType;
import com.example.BalanceSheet.enums.FinanceActivityType;
import com.example.BalanceSheet.enums.IncomeType;
import com.example.BalanceSheet.exception.CommonBadRequestException;
import com.example.BalanceSheet.exception.CommonException;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.model.Income;
import com.example.BalanceSheet.repository.ExpenseRepository;
import com.example.BalanceSheet.repository.IncomeRepository;

import java.util.Optional;

public class FinanceActivityServiceImpl {

    MsgSource msgSource;
    ExpenseRepository expenseRepository;
    IncomeRepository incomeRepository;

    Object findFinanceActivityInDB(GetFinanceActivityRequest request, FinanceActivityType type){
        Object objectToReturn = new Object();
        if (type == FinanceActivityType.EXPENSE) {
            Optional<Expense> optionalExpense = expenseRepository.findById(request.getId());
            if (!optionalExpense.isPresent()) {
                throw new CommonException(msgSource.ERR003);
            }
            objectToReturn =  optionalExpense.get();
        }else if (type == FinanceActivityType.INCOME){
            Optional<Income> optionalIncome = incomeRepository.findById(request.getId());
            if (!optionalIncome.isPresent()) {
                throw new CommonException(msgSource.ERR004);
            }
            objectToReturn =  optionalIncome.get();
        }
        return objectToReturn;
    }

    void validateAddFinanceActivityRequest(AddFinanceActivityRequest request, FinanceActivityType type){
        boolean validate = false;
        if (type == FinanceActivityType.EXPENSE) {
            ExpenseType[] types = ExpenseType.values();
            for (ExpenseType eType : types) {
                if (eType.geteType().equals(request.getType())) {
                    validate = true;
                    break;
                }
            }
            if (!validate) {
                throw new CommonBadRequestException(msgSource.ERR002);
            }
        }else if (type == FinanceActivityType.INCOME) {
            IncomeType[] types = IncomeType.values();
            for (IncomeType iType : types) {
                if (iType.getiType().equals(request.getType())) {
                    validate = true;
                    break;
                }
            }
            if (!validate) {
                throw new CommonBadRequestException(msgSource.ERR001);
            }
        }
    }

    Object addFinanceActivityToDB(AddFinanceActivityRequest request, FinanceActivityType type){
        Object objectToReturn = new Object();
        if (type == FinanceActivityType.EXPENSE) {
            ExpenseType expenseType = ExpenseType.valueOf(request.getType());
            Expense expense = new Expense(
                    null,
                    request.getDate(),
                    request.getValue(),
                    expenseType
            );
            objectToReturn = expenseRepository.save(expense);
        }else if (type == FinanceActivityType.INCOME){
            IncomeType incomeType = IncomeType.valueOf(request.getType());
            Income income = new Income(
                    null,
                    request.getDate(),
                    request.getValue(),
                    incomeType
            );
            objectToReturn = incomeRepository.save(income);
        }
        return objectToReturn;
    }
}
