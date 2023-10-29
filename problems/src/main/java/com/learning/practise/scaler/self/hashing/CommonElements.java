package com.learning.practise.scaler.self.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonElements {

    public static void main(String[] args) {

        System.out.println(solve(List.of(1, 2, 2, 1), List.of(2, 3, 1, 2)));
        System.out.println(solve(List.of(2, 1, 4, 10), List.of(3, 6, 2, 10, 10)));
    }

    public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Long> aMap = A.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> bMap = B.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Integer element : (A.size() > B.size() ? B : A)) {
            Long aCount = aMap.getOrDefault(element, 0L);
            Long bCount = bMap.getOrDefault(element, 0L);
            if (aCount > 0 && bCount > 0 && !result.contains(element)) {
                for (int i = 0; i < Math.min(aCount, bCount); i++) {
                    result.add(element);
                }
            }
        }
        return result;
    }
}
