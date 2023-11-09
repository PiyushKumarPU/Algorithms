package com.learning.scaler.advance.module2.binary_search.arrays.lecture;

import java.util.List;

/*
Find peak element in increasing-decreasing array.
* */
public class Problem4 {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 10, 7, 4};
        int[] arr2 = {1, 5, 9, 11, 7, 6, 2};
    }

    public static int solve(List<Integer> A) {
        int size = A.size();
        if (size == 1) return A.get(0);
        int start = 0, end = size - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || A.get(mid) >= A.get(mid - 1)) && (
                    mid == (size - 1) || A.get(mid) > A.get(mid + 1))) return A.get(mid);
            else if (mid == 0 || A.get(mid - 1) < A.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
