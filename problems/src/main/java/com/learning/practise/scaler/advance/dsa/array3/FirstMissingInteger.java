package com.learning.practise.scaler.advance.dsa.array3;

public class FirstMissingInteger {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        /*System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{-8, -7, -6}));*/
    }

    public static int firstMissingPositive(int[] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            while (A[i] >= 1 && A[i] <= size
                    && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < size; i++)
            if (A[i] != i + 1)
                return (i + 1);
        return (size + 1);
    }
}
