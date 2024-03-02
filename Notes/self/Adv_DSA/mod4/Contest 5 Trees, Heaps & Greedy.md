
## Tree Heap and Greedy Contest Discussion

## Scope / Agenda
- [Asteroid Destruction](#asteroid-destruction)
- [ValidBinary Search Tree](#validbinary-search-tree)
- [Winner Stone](#winner-stone)
  

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/contest5)

## Class Notes and Videos
1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/Tree%20Heap%20and%20Greedy%20Contest.pdf)
2. [Class/Lecture Video](https://youtu.be/GXraklk5Nd8)

## Asteroid Destruction
    Problem Description
        In a faraway galaxy, there is a spaceship traveling through the asteroid field.
        The spaceship has a shield with a certain amount of energy.
        You are given an integer energy A, which represents the original energy of the shield.
        You are further given an integer array B of size N, where B[i] is the energy of the i-th asteroid.
        You can arrange for the spaceship to collide with the asteroids in any arbitrary order.
        If the energy of the shield is greater than or equal to the energy of the asteroid,
        the asteroid is destroyed and the shield gains the energy of the asteroid. Otherwise, the shield is destroyed.
        Return 1 if all asteroids can be destroyed. Otherwise, return 0.
    Problem Constraints
        1 <= A <= 10^9
        1 <= N <= 10^5
        1 <= B[i] <= 10^9
    Input Format
        First argument A is an integer. Second argument B is an integer array.
    Output Format
        Return an integer.
    Example Input
        Input 1:
            A = 10
            B = [14, 3, 2]
        Input 2:
            A = 4
            B = [2, 9, 2]
    Example Output
        Output 1:
            1
        Output 2:
            0

    Example Explanation
        Explanation 1:
            The spaceship can collide with the asteroids in the order [3, 2, 14]. It will destroy all the asteroids.

        Explanation 2:
            The spaceship will not be able to destroy the second asteroid.

### Solution
```java
    public int solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        java.math.BigInteger actual = java.math.BigInteger.valueOf(A);
        minHeap.addAll(B);
        while(!minHeap.isEmpty()){
            if(A <= 0) return 0;
            java.math.BigInteger current = java.math.BigInteger.valueOf(minHeap.poll());
            if(current.compareTo(actual) > 0) return 0;
            actual = actual.add(current);
        }
        return 1;
    }
```

## ValidBinary Search Tree
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
## Winner Stone
    Problem Description
        You are given an array of integers A of size N, where each element represents the weight of a stone.
        We are playing a game with the stones. On each turn, we choose the two heaviest stones and smash them together.
        Suppose the stones have weights x and y with x <= y.
        The result of this smash is:
            If x == y, both stones are totally destroyed.
            If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y - x.
            At the end, there is at most one stone left.
            Return the weight of this stone (or 0 if there are no stones left).

        Problem Constraints
            1 <= N <= 10^4
            1 <= A[i] <= 106

        Input Format
            First and only argument is the Integer array A.

        Output Format
            An integer representing the weight of the last remaining stone, or 0 if there are no stones left.

        Example Input

        Input 1:A = [1, 2, 3, 4, 5]

        Input 2:A = [3, 5, 7, 1, 4, 2, 8, 6]

        Example Output

        Output 1:
            1

        Output 2:
            0

        Example Explanation

        Explanation 1:

            Initially, the two heaviest stones are 4 and 5. Smash them together, and the remaining stone weights are [1,2,3,1].

            Next, the two heaviest stones are 2 and 3. Smash them together, and the remaining stone weights are [1,1,1].

            Now the heaviest stone remaining is 1.

        Explanation 2:
            Initially, stones are [3, 5, 7, 1, 4, 2, 8, 6]. We choose the heaviest two, 8 and 7, and smash them together. The resulting stone has weight 1.

            Now, stones are [3, 5, 1, 4, 2, 1, 6]. We choose the heaviest two, 6 and 5, and smash them together. The resulting stone has weight 1.

            Now, stones are [3, 1, 4, 2, 1, 1]. We choose the heaviest two, 4 and 3, and smash them together. The resulting stone has weight 1.

            Now, stones are [2, 1, 1, 1, 1]. We choose the heaviest two, 2 and 1, and smash them together. The resulting stone has weight 1.

            Now, stones are [1, 1, 1, 1]. We choose the heaviest two, 1 and 1, and smash them together. Remove both stones.

            Now, stones are [1, 1]. We choose the heaviest two, 1 and 1, and smash them together. Remove both stones.

            Since no stones are left, the answer is 0.
### Solution
```java
    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(A);
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) return maxHeap.poll();
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first != second) {
                maxHeap.add(first - second);
            }
        }
        return 0;
    }
```