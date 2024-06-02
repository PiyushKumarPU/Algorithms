package com.learning.leet.code;

public class FindIndexFirstOccurrenceString {

    public static void main(String[] args) {
        /*System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("sadbutsad", "sad"));*/
        System.out.println(strStr("a", "a"));
    }


    public static int strStr(String haystack, String needle) {
        if(haystack == null || haystack.isEmpty()) return -1;
        if(haystack.length() == needle.length() && haystack.equals(needle) ) return 0;
        int start = 0, nLen = needle.length();
        while (start < haystack.length() - nLen) {
            if (haystack.substring(start, start + needle.length()).equals(needle)) return start;
            start++;
        }
        return -1;
    }

    // using KMP Algo
    public static int strStrUsingKMP(String haystack, String needle) {
        int j = 0;  // Pointer for the current position in the needle (pattern)

        // Compute the Longest Prefix Suffix (LPS) array for the pattern
        int[] lps = computeLPSArray(needle);

        // Start searching through the haystack (text)
        for (int i = 0; i < haystack.length(); ) {
            // If the characters match, move both pointers (i and j) forward
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                // If there is a mismatch after some matches
                if (j == 0) {
                    // If j is 0, just move the haystack pointer i forward
                    i++;
                } else {
                    // Move the pattern pointer j to the last known good prefix position
                    j = lps[j - 1];
                }
            }
            // If we have matched the entire needle (pattern)
            if (j == needle.length()) {
                // Return the starting index of the match in the haystack
                return i - j;
            }
        }
        // If no match is found, return -1
        return -1;
    }

    // Function to compute the LPS array
    public static int[] computeLPSArray(String pattern) {
        int length = pattern.length(); // Length of the pattern
        int[] lps = new int[length]; // LPS array to hold the longest prefix suffix values
        int lpsLength = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character as lps[0] is always 0

        // Loop to fill the LPS array
        while (i < length) {
            if (pattern.charAt(i) == pattern.charAt(lpsLength)) {
                // Case 1: Current character matches the character at the lpsLength position
                lpsLength++; // Increment the length of the current longest prefix suffix
                lps[i] = lpsLength; // Set the LPS value for the current position
                i++; // Move to the next character
            } else if (lpsLength != 0) {
                // Case 2: Mismatch after at least one matching character
                lpsLength = lps[lpsLength - 1];
                // Update lpsLength to the LPS value of the previous position
            } else {
                // Case 3: Mismatch with no previous matching character
                lps[i] = 0; // Set the LPS value for the current position to 0
                i++; // Move to the next character
            }
        }
        return lps; // Return the computed LPS array
    }
}
