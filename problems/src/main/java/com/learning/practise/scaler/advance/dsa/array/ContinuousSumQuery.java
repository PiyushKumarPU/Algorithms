package com.learning.practise.scaler.advance.dsa.array;

import java.util.Arrays;

public class ContinuousSumQuery {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(5, new int[][]{
                {1, 2, 10}, {
                2, 3, 20
        }, {
                2, 5, 25
        }
        })));
    }

    public static int[] solve(int A, int[][] B) {
        int[] result = new int[A];
        Arrays.fill(result, 0);
        for (int[] ints : B) {
            int start = ints[0];
            int end = ints[1];
            int val = ints[2];
            if (start - 1 >= 0) result[start - 1] += val;
            if (end < A) result[end] -= val;
        }
        for (int i = 0; i < A; i++) {
            result[i] = result[i] + (i > 0 ? result[i - 1] : 0);
        }
        return result;
    }
}
