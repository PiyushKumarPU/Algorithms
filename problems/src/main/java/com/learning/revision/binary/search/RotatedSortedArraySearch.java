package com.learning.revision.binary.search;

public class RotatedSortedArraySearch {

    public int search(final int[] A, int B) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) return mid;
            // check if target is in part 1
            if (B >= A[0]) {
                if (A[mid] >= A[0]) {
                    if (A[mid] > B) end = mid - 1;
                    else start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (A[mid] >= A[0]) {
                    start = mid + 1;
                } else {
                    if (A[mid] > B) end = mid - 1;
                    else start = mid + 1;
                }
            }
        }
        return -1;
    }


}
