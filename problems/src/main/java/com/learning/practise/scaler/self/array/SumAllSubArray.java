package com.learning.practise.scaler.self.array;

public class SumAllSubArray {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}));
        //System.out.println(subarraySum(new int[]{2, 1, 3}));
    }

    public static long subarraySum(int[] A) {
        long result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i] * (long)(i +1) * (A.length - i);
        }
        return result;
    }
}
