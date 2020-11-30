package com.example.BalanceSheet.enums;

public enum ExpenseType {
    E1("Podatki"),
    E2("Zakupy spożywcze"),
    E3("Paliwo"),
    E4("Ubrania"),
    E5("Elektronika"),
    E6("Hobby"),
    E7("Dom"),
    E8("Motoryzacja");

    public String eType;

    ExpenseType(String eType) {
        this.eType = eType;
    }

    public String geteType() {
        return eType;
    }
}
