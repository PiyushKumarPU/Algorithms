package com.learning.scaler.advance.module2.binary_search.bs_answers.assignment;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106



Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.



Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.



Example Input
Input 1:

 A = 2
 B = 5
 C = [1, 10]
Input 2:

 A = 10
 B = 1
 C = [1, 8, 11, 3]


Example Output
Output 1:

 50
Output 2:

 11


Example Explanation
Explanation 1:

 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003
Explanation 2:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003
* * */
public class PaintersPartition {

    public static void main(String[] args) {
        int A = 2, B = 5;
        List<Integer> C = List.of(1, 10);
        //System.out.println(paint(A, B, new ArrayList<>(C)));
        A = 3;
        B = 10;
        // 18670  i.e. 1867
        C = List.of(185, 186, 938, 558, 655, 461, 441, 234, 902, 681);
        //System.out.println(paint(A, B, new ArrayList<>(C)));

        A = 4;
        B = 10;
        C = List.of(8, 8, 8, 8, 8, 8, 8);
        //System.out.println(paint(A, B, new ArrayList<>(C)));

        System.out.println(paint(1,1000000,new ArrayList<>(List.of(1000000,1000000))));
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {
        int modulo = 10000003, ans = 0, start = 0, end = 0;
        for (Integer ele : C) {
            start = Math.max(start, ele);
            end += ele;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isValidTime =  isValidTime(mid, A, C);
            if (isValidTime) {
                ans = (int)(((long) mid * B) % modulo);
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }

    public static boolean isValidTime(int time, int painters, ArrayList<Integer> boards) {
        int currentCount = 1, workDone = 0;
        for (Integer board : boards) {
            if (workDone + board <= time) {
                workDone += board;
            } else {
                currentCount++;
                workDone = board;
            }
            if (currentCount > painters) return false;
        }
        return currentCount <= painters;
    }


}
