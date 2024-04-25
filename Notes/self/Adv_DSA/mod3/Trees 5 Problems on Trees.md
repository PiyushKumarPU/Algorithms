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

### Problem Description
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

### Psuedo Code
```java
   void invert(TreeNode node){
    if (node == null) return;
    // swap left child with right child and vice versa
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
    // invert left and right child
    if(node.left != null) invert(node.left);
    if(node.right != null) invert(node.right);
   }
```

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

### Psuedo code:
#### Map approach
```java
   calculate sum of each node and store it in Map<Integer,Boolean>
   check if required some is present in map
   if present return true or false
```
#### Recursive approach
```java
    1. find sum of all node and store in a variable
    2. check if sum is odd then return false
    3. find left sum and right sum of all node one by one and check below condition
    4. if any of left sum, right sum, left sum + root val and right sum + root val is mathcing with required sum then return true
    5. if none of the value matching with required sum return false at the end
```
### Solution
#### HashMap approach
```java
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
```
#### Recursive approach
```java
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

    private BigInteger findTreeSum(TreeNode node) {
        if (node == null || node.val < 0) {
            return BigInteger.ZERO;
        }
        return BigInteger.valueOf(node.val).add(findTreeSum(node.left)).add(findTreeSum(node.right));
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

#### Psuedo code:
```java
    define a Queue
    add left and right node to the queue
    poll current element from queue and store it in current variable
    start iterating from 1 till queue size and store in next variable
    assign next address to the next address of current
```
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

## Root to Leaf Path Sum k
#### Problem Description
    Check if given binary tree has any root to leaf path sum K
![Problem Description](../../../images/Path_sum_k.png?raw=true)

#### Solution approach:
    1. Start checking all leaf node sum from root node till that node and return true if present and false not present.

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
## Diameter of Binary Tree
