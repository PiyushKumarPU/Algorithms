package com.learning.leet.code;

public class FindIndexFirstOccurrenceString {

    public static void main(String[] args) {
        System.out.println(strStrUsingKMP("sadbutsad", "sad"));
    }

    // Using BF
    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty()) return -1;
        if (haystack.length() == needle.length() && haystack.equals(needle)) return 0;
        int start = 0, nLen = needle.length();
        while (start < haystack.length() - nLen) {
            if (haystack.substring(start, start + needle.length()).equals(needle)) return start;
            start++;
        }
        return -1;
    }

    // using KMP Algo
    public static int strStrUsingKMP(String haystack, String needle) {
        int[] lps = computeLPSArray(needle + "#" + haystack);
        int ignoreLength = needle.length() + 1;
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == needle.length()) return i - needle.length() * 2;
        }
        // If no match is found, return -1
        return -1;
    }

    // Function to compute the LPS array
    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            int x = lps[i - 1];
            while (pattern.charAt(i) != pattern.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
}
