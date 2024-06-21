package com.learning.practise.scaler.dsa4_2.trie1;

import com.learning.leet.code.TrieBucket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShortestUniquePrefix {


    public static void main(String[] args) {
        ShortestUniquePrefix prefix = new ShortestUniquePrefix();
        System.out.println(prefix.prefix(new ArrayList<>(List.of("zebra", "dog", "duck", "dove"))));
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieBucket root = new TrieBucket();
        for (String word : A) {
            TrieBucket temp = root;
            for (int i = 0; i < word.length(); i++) {
                Character current = word.charAt(i);
                temp = temp.cache.computeIfAbsent(current, notPresent -> new TrieBucket());
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<Character, TrieBucket> entry : root.cache.entrySet()) {
            // find all the character till brancing exists
            StringBuilder str = new StringBuilder(entry.getKey());
            while (entry.getValue().cache.size() == 1) {
                str.append(entry.getKey());
                entry = entry.getValue().cache.entrySet().stream().findFirst().get();
            }
            result.add(str.toString());
        }
        return result;
    }

}
