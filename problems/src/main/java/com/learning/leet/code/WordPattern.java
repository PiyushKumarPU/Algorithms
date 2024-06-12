package com.learning.leet.code;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        // pattern = "abba", s = "dog cat cat dog"
        HashMap<Character, String> charWordMap = new HashMap<>();
        HashMap<String, Character> wordCharMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];
            if (charWordMap.containsKey(currentChar) && !charWordMap.get(currentChar).equals(currentWord)) return false;
            if (wordCharMap.containsKey(currentWord) && wordCharMap.get(currentWord) != currentChar) return false;
            if (!charWordMap.containsKey(currentChar))
                charWordMap.put(currentChar, currentWord);
            if (!wordCharMap.containsKey(currentWord))
                wordCharMap.put(currentWord, currentChar);
        }
        return true;
    }
}
