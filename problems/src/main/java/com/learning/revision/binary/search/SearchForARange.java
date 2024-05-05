package com.learning.revision.binary.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SearchForARange {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 17, 100, 111}, 3)));
    }


    public static int[] searchRange(final int[] A, int B) {
        if (A == null || A.length == 0 || A.length == 1) return new int[]{0, 0};
        int[] result = new int[]{-1, -1};
        int start = 0, end = A.length - 1;
        // find left index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < B) {
                start = mid + 1;
            } else if (A[mid] == B) {
                if (A[mid] > (mid > 0 ? A[mid - 1] : 0)) {
                    start = mid;
                    end = A.length - 1;
                    if (result[0] < 0) result[0] = mid;
                    else result[1] = mid;
                    break;
                }
                end = mid - 1;
            } else end = mid - 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < B) {
                start = mid + 1;
            } else if (A[mid] == B) {
                if (A[mid] < (mid < A.length - 1 ? A[mid + 1] : Integer.MAX_VALUE)) {
                    result[1] = mid;
                    break;
                }
                start = mid + 1;
            } else end = mid - 1;
        }
        return result;
    }
}
