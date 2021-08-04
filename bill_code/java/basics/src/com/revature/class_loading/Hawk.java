package com.revature.class_loading;

public class Hawk extends Raptor {

    static {
        System.out.println("h1");
    }

    public static void main(String[] args) {
        System.out.println("init");
        new Penguin();
        new Hawk();
        System.out.println("hawk");
    }

}
