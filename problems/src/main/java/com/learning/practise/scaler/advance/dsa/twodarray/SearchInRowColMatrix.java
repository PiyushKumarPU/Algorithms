package com.learning.practise.scaler.advance.dsa.twodarray;

public class SearchInRowColMatrix {

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 2));

        System.out.println(solve(new int[][]{
                {1, 2},
                {3, 3}
        }, 3));
    }


    public static int solve(int[][] A, int B) {
        int ans = Integer.MAX_VALUE, i = 0, j = A[0].length - 1;
        while (i < A.length && j >= 0) {
            int val = A[i][j];
            if (val < B) {
                i++;
            } else {
                if (val == B) {
                    int indexVal = (i + 1) * 1009 + (j + 1);
                    ans = Math.min(indexVal, ans);
                }
                j--;
            }
        }
        return ans;
    }
}
