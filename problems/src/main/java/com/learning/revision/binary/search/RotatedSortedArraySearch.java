package com.learning.revision.binary.search;

public class RotatedSortedArraySearch {

    public int search(int[] A, int B) {
        int length = A.length;
        if (length == 1) return (A[0] == B) ? 0 : -1;
        int start = 0, end = length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) return mid;
            if (A[start] <= A[mid]) {
                if (A[start] <= B && B < A[mid]) {
                    end = mid - 1;
                } else start = mid + 1;
            } else {
                if (A[end] >= B && B > A[mid]) {
                    start = mid + 1;
                } else end = mid - 1;
            }
        }
        return -1;
    }

}
