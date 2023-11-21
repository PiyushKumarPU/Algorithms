package com.learning.scaler.advance.module2.binary_search.bs_answers.lecture;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Given N stalls and M cows. N >= M Position of each stall is given in A[N] in ascending order.
    Maximise the closest distance between cows.
    Further explanation: We need to place cow in a stall so that minimum distance between the cows will be maximum
    i.e. Each cow will be placed at maximum possible distance to each other.

* */
public class AggressiveCowsProblem {

    public static void main(String[] args) {
        System.out.println(placeCows(new ArrayList<>(List.of(2, 6, 11, 14, 19, 25, 30, 39, 43)), 4));
    }


    public static int placeCows(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        int start = Integer.MAX_VALUE, end = A.get(A.size() - 1) - A.get(0), ans = 0;
        for (int i = 1; i < A.size(); i++) start = Math.min(start, (A.get(i) - A.get(i - 1)));
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidDistance(mid, A, B)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private static boolean isValidDistance(int mid, ArrayList<Integer> distance, int cowCount) {
        int currentCount = 1, position = distance.get(0);
        for (int i = 1; i < distance.size(); i++) {
            if(distance.get(i) - position >= mid){
                currentCount++;
                position = distance.get(i);
                if(cowCount == currentCount) return true;
            }
        }
        return false;
    }
}
