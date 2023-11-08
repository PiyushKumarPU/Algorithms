package com.learning.scaler.advance.module2.binary_search.problems.assignment;

/*
Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.


Problem Constraints
0 <= A <= 109


Input Format
The first and only argument given is the integer A.


Output Format
Return floor(sqrt(A))


Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
Explanatino 2:
When A = 9 which is a perfect square of 3, so we return 3.
* */
public class SquareRootOfInteger {

    public static void main(String[] args) {
        //System.out.println(sqrt(11));
        //System.out.println(sqrt(9));
        System.out.println(sqrt(Integer.MAX_VALUE));
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }


    public static int sqrt(int A) {
        int ans = 0;
        long start = 1, end = A;
        while (start <= end) {
            long mid = (start + end) / 2, square = mid * mid;
            if (square == A) return (int) mid;
            else if (square > A) end = mid - 1;
            else {
                start = mid + 1;
                ans = (int) mid;
            }
        }
        return ans;
    }
}
