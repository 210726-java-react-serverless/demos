package com.revature.design_patterns.singleton;

// Singleton Design Pattern
// There can be only one.
// Eager instantiation makes this implementation thread-safe
public class EagerHighlander {

    private static EagerHighlander theOne = new EagerHighlander();

    private EagerHighlander() {

    }

    public static EagerHighlander getTheOne() {
        return theOne;
    }

}
