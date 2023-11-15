package com.learning.scaler.advance.module2.two.pointers.lecture;

import java.util.List;

/*
Given an integer array with +ve elements and an integer k,
check if there exists a subarray with given sum = k.
Note : TC should be O(N) and with constant space.
Example:
    arr1 = {1, 3, 15, 10, 20, 3, 23}
    k = 33
    ans = true
* */
public class SubArraySumWithGivenSum {


    public static void main(String[] args) {
        System.out.println(subArraySumWithGivenSum(List.of(1, 3, 15, 10, 20, 3, 23), 133));
    }

    public static boolean subArraySumWithGivenSum(List<Integer> arr, int target) {
        int start = 0, end = 0, currentSum = arr.get(0);
        while (end < arr.size()) {
            if(currentSum == target){
                return true;
            } else if (currentSum < target) {
                end++;
                if (end == (arr.size())) break;
                currentSum += arr.get(end);
            }else{
                currentSum -= arr.get(start);
                start++;
                if(start > end && start < arr.size()){
                    end++;
                    currentSum += arr.get(end);
                }
            }
        }
        return false;
    }
}
