## Advance DSA Day 34 Trees 4 LCA + Morris Inorder Traversal

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [Kth Smallest Element](#kth-smallest-element)
- [Morris Inorder Traversal](#morris-inorder-traversal)
- [LCA in Binary Tree](#lca-in-binary-tree)
- [LCA in BST](#lca-in-bst)
- [In time and out time](#in-time-and-out-time)
 

## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree4/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree4/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree4/lecture/)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/34.%20LCA%20and%20Moris%20InOrder%20Traversal.pdf)
2. [Class/Lecture Video](https://youtu.be/B-6XbM0cnYo)

## Kth Smallest Element
    Problem Description
        Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

    Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

    Input Format
        First and only argument is head of the binary tree A.

    Output Format
        Return an integer, representing the Bth element.

    Example Input
        Input 1:

                    2
                /   \
                1    3
        B = 2
        Input 2:
                    3
                /
                2
                /
                1
        B = 1

    Example
        Output 1:
            2
        Output 2:
            1

    Example
        Explanation 1:
            2nd element is 2.
        Explanation 2:
            1st element is 1.
### Solution Approach:
    Approach 1:
        Do inorder traversal and find K -1 element from the result.
        TC : O(n)
        SC : O(h + n)
    Approach 2:
        We need to find the kth smallest element so we will use property of BST, all the smaller element would be in left subtree of any node so we will do inorder traversal on left subtree first and if we are not able to find the kth smallest element then will traverse in right subtree.
        TC : O(n) --> Worst case if we need to traverse through all node of a tree
        SC : O(1)
### Solution
```java
    // Approach 1
    public int kthsmallest(TreeNode A, int B) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(A, inOrder);
        if (B > inOrder.size()) return -1;
        return inOrder.get(B - 1);
    }

    private void inOrder(TreeNode A, List<Integer> inOrder) {
        if (A == null) return;
        inOrder(A.left, inOrder);
        inOrder.add(A.val);
        inOrder(A.right, inOrder);
    }
    // Approach 2
    int ans = 0, count = 0;
    public int kthsmallestWithConstantSpace(TreeNode A, int B) {
        ans = 0;
        count = 0;
        inOrderWithCount(A, B);
        return ans;
    }
    private void inOrderWithCount(TreeNode A, int B) {
        if (A == null || count == B) return;
        inOrderWithCount(A.left, B);
        count++;
        if (count == B) ans = A.val;
        if (count < B)
            inOrderWithCount(A.right, B);
    }
```
## Morris Inorder Traversal
    Problem Description
        Given a binary tree, return the inorder traversal of its nodes' values.
        NOTE: Using recursion and stack are not allowed.

    Problem Constraints
        1 <= number of nodes <= 10^5

    Input Format
        First and only argument is root node of the binary tree, A.

    Output Format
        Return an integer array denoting the inorder traversal of the given binary tree.

    Example
        Input 1:
        1
            \
            2
            /
        3
        Input 2:
        1
        / \
        6   2
            /
        3

    Example
        Output 1:
            [1, 3, 2]
        Output 2:
            [6, 1, 3, 2]


    Example
        Explanation 1:
            The Inorder Traversal of the given tree is [1, 3, 2].
        Explanation 2:
            The Inorder Traversal of the given tree is [6, 1, 3, 2].
### Solution approach
> We will use morris in order traversal technique to perform inorder traversal 
in constant space.
#### Steps to perform while doing in order traversal
1. Initialize current as root 
2. While current is not NULL

**If the current does not have left child**
* Print current’s data
* Go to the right, i.e., current = current->right

**Else**
* Find rightmost node in current left subtree OR
            node whose right child == current.

**If we found right child == current**
* Update the right child as NULL of that node whose right child is current
* Print current’s data
* Go to the right, i.e. current = current->right

**Else**
* Make current as the right child of that rightmost 
node we found; and 
* Go to this left child, i.e., current = current->left
### Solution
```java
public ArrayList<Integer> solve(TreeNode A) {
    ArrayList<Integer> result = new ArrayList<>();
    TreeNode curr = A;

    while (curr != null) {
        if (curr.left == null) {
            result.add(curr.val);
            curr = curr.right;
        } else {
            TreeNode pre = curr.left;
            while (pre.right != null && pre.right != curr) {
                pre = pre.right;
            }

            if (pre.right == null) {
                pre.right = curr;
                curr = curr.left;
            } else {
                pre.right = null;
                result.add(curr.val);
                curr = curr.right;
            }
        }
    }
    return result;
}
```
## LCA in Binary Tree
## LCA in BST
## In time and out time
