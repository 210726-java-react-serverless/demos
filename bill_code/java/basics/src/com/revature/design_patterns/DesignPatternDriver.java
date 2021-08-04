package com.revature.design_patterns;

import com.revature.design_patterns.factory.Currency;
import com.revature.design_patterns.factory.CurrencyFactory;
import com.revature.design_patterns.singleton.EagerHighlander;

public class DesignPatternDriver {

    public static void main(String[] args) {
        EagerHighlander theOnlyOne = EagerHighlander.getTheOne();
        EagerHighlander stillTheOne = EagerHighlander.getTheOne();
        System.out.println(theOnlyOne == stillTheOne);

        //-------------------------------------------------

        String country = "Venezuela";
        Currency dollar = CurrencyFactory.printMoney(country);
        System.out.println(dollar.getSymbol());
    }
}
