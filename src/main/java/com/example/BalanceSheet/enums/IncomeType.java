package com.example.BalanceSheet.enums;

public enum IncomeType {
    I1("Umowa o pracę"),
    I2("Zlecenie"),
    I3("Kontrakt"),
    I4("Darowizna"),
    I5("Pożyczka"),
    I6("Dotacja");

    private String iType;
    IncomeType(String iType) {
        this.iType = iType;
    }

    public String getiType() {
        return iType;
    }
}
