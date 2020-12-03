package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.enums.FinanceActivityType;
import com.example.BalanceSheet.model.Income;
import com.example.BalanceSheet.service.FinanceActivityService;
import org.springframework.http.ResponseEntity;

public class IncomeServiceImpl extends FinanceActivityServiceImpl implements FinanceActivityService {

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addFinanceActivity(AddFinanceActivityRequest request) {
        validateAddFinanceActivityRequest(request, FinanceActivityType.INCOME);
        Income income = (Income) addFinanceActivityToDB(request, FinanceActivityType.INCOME);
        return ResponseEntity.ok(new AddFinanceActivityResponse(msgSource.OK002, income.getId()));
    }

    @Override
    public ResponseEntity<GetFinanceActivityResponse> getFinanceActivity(GetFinanceActivityRequest request) {
        Income income = (Income) findFinanceActivityInDB(request, FinanceActivityType.INCOME);
        return ResponseEntity.ok(new GetFinanceActivityResponse(msgSource.OK004, income.getId(),
                income.getDate(), income.getValue(), income.getIncomeType().toString()));
    }

    @Override
    public ResponseEntity<BasicResponse> deleteFinanceActivity(GetFinanceActivityRequest request) {
        Income income = (Income) findFinanceActivityInDB(request, FinanceActivityType.INCOME);
        incomeRepository.deleteById(income.getId());
        return ResponseEntity.ok(new BasicResponse(msgSource.OK006));
    }
}
