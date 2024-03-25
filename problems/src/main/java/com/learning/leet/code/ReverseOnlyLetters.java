package com.learning.leet.code;

public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String str = "a-bC-dEf-ghIj";
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters(str));
    }

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() <= 1) return s;
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            if (isNotLetter(chars[start]) || isNotLetter(chars[end])) {
                if (isNotLetter(chars[start])) start++;
                else end--;
            } else {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    private boolean isNotLetter(char ch) {
        return (ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z');
    }

}
