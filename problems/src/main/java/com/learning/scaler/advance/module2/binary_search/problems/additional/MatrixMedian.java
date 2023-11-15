package com.learning.scaler.advance.module2.binary_search.problems.additional;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedian {

    public static void main(String[] args) {
      System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(5, 17, 100))
        ))));

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of( 1,2,2,2,2,2,3,3,3,3,3))
        ))));



        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 3, 5)),
                new ArrayList<>(List.of(2, 6, 9)),
                new ArrayList<>(List.of(3, 6, 9))
        ))));

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of( 1,1,3,3,3,3,3))
        ))));


    }


    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int N = A.size(), M = A.get(0).size(), start = 0, end = N * M - 1, k = (N * M) / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / M, j = mid % M;
            int current = A.get(i).get(j);
            int count = count(A, current);
            if (count == k) {
                return current;
            } else if (count <= k) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return 0;
    }

    private static int count(ArrayList<ArrayList<Integer>> A, int target) {
        int count = 0;
        for (ArrayList<Integer> row : A) {
            int start = 0, end = row.size() - 1;
            if (target > row.get(end)) {
                count += row.size();
                continue;
            }
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midElement = row.get(mid);
                if ((midElement == target && (mid == 0 || midElement > row.get(mid - 1)))
                        || (midElement <= target && (mid == row.size() - 1 || target < row.get(mid + 1)))) {
                    count += target == midElement ? mid : mid + 1;
                    break;
                } else if (midElement < target) {
                    start = mid + 1;
                } else end = mid - 1;
            }
        }
        return count;
    }
}
