package com.learning.leet.code;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int ans = 0, start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }


    private boolean isBadVersion(int n) {
        // this was predefined in leet code
        return n % 2 == 0;
    }

}
