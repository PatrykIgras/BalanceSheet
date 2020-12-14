package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.common.MsgSource;
import com.example.BalanceSheet.enums.ExpenseType;
import com.example.BalanceSheet.exception.CommonBadRequestException;
import com.example.BalanceSheet.exception.CommonException;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.repository.ExpenseRepository;
import com.example.BalanceSheet.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    MsgSource msgSource;
    ExpenseRepository expenseRepository;

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addExpence(AddFinanceActivityRequest request) {
        validateAddFinanceActivityRequest(request);
        Expense expense = (Expense) addFinanceActivityToDB(request);
        return ResponseEntity.ok(new AddFinanceActivityResponse(msgSource.OK001, expense.getId()));
    }

    @Override
    public ResponseEntity<GetFinanceActivityResponse> getExpence(GetFinanceActivityRequest request) {
        Expense expense = (Expense) findFinanceActivityInDB(request);
        return ResponseEntity.ok(new GetFinanceActivityResponse(msgSource.OK003, expense.getId(),
                expense.getDate(), expense.getValue(), expense.getExpenseType().toString()));
    }

    @Override
    public ResponseEntity<BasicResponse> deleteExpence(GetFinanceActivityRequest request) {
        Expense expense = (Expense) findFinanceActivityInDB(request);
        expenseRepository.deleteById(expense.getId());
        return ResponseEntity.ok(new BasicResponse(msgSource.OK005));
    }

    Object findFinanceActivityInDB(GetFinanceActivityRequest request){
            Optional<Expense> optionalExpense = expenseRepository.findById(request.getId());
            if (!optionalExpense.isPresent()) {
                throw new CommonException(msgSource.ERR003);
            }
        return optionalExpense.get();
    }

    void validateAddFinanceActivityRequest(AddFinanceActivityRequest request){
        boolean validate = false;
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
    }

    Object addFinanceActivityToDB(AddFinanceActivityRequest request){
        ExpenseType expenseType = ExpenseType.valueOf(request.getType());
        Expense expense = new Expense(
                null,
                request.getDate(),
                request.getValue(),
                expenseType
        );
        return expenseRepository.save(expense);
    }
}
