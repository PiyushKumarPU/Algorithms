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


    }


    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int N = A.size(), M = A.get(0).size(), start = 0, end = N * M - 1, k = ((N * M) / 2);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / M, j = mid % M;
            int current = A.get(i).get(j);
            int count = count(A, current, i, j);
            if (count == k) {
                return current;
            }
            if (count > k) end = mid - 1;
            else start = mid + 1;
        }
        return 0;
    }

    private static int count(ArrayList<ArrayList<Integer>> A, int target, int i, int j) {
        int count = 0;
        for (int start = 0; start < A.size(); start++) {
            for (int end = 0; end < A.get(0).size(); end++) {
                if (start == i && end == j && A.get(0).size() == 1) return count;
                if (A.get(start).get(end) <= target) count++;
            }
        }
        return count;
    }

}
