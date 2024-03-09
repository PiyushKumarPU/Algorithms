## Advanced DSA Day 31 Trees 2 View and Types

## Scope / Agenda
- [Level Order Traversal](#level-order-traversal)
- [Right view](#right-view)
- [Vertical Level Traversal](#vertical-level-traversal)
- [Top view](#top-view)
- [Types of Binary Tree](#types-of-binary-tree)
- [Height of Binary tree](#height-of-binary-tree)
- [Height and Balanced Binary Tree](#balanced-binary-tree)


## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree2/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree2/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree2/lecture/)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/31.%20Adv%20Tree%202%20View%20and%20Types.pdf)
2. [Class/Lecture Video](https://youtu.be/QvghI4MnDUM)

## Level Order Traversal
> Level order means we will traverse tree node from left to right i.e. all nodes at root is at level 0, all nodes at height 1 is at level 1 and so on
    Problem Description
        Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    Problem Constraints
        1 <= number of nodes <= 10^5

    Input Format
        First and only argument is root node of the binary tree, A.

    Output Format
        Return a 2D integer array denoting the level order traversal of the given binary tree.

    Example Input
        Input 1:
            3
        / \
        9  20
            /  \
        15   7
        Input 2:
        1
        / \
        6   2
            /
        3

    Example Output
        Output 1:
            [
            [3],
            [9, 20],
            [15, 7]
            ]
        Output 2:
            [
            [1]
            [6, 2]
            [3]
            ]

    Example Explanation
        Explanation 1:
            Return the 2D array. Each row denotes the traversal of each level.
### Solution Approach
    Start traversing from root node and add left and right child of the root 
    to queue if present and in iteration we will get the size of queue and 
    operate on only those many node.
    Example 
        Level 1: only root node
        Level 2: Left and right node of root node
        Level 3 : All child of prev level nodes
    TC : O(n)
    SC : O(n)
### Solution
```java
public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    row.add(current.val);
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
            result.add(row);
        }
        return result;
    }
```
## Right view
    Problem Description
        Given a binary tree of integers denoted by root A. Return an array of 
        integers representing the right view of the Binary tree. Right view of 
        a Binary Tree is a set of nodes visible when the tree is 
        visited from Right side.

    Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

    Input Format
        First and only argument is head of the binary tree A.

    Output Format
        Return an array, representing the right view of the binary tree.

    Example Input
        Input 1:

                    1
                /   \
                2    3
                / \  / \
            4   5 6  7
            /
            8
        Input 2:

                1
            /  \
            2    3
            \
                4
                \
                5

    Example Output
        Output 1:
            [1, 3, 7, 8]
        Output 2:
            [1, 3, 4, 5]

    Example Explanation
        Explanation 1:
            Right view is described.
        Explanation 2:
            Right view is described.
### Solution approach
    As problem states that we need to print only those node which can be seen from right side of the tree.
    We will use level order traversal technique and then print only last node of each level
    TC : O(n)
    SC : O(n)
### Solution
```java
public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    if (i == size - 1) {
                        result.add(current.val);
                    }
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
        }
        return result;
    }
```
## Vertical Level Traversal
![vertical Order](../../../images/vertical_order_images.jpeg)
    
    Problem Description
        Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details. 
        NOTE: 
            If 2 Tree Nodes shares the same vertical level then the one with 
            lesser depth will come first.

    Problem Constraints
        0 <= number of nodes <= 10^5

    Input Format
        First and only argument is a pointer to the root node of binary tree, A.

    Output Format
        Return a 2D array denoting the vertical order traversal of tree as shown.

    Example Input
        Input 1:
                6
                /   \
            3     7
            / \     \
            2   5     9
        Input 2:
                1
                /   \
            3     7
            /       \
            2         9


    Example Output
        Output 1:
            [
                [2],
                [3],
                [6, 5],
                [7],
                [9]
            ]
        Output 2:

            [
                [2],
                [3],
                [1],
                [7],
                [9]
            ]


    Example Explanation
        Explanation 1:
            First row represent the vertical line 1 and so on.
### Solution approach
    If we look at problem statement, we need to traverse the tree in top down 
    approach. We will consider root at 0 level and left child node at root 
    level -1 and right child node at root level + 1.
    Will maintain a hashmap to store all the level and its list of nodes 
    and at last we will traverse it and convert it into result.
### Solution
```java
public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) return result;
        Map<Integer, List<Integer>> levelNodesMap = new TreeMap<>();

        Queue<LevelNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(new LevelNode(0, A));
        while (!levelNodes.isEmpty()) {
            LevelNode current = levelNodes.poll();
            List<Integer> currentNodes = levelNodesMap.getOrDefault(current.level, new ArrayList<>());
            currentNodes.add(current.node.val);
            levelNodesMap.put(current.level, currentNodes);
            if (current.node.left != null)
                levelNodes.add(new LevelNode(current.level - 1, current.node.left));
            if (current.node.right != null)
                levelNodes.add(new LevelNode(current.level + 1, current.node.right));
        }

        for (int key : levelNodesMap.keySet()) {
            result.add(new ArrayList<>(levelNodesMap.get(key)));
        }

        return result;
    }
class LevelNode {
    int level;
    TreeNode node;

    public LevelNode(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}
```
## Top view
    Problem Description
        Given a binary tree of integers denoted by root A. Return an array of 
        integers representing the top view of the Binary tree. The top view 
        of a Binary Tree is a set of nodes visible when the tree is visited 
        from the top.
        Return the nodes in any order.

    Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

    Input Format
        First and only argument is head of the binary tree A.

    Output Format
        Return an array, representing the top view of the binary tree.

    Example Input
        Input 1:
                    1
                /   \
                2    3
                / \  / \
            4   5 6  7
            /
            8
        Input 2:
                    1
                /  \
                2    3
                \
                    4
                    \
                    5

    Example Output
        Output 1:
            [1, 2, 4, 8, 3, 7]
        Output 2:
            [1, 2, 3]

    Example Explanation
        Explanation 1:
            Top view is described.
        Explanation 2:
            Top view is described.
### Solution Approach
    If we look at problem statement carefully top view would be first node of each 
    level of vertical traversal. Will use same technique to do top view traversal.
### Solution
```java
public int[] solve(TreeNode A) {
        if (A == null) return new int[]{};
        Map<Integer, List<Integer>> levelNodesMap = new TreeMap<>();

        Queue<LevelNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(new LevelNode(0, A));
        while (!levelNodes.isEmpty()) {
            LevelNode current = levelNodes.poll();
            List<Integer> currentNodes = levelNodesMap.getOrDefault(current.level, new ArrayList<>());
            currentNodes.add(current.node.val);
            levelNodesMap.put(current.level, currentNodes);
            if (current.node.left != null)
                levelNodes.add(new LevelNode(current.level - 1, current.node.left));
            if (current.node.right != null)
                levelNodes.add(new LevelNode(current.level + 1, current.node.right));
        }
        int[] result = new int[levelNodesMap.size()];
        int index = 0;
        for (List<Integer> row : levelNodesMap.values()) {
            result[index++] = row.get(0);
        }
        return result;
    }
class LevelNode {
    int level;
    TreeNode node;

    public LevelNode(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}
```
## Bottom View 
### Solution Approach
    If we look at problem statement carefully bottom view would be last node of 
    each level of vertical traversal. Will use same technique to do 
    bottom view traversal.  
### Solution
```java
public int[] solve(TreeNode A) {
        if (A == null) return new int[]{};
        Map<Integer, List<Integer>> levelNodesMap = new TreeMap<>();

        Queue<LevelNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(new LevelNode(0, A));
        while (!levelNodes.isEmpty()) {
            LevelNode current = levelNodes.poll();
            List<Integer> currentNodes = levelNodesMap.getOrDefault(current.level, new ArrayList<>());
            currentNodes.add(current.node.val);
            levelNodesMap.put(current.level, currentNodes);
            if (current.node.left != null)
                levelNodes.add(new LevelNode(current.level - 1, current.node.left));
            if (current.node.right != null)
                levelNodes.add(new LevelNode(current.level + 1, current.node.right));
        }
        int[] result = new int[levelNodesMap.size()];
        int index = 0;
        for (List<Integer> row : levelNodesMap.values()) {
            result[index++] = row.get(row.size() - 1);
        }
        return result;
    }
class LevelNode {
    int level;
    TreeNode node;

    public LevelNode(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}
```
## Types of Binary Tree
> Please refer [here](https://www.geeksforgeeks.org/types-of-binary-tree/) to know more about types of binary tree

### Height of Binary tree
> Height of any tree is the longest path from root to leaf
> Height if any node would be max of height of left node and right node.
```java
public int findHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(findHeight(node.left), findHeight(node.right));
    }
```
## Balanced Binary Tree
    Problem Description
        Given a root of binary tree A, determine if it is height-balanced.
        A height-balanced binary tree is defined as a binary tree in which the depth of the two
        subtrees of every node never differ by more than 1.

    Problem Constraints
        1 <= size of tree <= 100000

    Input Format
        First and only argument is the root of the tree A.

    Output Format
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

    Example Input
        Input 1:

            1
        / \
        2   3
        Input 2:

            1
            /
            2
            /
        3

    Example Output
        Output 1:
            1
        Output 2:
            0

    Example Explanation
        Explanation 1:
            It is a complete binary tree.
        Explanation 2:
            Because for the root node, left subtree has depth 2 and right subtree has depth 0.
            Difference = 2 > 1.
### Solution approach
    In order to check if root is balanced, we will check if both of its children 
    is balanced tree or not. 
    If it is a leaf node then it is balanced node with height 1.
    TC : O(n)
    SC : O(h)
### Solution
```java
public int isBalanced(TreeNode A) {
    return isBalancedTree(A).isBalanced ? 1 : 0;
}

private BalancePair isBalancedTree(TreeNode A) {
    if (A == null) return new BalancePair(true, 0);

    BalancePair leftNode = isBalancedTree(A.left);
    BalancePair rightNode = isBalancedTree(A.right);
    int heightDiff = Math.abs(leftNode.height - rightNode.height);
    return new BalancePair((leftNode.isBalanced && rightNode.isBalanced && heightDiff <= 1),
            (Math.max(leftNode.height, rightNode.height) + 1));
}
class BalancePair {
    boolean isBalanced;
    int height;

    public BalancePair(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}
```

