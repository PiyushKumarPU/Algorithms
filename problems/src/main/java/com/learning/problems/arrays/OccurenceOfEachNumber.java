package com.learning.problems.arrays;

import java.util.*;

public class OccurenceOfEachNumber {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 2, 2, 1, 2, 2, 2, 1));
        System.out.println(findOccurences(integers));
    }

    public static ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); ) {
            int start = i + 1;
            if (start < A.size()) {
                if (Objects.equals(A.get(i), A.get(start))) {
                    while (start < A.size() && Objects.equals(A.get(i), A.get(start)))
                        start++;
                    result.add((start - i + 1));
                } else {
                    result.add(1);
                }
                i = start;
            }else i++;

        }
        return result;
    }
}
