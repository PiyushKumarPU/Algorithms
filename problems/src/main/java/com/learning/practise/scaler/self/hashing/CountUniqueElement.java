package com.learning.practise.scaler.self.hashing;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountUniqueElement {

    public static void main(String[] args) {
        System.out.println(solve(List.of(3, 4, 3, 6, 6)));
        System.out.println(solve(List.of(3, 3, 3, 9, 0, 1, 0)));

    }

    public static int solve(List<Integer> A) {
        Map<Integer, List<Integer>> countMap = A.stream().collect(Collectors.groupingBy(Function.identity()));
        return (int) countMap.values().stream().filter(datas -> datas.size() ==1 ).count();
    }
}
