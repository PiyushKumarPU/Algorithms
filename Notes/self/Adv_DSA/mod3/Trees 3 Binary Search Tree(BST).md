## Advanced DSA Day 32 Trees 3 Binary Search Tree(BST)

## Scope / Agenda
- [What is BST](#what-is-bst)
- [Min Max in BST](#min-max-in-bst)
- [Search Insert Delete in BST](#search-insert-delete-in-bst)
- [Construct BST from sorted array](#construct-bst-from-sorted-array)
- [Check valid BST](#check-valid-bst)


## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree3/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree3/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree3/lecture/)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/32.%20Trees%203%20Binary%20Search%20Tree(BST).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=yb1twAp-xQ4&list=PLWV5FkQMcDU7gC6Lh87kP5ECv2HlsYF_7&index=34&ab_channel=GrowTogether)

## what is BST
Binary Search Tree is a node-based binary tree data structure which has the following properties:
* The left subtree of a node contains only nodes with keys lesser than the node’s key.
* The right subtree of a node contains only nodes with keys greater than the node’s key.
* The left and right subtree each must also be a binary search tree.

### BST Example
![BST](../../../images/bst_1.png?raw=true)

## Search in BST
    We need to find a value in BST, if present return true else false.

### Input
![Input](../../../images/BST_search_input.png?raw=true)

### Solution approach
    We will use BST property to find a value and based on the available node value 
    we will decide whether given value will be present in left subtree or 
    right subtree.
    Steps:
        * Check of current node value is same as search value, if yes return true.
        * If current node value is greater than search value then do the search in left subtree.
        * If current node value is lesser than search value then do the search in right subtree.
    TC : O(H)
    SC : O(1)

    In best case height of tree will logN (Balanced BST)
    In worst case height of tree will be N (Skew tree)

### Psuedo code
```java
    // start your search with root node
    while (node != null) {
        if (node.getVal() == B) return true;
        else if (node.getVal() > B) node = node.getLeft();
        else node = temp.getRight();
    }
```

### Solution
```java
    public boolean solve(TreeNode A, int B) {
        TreeNode temp = A;
        while (temp != null) {
            if (temp.getVal() == B) return true;
            else if (temp.getVal() > B) temp = temp.getLeft();
            else temp = temp.getRight();
        }
        return false;
    }
```

## Find min/smallest node in BST
### Input
![Input](../../../images/BST_search_input.png?raw=true)

### Solution approach
    We will use properties of BST, based on that we can observe that smallest node of any BST will be the leftmost node.

### Psuedo code
```java
    // start your search with root node
    while (node.getLeft() != null) {
         node = node.getLeft();
    }
    return node.getVal();
```

### Solution
```java
    public int solve(TreeNode A) {
        while (A.getLeft() != null){
            A = A.getLeft();
        }
        return A.getVal();
    }
```

## Find max/largest node in BST
### Input
![Input](../../../images/BST_search_input.png?raw=true)

### Solution approach
    We will use properties of BST, based on that we can observe that smallest node of any BST will be the rightmost node.

### Psuedo code
```java
    // start your search with root node
    while (node.getRight() != null) {
         node = node.getRight();
    }
    return node.getVal();
```

### Solution
```java
    public int solve(TreeNode A) {
        while (A.getRight() != null){
            A = A.getRight();
        }
        return A.getVal();
    }
```

### Time and space complexity of find min/max node in BST
    TC : O(H) in worst case height will be N
    SC : O(1)

## Insert in BST
### Input
![Input](../../../images/BST_Insert.png?raw=true)
    Item to insert: \
        22 \
        10

### Solution approach
    First we will find place to insert given node, to do that we will follow below steps
        1. Check if root is null, if yes then insert new node at root and return
        2. We will use property of BST
        3. Start comparing given node val with root node val
        4. If given node is bigger then move right else move left
        5. start repeating step 2 to 4 until we find the proper place
        6. while searching we will keep maintaining parent node address too so that we can easily add a new node

### Solution
```java
    public TreeNode insert(TreeNode A, int newVal) {
        TreeNode newNode = new TreeNode(newVal);
        if (A == null) return newNode;
        TreeNode parent = null, temp = A;
        while (temp != null && temp.getVal() != newVal) {
            parent = temp;
            temp = newVal > temp.getVal() ? temp.getRight() : temp.getLeft();
        }
        if (parent != null) {
            if (parent.getVal() > newVal) parent.setLeft(newNode);
            else parent.setRight(newNode);
        }
        return A;
    }
```
## Delete in BST
### Input
![Input](../../../images/BST_Insert.png?raw=true)
    Item to insert: \
        22 \
        10

### Solution approach:
* Case 1, if node to be deleted is leaf node
    >We will diretly delete the leaf node and complete the operation
* Case 2, node to be deleted has only one child
    > We will replace the node to be deleted with its child, whether it is left child or right child that does not matter
* Case 3, node to be deleted has both the child
    > We will replace node to be deleted with either max of the left subtree or the min of the right subtree.
* Case 3.1, If max of left subtree or min of right subtree is leaf node then nothing to worry about.
* Case 3.1, If either of left or right subtree has child node, max of left subtree may have left child and min of right subtree will right child. In this case we will replace max/min of left/right subtree with the root node.
## Construct BST from sorted array
    Idea 1 : Construct Right Skewed tree
        Take element one by one and insert into BST
        H = N i.e. height of the tree will be same as no of node
        TC : O(N^2) --> TC of 1 insertion would be O(H)
        Similarly, TC of N insertion O(H *N) --> given H ==N
    Idea 2 : Construct Right Skewed tree but maitain right most node
        Take element one by one and keep adding at the right most node and maintain address of right most node
        TC : O(N)
        SC : O(1)
    Idea 3 : Balance tree
        Use the property of sorted array and start with middle element
        Basically we are going to find mid element of the array and construct left and right subtree from the given array.
        All the element before mid index will be used to construct left subtree and all the element after mid index will be used to construct right subtree.
### Solution
```java
public TreeNode sortedArrayToBST(final List<Integer> A) {
    return constructTree(A, 0, A.size() - 1);
}

private TreeNode constructTree(final List<Integer> A, int start, int end) {
    if (start > end) return null;
    else if (start == end) return new TreeNode(A.get(start));
    int mid = (end + start) / 2;
    TreeNode root = new TreeNode(A.get(mid));
    if (mid - 1 >= start)
        root.left = constructTree(A, start, mid - 1);
    if (mid + 1 <= end)
        root.right = constructTree(A, mid + 1, end);
    return root;
}
```
## Check valid BST
    Problem Description
        You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
    Assume a BST is defined as follows:
        1) The left subtree of a node contains only nodes with keys less than the node's key.
        2) The right subtree of a node contains only nodes with keys greater than the node's key.
        3) Both the left and right subtrees must also be binary search trees.

    Problem Constraints
        1 <= Number of nodes in binary tree <= 10^5
        0 <= node values <= 2^32-1

    Input Format
        First and only argument is head of the binary tree A.

    Output Format
        Return 0 if false and 1 if true.

    Example Input
        Input 1:

            1
            /  \
            2    3
        Input 2:

            2
            / \
            1   3

    Example Output
        Output 1:
            0
        Output 2:
            1

    Example Explanation
        Explanation 1:
            2 is not less than 1 but is in left subtree of 1.
        Explanation 2:
            Satisfies all conditions.
### Solution approach
    We need to check two condition here
            1. Each node should be valid binary tree
            2. All nodes of a parent node should be valid binary tree
    Idea 1:
        In order to check root node is valid binary tree, its value should be bigger or equal then max element of left subtree and it should be less than min value of right subtree.
    Idea 2: Enhancement to prev solution
        In place of checking min and max for each node we can specify range like 
            All the element in left subtree should have less or equal value than root node value 
            All the element in ritgh subtree should have greater value than root node value.
### Solution
```java
    public int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBST(TreeNode A, int start, int end) {
        if (A == null) return true;
        if (start <= A.val && A.val <= end) {
            return isValidBST(A.left, start, A.val - 1) && isValidBST(A.right, A.val + 1, end);
        }
        return false;
    }
```
