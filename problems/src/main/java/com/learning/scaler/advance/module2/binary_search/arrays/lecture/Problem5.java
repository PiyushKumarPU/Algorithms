package com.learning.scaler.advance.module2.binary_search.arrays.lecture;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array with duplicates, count total occurrences of a given num.
* */
public class Problem5 {

    public static void main(String[] args) {

    }


    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (A.size() == 1) {
            if(A.get(0) == B){
                result.add(0);
                result.add(0);
                return result;
            }
            return result;
        }
        int start = 0, end = A.size() - 1, leftMostIndex = Integer.MAX_VALUE, rightMostIndex = Integer.MIN_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A.get(mid) == B) leftMostIndex = Math.min(leftMostIndex, mid);
            if ((A.get(mid) == B && (mid > 0 && A.get(mid - 1) == B)) || A.get(mid) > B) {
                end = mid - 1;
            } else start = mid + 1;
        }
        if(leftMostIndex != Integer.MAX_VALUE){
            start = leftMostIndex;
            end = A.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (A.get(mid) == B) rightMostIndex = Math.max(rightMostIndex, mid);
                if ((A.get(mid) == B && (mid < (A.size() - 1) && A.get(mid + 1) == B)) || A.get(mid) < B) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        result.add(leftMostIndex != Integer.MAX_VALUE ? leftMostIndex : -1);
        result.add(rightMostIndex != Integer.MIN_VALUE ? rightMostIndex : -1);
        return result;
    }
}
