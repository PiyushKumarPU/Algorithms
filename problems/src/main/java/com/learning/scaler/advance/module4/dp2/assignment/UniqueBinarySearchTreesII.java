package com.learning.scaler.advance.module4.dp2.assignment;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Problem Description
    Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?

Problem Constraints
    1 <= A <=18

Input Format
    First and only argument is the integer A

Output Format
    Return a single integer, the answer to the problem

Example Input
    Input 1:
        1
    Input 2:
        2

Example Output
    Output 1:
        1
    Output 2:
        2

Example Explanation
    Explanation 1:
         Only single node tree is possible.
    Explanation 2:
         2 trees are possible, one rooted at 1 and the other rooted at 2.
* */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        //System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTreesBf(3));
    }

    static int[] bstCount;

    public static int numTrees(int A) {
        if (bstCount == null) {
            bstCount = new int[A + 1];
            Arrays.fill(bstCount, -1);
            bstCount[0] = bstCount[1] = 1;
        }
        if (bstCount[A] != -1) return bstCount[A];
        int total = 0;
        for (int i = 1; i <= A; i++) {
            total += numTrees(i - 1) * numTrees(A - i);
        }
        bstCount[A] = total;
        return bstCount[A];
    }

    public static int numTreesBf(int A) {
        if (A == 0 || A == 1) return 1;
        if (A < 0) return 0;
        int total = 0;
        for (int i = 1; i <= A; i++) {
            total += numTreesBf(i - 1) * numTreesBf(A - i);
        }
        bstCount[A] = total;
        return bstCount[A];
    }
}
