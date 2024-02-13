package com.learning.scaler.intermediate.carry_forwar_contri.assignment;

/*
Problem Description
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.



Problem Constraints
1 <= length(A) <= 105



Input Format
First and only argument is a string A.



Output Format
Return an integer denoting the answer.



Example Input
Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 Subsequence "AG" is 3 times in given string
Explanation 2:

 There is no subsequence "AG" in the given string.
* */
public class SpecialSubsequencesAG {

    public int solve(String A) {
        int count = 0, aCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'A') aCount++;
            else if (A.charAt(i) == 'G' && aCount > 0) {
                count += aCount;
                count = count % 1000000007;
            }
        }
        return count % 1000000007;
    }

    public int solveScaler(String A) {
        int n = A.length(), ans = 0, MOD = 1000 * 1000 * 1000 + 7, count = 0;
        int[] cnt_G = new int[n];

        //Suffix count of G
        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }

        // traverse the string again from beginning
        for (int i = 0; i < n; i++) {
            // if current character is "A" then add number of G's after that
            if (A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }
}
