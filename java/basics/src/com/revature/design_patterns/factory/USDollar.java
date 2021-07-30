package com.revature.design_patterns.factory;

public class USDollar implements Currency {
    @Override
    public String getSymbol() {
        return "USD";
    }
}
