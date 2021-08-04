package com.revature.design_patterns.factory;

public class Bitcoin implements Currency {
    @Override
    public String getSymbol() {
        return "BTC";
    }
}
