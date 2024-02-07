## Advance DSA Day 43 DP 4  Applications of Knapsack

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [Cutting the Rod]()
- [Coin change I]()
- [Coin change II]()
- [Extended 0-1 Knapsack]()

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp4/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp4/additional)
3. [Class/Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp4/lecture)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/43.%20DP%204%20Applicaiton%20of%20Knapsack.pdf)
2. [Class/Lecture Video](https://youtu.be/WVM8zZECzO4)

## Cutting the Rod
    Problem Description
        Given a rod of length N units and an array A of size N denotes prices that contains prices of all
        pieces of size 1 to N.
        Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.

    Problem Constraints
        1 <= N <= 1000
        0 <= A[i] <= 10^6

    Input Format
        First and only argument is an integer array A of size N.

    Output Format
        Return an integer denoting the maximum value that can be obtained by cutting up
        the rod and selling the pieces.

    Example Input
        Input 1:
        A = [3, 4, 1, 6, 2]
        Input 2:
        A = [1, 5, 2, 5, 6]

    Example Output
        Output 1:
            15
        Output 2:
            11

    Example Explanation
        Explanation 1:
            Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
        Explanation 2:
            Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.

### Solution approach
    Idea 1: 
        We can start looking for all the possible combination of different length and find the maximum profit.
        This solution would be kind of recursion problems and time complexity will be very high.
        TC : O(2^N) Same as time complexity of recursion 
        SC : O(h) --> height of recursion stack
    Idea 2:
        We will use greedy approach to maximise the profit.
     * Start cutting rod in all possible options and find the max of each steps.

## Coin change I
    Problem Description
        You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount
        of each coin in the set.
        NOTE:
            Coins in set A will be unique. Expected space complexity of this problem is O(B).
            The answer can overflow. So, return the answer % (10^6 + 7).

    Problem Constraints
        1 <= A <= 500
        1 <= A[i] <= 1000
        1 <= B <= 50000

    Input Format
        First argument is an integer array A representing the set.
        Second argument is an integer B.

    Output Format
        Return an integer denoting the number of ways.

    Example Input
        Input 1:
        A = [1, 2, 3]
        B = 4
        Input 2:
        A = [10]
        B = 10

    Example Output
        Output 1:
            4
        Output 2:
            1

    Example Explanation
        Explanation 1:
        The 4 possible ways are:
        {1, 1, 1, 1}
        {1, 1, 2}
        {2, 2}
        {1, 3}
        Explanation 2:
        There is only 1 way to make sum 10.
## Coin change II
## Extended 0-1 Knapsack 
    Problem Description
        Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
        Also given an integer C which represents knapsack capacity.
        Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
        NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

    Problem Constraints
        1 <= N <= 500
        1 <= C, B[i] <= 10^6
        1 <= A[i] <= 50

    Input Format
        First argument is an integer array A of size N denoting the values on N items.
        Second argument is an integer array B of size N denoting the weights on N items.
        Third argument is an integer C denoting the knapsack capacity.

    Output Format
        Return a single integer denoting the maximum value subset of A such that sum of the weights of this
        subset is smaller than or equal to C.

    Example Input
        Input 1:
        A = [6, 10, 12]
        B = [10, 20, 30]
        C = 50
        Input 2:
        A = [1, 3, 2, 4]
        B = [12, 13, 15, 19]
        C = 10

    Example Output
        Output 1:
        22
        Output 2:
        0

    Example Explanation
        Explanation 1:
            Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
        Explanation 2:
            Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack 
            therefore answer is 0.
