package com.learning.practise.scaler.self.array;

public class ArraySpecialIndex {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 1, 1}));
    }

    public static int solve(int[] A) {
        long[] PFEven = new long[A.length];
        long[] PFOdd = new long[A.length];
        PFEven[0] = A[0];
        PFOdd[0] = 0;
        int count = 0;
        for (int index = 1; index < A.length; index++) {
            PFEven[index] = PFEven[index - 1] + (index % 2 == 0 ? A[index] : 0);
            PFOdd[index] = PFOdd[index - 1] + (index % 2 != 0 ? A[index] : 0);
        }

        // derived
        long lastEvenIndex = PFEven[A.length - 1];
        long lastOddIndex = PFOdd[A.length - 1];
        for (int index = 0; index < A.length; index++) {
            long evenSum = (index > 0 ? PFEven[index - 1] : 0) + (lastOddIndex - PFOdd[index]);
            long oddSum = (index > 0 ? PFOdd[index - 1] : 0) + (lastEvenIndex - PFEven[index]);
            if (evenSum == oddSum) count++;
        }
        return count;

    }
}
