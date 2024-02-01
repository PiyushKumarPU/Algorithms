package com.learning.scaler.advance.module1.recursion1.lecture;


/*
     Find a^n using recursion
*
* */
public class FindPower {

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }


    public static int pow(int base, int exp) {
        if (exp == 0) return 1;
        return base * pow(base, exp - 1);
    }
}
