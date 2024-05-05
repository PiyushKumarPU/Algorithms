package com.learning.revision.binary.search;

public class MatrixSearch {

    public int searchMatrix(int[][] A, int B) {
        if (A.length == 1 && A[0].length == 1) return A[0][0] == B ? 1 : 0;
        int m = A[0].length;
        if (B < A[0][0] || B > A[A.length - 1][m - 1]) return 0;
        for (int[] arr : A) {
            if (B > arr[m - 1] || B < arr[0]) continue;
            int start = 0, end = m - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == B) return 1;
                else if (arr[mid] > B) end = mid - 1;
                else start = mid + 1;
            }
        }
        return 0;
    }

}
