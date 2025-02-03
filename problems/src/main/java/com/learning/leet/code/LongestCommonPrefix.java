package com.learning.leet.code;

import java.util.Arrays;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefixUsingTrie(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefixUsingArray(String[] strs) {
        if (strs == null) return null;
        else if (strs.length == 1 && strs[0].isEmpty()) return "";
        StringBuilder minCommon = new StringBuilder();
        // find min length String
        String minLengthStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLengthStr.length()) {
                minLengthStr = strs[i];
            }
        }
        // iterate through each character and check if it there at the same index for all the strings
        for (int i = 0; i < minLengthStr.length(); i++) {
            char c = minLengthStr.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return minCommon.toString();
                }
            }
            minCommon.append(c);
        }
        return minCommon.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        Arrays.sort(strs);
        String smallest = strs[0], largest = strs[strs.length - 1];
        while (smallest.length() > count && largest.length() > count) {
            if (smallest.charAt(count) != largest.charAt(count)) break;
            count++;
        }
        return smallest.substring(0, count);
    }

    public String longestCommonPrefixUsingTrie(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        TrieBucket root = new TrieBucket();

        // Find the minimum length of the strings in the array
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        if (minLength == 0) return "";
        // Build the Trie up to the length of the shortest string
        for (String str : strs) {
            TrieBucket temp = root;
            for (int i = 0; i < minLength; i++) {
                char current = str.charAt(i);
                if (!temp.cache.containsKey(current)) {
                    temp.cache.put(current, new TrieBucket());
                }
                temp = temp.cache.get(current);
            }
        }

        // Find the longest common prefix
        StringBuilder builder = new StringBuilder();
        TrieBucket temp = root;
        while (temp.cache.size() == 1) {
            Map.Entry<Character, TrieBucket> entry = temp.cache.entrySet().iterator().next();
            builder.append(entry.getKey());
            temp = entry.getValue();
        }
        return builder.toString();
    }

    private String longestCommon(String str1, String str2) {
        if (str1.length() > str2.length()) return longestCommon(str2, str1);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) str.append(str1.charAt(i));
        }
        return str.toString();
    }
}

