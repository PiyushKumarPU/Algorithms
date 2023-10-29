package com.learning.practise.scaler.self.hashing;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ElementFrequencyQuery {

    public static void main(String[] args) {
        System.out.println(solve(List.of(1, 2, 1, 1), List.of(1, 2)));
    }

    public static List<Integer> solve(List<Integer> A, List<Integer> B) {
        Map<Integer, Long> frequencyMap = A.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return B.stream().map(key -> frequencyMap.getOrDefault(key, 0L).intValue()).collect(Collectors.toList());
    }
}
