package com.learning.scaler.intermediate.strings.assignment;

/*
Problem Description
    Given a string A of size N, find and return the longest palindromic substring in A.
    Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
    A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
    Incase of conflict, return the substring which occurs first ( with the least starting index).

Problem Constraints
    1 <= N <= 6000

Input Format
    First and only argument is a string A.

Output Format
    Return a string denoting the longest palindromic substring of string A.

Example Input
    Input 1:
        A = "aaaabaaa"
    Input 2:
        A = "abba

Example Output
    Output 1:
        "aaabaaa"
    Output 2:
        "abba"

Example Explanation
    Explanation 1:
        We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
    Explanation 2:
        We can see that longest palindromic substring is of length 4 and the string is "abba".
* */
public class LongestPalindromicSubstring {
    String result = "";
    int maxLength = 0;

    public static void main(String[] args) {
     System.out.println(new LongestPalindromicSubstring().longestPalindrome("aab"));
    }

    public String longestPalindrome(String A) {
        for (int i = 0; i < A.length(); i++) {
            // check for odd length
            findMaxLengthPalindrome(i, i, A);
            findMaxLengthPalindrome(i, i + 1, A);
        }
        return result;
    }

    private void findMaxLengthPalindrome(int left, int right, String A) {
        while (left >= 0 && right < A.length()) {
            if (A.charAt(left) != A.charAt(right)) break;
            else {
                left--;
                right++;
            }
        }
        int currentLength = right - left + 1;
        if (currentLength > maxLength) {
            maxLength = currentLength;
            result = A.substring(left + 1, right);
        }
    }
}
