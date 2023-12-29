## Advanced DSA Day 32 Trees 3 Binary Search Tree(BST)

## Scope / Agenda
- [what is BST](#what-is-bst)
- [Min Max in BST](#min-max-in-bst)
- [Search Insert Delete in BST](#search-insert-delete-in-bst)
- [Construct BST from sorted array](#construct-bst-from-sorted-array)
- [Check valid BST](#check-valid-bst)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/tree3/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/tree3/additional)
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/32.%20Trees%203%20Binary%20Search%20Tree(BST).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=yb1twAp-xQ4&list=PLWV5FkQMcDU7gC6Lh87kP5ECv2HlsYF_7&index=34&ab_channel=GrowTogether)

## what is BST
Binary Search Tree is a node-based binary tree data structure which has the following properties:
* The left subtree of a node contains only nodes with keys lesser than the node’s key.
* The right subtree of a node contains only nodes with keys greater than the node’s key.
* The left and right subtree each must also be a binary search tree.

### BST Example
![BST](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/88b55b7f2cdee22ed0b9c94902aadfcd87714c17/Notes/images/bst_1.png?raw=true)

## Search in BST
    We need to find a value in BST, if present return true else false.

### Input
![Input](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/5d56e1d4ede749b8fe21185e1179e53b75ecd071/Notes/images/BST_search_input.png?raw=true)

### Solution approach
    We will use BST property to find a value and based on the available node value we will decide whether given value will be present in left subtree or right subtree.
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
![Input](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/5d56e1d4ede749b8fe21185e1179e53b75ecd071/Notes/images/BST_search_input.png?raw=true)

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
![Input](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/5d56e1d4ede749b8fe21185e1179e53b75ecd071/Notes/images/BST_search_input.png?raw=true)

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
![Input](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/ccc7afbb0e5bfa0af57214f11a3dff7ce21d7f81/Notes/images/BST_Insert.png?raw=true)

### Solution approach

### Psuedo code

### Solution

## Delete in BST
## Construct BST from sorted array
## Check valid BST
