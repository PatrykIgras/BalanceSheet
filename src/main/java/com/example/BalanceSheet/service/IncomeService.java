package com.example.BalanceSheet.service;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import org.springframework.http.ResponseEntity;

public interface IncomeService {

    ResponseEntity<AddFinanceActivityResponse> addIncome(AddFinanceActivityRequest request);
    ResponseEntity<GetFinanceActivityResponse> getIncome(Integer id);
    ResponseEntity<BasicResponse> deleteIncome(Integer id);
}
