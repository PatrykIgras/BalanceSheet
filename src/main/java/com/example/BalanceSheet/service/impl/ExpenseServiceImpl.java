package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.enums.FinanceActivityType;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.service.FinanceActivityService;
import org.springframework.http.ResponseEntity;

public class ExpenseServiceImpl extends FinanceActivityServiceImpl implements FinanceActivityService {

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addFinanceActivity(AddFinanceActivityRequest request) {
        validateAddFinanceActivityRequest(request, FinanceActivityType.EXPENSE);
        Expense expense = (Expense) addFinanceActivityToDB(request, FinanceActivityType.EXPENSE);
        return ResponseEntity.ok(new AddFinanceActivityResponse(msgSource.OK001, expense.getId()));
    }

    @Override
    public ResponseEntity<GetFinanceActivityResponse> getFinanceActivity(GetFinanceActivityRequest request) {
        Expense expense = (Expense) findFinanceActivityInDB(request, FinanceActivityType.EXPENSE);
        return ResponseEntity.ok(new GetFinanceActivityResponse(msgSource.OK003, expense.getId(),
                expense.getDate(), expense.getValue(), expense.getExpenseType().toString()));
    }

    @Override
    public ResponseEntity<BasicResponse> deleteFinanceActivity(GetFinanceActivityRequest request) {
        Expense expense = (Expense) findFinanceActivityInDB(request, FinanceActivityType.EXPENSE);
        expenseRepository.deleteById(expense.getId());
        return ResponseEntity.ok(new BasicResponse(msgSource.OK005));
    }

}
