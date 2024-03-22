package com.learning.leet.code;

import java.util.HashMap;
import java.util.Objects;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if ((s == null || t == null) || s.length() != t.length()) return false;
        HashMap<Character, Integer> sFreqMap = new HashMap<>();
        HashMap<Character, Integer> tFreqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sFreqMap.put(s.charAt(i), sFreqMap.getOrDefault(s.charAt(i), 0) + 1);
            tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (sFreqMap.size() == tFreqMap.size()) {
            for (Character key : sFreqMap.keySet()) {
                if (!Objects.equals(sFreqMap.get(key), tFreqMap.getOrDefault(key, -1))) return false;
            }

        } else return false;
        return true;
    }

    public boolean isAnagramOptmized(String s, String t) {
        if ((s == null || t == null) || s.length() != t.length()) return false;
        int[] holders = new int[26];
        for (int i = 0; i < s.length(); i++) {
            holders[s.charAt(i) - 'a']++;
            holders[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (holders[i] != 1) return false;
        }
        return true;
    }
}
