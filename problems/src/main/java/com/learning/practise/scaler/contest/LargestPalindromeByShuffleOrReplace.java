package com.learning.practise.scaler.contest;

public class LargestPalindromeByShuffleOrReplace {

    public static void main(String[] args) {
        System.out.println(findLongestPalindrome("banana"));
    }

    static String findLongestPalindrome(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        StringBuilder beg = new StringBuilder();
        String mid = "";
        String end = "";

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch] % 2 == 1) {
                mid = String.valueOf(ch);
                count[ch--]--;
            } else {
                beg.append(String.valueOf(ch).repeat(Math.max(0, count[ch] / 2)));
            }
        }
        end = beg.toString();
        end = reverse(end);
        return beg + mid + end;
    }

    static String reverse(String str) {
        // convert String to character array
        // by using toCharArray
        String ans = "";
        char[] try1 = str.toCharArray();

        for (int i = try1.length - 1; i >= 0; i--) {
            ans += try1[i];
        }
        return ans;
    }
}
