package com.revature.class_loading;

public class Bird {

    {
        System.out.println("b1");
    }

    Bird() {
        System.out.println("b2");
    }

    static {
        System.out.println("b3");
    }

}
