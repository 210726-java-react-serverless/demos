package com.revature.class_loading;

public class Penguin extends Bird {

    static {
        System.out.println("p1");
    }

    {
        System.out.println("p2");
    }

}
