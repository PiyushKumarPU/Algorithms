package com.learning.practise.scaler.advance.dsa.recursion1;

public class SimpleRecursion {

    public static void main(String[] args) {
        System.out.println(foo(3, 5));
    }


    static int bar(int x, int y) {
        if (y == 0) return 0;
        return (x + bar(x, y - 1));
    }

    static int foo(int x, int y) {
        if (y == 0) return 1;
        return bar(x, foo(x, y - 1));
    }


}
