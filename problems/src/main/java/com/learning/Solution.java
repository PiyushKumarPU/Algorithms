package com.learning;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        long totalSum = 0;
        int n = A.size();
        for (Integer i : A) {
            totalSum += i;
        }
        if (totalSum <= B) return n;
        long[] prefix = new long[n];
        prefix[0] = A.get(0);
        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }
        int lo = 1;
        int hi = n;
        int ans = 0;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (check(mid, prefix, B) == 1) {
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }



    // Checks if there is a subarray of size s whose sum is greater than sm in linear time
    int check(int s, long[] arr, long sm) {
        for (int i = s - 1; i < arr.length; ++i) {
            if (i == s - 1) {
                if (arr[i] > sm) {
                    return 1;
                }
            } else if (arr[i] - arr[i - s] > sm) {
                return 1;
            }
        }
        return 0;
    }
}
