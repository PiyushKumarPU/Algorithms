package com.learning.scaler.advance.module3.stack1.lecture;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        if (s == null || s.length() == 1) return s;
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!charStack.isEmpty() && charStack.peek() == current) charStack.pop();
            else charStack.push(current);
        }
        return charStack.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String removeDuplicatesOtherApproach(String s) {
        char[] chars = s.toCharArray();
        int i = -1;
        for (char ch : chars) {
            if (i >= 0 && ch == chars[i]) {
                i--;
            } else {
                chars[++i] = ch;
            }
        }
        return String.valueOf(chars, 0, i + 1);
    }
}
