package com.learning.leet.code;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {
        int openCount = 0, operationCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else {
                    operationCount++;
                }
            }
        }
        if (openCount > 0) {
            operationCount += openCount;
        }
        return operationCount;
    }
}
