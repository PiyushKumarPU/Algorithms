package com.learning.practise.scaler.self.array;

public class SubArrayWithLeastAverage {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{15, 3, 15, 6, 9, 14, 8, 10, 9, 17}, 1,1));
        //solve(new int[]{15, 3, 15, 6, 9, 14, 8, 10, 9, 17}, 1);
    }

    public static int solve(int[] A, int B) {
        int result = 0, initialSum = 0, startIndex = 1, endIndex = B;
        for (int i = 0; i < B; i++) {
            initialSum += A[i];
        }
        while (endIndex < A.length) {
            int currentSum = initialSum + (A[endIndex] - A[startIndex - 1]);
            if (currentSum < initialSum) {
                result = startIndex;
            }
            initialSum = currentSum;
            startIndex++;
            endIndex++;

        }
        return result;
    }

    public static int solve(int[] A, int B, int C) {
        int resultIndex = 0, carrySum = 0;
        for (int i = 0; i < B; i++) {
            carrySum += A[i];
        }
        int startIndex = 1, endIndex = B, resultSum = carrySum;
        while (endIndex < A.length){
            carrySum = carrySum - A[startIndex-1] + A[endIndex];
            if(carrySum < resultSum){
                resultSum = carrySum;
                resultIndex = startIndex;
            }
            startIndex++;
            endIndex++;
        }

        return resultIndex;
    }
}
