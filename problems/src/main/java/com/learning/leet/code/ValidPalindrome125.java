package com.learning.leet.code;

// https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }



    public static void main(String[] args) {
        String str = "0P";
        System.out.println(isPalindrome(str));

    }
}
