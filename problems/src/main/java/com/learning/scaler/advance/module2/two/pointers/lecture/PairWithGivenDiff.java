package com.learning.scaler.advance.module2.two.pointers.lecture;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array of integer A and an integer k,
find any pair such that A[j] - A[i] = k and (i != j).
Note : TC should be O(N) and with constant space.
Example:
    arr1 = {-5,-2,1,8,10,12,15}
    k = 11
    ans = (2,5)
* */
public class PairWithGivenDiff {

    public static void main(String[] args) {
        System.out.println(pairWithGivenDiff(List.of(-5, -2, 1, 8, 10, 12, 15), 11));
    }

    public static List<Integer> pairWithGivenDiff(List<Integer> arr, int target) {
        List<Integer> result = new ArrayList<>(2);
        int start = 0, end = 1;
        while (end < arr.size()) {
            int diff = arr.get(end) - arr.get(start);
            if (diff == target) {
                result.add(start);
                result.add(end);
                return result;
            } else if (diff < target) end++;
            else start++;
        }
        result.add(-1);
        result.add(-1);
        return result;
    }


}
