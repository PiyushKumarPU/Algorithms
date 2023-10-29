package com.learning.practise.scaler.advance.dsa.array;

import java.util.List;

public class MaxSumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(List.of(1, 2, 3, 4, -10)));
        System.out.println(maxSubArray(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
        System.out.println(maxSubArray(List.of(-1,-2,-3,-4,-5,-6,-7)));
    }

    public static int maxSubArray(final List<Integer> A) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer integer : A) {
            sum += integer;
            result = Math.max(result, sum);
            if (sum < 0) sum = 0;
        }
        return result;
    }
}
