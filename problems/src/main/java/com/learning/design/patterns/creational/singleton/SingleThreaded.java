package com.learning.design.patterns.creational.singleton;

/*
    It’s pretty easy to implement a sloppy Singleton. You just need to hide the constructor and implement a static creation method.
* */
public final class SingleThreaded {

    private static SingleThreaded instance;

    private SingleThreaded() {
    }

    public static SingleThreaded getInstance() {
        if (instance == null) {
            instance = new SingleThreaded();
        }
        return instance;
    }
}
