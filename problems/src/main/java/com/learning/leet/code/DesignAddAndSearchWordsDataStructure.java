package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }
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
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, NodeBucket node) {
        if (index == word.length()) {
            return node.isEndOfWord != null && node.isEndOfWord;
        }

        char current = word.charAt(index);
        if (current == '.') {
            for (char key : node.cache.keySet()) {
                if (searchInNode(word, index + 1, node.cache.get(key))) {
                    return true;
                }
            }
            return false;
        } else {
            NodeBucket nextNode = node.cache.get(current);
            if (nextNode == null) {
                return false;
            }
            return searchInNode(word, index + 1, nextNode);
        }
    }
}

class WordDictionary2 {
    // implement a prefix tree again

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        // add word to trie char by char
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int cI = (int) c - (int) 'a';
            if (curr.children[cI] == null) {
                curr.children[cI] = new TrieNode();
            }
            curr = curr.children[cI];
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        return search(word, this.root, 0);
    }

    private boolean search(String word, TrieNode root, int j) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && search(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int cI = (int) c - (int) 'a';
                if (curr.children[cI] == null) {
                    return false;
                }
                curr = curr.children[cI];
            }
        }
        return curr != null && curr.isWordEnd;
    }
}

class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    public final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    public boolean isWordEnd = false;
}

class NodeBucket {
    Map<Character, NodeBucket> cache = new HashMap<>();
    Boolean isEndOfWord;
}
