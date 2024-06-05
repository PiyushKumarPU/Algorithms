package com.learning.algo;

public class Manacher {

    public static String longestPalindromicSubstring(String s) {
        // Preprocess the string
        StringBuilder processedStr = new StringBuilder("$#");
        for (char c : s.toCharArray()) {
            processedStr.append(c).append("#");
        }
        processedStr.append("@");
        int n = processedStr.length();
        int[] P = new int[n];
        int C = 0, R = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;

            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Attempt to expand palindrome centered at i
            while (processedStr.charAt(i + (1 + P[i])) == processedStr.charAt(i - (1 + P[i]))) {
                P[i]++;
            }

            // If palindrome centered at i expands past R,
            // adjust center and right boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // Find the maximum element in P.
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        // Calculate start and end indices of the longest palindrome.
        int startIndex = (centerIndex - maxLen) / 2;
        int endIndex = startIndex + maxLen - 1;

        // Remove delimiters from the result
        return s.substring(startIndex, endIndex).replaceAll("#", "");
    }

    public static void main(String[] args) {
        String s = "baba#d";
        System.out.println(longestPalindromicSubstring(s)); // Output: "bab" or "aba"
    }
}


