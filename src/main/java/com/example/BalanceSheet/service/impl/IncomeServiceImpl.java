package com.example.BalanceSheet.service.impl;

import com.example.BalanceSheet.api.BasicResponse;
import com.example.BalanceSheet.api.request.AddFinanceActivityRequest;
import com.example.BalanceSheet.api.request.GetFinanceActivityRequest;
import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.api.response.GetFinanceActivityResponse;
import com.example.BalanceSheet.common.MsgSource;
import com.example.BalanceSheet.enums.ExpenseType;
import com.example.BalanceSheet.enums.FinanceActivityType;
import com.example.BalanceSheet.enums.IncomeType;
import com.example.BalanceSheet.exception.CommonBadRequestException;
import com.example.BalanceSheet.exception.CommonException;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.model.Income;
import com.example.BalanceSheet.repository.ExpenseRepository;
import com.example.BalanceSheet.repository.IncomeRepository;
import com.example.BalanceSheet.service.IncomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    MsgSource msgSource;
    IncomeRepository incomeRepository;

    public IncomeServiceImpl(MsgSource msgSource, IncomeRepository incomeRepository) {
        this.msgSource = msgSource;
        this.incomeRepository = incomeRepository;
    }

    @Override
    public ResponseEntity<AddFinanceActivityResponse> addIncome(AddFinanceActivityRequest request) {
        validateAddFinanceActivityRequest(request);
        Income income = (Income) addFinanceActivityToDB(request);
        return ResponseEntity.ok(new AddFinanceActivityResponse(msgSource.OK002, income.getId()));
    }

    @Override
    public ResponseEntity<GetFinanceActivityResponse> getIncome(GetFinanceActivityRequest request) {
        Income income = (Income) findFinanceActivityInDB(request);
        return ResponseEntity.ok(new GetFinanceActivityResponse(msgSource.OK004, income.getId(),
                income.getDate(), income.getValue(), income.getIncomeType().toString()));
    }

    @Override
    public ResponseEntity<BasicResponse> deleteIncome(GetFinanceActivityRequest request) {
        Income income = (Income) findFinanceActivityInDB(request);
        incomeRepository.deleteById(income.getId());
        return ResponseEntity.ok(new BasicResponse(msgSource.OK006));
    }

    Object findFinanceActivityInDB(GetFinanceActivityRequest request){
        Optional<Income> optionalIncome = incomeRepository.findById(request.getId());
        if (!optionalIncome.isPresent()) {
            throw new CommonException(msgSource.ERR004);
        }
        return optionalIncome.get();
    }

    void validateAddFinanceActivityRequest(AddFinanceActivityRequest request){
        boolean validate = false;
        IncomeType[] types = IncomeType.values();
        for (IncomeType iType : types) {
            if (iType.getiType().equals(request.getType())) {
                validate = true;
                break;
            }
        }
        if (!validate) {
            throw new CommonBadRequestException(msgSource.ERR001);
        }
    }

    Object addFinanceActivityToDB(AddFinanceActivityRequest request){
        IncomeType incomeType = null;
        IncomeType[] types = IncomeType.values();
        for (IncomeType iType : types) {
            if (iType.getiType().equals(request.getType())) {
                incomeType = iType;
                break;
            }
        }
        Income income = new Income(
                null,
                request.getDate(),
                request.getValue(),
                incomeType
        );
        return incomeRepository.save(income);
    }
}
