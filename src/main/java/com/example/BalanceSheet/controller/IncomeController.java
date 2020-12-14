package com.example.BalanceSheet.controller;

import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.service.impl.IncomeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("income")
public class IncomeController {
    private IncomeServiceImpl incomeServiceImpl;

    public IncomeController(IncomeServiceImpl incomeServiceImpl) {
        this.incomeServiceImpl = incomeServiceImpl;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<AddFinanceActivityResponse> addIncome(@RequestBody AddFinanceActivityRequest request){
        return incomeServiceImpl.addIncome(request);
    }

    @GetMapping(value = "/get", produces = "application/json")
    public ResponseEntity<GetFinanceActivityResponse> getIncome(@RequestParam GetFinanceActivityRequest request){
        return incomeServiceImpl.getIncome(request);
    }
}
