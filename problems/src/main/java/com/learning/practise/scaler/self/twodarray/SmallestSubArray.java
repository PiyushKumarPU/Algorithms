package com.learning.practise.scaler.self.twodarray;

public class SmallestSubArray {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4,4,4,4,4}));
    }

    public static int solve(int[] A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int length = Integer.MAX_VALUE, lastMinIndex = -1, lastMaxIndex = -1;
        for (int i : A) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        if(min == max) return 1;
        for (int index = 0; index < A.length; index++) {
            if (A[index] == min) {
                if (lastMaxIndex != -1) {
                    length = Math.min((index - lastMaxIndex+1), length);
                }
                lastMinIndex = index;
            } else if (A[index] == max) {
                if (lastMinIndex != -1) {
                    length = Math.min((index - lastMinIndex+1), length);
                }
                lastMaxIndex = index;
            }
        }
        return length;
    }
}
