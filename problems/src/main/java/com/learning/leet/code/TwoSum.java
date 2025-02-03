package com.learning.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public int[] twoSumBF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            if (valueIndexMap.containsKey(current)) {
                return new int[]{valueIndexMap.get(current), i};
            }
            valueIndexMap.put(target - current, i);
        }
        return null;

    }

    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end ) {
            int currentSum = numbers[start] + numbers[end];
            if (currentSum == target) return new int[]{start + 1, end + 1};
            else if (currentSum > target) end--;
            else start++;
        }
        return null;
    }

}
