package com.learning.scaler.advance.module2.binary_search.problems.additional;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedian {

    public static void main(String[] args) {
        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(5, 17, 100))
        ))));

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 3, 5)),
                new ArrayList<>(List.of(2, 6, 9)),
                new ArrayList<>(List.of(3, 6, 9))
        ))));


        // 1 2 3 3 5 6 6 9 9
        // 1 2 3 4 5 6


    }


    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE, N = A.size(), M = A.get(0).size(), elementCount = M * N;
        // find min for start and max for end
        for (ArrayList<Integer> row : A) {
            start = Math.min(start, row.get(0));
            end = Math.max(end, row.get(M - 1));
        }

        while (start <= end) {

        }


    }


}
