package com.learning.practise.scaler.advance.dsa.bitmanipulation2;


import java.util.Arrays;

/*Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.*/
public class SingleNumber3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{186, 256, 102, 377, 186, 377})));
    }

    public static int[] solve(int[] A) {
        int xorAll = 0, pos, num1 = 0, num2 = 0;
        for (int j : A) {
            xorAll = xorAll ^ j;
        }

        for (pos = 0; pos < 32; pos++) {
            if ((xorAll & (1 << pos)) != 0) break;
        }

        for (int j : A) {
            if ((j & (1 << pos)) != 0) {
                num1 = num1 ^ j;
            } else {
                num2 = num2 ^ j;
            }
        }
        int[] result = new int[]{num1,num2};
        if (num1 >= num2) {
            result[0] = num2;
            result[1] = num1;
        }
        return result;
    }


}
