package com.learning.revision.binary.search;

import java.util.ArrayList;

public class SortedInsertPosition {

    public int searchInsert(int[] A, int B) {
        if (A == null || A.length == 0) return -1;
        if (A[0] > B) return 0;
        else if (A[A.length - 1] < B) return A.length;

        int size = A.length, start = 0, end = size - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) return mid;
            else if (A[mid] < B && B < (mid < size - 1 ? A[mid + 1] : Integer.MAX_VALUE)) return mid + 1;
            else if (A[mid] < B) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }

    public int searchInsert(ArrayList<Integer> A, int B) {
        if (A == null || A.size() == 0) return -1;
        if (A.get(0) > B) return 0;
        else if (A.get(A.size() - 1) < B) return A.size();

        int size = A.size(), start = 0, end = size - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) == B) return mid;
            else if (A.get(mid) < B && B < (mid < size - 1 ? A.get(mid + 1) : Integer.MAX_VALUE)) return mid + 1;
            else if (A.get(mid) < B) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}
