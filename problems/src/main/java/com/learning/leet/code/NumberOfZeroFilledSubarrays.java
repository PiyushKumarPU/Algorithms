package com.learning.leet.code;

public class NumberOfZeroFilledSubarrays {

    public static long zeroFilledSubarray(int[] nums) {
        long totalCount = 0, currentCount = 0;
        for (int num : nums) {
            if (num == 0) {
                currentCount++;
            } else {
                totalCount += (currentCount * (currentCount + 1)) / 2;
                currentCount = 0;
            }
        }
        totalCount += (currentCount * (currentCount + 1)) / 2;
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{0, 1, 2, 3, 4}));
        System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
        System.out.println(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
         System.out.println(zeroFilledSubarray(new int[]{2, 10, 2019}));
    }
}
