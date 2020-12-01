package com.example.BalanceSheet.service;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import org.springframework.http.ResponseEntity;

public interface FinanceActivityService {

    ResponseEntity<AddFinanceActivityResponse> addFinanceActivity(AddFinanceActivityRequest request);
    ResponseEntity<GetFinanceActivityResponse> getFinanceActivity(GetFinanceActivityRequest request);
    ResponseEntity<BasicResponse> deleteFinanceActivity(int id);
}
