package com.learning.leet.code;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {


    public List<List<String>> groupAnagramsWithMapAndSort(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            str = new String(sorted);
            if (anagramMap.containsKey(str)) anagramMap.get(str).add(str);
            else {
                List<String> row = new ArrayList<>();
                row.add(str);
                anagramMap.put(str, row);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : anagramMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    // high tc solution
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == "-1") continue;
            List<String> row = new ArrayList<>();
            row.add(strs[i]);
            int start = i + 1;
            while (start < strs.length) {
                if (strs[i].length() == strs[start].length() && strs[start] != "-1") {
                    if (isAnagram(strs[i], strs[start])) {
                        row.add(strs[start]);
                        strs[start] = "-1";
                    }
                }
                start++;
            }
            result.add(row);
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        for (int count : charCounts) if (count != 0) return false;
        return true;
    }
}
