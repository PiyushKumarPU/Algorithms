package com.learning.scaler.intermediate.strings.assignment;


/*
Problem Description
    Given a string A, you are asked to reverse the string and return the reversed string.

Problem Constraints
    1 <= |A| <= 10^5
    String A consist only of lowercase characters.

Input Format
    First and only argument is a string A.

Output Format
    Return a string denoting the reversed string.

Example Input
    Input 1:
        A = "scaler"
    Input 2:
        A = "academy"

Example Output
    Output 1:
        "relacs"
    Output 2:
        "ymedaca"

Example Explanation
    Explanation 1:
        Reverse the given string.
* */
public class SimpleReverse {


    public String solve(String A) {
        char[] chars = A.toCharArray();
        int start = 0, end = A.length() - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public String solveScaler(String A) {
        char[] s = A.toCharArray();
        int n = A.length();
        for (int i = 0; i < n / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = tmp;
        }
        return new String(s);
    }
}
