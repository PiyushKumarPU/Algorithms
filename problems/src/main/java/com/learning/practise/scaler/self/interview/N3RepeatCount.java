package com.learning.practise.scaler.self.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N3RepeatCount {

    public static void main(String[] args) {
        System.out.println(repeatedNumber(List.of(1, 2, 3, 1, 1)));
        System.out.println(repeatedNumber(List.of(1, 2, 3)));

    }

    public static int repeatedNumber(final List<Integer> a) {
        int limit = a.size() / 3;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int currentCount = frequencyMap.getOrDefault(a.get(start), 0) + 1;
            if (currentCount > limit) return a.get(start);
            frequencyMap.put(a.get(start), currentCount);
            if (start != end) {
                currentCount = frequencyMap.getOrDefault(a.get(end), 0) + 1;
                if (currentCount > limit) return a.get(end);
                frequencyMap.put(a.get(end), currentCount);
            }
            start++;
            end--;
        }
        return -1;
    }
}
