package com.learning.leet.code;

public record ReverseWordsInAString() {

    public static void main(String[] args) {
        System.out.println(reverseWordsPoint1("a"));
    }

    public static String reverseWordsPoint(String s) {
        if (s == null || s.isEmpty()) return s;
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == ' ') start++;
        while (end >= start && s.charAt(end) == ' ') end--;
        if (start == end) return "";
        StringBuilder result = new StringBuilder();
        while (end >= start) {
            if (s.charAt(end) == ' ') {
                // keep moving till last space and add one space once moved
                int spaceIndex = end;
                while (s.charAt(spaceIndex) == ' ') spaceIndex--;
                result.append(" ");
                end = spaceIndex;
            } else {
                int charIndex = end;
                while (charIndex >= start && s.charAt(charIndex) != ' ') charIndex--;
                result.append(s, charIndex + 1, end + 1);
                end = charIndex + 1;
            }
            end--;
        }
        return result.toString();
    }

    public static String reverseWordsPoint1(String s) {
        if (s == null || s.isEmpty()) return s;
        int start = 0, end = s.length() - 1;
        if (start == end && s.charAt(start) != ' ') return s;
        while (start <= end && s.charAt(start) == ' ') start++;
        while (end >= start && s.charAt(end) == ' ') end--;
        if (start == end) return "";
        StringBuilder result = new StringBuilder();
        for (int i = end; i >= start; ) {
            int k = i;
            while (k >= start && s.charAt(k) != ' ') k--;
            result.append(s, k + 1, i + 1);
            i = k;
            if (i >= start && s.charAt(i) == ' ')
                result.append(" ");
            while (i >= start && s.charAt(i) == ' ') i--;
        }
        return result.toString();
    }
}
