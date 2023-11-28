package com.learning.scaler.advance.module2.binary_search.problems.additional;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedian {

    public static void main(String[] args) {
        /*System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(5, 17, 100))
        ))));

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3))
        ))));


        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 3, 5)),
                new ArrayList<>(List.of(2, 6, 9)),
                new ArrayList<>(List.of(3, 6, 9))
        ))));*/

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 1, 3, 3, 3, 3, 3))
        ))));

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 1, 1, 1, 1, 1, 1))
        ))));


    }


    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int N = A.size(), M = A.get(0).size(), start = 0, end = N * M - 1, k = ((N * M) / 2) + 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / M, j = mid % M;
            int current = A.get(i).get(j);
            int count = count(A, current);

        }
        return 0;
    }

    private static int count(ArrayList<ArrayList<Integer>> A, int target) {
        int count = 0;
        for (ArrayList<Integer> row : A) {
            if (target > row.get(row.size() - 1)) {
                count += row.size();
                continue;
            }
            for (Integer integer : row) {
                if (integer <= target) count++;
            }
        }
        return count;
    }

}
