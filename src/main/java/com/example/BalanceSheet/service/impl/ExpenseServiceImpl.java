package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.common.MsgSource;
import com.example.BalanceSheet.enums.ExpenseType;
import com.example.BalanceSheet.enums.IncomeType;
import com.example.BalanceSheet.exception.CommonBadRequestException;
import com.example.BalanceSheet.exception.CommonConflictException;
import com.example.BalanceSheet.exception.CommonException;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.repository.ExpenseRepository;
import com.example.BalanceSheet.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private MsgSource msgSource;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addExpence(AddFinanceActivityRequest request) {
        validateAddFinanceActivityRequest(request);
        Expense expense = (Expense) addFinanceActivityToDB(request);
        return ResponseEntity.ok(new AddFinanceActivityResponse(msgSource.OK001, expense.getId()));
    }

    @Override
    public ResponseEntity<GetFinanceActivityResponse> getExpence(Integer id) {
        Expense expense = (Expense) findFinanceActivityInDB(id);
        return ResponseEntity.ok(new GetFinanceActivityResponse(msgSource.OK003, expense.getId(),
                expense.getDate(), expense.getValue(), expense.getExpenseType().geteType()));
    }

    @Override
    public ResponseEntity<BasicResponse> deleteExpence(Integer id) {
        findFinanceActivityInDB(id);
        expenseRepository.deleteById(id);
        return ResponseEntity.ok(new BasicResponse(msgSource.OK005));
    }

    Expense findFinanceActivityInDB(Integer id){
            Optional<Expense> optionalExpense = expenseRepository.findById(id);
            if (!optionalExpense.isPresent()) {
                throw new CommonConflictException(msgSource.ERR003);
            }
        return optionalExpense.get();
    }

    void validateAddFinanceActivityRequest(AddFinanceActivityRequest request){
        boolean validate = false;
        ExpenseType[] types = ExpenseType.values();
        for (ExpenseType eType : types) {
            String value = eType.geteType();
            if (value.equals(request.getType())) {
                validate = true;
                break;
            }
        }
        if (!validate) {
            throw new CommonBadRequestException(msgSource.ERR002);
        }
    }

    Object addFinanceActivityToDB(AddFinanceActivityRequest request){
        ExpenseType expenseType = null;
        ExpenseType[] types = ExpenseType.values();
        for (ExpenseType eType : types) {
            if (eType.geteType().equals(request.getType())) {
                expenseType = eType;
                break;
            }
        }
        Expense expense = new Expense(
                null,
                request.getDate(),
                request.getValue(),
                expenseType
        );
        return expenseRepository.save(expense);
    }
}
