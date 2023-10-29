package com.learning.practise.scaler.advance.dsa.recursion2;

import java.util.ArrayList;

public class GenerateAllParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        solve(result, "", 0, 0, A);
        return result;
    }

    static void solve(ArrayList<String> list, String str, int open, int close, int count) {
        if (str.length() == count * 2) {
            list.add(str);
            return;
        }
        if (open < count) {
            solve(list, str + "(", open + 1, close, count);
        }
        if (close < open) {
            solve(list, str + ")", open, close + 1, count);
        }
    }


}
