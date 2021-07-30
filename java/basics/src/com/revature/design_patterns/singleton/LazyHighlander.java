package com.revature.design_patterns.singleton;

// Lazy instantiation of the singleton pattern
// Not safe in a multithreaded environment!
public class LazyHighlander {

    private static LazyHighlander theOne;

    private LazyHighlander() {

    }

    public static LazyHighlander getTheOne() {

        if (theOne == null) {
            theOne = new LazyHighlander();
        }

        return theOne;
    }

}
