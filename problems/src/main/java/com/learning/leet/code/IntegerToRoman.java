package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {


    public String intToRoman(int num) {
        Map<Integer, Character> map = Map.of(1, 'I', 5, 'V', 10, 'X', 50, 'L', 100, 'C', 500, 'D', 1000, 'M');


        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};
        // Arrays for Roman numeral symbols and their integer values
        StringBuilder roman = new StringBuilder();

        // Construct the Roman numeral string
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();

    }




    /*static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public static String intToRoman(int num) {
        // Arrays for Roman numeral symbols and their integer values
        StringBuilder roman = new StringBuilder();

        // Construct the Roman numeral string
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }*/

}
