package com.learning.practise.scaler.advance.dsa.bitmanipulation2;

import java.util.*;
import java.util.stream.Collectors;

public class MaxAndPair {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(53);
        integers.add(39);
        integers.add(88);

        System.out.println(solve(integers));
        integers = new ArrayList<>();
        integers.add(38);
        integers.add(44);
        integers.add(84);
        integers.add(12);
        System.out.println(solve(integers));
    }

    public static int solve(List<Integer> A) {
        for (int pos = 31; pos >= 0; pos--) {
            int setCount = 0, shiftVal = 1 << pos;
            for (int j : A) {
                if ((j & shiftVal) > 0) setCount++;
            }
            if (setCount >= 2) {
                for (int j = 0; j < A.size(); j++) {
                    if ((A.get(j) & shiftVal) == 0) A.set(j, 0);
                }
            }
        }
        A = A.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return A.get(0) & A.get(1);
    }
}
