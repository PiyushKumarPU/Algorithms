package com.learning.practise.scaler.self.basics;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(solve(List.of(5 ,2, 1)));
    }

    public static int solve(List<Integer> A) {
        int result = 0;
        List<Integer> sorted = A.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int index = 0;
        for (Integer element : sorted) {
            result += element * (index + 1);
            index++;
        }
        return result;
    }
}
