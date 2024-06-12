package com.learning.leet.code;

public class FactorialTrailingZeroes {

    /*
    To find the number of trailing zeroes in n!. you need to count how many times the factorial
    of n can be divided by 10.
    Since 10 is 2 * 5 and the number of 2's will always exceed the number of 5's,
    you just need to count how many times n can be divided by 5.
    * */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }


}
