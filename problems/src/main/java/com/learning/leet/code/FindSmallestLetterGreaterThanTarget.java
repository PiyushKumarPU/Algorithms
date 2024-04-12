package com.learning.leet.code;

public class FindSmallestLetterGreaterThanTarget {


    // n time complexity
    public char nextGreatestLetterApproach1(char[] letters, char target) {
        for (char ch : letters) if (ch > target) return ch;
        return letters[0];
    }

    // Using binary search
    public char nextGreatestLetterApproach2(char[] letters, char target) {
        //int start =
        return letters[0];
    }
}
