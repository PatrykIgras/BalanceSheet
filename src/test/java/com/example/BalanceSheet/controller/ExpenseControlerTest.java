package com.example.BalanceSheet.controller;

import com.example.BalanceSheet.api.response.AddFinanceActivityResponse;
import com.example.BalanceSheet.model.Expense;
import com.example.BalanceSheet.repository.ExpenseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ExpenseControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void ifAddExpenseWithCorrectRequestShouldReturnHttpCode200AndMessage() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(post("/expense/add")
                        .content(
                                "{\n" +
                                        "  \"date\": \"2021-01-10T11:34:44.136Z\",\n" +
                                        "  \"type\": \"Paliwo\",\n" +
                                        "  \"value\": 150\n" +
                                        "}"
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(content().string(Matchers.containsString("Poprawnie dodano wydatek.")))
                .andExpect(content().string(Matchers.containsString("id")))
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        AddFinanceActivityResponse response = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                AddFinanceActivityResponse.class
        );
        Optional<Expense> optionalExpense = expenseRepository.findById(response.getId());
        Assert.assertTrue(optionalExpense.isPresent());
    }

    @Test
    void ifAddExpenseWithIncorrectExpenseTypeShouldReturnHttpCode400AndMessageErr002() throws Exception {
        mockMvc
                .perform(post("/expense/add")
                        .content(
                                "{\n" +
                                        "  \"date\": \"2021-01-10T11:34:44.136Z\",\n" +
                                        "  \"type\": \"IncorrectType\",\n" +
                                        "  \"value\": 150\n" +
                                        "}"
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(400))
                .andExpect(content().string(Matchers.containsString("ERR002")))
                .andReturn();
    }

    @Test
    void ifAddExpenseWithIncorrectDateFormatShouldReturnHttpCode400() throws Exception {
        mockMvc
                .perform(post("/expense/add")
                        .content(
                                "{\n" +
                                        "  \"date\": \"2021-01-10\",\n" +
                                        "  \"type\": \"Paliwo\",\n" +
                                        "  \"value\": 150\n" +
                                        "}"
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(400))
                .andReturn();
    }

    @Test
    void ifAddExpenseWithIncorrectValueTypeShouldReturnHttpCode400() throws Exception {
        mockMvc
                .perform(post("/expense/add")
                        .content(
                                "{\n" +
                                        "  \"date\": \"2021-01-10T11:34:44.136Z\",\n" +
                                        "  \"type\": \"Paliwo\",\n" +
                                        "  \"value\": \"String\"\n" +
                                        "}"
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(400))
                .andReturn();
    }

    @Test
    void ifGetExpenseWithCorrectRequestShouldReturnHttpCode200AndJsonObject() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/expense/add")
                .content(
                        "{\n" +
                                "  \"date\": \"2021-01-10T11:34:44.136Z\",\n" +
                                "  \"type\": \"Paliwo\",\n" +
                                "  \"value\": 150\n" +
                                "}"
                )
                .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        AddFinanceActivityResponse response = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                AddFinanceActivityResponse.class
        );

        mockMvc.perform(get("/expense/get/{expenseId}", response.getId()))
                .andExpect(status().is(200))
                .andExpect(content().json(
                        "{\n" +
                                "\t\"responseMsg\": \"Odnaleziono koszt o podanym id.\",\n" +
                                "\t\"responseStatus\": \"SUCCESS\",\n" +
                                "\t\"id\": 1," +
                                "\t\"date\": \"2021-01-10T11:34:44.136\",\n" +
                                "\t\"value\": 150,\n" +
                                "\t\"type\": \"Paliwo\"\n" +
                                "}"
                ));
    }

    @Test
    void ifGetExpenseWithNoExistIdShouldReturnHttpCode409AndErrorCodeErr003() throws Exception {
        mockMvc.perform(get("/expense/get/{expenseId}", 1))
                .andExpect(status().is(409))
                .andExpect(content().string(Matchers.containsString("ERR003")));
    }

    @Test
    void deleteExpense() {
    }
}