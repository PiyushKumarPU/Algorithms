package com.learning.leet.code;

import java.util.HashSet;

public class LongestConsecutiveSequence {


    public static void main(String[] args) {
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        System.out.println(sequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }
        int maxLength = 0;
        for (int num : elements) {
            // Only check for the start of sequences
            if (!elements.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (elements.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
