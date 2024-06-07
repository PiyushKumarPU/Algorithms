package com.learning.leet.code;

import java.util.Stack;

public record ReverseWordsInAString() {

    public static void main(String[] args) {
    }

    public static String reverseWordsBF(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static String reverseWords(String s) {
        // Convert to char array for in-place modification
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Trim leading and trailing spaces
        int start = 0, end = n - 1;
        while (start <= end && chars[start] == ' ') start++;
        while (start <= end && chars[end] == ' ') end--;

        // If the whole string is spaces, return empty string
        if (start > end) return "";

        // Step 2: Reverse the entire trimmed array
        reverse(chars, start, end);

        // Step 3: Reverse each word within the reversed array
        int wordStart = start;
        for (int i = start; i <= end; i++) {
            if (chars[i] == ' ') {
                reverse(chars, wordStart, i - 1);
                wordStart = i + 1;
            } else if (i == end) {
                reverse(chars, wordStart, i);
            }
        }

        // Step 4: Clean up spaces between words
        int i = start, j = start;
        while (i <= end) {
            if (chars[i] != ' ') {
                if (j > start && chars[j - 1] != ' ') chars[j++] = ' ';
                while (i <= end && chars[i] != ' ') chars[j++] = chars[i++];
            } else {
                i++;
            }
        }

        return new String(chars, start, j - start);
    }

    public String reverseWordsUsingStack(String s) {
        Stack<String> st = new Stack<String>();
        for (String a : s.trim().split(" ")) {
            if (!a.isEmpty())
                st.push(a);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
