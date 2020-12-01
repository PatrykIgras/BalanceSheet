package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.common.MsgSource;
import com.example.BalanceSheet.enums.ExpenseType;
import com.example.BalanceSheet.exception.CommonBadRequestException;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.repository.ExpenseRepository;
import com.example.BalanceSheet.service.FinanceActivityService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.ResponseEntity;

public class ExpenseServiceImpl implements FinanceActivityService {

    private MsgSource msgSource;
    private ExpenseRepository expenseRepository;

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addFinanceActivity(AddFinanceActivityRequest request) {
        validateAddFinanceActivityRequest(request);
        Expense expense = addExpenseToDB(request);
        return ResponseEntity.ok(new AddFinanceActivityResponse("dodano wydaek", expense.getId()));
    }

    @Override
    public ResponseEntity<GetFinanceActivityResponse> getFinanceActivity(GetFinanceActivityRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<BasicResponse> deleteFinanceActivity(int id) {
        return null;
    }

    private void validateAddFinanceActivityRequest(AddFinanceActivityRequest request){
        ExpenseType[] types = ExpenseType.values();
        boolean validate = false;
        for (ExpenseType type : types){
            if (type.geteType().equals(request.getType())){
                validate = true;
                break;
            }
        }
        if (!validate){
            throw new CommonBadRequestException(msgSource.ERR002);
        }
    }

    private Expense addExpenseToDB(AddFinanceActivityRequest request){
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
