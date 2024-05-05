package com.learning.revision.binary.search;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        System.out.println(singleElement(new int[]{4, 4, 6, 7, 7, 9, 9}));
    }

    public static int singleElement(int[] A) {
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return A[0];
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid > 0 ? A[mid - 1] : Integer.MIN_VALUE);
            int next = (mid < A.length - 1 ? A[mid + 1] : Integer.MAX_VALUE);
            if (A[mid] > prev && A[mid] < next) {
                return A[mid];
            } else if (A[mid] == prev) {
                if (mid % 2 == 0) end = mid - 1;
                else start = mid + 1;
            } else if (A[mid] == next) {
                if (mid % 2 == 0) start = mid + 1;
                else end = mid - 1;
            }
        }
        return 0;
    }
}
