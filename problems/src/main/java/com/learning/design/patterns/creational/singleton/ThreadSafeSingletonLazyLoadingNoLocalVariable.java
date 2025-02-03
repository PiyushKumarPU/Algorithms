package com.learning.design.patterns.creational.singleton;

public class ThreadSafeSingletonLazyLoadingNoLocalVariable {

    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile ThreadSafeSingletonLazyLoadingNoLocalVariable instance;

    private ThreadSafeSingletonLazyLoadingNoLocalVariable() {
    }

    public static ThreadSafeSingletonLazyLoadingNoLocalVariable getInstance() {
        // First check without synchronization
        if (instance != null) {
            return instance;
        }
        // Synchronization block to create instance
        synchronized (ThreadSafeSingletonLazyLoadingNoLocalVariable.class) {
            // Second check within synchronized block
            if (instance == null) {
                instance = new ThreadSafeSingletonLazyLoadingNoLocalVariable();
            }
        }
        return instance;
    }

}
