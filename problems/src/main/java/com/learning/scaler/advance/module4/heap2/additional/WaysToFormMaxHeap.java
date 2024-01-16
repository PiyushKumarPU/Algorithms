package com.learning.scaler.advance.module4.heap2.additional;

/*
Problem Description
    Max Heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.
    Find the number of distinct Max Heap that can be made from A distinct integers.
    In short, you have to ensure the following properties for the max heap :

    Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
    Every node is greater than all its children.
    NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 10^9 + 7.

Problem Constraints
    1 <= A <= 100

Input Format
    The first and only argument is an integer A.

Output Format
    Return an integer denoting the number of distinct Max Heap.

Example Input
Input 1:
    A = 4
Input 2:
    A = 10

Example Output
    Output 1:
        3
    Output 2:
        3360

Example Explanation
    Explanation 1:
         Let us take 1, 2, 3, 4 as our 4 distinct integers
         Following are the 3 possible max heaps from these 4 numbers :
              4           4                     4
            /  \         / \                   / \
           3    2   ,   2   3      and        3   1
          /            /                     /
         1            1                     2
    Explanation 2:
        Number of distinct heaps possible with 10 distinct integers = 3360.
* */
public class WaysToFormMaxHeap {

    int MAXN = 105;
    int[] dp = new int[MAXN];
    int[][] nck = new int[MAXN][MAXN];
    int[] log2 = new int[MAXN];

    public int choose(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (k == 0) {
            return 1;
        }
        if (nck[n][k] != -1) {
            return nck[n][k];
        }
        int answer = (choose(n - 1, k - 1) + choose(n - 1, k)) % 1000000007;
        nck[n][k] = answer % 1000000007;
        return answer % 1000000007;
    }

    public int getLeft(int n) {
        if (n == 1) {
            return 0;
        }
        int h = log2[n];
        int numh = (1 << h); //(2 ^ h)
        int last = n - ((1 << h) - 1);
        if (last >= (numh / 2)) {
            return (1 << h) - 1; // (2^h) - 1
        } else {
            return (1 << h) - 1 - ((numh / 2) - last);
        }
    }

    public int numberOfHeaps(int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = getLeft(n);
        int ans = ((choose(n - 1, left) * numberOfHeaps(left))
                * (numberOfHeaps(n - 1 - left))) % 1000000007;
        dp[n] = ans % 1000000007;
        return ans % 1000000007;
    }

    public int solve(int A) {
        int currLog2 = -1;
        int currPower2 = 1;
        for (int i = 0; i <= A; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= A; j++) {
                nck[i][j] = -1;
            }
        }

        for (int i = 1; i <= A; i++) {
            if (currPower2 == i) {
                currLog2++;
                currPower2 *= 2;
            }
            log2[i] = currLog2;
        }
        return numberOfHeaps(A);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.print(new WaysToFormMaxHeap().solve(n));
    }

}
