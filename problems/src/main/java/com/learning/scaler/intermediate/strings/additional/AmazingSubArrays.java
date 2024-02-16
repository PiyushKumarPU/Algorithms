package com.learning.scaler.intermediate.strings.additional;


import java.util.TreeSet;

/*
Problem Statement
    You are given a string S, and you have to find all the amazing substrings of S.
    An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input
    Only argument given is string S.
Output
    Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints
    1 <= length(S) <= 10^6
    S can have special characters

Example
Input
    ABEC
Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
* */
public class AmazingSubArrays {

    public int solve(String A) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            boolean isVowel = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
            if (isVowel) count += (A.length() - i);
            count = count % 10003;
        }
        return count;
    }

    public int solveScaler(String A) {
        TreeSet<Character> se = new TreeSet<>();
        se.add('a');
        se.add('e');
        se.add('i');
        se.add('o');
        se.add('u');
        se.add('A');
        se.add('E');
        se.add('I');
        se.add('O');
        se.add('U');

        int n = A.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (se.contains(A.charAt(i))) {
                ans += (n - i);
            }
        }
        return (int) (ans % 10003);
    }

    public int solveOld(String A) {
        long result = 0;
        int startIndex = 0, endIndex = A.length() - 1;
        while (startIndex < endIndex) {
            if (A.charAt(startIndex) == 'A' ||
                    A.charAt(startIndex) == 'E' ||
                    A.charAt(startIndex) == 'I' ||
                    A.charAt(startIndex) == 'O' ||
                    A.charAt(startIndex) == 'U' ||
                    A.charAt(startIndex) == 'a' ||
                    A.charAt(startIndex) == 'e' ||
                    A.charAt(startIndex) == 'i' ||
                    A.charAt(startIndex) == 'o' ||
                    A.charAt(startIndex) == 'u') {
                result += (A.length() - startIndex) % 10003;
            }
            if (A.charAt(endIndex) == 'A' ||
                    A.charAt(endIndex) == 'E' ||
                    A.charAt(endIndex) == 'I' ||
                    A.charAt(endIndex) == 'O' ||
                    A.charAt(endIndex) == 'U' ||
                    A.charAt(endIndex) == 'a' ||
                    A.charAt(endIndex) == 'e' ||
                    A.charAt(endIndex) == 'i' ||
                    A.charAt(endIndex) == 'o' ||
                    A.charAt(endIndex) == 'u') {
                result += (A.length() - endIndex) % 10003;
            }
            startIndex++;
            endIndex--;
        }
        return (int) (result % 10003);
    }
}
