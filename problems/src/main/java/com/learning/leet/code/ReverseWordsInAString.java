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
}
