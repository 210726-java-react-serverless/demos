package com.revature.interfaces;

import java.io.Serializable;

/*
    Interfaces serve as a contract of method signatures that will
    be implemented by all concrete classes implementations of this interface.

    Marker Interfaces
        - Interfaces with no methods in them...
        - Kinda serve the same purpose as annotations (annotations were introduced in Java 5)
        - Examples:
            + Serializable
            + Remote
            + Cloneable

    "Standard" Interfaces
        - Typical interfaces, nothing fancy
        - Have method stubs that will be implemented by concrete classes
        - Could potentially have public, static, final fields that are also shared across all implementations

    Functional Interfaces
        - Were introduced in Java 8
        - Interfaces with one and only one abstract method
        - Can be used with a lambda expression
            + Lambda expressions are the inline implementation of a functional interfaces one and only abstract method
        - Examples:
            + Runnable (exposes the run() method)
            + Supplier (exposes the get() method)
            + Predicate (exposes the test() method)
            + Function
            + Consumer

 */
@FunctionalInterface
public interface MyInterface extends Serializable {

    // method stub (abstract)
    void foo();

    // static method (concrete; cannot be overridden)
    static void bar() {

    }

    // default method (concrete; can be overridden; introduced in Java 8)
    default void baz() {

    }
}
