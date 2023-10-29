package com.learning.practise.scaler.self.basics;


import java.util.Arrays;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 4}, 2)));
    }

    public static int[] solve(int[] A, int B) {
        int noOfRotation =  B% A.length;
        for(int i = 0; i< noOfRotation; i++){
            int temp = A[A.length-1];
            for(int index = A.length-2; index >=0; index--){
                A[index+1] = A[index];
            }
            A[0] = temp;
        }

        return A;
    }
}
