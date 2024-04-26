## Advance DSA Day 35 Trees 5 Problems on Trees

## Scope / Agenda
- [Invert Binary Tree](#invert-binary-tree)
- [Equal Tree Partition](#equal-tree-partition)
- [Populate Next Pointer in Binary Tree](#populate-next-pointer-in-binary-tree)
- [Populate Next Pointer in Perfect Binary Tree](#populate-next-pointer-in-perfect-binary-tree)
- [Root to Leaf Path Sum k](#root-to-leaf-path-sum-k)
- [Longest path across root node of Binary Tree](#longest-path-across-root-node-of-binary-tree)
- [Diameter of Binary Tree](#diameter-of-binary-tree)

## Problems and solutions
1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree5/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree5/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree5/lecture/)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes//35.%20Problems%20on%20Trees.pdf)
2. [Class/Lecture Video](https://youtu.be/YnmGLLiFT_Q)
3. [Notability Link](https://notability.com/n/2dGLLHz5G3GeJOUxYUQKVp)
4. [New Batch Video](https://youtu.be/DmI4mJXMAT0)
5. [New Lecture Notes](../../../new_batch_notes/DSA%20Trees%205%20Problems%20on%20Trees.pdf)


## Invert Binary Tree
    Problem Description
        Given a binary tree A, invert the binary tree and return it.
        Inverting refers to making the left child the right child and vice versa.

    Problem Constraints
        1 <= size of tree <= 100000

    Input Format
        First and only argument is the head of the tree A.

    Output Format
        Return the head of the inverted tree.

    Example Input
        Input 1:

                1
              /   \
             2     3
        Input 2:

                1
              /   \
             2     3
            / \   / \
            4   5 6   7

    Example Output
        Output 1:
                1
              /   \
             3     2
        Output 2:
                1
              /   \
             3     2
            / \   / \
            7   6 5   4

    Example Explanation
        Explanation 1:
            Tree has been inverted.
        Explanation 2:
            Tree has been inverted.

![Problem image](../../../images/invert_binary_tree_problems.png?raw=true)

### Solution approach
    We will swap left child with right child and right child with left child for all the none leaf node 
    and that will be inverted binary tree.

    TC : O(n)
    SC : O(h) --> stack space
### Solution
```java
    public void invert(TreeNode node) {
        // swap left --> right child and vice versa of each node
        if (node == null) return;
        TreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        if(node.left != null) invert(node.left);
        if(node.right != null) invert(node.right);
    }
```

## Equal Tree Partition
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
            Tree 1 =                                                       Tree 2 =
                        5                                                     7
                        /                                                     / \
                        3                                                     5   6
                        / \
                        4   6
            Sum of Tree 1 = Sum of Tree 2 = 18
    Explanation 2:
    The given Tree cannot be partitioned.



![Tree Equal Partition](../../../images/Tree_Equal_partition.png?raw=true)

### Solution approach:
    1. First calculate the sum of all node of tree
    2. If total sum is odd there is no chance of getting a subtree which can divide tree in equal partition and return false
    3. Start finding iterative some of each node and check if any node value is matching with required sum

    TC : O(n)
    SC : O(h)  
    SC : O(h+n) --> in case of Map approach

### Solution
```java
// HashMap approach
public int solve(TreeNode a) {
    Map<Long, Integer> map = new HashMap<>();
    long tot = populate(a, map);
    // since total sum can also be zero
    if (tot == 0)
        return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
    return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
}

private long populate(TreeNode a, Map<Long, Integer> map) {
    if (a == null || a.val < 0)
        return 0;
    long sum = a.val + populate(a.left, map) + populate(a.right, map);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
}

// Recursive approach
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
    isTreeAvailable(A.left, sum);
    isTreeAvailable(A.right, sum);
}
```
```java
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    public TreeLinkNode(int val){
        this.val = val;
    }
}
```
![Structure](../../../images/Next_Pointer_Tree.png?raw=true)

## Populate Next Pointer in Binary Tree
#### Problem Description
    Problem Description
        Given a binary tree,
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer 
        should be set to NULL.
        Initially, all next pointers are set to NULL.

        Assume perfect binary tree.

    Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

    Input Format
        First and only argument is head of the binary tree A.

    Output Format
        Return the head of the binary tree after the changes are made.

    Example Input
        Input 1:

            1
            /  \
        2    3
        Input 2:

              1
            /  \
            2    5
            / \  / \
            3  4  6  7

    Example Output
        Output 1:

              1 -> NULL
            /  \
            2 -> 3 -> NULL
        Output 2:

             1 -> NULL
            /  \
            2 -> 5 -> NULL
            / \  / \
            3->4->6->7 -> NULL


    Example Explanation
        Explanation 1:
            Next pointers are set as given in the output.
        Explanation 2:
            Next pointers are set as given in the output.

#### Solution approach:
    1. Perform level order traversal and assign next node(if present) address to the next properties of current node

    TC : O(n)
    SC : O(n) --> queue size
#### Solution
```java
    public void connectUsingQueue(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            TreeLinkNode current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            TreeLinkNode next;
            for (int i = 1; i < queueSize; i++) {
                next = queue.poll();
                if (next != null) {
                    current.next = next;
                    if (next.left != null) queue.add(next.left);
                    if (next.right != null) queue.add(next.right);
                    current = next;
                }
            }
        }
    }
```
## Populate Next Pointer in Perfect Binary Tree
    Problem Description
        Given a binary tree,
        Populate each next pointer to point to its next right node. If there is no next right node, the next 
        pointer should be set to NULL.
        Initially, all next pointers are set to NULL.

        Assume perfect binary tree.


    Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

    Input Format
        First and only argument is head of the binary tree A.

    Output Format
        Return the head of the binary tree after the changes are made.

    Example Input
        Input 1:

            1
            /  \
        2    3
        Input 2:

                1
            /  \
            2    5
            / \  / \
            3  4  6  7

    Example Output
        Output 1:

                1 -> NULL
            /  \
            2 -> 3 -> NULL
        Output 2:

                1 -> NULL
            /  \
            2 -> 5 -> NULL
            / \  / \
            3->4->6->7 -> NULL


    Example Explanation
        Explanation 1:
            Next pointers are set as given in the output.
        Explanation 2:
            Next pointers are set as given in the output.

### Solution Approach
    Approach 1: Using queue and level order traversal
        Do level order traversal, and link current node with next node present in same level
        TC : O(n)
        SC : O(n)
    Approach 2: Using recursion space
        Use preorder traversal and use current node as linkage to create link to next node
            step 1: connect current.left with current.right
            step 2: check if current has next node
            step 3: if yes, connect connect.right.next = current.next.left
        TC : O(n)
        SC : O(h) --> recursion stack space
    Approach 3: Using no space, not even recursion space
        Note : This approach needs to be understand properly
        TC : O(n)
        SC : O(1)
### Solution
```java
// Approach 1
public void connectUsingQueue(TreeLinkNode root) {
    Queue<TreeLinkNode> queue = new ArrayDeque<>();
    if (root.left != null) queue.add(root.left);
    if (root.right != null) queue.add(root.right);
    while (!queue.isEmpty()) {
        int queueSize = queue.size();
        TreeLinkNode current = queue.poll();
        if (current.left != null) {
            queue.add(current.left);
        }
        if (current.right != null) {
            queue.add(current.right);
        }
        TreeLinkNode next;
        for (int i = 1; i < queueSize; i++) {
            next = queue.poll();
            if (next != null) {
                current.next = next;
                if (next.left != null) queue.add(next.left);
                if (next.right != null) queue.add(next.right);
                current = next;
            }
        }
    }
}
// Approach 2
public void connectUsingRecursion(TreeLinkNode treeNode) {
    if (treeNode == null) return;
    if (treeNode.left == null && treeNode.right == null) return;
    else if (treeNode.left != null) {
        treeNode.left.next = treeNode.right;
        if (treeNode.next != null)
            treeNode.right.next = treeNode.next.left;
    }
    connectUsingRecursion(treeNode.left);
    connectUsingRecursion(treeNode.right);
}
// Approach 3
public void connectWithConstantSpace(TreeLinkNode treeNode) {
    TreeLinkNode temp = treeNode;
    while (temp.left != null) {
        TreeLinkNode current = temp;
        while (temp != null) {
            temp.left.next = temp.right;
            if (temp.next != null)
                temp.right.next = temp.next.left;
            temp = temp.next;
        }
        temp = current.left;
    }
}
```
## Root to Leaf Path Sum k
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

#### Solution approach:
    We will check sum till all the leaf node from root, at initial we will initialize sum as target and on each iteration
    will keep reducing target sum with node value.
    Will check if there is any leaf node where taget sum is zero
    if yes return true or return false at last.

#### Solution
```java
int hasPathSum = 0;
public int hasPathSum(TreeNode A, int B) {
    isPathPresent(A, B);
    return hasPathSum;
}

private void isPathPresent(TreeNode A, int sum) {
    if (A == null || A.val == -1 || hasPathSum == 1) return;
    int remainingSum = sum - A.val;
    boolean isChildNode = (A.left == null || A.left.val == -1) && (A.right == null || A.right.val == -1);
    if (remainingSum == 0 && isChildNode) hasPathSum = 1;
    if (A.left != null && A.left.val != -1) isPathPresent(A.left, remainingSum);
    if (A.right != null && A.right.val != -1) isPathPresent(A.right, remainingSum);
}
```

## Longest path across root node of Binary Tree
    Find the longest path of the tree that goes across root node and duplicate edge is not allowed
### Solutuon apporoach
* Height of any node is ```max(height of left node, height of right node) + 1```
* Similary longest path would be the sum of height of left node and right node + 2\ (+2 because there are two edge to reach till the root node)  ```height of left node + height of right node + 2```

> Find the longest path using this approach

### Solution
```java
public int longestPathAcrossRoot(TreeNode treeNode) {
    if (treeNode == null) return 0;
    return findHeight(treeNode.left) + findHeight(treeNode.right) + 2;
}

private int findHeight(TreeNode treeNode) {
    if (treeNode == null) return -1;
    return Math.max(findHeight(treeNode.left), findHeight(treeNode.right)) + 1;
}
```
## Diameter of Binary Tree
    Problem Description
        Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
        The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

    Problem Constraints
        0 <= N <= 10^5

    Input Format
        First and only Argument represents the root of binary tree A.

    Output Format
        Return an single integer denoting the diameter of the tree.

    Example Input
        Input 1:
                1
                /   \
                2     3
            / \
            4   5
        Input 2:
                    1
                /   \
                2     3
                / \     \
            4   5     6

    Example Output
        Output 1:
            3
        Output 2:
            4

    Example Explanation
        Explanation 1:
            Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
        Explanation 2:
            Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.

### Solution approach
    We will use existing approach with small addition, will maintain a global variable called diameter and will update it
    while calculating height of all the node and that global variable would be the answer.
        Step 1: Start finding height of root node
        step 2: while calculating height of any node, keep updating diameter variable with the max value.
        step 3: return max value
    TC : O(n)
    SC : O(h) --> stack space
### Solution
```java
int diameter = Integer.MIN_VALUE;
public int solve(TreeNode A) {
    if (A == null) return 0;
    findHeight(A);
    return diameter;
}

private int findHeight(TreeNode treeNode) {
    if (treeNode == null) return -1;
    int leftHeight = (treeNode.left != null) ? findHeight(treeNode.left) : -1;
    int rightHeight = (treeNode.right != null) ? findHeight(treeNode.right) : -1;
    int currentNodeHeight = Math.max(leftHeight, rightHeight) + 1;
    diameter = Math.max((leftHeight + rightHeight + 2), diameter);
    return currentNodeHeight;
}
```

