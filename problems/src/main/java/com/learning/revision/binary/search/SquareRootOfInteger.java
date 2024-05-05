package com.learning.revision.binary.search;

public class SquareRootOfInteger {

    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }

    public static int sqrt(int A) {
        long start = 1, end = A, ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;
            if (square <= A) {
                ans = Math.max(ans, mid);
                start = mid + 1;

            } else end = mid - 1;
        }
        return (int)ans;
    }
}
