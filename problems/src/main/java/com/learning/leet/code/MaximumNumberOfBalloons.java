package com.learning.leet.code;

import java.util.HashMap;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('b', 0);
        map.put('a', 0);
        map.put('n', 0);
        map.put('l', 0);
        map.put('o', 0);

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }
        int pairCount = Math.min(map.get('o') / 2, map.get('l') / 2);
        int singleCount = Math.min(Math.min(map.get('b'), map.get('a')), map.get('n'));
        return Math.min(pairCount, singleCount);
    }

    public int maxNumberOfBalloons1(String text) {
        int[] counts = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'b') counts[0]++;
            else if (c == 'a') counts[1]++;
            else if (c == 'l') counts[2]++;
            else if (c == 'o') counts[3]++;
            else if (c == 'n') counts[4]++;
        }
        counts[2] /= 2;
        counts[3] /= 2;

        // Find the minimum count among all characters
        int min = counts[0];
        for (int i = 1; i < 5; i++) {
            min = Math.min(min, counts[i]);
        }

        return min;
    }
}
