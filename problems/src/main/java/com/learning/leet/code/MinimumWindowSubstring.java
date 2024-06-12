package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty())
            return "";

        // Initialize pointers and variables
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        String minWindow = "";
        Map<Character, Integer> charCount = new HashMap<>();
        int requiredChars = 0, formedChars = 0;

        // Count characters in t
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            requiredChars++;
        }

        // Sliding window
        while (right < s.length()) {
            // Expand the window by moving the right pointer
            char ch = s.charAt(right);
            if (charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) - 1);
                if (charCount.get(ch) >= 0)
                    formedChars++;
            }

            // Contract the window by moving the left pointer
            while (formedChars == requiredChars && left <= right) {
                int tempLen = right - left + 1;
                if (tempLen < minLen) {
                    minLen = tempLen;
                    minWindow = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                if (charCount.containsKey(leftChar)) {
                    charCount.put(leftChar, charCount.get(leftChar) + 1);
                    if (charCount.get(leftChar) > 0)
                        formedChars--;
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }

    public String minWindow1(String s, String t) {
        int[] tElements = new int[123]; //to track a-z & A-Z
        for (char c : t.toCharArray()) {
            tElements[c]++; //count frequency of letters
        }

        char[] S = s.toCharArray();
        int minLength = Integer.MAX_VALUE, start = 0;
        int find = t.length();//Letters to be found

        int left = 0, right = 0;    //sliding window
        while (right < S.length) {    //to slide right limit

            if (tElements[S[right]] > 0) find--;
            tElements[S[right]]--;
            right++;

            while (find == 0) {   //to slide left limit when all required characters are found
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }
                if (tElements[S[left]] == 0) find++;
                tElements[S[left]]++;
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLength);
    }

}
