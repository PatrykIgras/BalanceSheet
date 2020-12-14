package com.example.BalanceSheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
@ComponentScan(basePackages = {"com.example.BalanceSheet.controller",
        "com.example.BalanceSheet.repository",
        "com.example.BalanceSheet.common",
        "com.example.BalanceSheet.service"}
)
public class BalanceSheetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalanceSheetApplication.class, args);
    }

}
