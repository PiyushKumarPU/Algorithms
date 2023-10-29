package com.learning.practise.scaler.self.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class SubArraySumZero {

    public static void main(String[] args) {
        System.out.println(solve(List.of(30,-30,30,-30)));

    }

    public static int solve(List<Integer> A) {
        AtomicLong result = new AtomicLong();
        int currentSum = A.get(0);
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(currentSum, 1L);
        for (int i = 1; i < A.size(); i++) {
            currentSum += A.get(i);
            long count = countMap.getOrDefault(currentSum, 0L) + 1L;
            countMap.put(currentSum, count);
        }
        result.addAndGet(countMap.getOrDefault(0, 0L));
        countMap.entrySet().stream().filter(entry -> entry.getKey() != 0 && entry.getValue() > 1)
                .map(Map.Entry::getValue).forEach(dataCount -> {
                            result.addAndGet(dataCount);
                            result.updateAndGet(v -> v % 1000000007);
                        }
                );
        return (int) (result.get() % 1000000007);
    }


}
