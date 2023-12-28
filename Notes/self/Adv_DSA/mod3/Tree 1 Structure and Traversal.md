## Advance DSA Day 30 Tree 1: Structure and Traversal

## Scope/Agenda
- [What is Tree?](#what-is-tree)
- [Tree Terminology](#tree-terminology)
- [Traversal](#traversal)
- [Inorder traversal(Iterative)](#inorder-traversaliterative)
- [Construct Tree Question](#construct-tree-question)

  

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/30%20Trees%201%20Structure%20and%20Traversal.pdf)
2. [Class/Lecture Video](https://youtu.be/sfZ76utvYHo)


## What is Tree?
    Tree is a non linera data structure used to represent hierarchy in information.

    e.g. Family tree

    A tree data structure is a hierarchical structure that is used to represent and organize data in a way that is easy to navigate and search. It is a collection of nodes that are connected by edges and has a hierarchical relationship between the nodes. 

    The topmost node of the tree is called the root, and the nodes below it are called the child nodes. Each node can have multiple child nodes, and these child nodes can also have their own child nodes, forming a recursive structure.



### Please refer below links for more information on Trees

* [Wiki](https://en.wikipedia.org/wiki/Tree_(data_structure))
* [GFG](https://www.geeksforgeeks.org/introduction-to-tree-data-structure-and-algorithm-tutorials/)
* [Interview bit](https://www.interviewbit.com/courses/programming/tree-data-structure/)
## Tree Terminology
![Tree representation](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/9aec791bc43216e11ba3a2f775782a43350591f4/Notes/images/Treedatastructure.png?raw=true)

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

## Inorder traversal(Iterative)

### Steps to follow while performin In-order traversal
    In-order traversal
    Left Node Right i.e. L N R
    
* **Traverse through Left sub-tree**
* **Traverse root node of respective subtree**
* **Traverse through right sub-tree**


![In-Order Traversal Technique](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/aa69cd7213a7db59b3a24571db7d035930d68375/Notes/images/in_order_traversal.gif?raw=true)

![In-order traversal examples/steps](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/d29c95bd94eab9965e37e011e460781d926bd26a/Notes/images/in_order_traversla_steps.gif?raw=true)

### Lets take an exmple to understand In-order traversal
#### Input
![Input](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/58e6b9ca8f6a9d966d438d98d49e9ef9d7c66b53/Notes/images/Tree1_example1.png?raw=true)

#### Expected Output after performing In-Order traversal
![Output](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/58e6b9ca8f6a9d966d438d98d49e9ef9d7c66b53/Notes/images/Tree1_example2.png?raw=true)

#### Psuedo code for above example
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

## Construct Tree Question
