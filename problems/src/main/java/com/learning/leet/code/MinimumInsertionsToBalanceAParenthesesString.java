package com.learning.leet.code;

public class MinimumInsertionsToBalanceAParenthesesString {

    public int minInsertions(String s) {
        /*
        Steps to follow
            Keep increasing opening count once we find ( braces
            if it is closing braces there could be three scenarion
                1. we have opening braces for it and there are two consecutive )) then do nothing
                2. If there are only one closing and there is no opening increase operation count by 1
                3. if there are two consecutinve closing and there is no opening then operation count by 2
                in scenarion 1
            at last check if any opening braces left
        * */
        int openCount = 0, operationCount = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == '(') {
                openCount++;
                i++;
            } else {
                int closeCount = 1;
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') closeCount++;
                if (openCount > 0) {
                    operationCount += (closeCount == 2 ? 0 : closeCount);
                    openCount--;
                } else {
                    operationCount += (3 - closeCount);
                }
                i += closeCount;
            }
        }
        if (openCount > 0) {
            operationCount += openCount * 2;
        }
        return operationCount;
    }
}
