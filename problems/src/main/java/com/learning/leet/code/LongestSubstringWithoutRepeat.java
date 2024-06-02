package com.learning.leet.code;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String A) {
        boolean[] ss = new boolean[256];
        int ans = 0;
        for (int i = 0, j = 0; j < A.length(); j++) {
            char c = A.charAt(j);
            while (ss[c]) {
                ss[A.charAt(i++)] = false;
            }
            ss[c] = true;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

}
