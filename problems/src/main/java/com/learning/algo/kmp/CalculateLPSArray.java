package com.learning.algo.kmp;

public class CalculateLPSArray {

    // Function to compute the LPS array
    public static void main(String[] args) {
        // Example pattern for testing
        String pattern = "AABA";
        // Compute the LPS array for the given pattern
        int[] lps = computeLPSArray(pattern);
        // Print the resulting LPS array
        for (int l : lps) {
            System.out.print(l + " ");
        }
    }

    // Function to compute the LPS array
    public static int[] computeLPSArray(String pattern) {
        int length = pattern.length(); // Length of the pattern
        int[] lps = new int[length]; // LPS array to hold the longest prefix suffix values
        int longestPrefixSuffixLength = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character as lps[0] is always 0

        // Loop to fill the LPS array
        while (i < length) {
            if (pattern.charAt(i) == pattern.charAt(longestPrefixSuffixLength)) {
                // Case 1: Current character matches the character at the longestPrefixSuffixLength position
                longestPrefixSuffixLength++; // Increment the length of the current longest prefix suffix
                lps[i] = longestPrefixSuffixLength; // Set the LPS value for the current position
                i++; // Move to the next character
            } else if (longestPrefixSuffixLength != 0) {
                // Case 2: Mismatch after at least one matching character
                longestPrefixSuffixLength = lps[longestPrefixSuffixLength - 1];
                // Update longestPrefixSuffixLength to the LPS value of the previous position
            } else {
                // Case 3: Mismatch with no previous matching character
                lps[i] = 0; // Set the LPS value for the current position to 0
                i++; // Move to the next character
            }
        }

        return lps; // Return the computed LPS array
    }

}
