package com.learning.revision.binary.search;

public class FindAPeakElement {


    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{1,1000000000,1000000000}));
    }


    public static int findPeak(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = mid > 0 ? A[mid - 1] : 0;
            int next = mid < A.length - 1 ? A[mid + 1] : 0;
            if (A[mid] >= prev && A[mid] >= next) return A[mid];
            else if (A[mid] < prev) end = mid - 1;
            else if (A[mid] > prev) start = mid + 1;
        }
        return 0;
    }
}
