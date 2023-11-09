package com.learning.scaler.advance.module2.binary_search.arrays.lecture;

import java.util.List;
import java.util.Objects;

/*
Given a sorted array where every element appears twice except one element that appears only once,
find that unique element
* */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(findUniqueElement(List.of(2, 2, 5, 7, 7, 10, 10)));
        System.out.println(findUniqueElement(List.of(1, 1, 5, 5, 7, 7, 10, 13, 13, 18, 18)));
    }

    public static int findUniqueElement(List<Integer> A) {
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (
                    (mid == 0 || !Objects.equals(A.get(mid), A.get(mid - 1))) &&
                            (mid == A.size() - 1 || !Objects.equals(A.get(mid), A.get(mid + 1)))) return A.get(mid);

            int ti = A.get(mid).equals(A.get(mid - 1)) ? mid -1 : mid;
            if(ti % 2 == 0) start = mid + 1;
            else end = mid -1;
        }
        return 0;
    }
}
