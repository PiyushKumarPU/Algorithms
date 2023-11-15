package com.learning.scaler.advance.module2.two.pointers.lecture;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array of integer A and an integer k, find any pair (i,j)
        such that A[i] + A[j] = k and (i != j).
        Note : TC should be O(N) and with constant space.
        Example:
            arr1 = {-5,-2,1,8,10,12,15}
            k = 11
            ans = (2,4)
* */
public class PairWithGiveSum1 {

    public static void main(String[] args) {
        System.out.println(pairWithTargetSum(List.of(-5, -2, 1, 8, 10, 12, 15), 11));
    }

    public static List<Integer> pairWithTargetSum(List<Integer> arr, int target) {
        List<Integer> result = new ArrayList<>(2);
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            int sum = arr.get(start) + arr.get(end);
            if (sum == target) {
                result.add(start);
                result.add(end);
                return result;
            } else if (sum < target) {
                start++;
            } else end--;
        }
        return result;
    }
}
