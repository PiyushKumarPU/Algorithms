package com.learning.practise.scaler.self.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(List.of(2, 1, 2)));
        System.out.println(majorityElement(List.of(1, 1, 1)));
    }

    // TC O(N) SC O(N)
    public static int majorityElement(final List<Integer> A) {
        int limit = A.size() / 2;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int currentCount = frequencyMap.getOrDefault(A.get(start), 0) + 1;
            if (currentCount > limit) return A.get(start);
            frequencyMap.put(A.get(start), currentCount);
            if (start != end) {
                currentCount = frequencyMap.getOrDefault(A.get(end), 0) + 1;
                if (currentCount > limit) return A.get(end);
                frequencyMap.put(A.get(end), currentCount);
            }
            start++;
            end--;
        }
        return 0;
    }
}
