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
            if (count >= k) {
                return current;
            }

            if (count < k) {
                start = mid + 1;
            } else end = mid - 1;
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

    static int count(List<Integer> nums, int mid)
    {
        int cnt = 0;
        for (Integer ele : nums)
            if (ele <= mid)
                cnt++;
        return cnt;
    }

    static int kthSmallest(List<Integer> nums, int k)
    {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        // calculate minimum and maximum the array.
        for (Integer ele : nums) {
            low = Math.min(low, ele);
            high = Math.max(high, ele);
        }
        // Our answer range lies between minimum and maximum
        // element of the array on which Binary Search is
        // Applied
        while (low < high) {
            int mid = low + (high - low) / 2;
            /*if the count of number of elements in the
              array less than equal to mid is less than k
              then increase the number. Otherwise decrement
              the number and try to find a better answer.
            */
            if (count(nums, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

}
