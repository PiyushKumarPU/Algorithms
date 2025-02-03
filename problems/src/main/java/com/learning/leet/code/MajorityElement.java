package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int currentCount = freqMap.getOrDefault(num, 0) + 1;
            if (currentCount > (nums.length / 2)) return num;
            freqMap.put(num, currentCount);
        }
        return -1;
    }

    // Boyer-Moore Voting Algorithm
    public static int majorityElementVoting(int[] nums) {
        int candidate = nums[0], count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));  // Output: 2
    }
}
