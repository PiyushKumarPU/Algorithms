package com.learning.scaler.advance.module3.tree5.assignment;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

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


        System.out.println(new EqualTreePartition().solve(root));

    }

    public int solve(TreeNode A) {
        int sum = findTreeSum(A);
        if (sum % 2 != 0) return 0;
        else {
            // find tree with half sum;
            int requiredSum = sum / 2;
            isTreeAvailable(A, (sum / 2));
            if (isAvailable) return 1;
        }
        return 0;
    }

    private void isTreeAvailable(TreeNode A, int sum) {
        if (A == null || A.getVal() < 0 || isAvailable) return;
        int leftSum = findTreeSum(A.getLeft());
        int rightSum = findTreeSum(A.getRight());
        int rootLeftSum = leftSum + A.getVal();
        int rootRightSum = rightSum + A.getVal();
        if( leftSum == sum || rightSum == sum || rootLeftSum == sum || rootRightSum == sum) isAvailable = true;
    }

    private int findTreeSum(TreeNode node) {
        if (node == null || node.getVal() == -1) return 0;
        return node.getVal() + findTreeSum(node.getLeft()) + findTreeSum(node.getRight());
    }
}
