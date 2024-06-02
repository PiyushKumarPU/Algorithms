package com.learning.leet.code;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome = getLongestPalindrome(s, i, i);
            if (palindrome.length() > result.length()) result = palindrome;
            // even length
            palindrome = getLongestPalindrome(s, i, i + 1);
            if (palindrome.length() > result.length()) result = palindrome;
        }
        return result;
    }

    private String getLongestPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) break;
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
