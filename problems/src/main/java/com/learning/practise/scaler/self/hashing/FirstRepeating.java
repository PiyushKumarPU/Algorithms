package com.learning.practise.scaler.self.hashing;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeating {

    public static void main(String[] args) {
        System.out.println(solve(List.of(10, 5, 3, 4, 3, 5, 6)));
        System.out.println(solve(List.of(6, 10, 5, 4, 9, 120)));
    }

    public static int solve(List<Integer> A) {
        Map<Integer, Long> frequencyMap = A.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        for (Integer integer : A) {
            if (frequencyMap.get(integer) > 1) return integer;
        }
        return -1;
    }
}
