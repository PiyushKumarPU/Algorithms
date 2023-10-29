package com.learning.practise.scaler.self.array;

public class GoodSubArray {

    public static void main(String[] args)
    {
        System.out.println(solve(new int[]{13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9}, 65));
    }

    public static int solve(int[] A, int B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int currentSum = 0;
            for (int j = i; j < A.length; j++) {
                currentSum += A[j];
                int subArrayLength = j - i + 1;
                if ((subArrayLength % 2 == 0 && currentSum < B) ||
                        (subArrayLength % 2 != 0 && currentSum > B)) count++;
            }
        }
        return count;
    }
}
