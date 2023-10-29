package com.learning.practise.scaler.self.array;

public class MinSwap {

    public static void main(String[] args) {
        System.out.println(minSwap(
                new int[]{52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70},
                19));

      /*  System.out.println(solve(new int[]{54, 67, 55, 41, 58, 24, 100, 1, 98, 68, 21, 33, 27, 67, 20, 66, 20, 100, 36, 89, 20, 15, 13, 26, 11, 29, 99, 36, 39, 49, 74, 77, 54, 66, 30, 21, 14, 18, 83, 72, 10, 22, 53, 83, 60, 9, 68, 56, 9, 21, 77, 44, 45, 61, 97, 82, 35, 16, 38, 95, 55, 11, 46, 77, 25, 3, 44},
                18));*/

        // System.out.println(solve(new int[]{1, 12, 10, 3, 14, 10, 5}, 8));
        // test();
    }

    static int minSwap(int[] A, int B) {
        int count = 0, n = A.length;
        for (int value : A)
            if (value <= B)
                ++count;

        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (A[i] > B)
                ++bad;

        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {
            if (A[i] > B)
                --bad;
            if (A[j] > B)
                ++bad;
            ans = Math.min(ans, bad);
        }
        return ans;
    }
}
