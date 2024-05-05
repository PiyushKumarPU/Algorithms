package com.learning.revision.binary.search;

import java.util.ArrayList;
import java.util.List;

public class SmallerOrEqualElements {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(3, 4, 5, 17, 19, 22, 27, 33, 37, 42, 43, 46, 48)), 22));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int start = 0, end = A.size() - 1, ans = -1;
        if (B < A.get(start)) return 0;
        else if (B > A.get(end)) return A.size();
        else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (A.get(mid) <= B) {
                    if (A.get(mid) == B) ans = mid + 1;
                    start = mid + 1;
                } else {
                    ans = mid;
                    end = mid - 1;
                }
            }
            return ans;
        }
    }
}
