package com.learning.practise.scaler.advance.dsa.bitmanipulation2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MInXORVal {

    public static void main(String[] args) {
        System.out.println(findMinXor(List.of(0, 2, 5, 7)));
        System.out.println(findMinXor(List.of(0, 4, 7, 9)));
    }

    public static int findMinXor(List<Integer> A) {
        List<Integer> sorted = A.stream().sorted().collect(Collectors.toList());
        return sorted.get(0) ^ sorted.get(1);
    }
}
