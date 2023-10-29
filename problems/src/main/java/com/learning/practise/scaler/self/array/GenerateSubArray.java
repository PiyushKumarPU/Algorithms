package com.learning.practise.scaler.self.array;

import java.util.Arrays;

public class GenerateSubArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1,2,3})));
    }


    public static int[][] solve(int[] A) {
        int subArrayCount = A.length * (A.length+1)/2;
        int[][] result = new int[subArrayCount][];
        int indexCount = 0;
        for(int i = 0; i < A.length; i ++){
            for(int j = i; j < A.length; j++){
                int[] currentArray = new int[j-i+1];
                int tempIndex = 0;
                for(int index = i; index <= j; index++){
                    currentArray[tempIndex++] = A[index];
                }
                result[indexCount++] = currentArray;
            }
        }
        return result;
    }
}
