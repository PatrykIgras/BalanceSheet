package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.service.FinanceActivityService;
import org.springframework.http.ResponseEntity;

public class IncomeServiceImpl implements FinanceActivityService {

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addFinanceActivity(AddFinanceActivityRequest request) {
        return null;
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
        //TODO
    }
}
