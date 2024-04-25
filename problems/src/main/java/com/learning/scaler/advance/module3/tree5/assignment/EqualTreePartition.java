package com.learning.scaler.advance.module3.tree5.assignment;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
    Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal
    sum of values after removing exactly one edge on the original tree.

Problem Constraints
    1 <= size of tree <= 100000
    0 <= value of node <= 10^9

Input Format
    First and only argument is head of tree A.

Output Format
    Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

Example Input
    Input 1:

                    5
                   /  \
                  3    7
                 / \  / \
                4  6  5  6
    Input 2:


                    1
                   / \
                  2   10
                      / \
                     20  2

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
Explanation 1:
 Remove edge between 5(root node) and 7:
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:
 The given Tree cannot be partitioned.
* */
public class EqualTreePartition {

    private boolean isAvailable;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root9 = new TreeNode(9);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        TreeNode root3 = new TreeNode(3);
        TreeNode root_1 = new TreeNode(-1);

        root.setLeft(root9);
        root.setRight(root4);
        root4.setLeft(root8);
        root8.setRight(root3);

        // NULL node
        root9.setLeft(root_1);
        root9.setRight(root_1);
        root4.setRight(root_1);
        root8.setLeft(root_1);
        root3.setLeft(root_1);
        root3.setRight(root_1);

        System.out.println(PrintTreeNode.traversePreOrder(root));


        System.out.println(new EqualTreePartition().solveScaler(root));

    }

    public int solve(TreeNode A) {
        BigInteger sum = findTreeSum(A);
        if (sum.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
            return 0;
        } else {
            // find tree with half sum;
            isTreeAvailable(A, (sum.divide(BigInteger.TWO)));
            return isAvailable ? 1 : 0;
        }
    }

    private void isTreeAvailable(TreeNode A, BigInteger sum) {
        if (A == null || A.val < 0 || isAvailable) {
            return;
        }

        BigInteger leftSum = findTreeSum(A.left);
        BigInteger rightSum = findTreeSum(A.right);
        BigInteger rootLeftSum = leftSum.add(BigInteger.valueOf(A.val));
        BigInteger rootRightSum = rightSum.add(BigInteger.valueOf(A.val));

        if (leftSum.equals(sum) || rightSum.equals(sum) || rootLeftSum.equals(sum) || rootRightSum.equals(sum)) {
            isAvailable = true;
            return;
        }

        // Recur on left and right subtrees
        if (A.left != null) isTreeAvailable(A.left, sum);
        if (A.right != null) isTreeAvailable(A.right, sum);
    }

    private BigInteger findTreeSum(TreeNode node) {
        if (node == null || node.val < 0) {
            return BigInteger.ZERO;
        }
        return BigInteger.valueOf(node.val).add(findTreeSum(node.left)).add(findTreeSum(node.right));
    }

    // scaler solution
    public int solveScaler(TreeNode a) {
        Map<Long, Integer> map = new HashMap<>();
        long tot = populate(a, map);
        // since total sum can also be zero
        if (tot == 0)
            return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
        return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
    }

    public long populate(TreeNode a, Map<Long, Integer> map) {
        if (a == null || a.val < 0)
            return 0;
        long sum = a.val + populate(a.left, map) + populate(a.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
