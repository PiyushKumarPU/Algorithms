package com.learning.practise.scaler.self.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "b", "c"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "abc", "abcd"}));

    }

    public static String longestCommonPrefix(String[] A) {
        if (A.length == 1) return A[0];
        String result = "";
        for (int index = 0; index < A.length - 1; index++) {
            String first = A[index];
            String second = A[index + 1];
            StringBuilder tempResult = new StringBuilder();
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) == second.charAt(j)) tempResult.append(first.charAt(j));
                else break;
            }
            String temp = tempResult.toString();
            if (temp.isEmpty()) {
                return "";
            } else if (result.isEmpty() || result.startsWith(temp)) {
                result = temp;
            } else if (!result.startsWith(temp) && !temp.startsWith(result)) {
                return "";
            }
        }
        return result;
    }
}
