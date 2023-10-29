package com.learning.practise.scaler.self.strings;

import java.util.Objects;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(solve2(" aa  b   c   d   e     a   "));
    }

    public static String solve(String A) {
        char[] chars = A.toCharArray();
        int start = 0, end = A.length() - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static String solve2(String A) {
        StringBuilder result = new StringBuilder();
        String[] elements = A.split(" ");
        for (int index = elements.length - 1; index >= 0; index--) {
            String element = elements[index];
            if (!Objects.equals(element, "") && !Objects.equals(element, " "))
                result.append(!result.isEmpty() && (index > 0 || (index != elements.length - 1)) ? " " : "").append(element);
        }
        return result.toString();
    }
}
