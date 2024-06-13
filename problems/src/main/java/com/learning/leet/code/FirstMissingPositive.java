package com.learning.leet.code;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositiveWithSpace(new int[]{1}));
        System.out.println(firstMissingPositiveWithSpace(new int[]{2, 1}));
    }

    public static int firstMissingPositiveWithSpace(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int current : nums) {
            if (current <= 0 || current > length) continue;
            result[current - 1] = current;
        }
        for (int i = 0; i < length; i++) {
            int present = result[i];
            if (present != (i + 1)) return i + 1;
        }
        return length + 1;
    }

}
