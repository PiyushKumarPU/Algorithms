package com.learning.practise.scaler.self.array;

public class PickFromBothSide {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 3, -1, 4, 2, 1}, 6));
    }

    public static int solve(int[] A, int B) {
        long maxPossibleSum = Long.MIN_VALUE;
        int arraySize = A.length, min = 0;
        int max = B;
        long[] pf = new long[arraySize];
        pf[0] = A[0];
        for (int index = 1; index < arraySize; index++) {
            pf[index] = pf[index - 1] + A[index];
        }
        while (min <= max) {
            long minToMaxSum = (min > 0 ? pf[min - 1] : 0) + pf[arraySize - 1] - (max < arraySize ? pf[arraySize - 1 - max] : 0);
            long maxToMin = (max > 0 ? pf[max - 1] : 0) + pf[arraySize - 1] - (min < arraySize ? pf[arraySize - 1 - min] : 0);
            maxPossibleSum = Math.max(maxPossibleSum, Math.max(minToMaxSum, maxToMin));
            min++;
            max--;
        }
        return (int) maxPossibleSum;
    }
}
