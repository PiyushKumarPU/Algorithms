package com.learning.practise.gfg.prefix.sum;

import java.util.Arrays;

public class SumOfSubArrayOfGivenSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subArrayIndex(new int[]{12, 2, 3, 7, 5}, 12)));
    }

    public static int[] subArrayIndex(int[] arr, long n) {
        long[] pf = new long[arr.length];
        pf[0] = arr[0];
        int[] result = new int[2];
        for (int i = 1; i < arr.length; i++) {
            pf[i] = pf[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                long sum = pf[j] - (i > 0 ? pf[i - 1] : 0);
                if (sum == n) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }

        return result;
    }
}
