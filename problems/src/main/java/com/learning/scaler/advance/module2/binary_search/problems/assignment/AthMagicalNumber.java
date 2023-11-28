package com.learning.scaler.advance.module2.binary_search.problems.assignment;

import java.lang.annotation.Target;

/*
Problem Description
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
* */
public class AthMagicalNumber {

    public static void main(String[] args) {
        System.out.println(solve(11,2,3));
       /* System.out.println(solve(4,2,3));
        System.out.println(solve(2,10,11));*/

    }

    public static int solve(int A, int B, int C) {
        if (A == 1) return Math.min(B, C);
        long evenIndexEle = Math.min(B, C), oddIndexEle = Math.max(B, C);
        long targetIndex = A - 1 , targetTermCount = targetIndex/2 + 1;
        return (int) (targetIndex % 2 == 0 ? (evenIndexEle + (targetTermCount -1) * evenIndexEle) :
                        (oddIndexEle + (targetTermCount -1) * oddIndexEle));
    }
}
