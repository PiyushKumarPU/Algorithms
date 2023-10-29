package com.learning.practise.scaler.self.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayZeroSumExists {

    public static void main(String[] args) {

        System.out.println(solve(List.of(2, -2, 4, -4)));
        System.out.println(solve(List.of(4, -1, 1)));
        System.out.println(solve(List.of(1, 2, 3, 4, 5, 6)));
    }

    public static int solve(List<Integer> A) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        long currentSum = A.get(0);
        frequencyMap.put(currentSum, 1);
        for (int element : A) {
            currentSum += element;
            if(currentSum == 0) return 1;
            if(frequencyMap.containsKey(currentSum)) return 1;
            frequencyMap.put(currentSum, (frequencyMap.getOrDefault(currentSum, 0) + 1));
        }
        return 0;
    }
}
