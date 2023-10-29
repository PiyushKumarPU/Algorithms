package com.learning.practise.scaler.advance.dsa.array;

import java.util.Arrays;

public class Flip {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flip("1111111")));
        System.out.println(Arrays.toString(flip("000000")));
         System.out.println(Arrays.toString(flip("00001")));
    }

    public static int[] flip(String A) {
        int l = 0, r = 0, currentSum = 0, maxSum = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length(); i++) {
            int val = A.charAt(i) - '0';
            currentSum += val > 0 ? -1 : 1;
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = l + 1;
                result[1] = r + 1;
            }
            if (currentSum < 0) {
                currentSum = 0;
                l = i + 1;
                r = i + 1;
            } else {
                r++;
            }
        }
        if (maxSum == 0) return new int[]{};
        else return result;
    }
}
