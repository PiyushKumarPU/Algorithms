package com.learning.practise.scaler.self.strings;

public class LongestPalindromicString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
        System.out.println(longestPalindrome("aabbab"));
        System.out.println(longestPalindrome("aaabaaa"));
        System.out.println(longestPalindrome("aaaaaa"));
        System.out.println(longestPalindrome("abcdefgh"));
    }

    public static String longestPalindrome(String A) {
        String result = "";
        int length = 0;
        for (int i = 0; i < A.length(); i++) {
            // check for odd size string i.e. mirror image
            int startIndex = i, endIndex = i;
            while (startIndex >= 0 && endIndex < A.length()) {
                if (A.charAt(startIndex) != A.charAt(endIndex)) {
                    break;
                }
                startIndex--;
                endIndex++;
            }
            length = Math.max(length, (endIndex - startIndex - 1));
            String tempResult = A.substring(Math.max(startIndex + 1, 0), Math.min(A.length(), endIndex));
            result = tempResult.length() > result.length() ? tempResult : result;
            // check for even size string
            int eStartIndex = i, eEndIndex = i + 1;
            while (eStartIndex >= 0 && eEndIndex < A.length()) {
                if (A.charAt(eStartIndex) != A.charAt(eEndIndex)) {
                    break;
                }
                eStartIndex--;
                eEndIndex++;
            }
            length = Math.max(length, (eEndIndex - eStartIndex - 1));
            tempResult = A.substring(Math.max(eStartIndex + 1, 0), Math.min(A.length(), eEndIndex));
            result = tempResult.length() > result.length() ? tempResult : result;
        }
        return result;
    }
}
