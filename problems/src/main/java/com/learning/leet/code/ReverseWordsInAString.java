package com.learning.leet.code;

public record ReverseWordsInAString() {

    public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        String[] strings = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].charAt(0) == ' ' && (i == strings.length - 1 || i == 0)) continue;

        }
        return "";
    }

    public String reverseWordsPoint(String s) {
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
}
