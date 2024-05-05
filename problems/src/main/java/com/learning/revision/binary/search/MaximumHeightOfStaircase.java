package com.learning.revision.binary.search;

public class MaximumHeightOfStaircase {

    public int solve(int A) {
        if (A <= 0) return 0;
        int start = 1, end = 44721, ans = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int currentMax = mid * (mid + 1) / 2;
            if (currentMax <= A) {
                if (currentMax == A) return mid;
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

}
