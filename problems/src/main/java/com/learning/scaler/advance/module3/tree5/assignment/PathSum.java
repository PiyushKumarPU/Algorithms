package com.learning.scaler.advance.module3.tree5.assignment;

import com.learning.scaler.advance.module3.BTreePrinter;
import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.List;

/*
Problem Description
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the
    values along the path equals the given sum.

Problem Constraints
    1 <= number of nodes <= 10^5
    -100000 <= B, value of nodes <= 100000

Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B denoting the sum.

Output Format
    Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum.
    Else, return 0.

Example Input
    Input 1:
     Tree:    5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
     B = 22
    Input 2:
     Tree:    5
             / \
            4   8
           /   / \
         -11 -13  4
    B = -1


Example Output
    Output 1:
         1
    Output 2:
         0


Example Explanation
    Explanation 1:
         There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
    Explanation 2:
         There is no path which has sum -1.
* */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root1 = LevelOrderTreeConstruction.constructTree(List.of(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1));
        TreeNode root2 = LevelOrderTreeConstruction.constructTree(List.of(1000, 2, 1, 1, -1 - 1 - 1, 1000));

        PathSum pathSum = new PathSum();
        //BTreePrinter.printNode(root1);
        //System.out.println(pathSum.hasPathSum(root1, 22));

        BTreePrinter.printNode(root2);
        System.out.println(pathSum.hasPathSum(root2, -1));
    }

    int hasPathSum = 0;

    public int hasPathSum(TreeNode A, int B) {
        isPathPresent(A, B);
        return hasPathSum;
    }

    private void isPathPresent(TreeNode A, int sum) {
        if (A == null || hasPathSum == 1) return;
        int remainingSum = sum - A.val;
        boolean isChildNode = A.left == null && A.right == null;
        if (remainingSum == 0 && isChildNode) hasPathSum = 1;
        if (A.left != null) isPathPresent(A.left, remainingSum);
        if (A.right != null) isPathPresent(A.right, remainingSum);
    }
}
