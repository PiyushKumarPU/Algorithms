package com.learning.revision.binary.search;

import java.util.List;

public class FindMinInRotatedSortedArray {

    public int findMin(final List<Integer> a) {
        if (a.get(0) <= a.get(a.size() - 1)) return a.get(0);
        int start = 0, end = a.size() - 1, ans = Integer.MAX_VALUE, first = a.get(0);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) > first) start = mid + 1;
            else {
                ans = Math.min(ans, a.get(mid));
                end = mid - 1;
            }
        }
        return ans;
    }
}
