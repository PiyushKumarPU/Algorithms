package com.learning.design.patterns.creational.singleton;

/*
The same class behaves incorrectly in a multithreaded environment.
Multiple threads can call the creation method simultaneously and get several instances of Singleton class.
* */
public class MultithreadedSingleton {
    private static MultithreadedSingleton instance;

    private MultithreadedSingleton() {
    }

    public static MultithreadedSingleton getInstance() {
        if (instance == null) {
            instance = new MultithreadedSingleton();
        }
        return instance;
    }
}
