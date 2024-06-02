package com.learning.gfg.array;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 7, 5}, 5, 1200));
        System.out.println(subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,100,100,1000,10000}, 14, 11255));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        // Your code here
        long[] pf = new long[n];
        pf[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            long sum =0;
            for (int j = i; j < n; j++) {
                sum = pf[j] - (i > 0 ? pf[i - 1] : 0);
                if (sum == s) {
                    result.add(i + 1);
                    result.add(j + 1);
                    return result;
                }
            }
        }
        result.add(-1);
        return result;
    }
}
