package com.learning.practise.scaler.self.interview;

public class LongestConsecutive1s {

    public static void main(String[] args) {
        System.out.println(solve("1111111"));
        System.out.println(solve("000000"));

    }

    public static int solve(String A) {
        int count = 0, onesCount = 0;
        for (char ch : A.toCharArray()) {
            if (ch == '1') onesCount++;
        }
        if (onesCount == 0) return 0;
        if (onesCount == A.length()) return onesCount;
        for (int i = 0; i < A.length(); i++) {
            int lCount = 0, rCount = 0;
            int left = i - 1, right = i + 1;
            while (left >= 0 && A.charAt(left) == '1') {
                lCount++;
                left--;
            }
            while (right < A.length() && A.charAt(right) == '1') {
                right++;
                rCount++;
            }
            int tempResult = lCount + rCount;
            if (tempResult < onesCount) tempResult += 1;
            count = Math.max(count, tempResult);
        }
        return count;
    }
}
