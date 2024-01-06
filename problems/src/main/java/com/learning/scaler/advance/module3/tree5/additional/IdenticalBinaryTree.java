package com.learning.scaler.advance.module3.tree5.additional;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.List;

/*
Problem Description
    Given two binary trees, check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    The first argument is a root node of the first tree, A.
    The second argument is a root node of the second tree, B.

Output Format
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
    Input 1:
           1       1
          / \     / \
         2   3   2   3
    Input 2:
           1       1
          / \     / \
         2   3   3   3

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
        Both trees are structurally identical and the nodes have the same value.
    Explanation 2:
        Values of the left child of the root node of the trees are different.
* */
public class IdenticalBinaryTree {

    private int isIdentical = 0;

    public static void main(String[] args) {

        TreeNode root1 = LevelOrderTreeConstruction.constructTree(List.of(5, 10, -1, -1, -1));
        TreeNode root2 = LevelOrderTreeConstruction.constructTree(List.of(5, -1, -1));

        System.out.println(PrintTreeNode.traversePreOrder(root1));
        System.out.println(PrintTreeNode.traversePreOrder(root2));


        /*IdenticalBinaryTree identicalBinaryTree = new IdenticalBinaryTree();
        System.out.println(identicalBinaryTree.isSameTree(root1, root2));*/
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        isIdTree(A, B);
        return isIdentical;
    }


    private void isIdTree(TreeNode treeNode1, TreeNode treeNode2) {
        if ((treeNode1 != null && treeNode1.val == -1
                && treeNode2 != null && treeNode2.val == -1))
            return;

        boolean isSameVal = treeNode1 != null && treeNode2 != null && treeNode1.val == treeNode2.val;
        isIdentical = isSameVal ? 1 : 0;
        isIdTree(treeNode1.left,treeNode2.left);
        isIdTree(treeNode1.right,treeNode2.right);

    }


}
