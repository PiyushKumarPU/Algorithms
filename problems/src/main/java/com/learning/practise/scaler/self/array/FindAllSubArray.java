package com.learning.practise.scaler.self.array;

import java.util.Arrays;

public class FindAllSubArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1,2,3,4})));
    }

    public static int[][] solve(int[] A) {
        int[][] result =  new int[A.length][A.length];
        for(int i = 0; i < A.length; i ++){
            System.out.print("[");
            for(int j = i; j < A.length; j++){
                //System.out.print(A[j] +"\t");
                System.out.print("("+i+","+j+")");
            }
            System.out.print("]");
            System.out.println();
        }
        return result;
    }
}
