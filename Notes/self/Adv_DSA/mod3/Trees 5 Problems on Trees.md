## Advance DSA Day 35 Trees 5 Problems on Trees

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [Invert Binary Tree](#invert-binary-tree)
- [Equal Tree Partition](#equal-tree-partition)
- [Populate Next Pointer in Binary Tree](#populate-next-pointer-in-binary-tree)
- [Populate Next Pointer in Perfect Binary Tree](#populate-next-pointer-in-perfect-binary-tree)
- [Root to Leaf Path Sum k](#root-to-leaf-path-sum-k)
- [Longest path across root node of Binary Tree](#longest-path-across-root-node-of-binary-tree)
- [Diameter of Binary Tree](#diameter-of-binary-tree)


## Problems and solutions
1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes//35.%20Problems%20on%20Trees.pdf)
2. [Class/Lecture Video](https://youtu.be/YnmGLLiFT_Q)
3. [Notability Link](https://notability.com/n/2dGLLHz5G3GeJOUxYUQKVp)


## Invert Binary Tree

### Problem Description
    Create mirror image of given binary tree. i.e. invert given binary tree.
![Problem image](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/dc9d38ffd135c7ff01100ce11e87fa30c54b600c/Notes/images/invert_binary_tree_problems.png?raw=true)

### Solution approach
    We will swap left child with right child and right child with left child for all the none leaf node and that will be inverted binary tree.

### Psuedo Code
```java
   void invert(TreeNode node){
    if (node == null) return;
    // swap left child with right child and vice versa
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
    // invert left and right child
    invert(node.left);
    invert(node.right);
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
        invert(node.getLeft());
        invert(node.getRight());
    }
```

## Equal Tree Partition
## Populate Next Pointer in Binary Tree
## Populate Next Pointer in Perfect Binary Tree
## Root to Leaf Path Sum k
## Longest path across root node of Binary Tree
## Diameter of Binary Tree
