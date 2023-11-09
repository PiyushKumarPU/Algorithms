package com.learning.scaler.advance.module2.binary_search.arrays.lecture;

import java.util.List;
import java.util.Objects;

/*
Find the first occurrence of a element in sorted array with duplicates.
* */
public class Problem2 {

    public static void main(String[] args) {
        System.out.println(findFirstOccurrence(List.of(2, 2, 5, 5, 5, 5, 8, 10, 12, 15), 5));

        int[] arr = {1, 1, 5, 5, 7, 7, 10, 13, 13, 18, 18};
    }

    public static int findFirstOccurrence(List<Integer> A, Integer target) {
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (Objects.equals(A.get(mid), target) && (mid == 0 || A.get(mid - 1) < target))
                return mid;
            else if (A.get(mid) >= target) end = mid - 1;
            else start = mid + 1;
        }
        return 0;
    }


}
