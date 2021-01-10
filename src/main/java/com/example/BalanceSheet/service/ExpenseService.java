package com.example.BalanceSheet.service;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import org.springframework.http.ResponseEntity;

public interface ExpenseService {

    ResponseEntity<AddFinanceActivityResponse> addExpence(AddFinanceActivityRequest request);
    ResponseEntity<GetFinanceActivityResponse> getExpence(Integer id);
    ResponseEntity<BasicResponse> deleteExpence(Integer id);
}
