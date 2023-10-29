package com.learning.practise.scaler.self.array;

import java.util.Arrays;

public class ArrayPrefixSumQueryResult {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rangeSum(new int[]{7,3,1,5,5,5,1,2,4,5},
                new int[][]{
                        {6,9},{2,9},{2,4},{0,9}
                })));
    }

    public static long[] rangeSum(int[] A, int[][] B) {
        int[] PF = new int[A.length];
        PF[0] = A[0];
        long[] sum = new long[B.length];
        for(int index = 1; index < A.length; index ++){
            PF[index] = PF[index-1]+A[index];
        }
        for(int index = 0; index < B.length; index++){
            int low = B[index][0];
            int high = B[index][1];
            sum[index] =
                    low > 0 ? PF[high] - PF[low-1] : PF[high];
        }
        return sum;
    }
}
