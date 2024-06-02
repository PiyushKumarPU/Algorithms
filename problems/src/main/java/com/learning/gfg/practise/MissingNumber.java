package com.learning.gfg.practise;

public class MissingNumber {

    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            System.out.println(Math.pow(10,i));
        }

        /*System.out.println(missingNumber(new int[]{1, 2, 3, 5}, 5));
        System.out.println(missingNumber(new int[]{6, 1, 2, 8, 3, 4, 7, 10, 5}, 10));*/
    }

    public static int missingNumber(int[] array, int n) {
        // Your Code Here
        int actSum = n * (n + 1) / 2;
        int currentSum = 0;
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (i != j) {
                currentSum += array[j];
                currentSum += array[i];
            } else {
                currentSum += array[i];
            }
            i++;
            j--;
        }
        return actSum - currentSum;
    }
}
