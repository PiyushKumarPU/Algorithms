package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int existingIndex = charCountMap.getOrDefault(nums[i], -1);
            if (existingIndex < 0) charCountMap.put(nums[i], i);
            else {
                int difference = Math.abs(i - existingIndex);
                if (difference <= k) return true;
            }
        }
        return false;
    }
}
