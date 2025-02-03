package com.learning.leet.code;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
        System.out.println("PINALSIGYAHRPI");

        /*System.out.println(convert2(s, 3));
        System.out.println("PAHNAPLSIIGYIR");

        System.out.println(convert2("A", 1));
        System.out.println("A");

        System.out.println(convert2("AB", 1));
        System.out.println("AB");*/
    }

    public static String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int start = 0, i = 0;
        while (i < s.length()) {
            if (start == 0) {
                while (start < numRows && i < s.length()) {
                    rows.get(start).append(s.charAt(i++));
                    start++;
                }
            }
            if (start == numRows) {
                start -= 2;
                start = Math.max(start, 0);
                while (start > 0 && i < s.length()) {
                    rows.get(start).append(s.charAt(i++));
                    start--;
                }
            }
        }

        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s; // No zigzag pattern needed
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static String convertNoSpace(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s; // No zigzag pattern needed
        }

        StringBuilder result = new StringBuilder();
        int cycleLength = 2 * numRows - 2; // The repeating cycle length

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += cycleLength) {
                result.append(s.charAt(j)); // Add the character in the current row

                // Handle the middle characters in the zigzag pattern
                int secondCharIndex = j + cycleLength - 2 * row;
                if (row != 0 && row != numRows - 1 && secondCharIndex < s.length()) {
                    result.append(s.charAt(secondCharIndex));
                }
            }
        }

        return result.toString();
    }
}
