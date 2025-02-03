package com.learning.design.patterns.creational.singleton;

public class ThreadSafeSingletonLazyLoadingAndDoubleLock {

    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile ThreadSafeSingletonLazyLoadingAndDoubleLock instance;

    private ThreadSafeSingletonLazyLoadingAndDoubleLock() {
    }

    public static ThreadSafeSingletonLazyLoadingAndDoubleLock getInstance() {
        // A local variable result is used to minimize the need to access the volatile field directly,
        // improving performance by reducing synchronization overhead.
        ThreadSafeSingletonLazyLoadingAndDoubleLock result = instance;
        if (result != null) {
            return result;
        }
        synchronized (ThreadSafeSingletonLazyLoadingAndDoubleLock.class) {
            if (instance == null) {
                instance = new ThreadSafeSingletonLazyLoadingAndDoubleLock();
            }
            return instance;
        }
    }

}
