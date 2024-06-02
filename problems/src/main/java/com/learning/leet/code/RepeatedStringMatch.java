package com.learning.leet.code;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd","cdabcdab"));
    }

    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        int[] lps = calculateLpsArray(b);
        if (isPresent(a, b, lps)) return count;
        for (; ; ) {
            a = a + a;
            count++;
            if (isPresent(a, b, lps)) return count;
        }
    }

    private boolean isPresent(String text, String pattern, int[] lps) {
        int j = 0;
        for (int i = 0; i < text.length(); ) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    private int[] calculateLpsArray(String pattern) {
        int length = pattern.length();
        int[] lps = new int[length];
        lps[0] = 0;
        int start = 1, lpsLength = 0;
        while (start < length) {
            if (pattern.charAt(start) == pattern.charAt(lpsLength)) {
                lpsLength++;
                lps[start] = lpsLength;
                start++;
            } else if (lpsLength == 0) {
                lps[start] = 0;
                start++;
            } else lpsLength = lps[lpsLength - 1];
        }
        return lps;
    }

}
