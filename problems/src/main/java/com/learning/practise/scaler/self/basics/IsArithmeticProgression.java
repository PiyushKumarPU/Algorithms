package com.learning.practise.scaler.self.basics;

import java.util.List;
import java.util.stream.Collectors;

public class IsArithmeticProgression {

    public static void main(String[] args) {
        System.out.println(solve(List.of(3, 5, 1)));

        System.out.println(solve(List.of(2, 4, 1)));
    }

    public static int solve(List<Integer> A) {
        List<Integer> sorted = A.stream().sorted().collect(Collectors.toList());
        int diff = sorted.get(1) - sorted.get(0);
        for (int index = 2; index < sorted.size(); index++) {
            if (diff != (sorted.get(index) - sorted.get(index - 1))) return 0;
        }
        return 1;
    }
}
