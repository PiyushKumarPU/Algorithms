package com.learning.leet.code;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }

    public boolean containsDuplicateMap(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (integers.contains(num)) return true;
            integers.add(num);
        }
        return false;
    }
}
