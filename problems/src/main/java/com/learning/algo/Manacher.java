package com.learning.algo;

public class Manacher {
    public String longestPalindrome(String s) {
        // Preprocess the string
        String t = preprocess(s);
        int n = t.length();
        int[] p = new int[n];
        int center = 0, right = 0;

        // Main loop to expand around the center
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // mirror of i around center

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            } else {
                p[i] = 0;
            }

            // Attempt to expand the palindrome centered at i
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 + p[i])) {
                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Find the maximum element in p
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Extract the longest palindrome from the original string
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    // Transform the input string s into t with '#' characters
    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Manacher manacher = new Manacher();
        String s = "babad";
        System.out.println("Longest Palindromic Substring: " + manacher.longestPalindrome(s));
    }
}

