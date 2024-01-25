package com.learning;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println(kthGrammar(3,0));
        System.out.println(kthGrammar(4,4));

    }


    public static int kthGrammar(int A, int B) {
        if (A == 1 || B == 0) {
            return 0;
        }

        int prevSymbol = kthGrammar(A - 1, B / 2);
        if (prevSymbol == 0) {
            return (B % 2 == 0) ? 0 : 1;
        } else {
            return (B % 2 == 0) ? 1 : 0;
        }
    }
}
