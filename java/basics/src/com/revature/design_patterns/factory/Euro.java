package com.revature.design_patterns.factory;

public class Euro implements Currency {
    @Override
    public String getSymbol() {
        return "EUR";
    }
}
