package com.learning.mock_preparation.day5_hashing;


import java.util.HashMap;

/*
Problem Description
    Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest
    substring that contains no repeating characters. The greater the length of this unique-character substring,
    the higher the "GOOD"ness of the string.
    Your task is to return an integer representing the "GOOD"ness of string A.
    Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.

Problem Constraints
    1 <= size(A) <= 10^6

    String consists of lowerCase,upperCase characters and digits are also present in the string A.

Input Format
    Single Argument representing string A.

Output Format
     Returns an integer denoting the maximum possible length of substring without repeating characters.

Example
    Input 1:
         A = "abcabcbb"
    Input 2:
         A = "AaaA"

Example Output
    Output 1:
         3
    Output 2:
         2

Example
    Explanation 1:
         Substring "abc" is the longest substring without repeating characters in string A.
    Explanation 2:
         Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
* */
public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("AaaA"));

        System.out.println(lengthOfLongestSubstringScaler("abcabcbb"));
        System.out.println(lengthOfLongestSubstringScaler("AaaA"));
    }

    // https://www.scaler.com/academy/mentee-dashboard/class/155293/homework/problems/161
    public static int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int maxCount = 0, startIndex = 0;
        for (int endIndex = 0; endIndex < A.length(); endIndex++) {
            char currentChar = A.charAt(endIndex);
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= startIndex) {
                startIndex = lastSeen.get(currentChar) + 1;
            }
            lastSeen.put(currentChar, endIndex);
            maxCount = Math.max(maxCount, (endIndex - startIndex + 1));
        }
        return maxCount;
    }

    public static int lengthOfLongestSubstringScaler(String A) {
        int count = 0, max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char c;
        int prevIndex;
        for (int i = 0; i < A.length(); i++) {
            c = A.charAt(i);
            if (hashMap.containsKey(c)) {
                prevIndex = hashMap.get(c);
                count = Math.min(count + 1, i - prevIndex);
                hashMap.put(c, i);
            } else {
                count++;
                hashMap.put(c, i);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
