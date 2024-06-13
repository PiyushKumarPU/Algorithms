package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefixUsingTrie(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        else if (strs.length == 1 && strs[0].isEmpty()) return "";
        String minCommon = longestCommon(strs[0], strs[1]);
        if (minCommon.isEmpty()) return minCommon;
        for (int i = 2; i < strs.length; i++) {
            minCommon = longestCommon(minCommon, strs[i]);
            if (minCommon.isEmpty()) return minCommon;
        }
        return minCommon;
    }

    public String longestCommonPrefixSmallest(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }
        return commonPrefix;
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

class TrieBucket {
    Map<Character, TrieBucket> cache;

    public TrieBucket() {
        cache = new HashMap<>();
    }
}
