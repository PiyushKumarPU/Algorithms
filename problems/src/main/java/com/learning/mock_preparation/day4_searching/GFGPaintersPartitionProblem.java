package com.learning.mock_preparation.day4_searching;


/*

 * */
public class GFGPaintersPartitionProblem {


    // https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
    static long minTime(int[] arr, int n, int k) {
        long result = 0, start = 0, end = 0;
        for (int ele : arr) {
            start = Math.max(start, ele);
            end += ele;
        }

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValidTime(mid, k, arr)) {
                end = mid - 1;
                result = mid;
            } else start = mid + 1;
        }
        return result;
    }

    private static boolean isValidTime(long givenTime, int painterCount, int[] boards) {
        int count = 1, work = 0;
        for (int board : boards) {

            if (work + board <= givenTime) {
                work += board;
            } else {
                count++;
                work = board;
            }
            if (count > painterCount) return false;
        }
        return count <= painterCount;
    }


}
