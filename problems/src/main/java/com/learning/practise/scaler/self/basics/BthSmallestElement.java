package com.learning.practise.scaler.self.basics;

public class BthSmallestElement {

    public static void main(String[] args) {
        System.out.println(kthsmallest(new int[]{8,16,80,55,32,8,38,40,65,18,15,45,50,38,54,52,23,74,81,42,28,16,66,35,91,36,44,9,85,58,59,49,75,20,87,60,17,11,39,62,20,17,46,26,81,92},
                9));
    }

    public static int kthsmallest(final int[] A, int B) {
        int[] resultArray = new int[A.length];
        System.arraycopy(A, 0, resultArray, 0, A.length);
        int index = 0;
        while (index < B) {
            int minIndex = index;
            for (int i = index + 1; i < resultArray.length; i++) {
                if (resultArray[minIndex] > resultArray[i]) minIndex = i;
            }
            if (resultArray[index] != resultArray[minIndex]) {
                int temp = resultArray[index];
                resultArray[index] = resultArray[minIndex];
                resultArray[minIndex] = temp;
            }
            index++;
        }
        return resultArray[B - 1];
    }
}
