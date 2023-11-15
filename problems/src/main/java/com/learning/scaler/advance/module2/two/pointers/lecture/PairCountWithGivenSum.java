package com.learning.scaler.advance.module2.two.pointers.lecture;

import java.util.List;

/*
Given an sorted array of integer A without duplicates and an integer k,
find all the pair such that A[i] + A[j] = k and (i != j).
Note : TC should be O(N) and with constant space.
Example:
    arr1 = {1,2,3,4,5,6,8}
    k = 10
    ans = 2
* */
public class PairCountWithGivenSum {

    public static void main(String[] args) {

        System.out.println(pairCount(List.of(1,2,3,4,5,6,8), 10));

    }

    public static int pairCount(List<Integer> inputs, int target) {
        int start = 0, end = inputs.size() - 1, count = 0;
        while (start < end) {
            int currentSum = inputs.get(start) + inputs.get(end);
            if (currentSum == target) {
                count++;
                start++;
                end--;
            } else if (currentSum < target) start++;
            else end--;
        }
        return count;
    }


}
