package com.revature.design_patterns.factory;

public class CurrencyFactory {

    public static Currency printMoney(String country) {

        switch (country) {

            case "USA":
            case "United States":
            case "America":
                return new USDollar();
            case "Germany":
            case "France":
            case "Italy":
                return new Euro();
            case "China":
                return new Yuan();
            case "Venezuela":
                return new RunescapeGold();
            default:
                return new Bitcoin();

        }

    }

}
