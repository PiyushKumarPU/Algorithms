package com.learning.practise.scaler.self.strings;

public class CountOccurences {

    public static void main(String[] args) {
        System.out.println(solve("bobob"));
    }

    public static int solve(String A) {
        int result = 0, index = 0;
        while (index < A.length() - 2) {
            int count = 1;
            if (A.charAt(index) == 'b') {
                if (A.charAt(index + 1) == 'o' && A.charAt(index + 2) == 'b') {
                    result++;
                    count = 2;
                }
            }
            index += count;
        }
        return result;
    }
}
