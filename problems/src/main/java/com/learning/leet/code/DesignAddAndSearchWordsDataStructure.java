package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {
}

class WordDictionary {

    NodeBucket root;

    public WordDictionary() {
        root = new NodeBucket();
    }

    public void addWord(String word) {
        NodeBucket temp = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            temp = temp.cache.computeIfAbsent(current, ifNotPresent -> new NodeBucket());
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        NodeBucket temp = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            temp = temp.cache.get(current);
            if (temp == null) return false;
        }
        return temp.isEndOfWord;
    }
}

class NodeBucket {
    Map<Character, NodeBucket> cache = new HashMap<>();
    Boolean isEndOfWord;
}
