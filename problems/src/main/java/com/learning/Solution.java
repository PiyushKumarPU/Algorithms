package com.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(List.of(36, 13, 13, 26, 37, 28, 27, 43, 7)));
    }

    public static ArrayList<Integer> solve(List<Integer> A) {
        System.out.println(String.valueOf(A.stream().sorted(Comparator.comparing(Solution::factor))
                .collect(Collectors.toCollection(ArrayList::new))));


    /*return A.stream().collect(Collectors.toMap(x -> x, Solution::factor))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));*/
      List<Integer> factors =  A.stream().map(Solution::factor)
              .collect(Collectors.toList());
      System.out.println(factors);

        return A.stream().sorted((o1, o2) -> {
            if (factor(o1) < factor(o2)) {
                return -1;
            } else if (factor(o1) > factor(o2)) {
                return 1;
            } else {
                return o1 - o2;
            }
        }).collect(Collectors.toCollection(ArrayList::new));

    }

    private static Integer factor(Integer N) {
        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                cnt += (i == N / i) ? 1 : 2;
            }
        }
        return cnt;
    }
}
 