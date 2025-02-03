package com.learning.leet.code;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;

        // start finding from char first and return once char is not present
        int start = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            while (start < t.length() && s.charAt(i) != t.charAt(start)) start++;
            if (start == t.length()) return false;
            start++;
        }
        // check if all character matched
        return i == s.length();
    }

    public boolean isSubsequence1(String s, String t) {
        char[] sc = s.toCharArray();

        for (char c : sc) {
            int index = t.indexOf(c);
            if (index >= 0) {
                t = t.substring(index + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isSubsequenceOptimized(String s, String t) {
        if (s == null || s.isEmpty())
            return true;

        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;

            if (i == s.length()) {
                return true;
            }
        }

        return false;
    }


    public static boolean isSubsequence2(String s, String t) {
        if (s == null || t == null) return false;
        int i = 0, j = 0;
        while ((i < s.length() && j < t.length())) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

}
