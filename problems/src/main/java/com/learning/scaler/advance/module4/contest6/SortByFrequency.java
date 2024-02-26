package com.learning.scaler.advance.module4.contest6;

import java.util.*;

public class SortByFrequency {

    public static void main(String[] args) {
        SortByFrequency sortByFrequency = new SortByFrequency();
        System.out.println(sortByFrequency.sortByFreq("bbbaaccccddd"));
    }

    public String sortByFreq(String str) {
        StringBuilder builder = new StringBuilder();

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
        }

        freqMap.entrySet().stream().sorted((e1, e2) -> {
            int valueCompare = e2.getValue().compareTo(e1.getValue());
            if (valueCompare != 0) return valueCompare;
            return e1.getKey().compareTo(e2.getKey());
        }).forEach(System.out::println);

        freqMap.entrySet().stream().sorted((e1, e2) -> {
            int valueCompare = e2.getValue().compareTo(e1.getValue());
            if (valueCompare != 0) return valueCompare;
            return e1.getKey().compareTo(e2.getKey());
        }).forEach(entry -> builder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue()))));
        return builder.toString();
    }

    public ArrayList<Integer> relativeSortArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            indexMap.put(B.get(i), i);
        }

        A.sort((num1, num2) -> {
            if (indexMap.containsKey(num1) && indexMap.containsKey(num2)) {
                return Integer.compare(indexMap.get(num1), indexMap.get(num2));
            } else if (indexMap.containsKey(num1)) {
                return -1;
            } else if (indexMap.containsKey(num2)) {
                return 1;
            } else {
                return Integer.compare(num1, num2);
            }
        });
        return A;
    }
}
