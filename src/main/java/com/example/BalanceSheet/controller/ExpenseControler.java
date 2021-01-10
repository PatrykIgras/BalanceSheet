package com.example.BalanceSheet.controller;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.service.impl.ExpenseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class ExpenseControler {

    private ExpenseServiceImpl expenseService;

    public ExpenseControler(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<AddFinanceActivityResponse> addExpense(@RequestBody AddFinanceActivityRequest request){
        return expenseService.addExpence(request);
    }

    @GetMapping(value = "/get/{expenseId}")
    public ResponseEntity<GetFinanceActivityResponse> getExpense(@PathVariable Integer expenseId){
        return expenseService.getExpence(expenseId);
    }

    @PutMapping(value = "/delete/{expenseId}")
    public ResponseEntity<BasicResponse> deleteExpense(@PathVariable Integer expenseId){
        return expenseService.deleteExpence(expenseId);
    }
}
