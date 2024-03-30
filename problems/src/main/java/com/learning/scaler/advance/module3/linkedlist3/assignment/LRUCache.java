package com.learning.scaler.advance.module3.linkedlist3.assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.*;
import java.util.stream.IntStream;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
    get and set.
    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
    it should invalidate the least recently used item before inserting the new item.
    The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum
    number of unique keys it can hold at a time.

    Definition of "least recently used": Access to an item is defined as a get or a set operation of the item. "Least
    recently used" item is the one with the oldest access time.

    NOTE: If you are using any global variables, make sure to clear them in the constructor.
Example :
    Input :
             capacity = 2
             set(1, 10)
             set(5, 12)
             get(5)        returns 12
             get(1)        returns 10
             get(10)       returns -1
             set(6, 14)    this pushes out key = 5 as LRU is full.
             get(5)        returns -1
Expected Output
    Enter your input as per the following guideline:
    There is 1 line in the input

    Line 1 (Corresponds to arg 1) : The line starts with a pair of number numOperations, capacity. Capacity is the
    number your constructor is initialized with.
    Then numOperation operations follow.
    Each operation is either:
     * G : This corresponds to a function call get()
     * S   : This corresponds to a function call set(num1, num2)
Note that the function calls are made in order.
* */
public class LRUCache {
    public static void main(String[] args) {

        String[] test = {"abc"};
    }


    // @Override
    public LRUCache(int capacity) {

    }

    public int get(int key) {
        return 0;
    }

    public void set(int key, int value) {

    }
}
