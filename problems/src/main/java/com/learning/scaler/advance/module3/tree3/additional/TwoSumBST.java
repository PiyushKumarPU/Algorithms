package com.learning.scaler.advance.module3.tree3.additional;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
Problem Description
    Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find
    whether there exist two different nodes X and Y such that X.value + Y.value = B.

    Return 1 to denote that two such nodes exist. Return 0, otherwise.

Problem Constraints
    1 <= size of tree <= 100000
    1 <= B <= 10^9


Input Format
    First argument is the head of the tree A.
    Second argument is the integer B.

Output Format
    Return 1 if such a pair can be found, 0 otherwise.

Example Input
    Input 1:

             10
             / \
            9   20

        B = 19
    Input 2:


              10
             / \
            9   20

        B = 40

Example Output
    Output 1:
        1
    Output 2:
        0


Example Explanation
    Explanation 1:
        10 + 9 = 19. Hence 1 is returned.
    Explanation 2:
        No such pair exists.
* */
public class TwoSumBST {

    public static void main(String[] args) {
        System.out.println(new TwoSumBST().t2Sum(LevelOrderTreeConstruction.constructTree(List.of(10, 9, 20, -1, -1, -1, -1)),
                40));
    }

    public int t2Sum(TreeNode A, int B) {
        Map<Integer, Integer> values = new HashMap<>();
        populate(A, values);
        for (Integer key : values.keySet()) {
            if (key > B) continue;
            Integer secondPart = B - key;
            if (secondPart.equals(key)) {
                if (values.get(key) > 1) return 1;
            } else if (values.containsKey(secondPart)) return 1;
        }
        return 0;
    }

    public void populate(TreeNode A, Map<Integer, Integer> values) {
        if (A == null || A.val < 0) return;
        Integer key = A.val;
        values.put(key, values.getOrDefault(key, 0) + 1);
        populate(A.left, values);
        populate(A.right, values);
    }

    public int t2SumScaler(TreeNode A, int B) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode current1 = A;
        TreeNode current2 = A;

        while (((!stack1.isEmpty()) || current1 != null) || (!stack2.isEmpty()) || current2 != null) {
            if (current1 != null || current2 != null) {
                if (current1 != null) {
                    stack1.push(current1);
                    current1 = current1.left;
                }
                if (current2 != null) {
                    stack2.push(current2);
                    current2 = current2.right;
                }
            } else {
                if (stack1.isEmpty() || stack2.isEmpty())
                    break;
                TreeNode node1 = stack1.peek();
                TreeNode node2 = stack2.peek();

                int sum = node1.val + node2.val;
                if (node1.val == node2.val) {
                    return 0;
                } else if (sum == B)
                    return 1;
                else if (sum < B) {
                    stack1.pop();
                    current1 = node1.right;
                } else {
                    stack2.pop();
                    current2 = node2.left;
                }
            }
        }
        return 0;
    }
}
