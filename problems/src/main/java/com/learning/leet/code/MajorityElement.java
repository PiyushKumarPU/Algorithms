package com.learning.leet.code;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = findCandidate(nums);
        return verifyCandidate(nums, candidate) ? candidate : -1;
    }

    private static int findCandidate(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    private static boolean verifyCandidate(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));  // Output: 2
    }
}
