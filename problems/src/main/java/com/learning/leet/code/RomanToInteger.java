package com.learning.leet.code;

import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    static Map<Character, Integer> romanMap = Map.of('I', 1,
            'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static int romanToInt(String s) {
        int result = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            int currentValue = romanMap.get(s.charAt(i));

            if (i < n - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }
}
