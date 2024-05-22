package com.learning.leet.code.top150;

public class FindIndexOfFirstOccurrenceInAString {

    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceInAString index = new FindIndexOfFirstOccurrenceInAString();
        System.out.println(index.strStr("abc", "c"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return 0;
        int wordLength = haystack.length(), checkLength = needle.length();
        // check for each window
        for (int i = 0; i <= (wordLength - checkLength); i++) {
            if (isValidRange(haystack, needle, i, i + checkLength - 1)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isValidRange(String main, String check, int start, int end) {
        int checkIndex = 0;
        for (int i = start; i <= end; i++) {
            if (main.charAt(i) != check.charAt(checkIndex++)) return false;
        }
        return true;
    }
}
