## Advance DSA Day 30 Tree 1: Structure and Traversal

## Scope/Agenda
- [What is Tree?](#what-is-tree)
- [Tree Terminology](#tree-terminology)
- [Traversal](#traversal)
- [Inorder traversal(Recursive)](#inorder-traversalrecursive)
- [Pre Order Traversal](#pre-order-traversal)
- [Post Order Traversal](#post-order-traversal)
- [Summary](#summary)
- [Inorder traversal(Iterative)](#inorder-traversaliterative)
- [Construct Tree Question](#construct-tree-question)

  

## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree1/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree1/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module3/tree1/lecture/)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/30%20Trees%201%20Structure%20and%20Traversal.pdf)
2. [Class/Lecture Video](https://youtu.be/-ZEpncxL304)


## What is Tree?
    Tree is a non linera data structure used to represent hierarchy in information.

    e.g. Family tree

    A tree data structure is a hierarchical structure that is used to represent and organize data in a way that is easy 
    to navigate and search. It is a collection of nodes that are connected by edges and has a hierarchical 
    relationship between the nodes. 

    The topmost node of the tree is called the root, and the nodes below it are called the child nodes. 
    Each node can have multiple child nodes, and these child nodes can also have their own child nodes, 
    forming a recursive structure.



### Please refer below links for more information on Trees

* [Wiki](https://en.wikipedia.org/wiki/Tree_(data_structure))
* [GFG](https://www.geeksforgeeks.org/introduction-to-tree-data-structure-and-algorithm-tutorials/)
* [Interview bit](https://www.interviewbit.com/courses/programming/tree-data-structure/)
## Tree Terminology
![Tree representation](../../../images/Treedatastructure.png?raw=true)

---

* **Root Node:** The topmost node of a tree or the node which does not have any parent node is called the root node. {A} is the root node of the tree. A non-empty tree must contain exactly one root node and exactly one path from the root to all other nodes of the tree.

* **Parent Node:** The node which is a predecessor of a node is called the parent node of that node. {B} is the parent node of {D, E}.
* **Child Node:** The node which is the immediate successor of a node is called the child node of that node. Examples: {D, E} are the child nodes of {B}.

* **Level or Depth of a node:** The count of edges on the path from the root node to that node. The root node has level 0.

* **Height of an Node :** Length of the longest path from the node to the most farthest leaf node. i.e. calculate the maxumim distance till leaf node(only select same subtree leaf) from the respective node.

* **Height of the tree :** Height of the tree will be the height of root node.

* **Leaf Node or External Node or Terminal Node:** The nodes which do not have any child nodes are called leaf nodes. {K, L, M, N, O, P, G} are the leaf nodes of the tree.

---
* **Ancestor of a Node:** Any predecessor nodes on the path of the root to that node are called Ancestors of that node. {A,B} are the ancestor nodes of the node {E}

* **Descendant:** Any successor node on the path from the leaf node to that node. {E,I} are the descendants of the node {B}.

* **Sibling:** Children of the same parent node are called siblings. {D,E} are called siblings.

* **Internal node:** A node with at least one child is called Internal Node.

* **Neighbour of a Node:** Parent or child nodes of that node are called neighbors of that node.

* **Subtree:** Any node of the tree along with its descendant. i.e. part of larger tree with all the nodes included for root node.

---

* **Binary Tree :** A type of tree which can have atmost 2 child node i.e. it can have 0 or 1 or 2 child node.
There are referred as left child and right child.

Structure class of Binary tree
```java
    class TreeNode{
        private <Respective Data type> data;
        private TreeNode left;    // reference of left child if present.
        private TreeNode right;   // reference of right child if present.
        // add constructor here
    }
```

## Traversal
* Please refer **[here](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)** to get more details on traversal technique.

## [Inorder traversal(Recursive)](https://www.geeksforgeeks.org/inorder-traversal-of-binary-tree/)

### Steps to follow while performing In-order traversal
    In-order traversal
    Left Node Right i.e. L N R
    
* **Traverse through Left sub-tree**
* **Traverse root node of respective subtree**
* **Traverse through right sub-tree**


![In-Order Traversal Technique](../../../images/in_order_traversal.gif?raw=true)

![In-order traversal examples/steps](../../../images/in_order_traversla_steps.gif?raw=true)

### Lets take an exmple to understand In-order traversal
#### **Input**
---
![Input](../../../images/Tree1_example1.png?raw=true)

#### **Expected Output after performing In-Order traversal**
---
![Output](../../../images/Tree1_example2.png?raw=true)

#### Psuedo code for above example
---
```java
   void inorder(TreeNode root){
    // base condition
    if(root == null) return;
    // traversing through left subtree
    inorder(root.left);
    // printing root node
    print(root);
    // traversing through right subtree
    inorder(root.right);
   }
```
#### TC and SC for above code
    TC : O(N)  --> N represent no of node in tree
    SC : O(H)  --> H represent height of the tree

## Inorder traversal(Iterative)
### Lets take an exmple to understand In-order(iterative) traversal technique

#### **Input**
---
![Input](../../../images/in_order_iterative_input.png?raw=true)

#### **Expected Output after performing In-Order traversal**
---
![Output](../../../images/in_order_iterative.png.png?raw=true)

### Sample code
```java
public  void iterativeInOrderTraversal(TreeNode root) {
    if (root == null) {
        return;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
        // Reach the leftmost node
        while (current != null) {
            stack.push(current);
            current = current.getLeft();
        }

        // Visit the top of the stack (current leftmost node)
        current = stack.pop();
        result2.add(current.getVal());
        current = current.getRight();
    }
}
```

## [Pre-Order traversal](https://www.geeksforgeeks.org/preorder-traversal-of-binary-tree/)
### Steps to follow while performing Pre-order traversal
    Pre-order traversal
    Node Left Right i.e. N L R
    
* **Traverse root node of respective subtree**
* **Traverse through Left sub-tree**
* **Traverse through right sub-tree**

![pre-order1](../../../images/pre-order_1.gif?raw=true)

![Pre-order2](../../../images/pre-order_2.gif?raw=true)

### Lets take an exmple to understand pre-order traversal
#### **Input**
---
![Input](../../../images/Tree1_example1.png?raw=true)

#### **Expected Output after performing In-Order traversal**
---

![Output](../../../images/pre_order_output.png?raw=true)

#### Psuedo code for above example
---
```java
   void pre_order(TreeNode root){
    // base condition
    if(root == null) return;
    // printing root node
    print(root);
    // traversing through left subtree
    pre_order(root.left);
    // traversing through right subtree
    pre_order(root.right);
   }
```
#### TC and SC for above code
    TC : O(N)  --> N represent no of node in tree
    SC : O(H)  --> H represent height of the tree

## [Post-Order traversal](https://www.geeksforgeeks.org/postorder-traversal-of-binary-tree/)
### Steps to follow while performing Pre-order traversal
    Pre-order traversal
    Node Left Right i.e. N L R

* **Traverse through Left sub-tree**
* **Traverse through right sub-tree**
* **Traverse root node of respective subtree**

![post order 1](../../../images/post_order_1.gif?raw=true)

### Lets take an exmple to understand post-order traversal

#### **Input**
---
![Input](../../../images/Tree1_example1.png?raw=true)

![Output](../../../images/post_order_2.gif.png?raw=true)

#### Psuedo code for above example
---
```java
   void post_order(TreeNode root){
    // base condition
    if(root == null) return;
    // traversing through left subtree
    post_order(root.left);
    // traversing through right subtree
    post_order(root.right);
    // printing root node
    print(root);
   }
```
#### TC and SC for above code
    TC : O(N)  --> N represent no of node in tree
    SC : O(H)  --> H represent height of the tree

## Summary
    L N R --> In-order traversal
    N L R --> Pre order traversal
    L R N --> Post order traversal
    TC and SC is same for all the traversal

## Construct Tree Question
### Binary Tree From Inorder And Postorder
    Problem Description
        Given the inorder and postorder traversal of a tree, construct the binary tree.
        NOTE: You may assume that duplicates do not exist in the tree.

    Problem Constraints
        1 <= number of nodes <= 10^5

    Input Format
        First argument is an integer array A denoting the inorder traversal of the tree.
        Second argument is an integer array B denoting the postorder traversal of the tree.

    Output Format
        Return the root node of the binary tree.

    Example Input
        Input 1:
            A = [2, 1, 3]
            B = [2, 3, 1]
        Input 2:
            A = [6, 1, 3, 2]
            B = [6, 3, 2, 1]

    Example Output
        Output 1:

            1
            / \
            2   3
        Output 2:

            1
            / \
            6   2
                /
            3


    Example Explanation
        Explanation 1:
            Create the binary tree and return the root node of the tree.
### Solution approach
    Take below input:
        A = [6, 1, 3, 2]
        B = [6, 3, 2, 1]
    Our main issue is to find the root node and all the node of left tree and right subtree.
    We will follow below steps until tree is constrcuted
        Step 1: Find the root node with the help of post order traversal
        Step 2: Find the index of root node in inorder traversal
        Step 3: Based on the root node index we can find the number of node from right subtree and left subtree.
        Step 4: All the element available in inorder traversal before root node index would be left and subtree 
        and all the element available after root node index would be right subtree.
        Step 5 : Will keep doing above mentioned steps untill we get invald index.

### Solution
```java
public TreeNode buildTree(int[] A, int[] B) {
    if (A == null || A.length == 0 || B == null || B.length == 0) return null;
    Map<Integer, Integer> valIndexMap = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
        valIndexMap.put(A[i], i);
    }
    return buildTree(A, B, valIndexMap, 0, A.length - 1, 0, A.length - 1);
}

public TreeNode buildTree(int[] A, int[] B, Map<Integer, Integer> valIndexMap, int inStart, 
int inEnd, int postStart, int postEnd) {
    if(inStart > inEnd) return null;
    int rootNode = B[postEnd];
    int rootIndex = valIndexMap.get(rootNode);
    int count = rootIndex - inStart;
    TreeNode root = new TreeNode(rootNode);
    // build left tree
    root.left = buildTree(A, B, valIndexMap, inStart, inStart + count - 1, postStart, postStart + count - 1);
    // build right tree
    root.right = buildTree(A, B, valIndexMap, rootIndex + 1, inEnd, postStart + count, postEnd - 1);
    return root;
}
```
### Construct Binary Tree from Preorder and Inorder Traversal
    Problem Description
        Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
        binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

    Problem Constraint:
        1 <= preorder.length <= 3000
        inorder.length == preorder.length
        -3000 <= preorder[i], inorder[i] <= 3000
        preorder and inorder consist of unique values.
        Each value of inorder also appears in preorder.
        preorder is guaranteed to be the preorder traversal of the tree.
        inorder is guaranteed to be the inorder traversal of the tree.

    Input:
        Example 1:
            Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
            Output: [3,9,20,null,null,15,7]
        Example 2:
            Input: preorder = [-1], inorder = [-1]
            Output: [-1]
### Solution Approach:
    We will use similar kind of approach as prev problem, the only difference would be in place of 
    post order traversal we will use preOrder traversal to decide root element.
### Solution
```java
public TreeNode buildTreeFromInorderAndPreOrder(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
    Map<Integer, Integer> valIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        valIndexMap.put(inorder[i], i);
    }
    return buildTreeFromInorderAndPreOrder(preorder, valIndexMap, 0,
            0, preorder.length - 1);
}

private TreeNode buildTreeFromInorderAndPreOrder(int[] preorder, Map<Integer, Integer> valIndexMap, int preStart,
                                                    int inStart, int inEnd) {
    if (inStart > inEnd) return null;

    int rootVal = preorder[preStart];
    int rootIndex = valIndexMap.get(rootVal);
    int count = rootIndex - inStart;
    TreeNode root = new TreeNode(rootVal);
    // construct left tree
    root.left = buildTreeFromInorderAndPreOrder(preorder, valIndexMap, preStart + 1,
            inStart, inStart + count - 1);

    //construct right tree
    root.right = buildTreeFromInorderAndPreOrder(preorder, valIndexMap, preStart + count + 1,
            rootIndex + 1, inEnd);

    return root;
}
```

### Another super solution for Construct Binary Tree from Preorder and Inorder Traversal
### Solution
```java
private int i = 0, j = 0;
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, inorder, Integer.MIN_VALUE);
}
private TreeNode build(int[] preorder, int[] inorder, int min_v) {
    if (i >= preorder.length) {
        return null;
    }
    if (inorder[j] == min_v) {
        ++j;
        return null;
    }
    TreeNode tree = new TreeNode(preorder[i++]);
    tree.left = build(preorder, inorder, tree.val);
    tree.right = build(preorder, inorder, min_v);
    return tree;
}
```

