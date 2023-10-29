package com.learning.practise.scaler.self.hashing;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDistinctElement {

    public static void main(String[] args) {
        System.out.println(solve(List.of(3, 4, 3, 6, 6)));
        System.out.println(solve(List.of(3, 3, 3, 9, 0, 1, 0)));

    }

    public static int solve(List<Integer> A) {
        return A.stream()
                .collect(Collectors.groupingBy(Function.identity())).keySet().size();
    }
}
