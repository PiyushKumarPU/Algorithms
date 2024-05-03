## Advance DSA Day 43 DP 4  Applications of Knapsack

## Scope / Agenda
- [Cutting the Rod](#cutting-the-rod)
- [Coin sum infinite with duplicate](#coin-sum-infinite-with-duplicate)
- [Coin Sum Infinite](#coin-sum-infinite)
- [Extended 0-1 Knapsack](#extended-0-1-knapsack)

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp4/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp4/additional)
3. [Class/Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp4/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/43.%20DP%204%20Applicaiton%20of%20Knapsack.pdf)
2. [Class/Lecture Video](https://youtu.be/WVM8zZECzO4)
3. [New Batch video](https://youtu.be/A7J1obf6JuE)
4. [New Batch Notes](../../../new_batch_notes/DP4%20Applications%20of%20Knapsack.pdf)

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
        If we look at problem description, it is as same as unbounded knapsack because for each step we can cut rod in all
        available options.

        Step 1: Cut rods in all possible length
        Step 2: Calculate profit and then again cut it into all available length
        step 3: Chosse the length which gives max profit
        TC : O(n^2)
        SC : O(n) --> dp length
### Solution
```java
// brute force
public int cuttingRods(int[] A) {
    if (A == null || A.length == 0) return 0;
    return cuttingRods(A, A.length);
}
public int cuttingRods(int[] A, int capacity) {
    if (capacity <= 0) return 0;
    int currentMax = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
        int current = 0;
        if (i + 1 <= capacity) {
            current = A[i] + cuttingRods(A, capacity - (i + 1));
        }
        currentMax = Math.max(currentMax, current);
    }
    return (currentMax == Integer.MIN_VALUE) ? 0 : currentMax;
}
// Using dynamic programming top down approach
int[] profitMatrix;
public int cuttingRods(int[] A) {
    if (A == null || A.length == 0) return 0;
    profitMatrix = new int[A.length + 1];
    Arrays.fill(profitMatrix, -1);
    profitMatrix[0] = 0;
    return cuttingRodsTopDown(A, A.length);
}
public int cuttingRodsTopDown(int[] A, int capacity) {
    if (capacity <= 0) return 0;
    if (profitMatrix[capacity] != -1) return profitMatrix[capacity];
    int currentMax = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
        int current = 0;
        if (i + 1 <= capacity) {
            current = A[i] + cuttingRods(A, capacity - (i + 1));
        }
        currentMax = Math.max(currentMax, current);
    }
    profitMatrix[capacity] = (currentMax == Integer.MIN_VALUE) ? 0 : currentMax;
    return profitMatrix[capacity];
}
```

## Coin sum infinite with duplicate
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
            7
        Output 2:
            1

    Example Explanation
        Explanation 1:
        The 4 possible ways are:
        {1, 1, 1, 1}
        {1, 1, 2}
        {1, 2, 1}
        {2, 1, 1}
        {2, 2}
        {1, 3}
        {3, 1}
        Explanation 2:
        There is only 1 way to make sum 10.
### Solution Approach
    Approach 1: Brute Force
        Look for all possible options as we can select same coin as many as times we can.
        TC : O(2^n)
        SC: O(n) --> stack space
    Approach 2:
        Store and resuse duplicate calculation in above approach
        TC : O(B * A.length)
        SC : O(B)
### Solution
```java
// Brute force
public int coinSum(int[] A, int B) {
    if (A == null || A.length == 0 || B < 0) return 0;
    if (B == 0) return 1;
    int count = 0;
    for (int a : A) {
        if (a <= B) {
            count += coinSum(A, B - a);
        }
    }
    return count;
}
// Dp top down approach
int[] waysMatrix;
public int coinSumTopDown(int[] A, int B) {
    if (A == null || A.length == 0 || B < 0) return 0;
    waysMatrix = new int[B + 1];
    Arrays.fill(waysMatrix, -1);
    waysMatrix[0] = 1;
    return coinSumTopDownRec(A, B);
}

public int coinSumTopDownRec(int[] A, int B) {
    if (A == null || A.length == 0 || B < 0) return 0;
    if (B == 0) return 1;
    if (waysMatrix[B] != -1) return waysMatrix[B];
    int count = 0;
    for (int a : A) {
        if (a <= B) {
            count += coinSumTopDownRec(A, B - a);
        }
    }
    waysMatrix[B] = count;
    return waysMatrix[B];
}
```
    
## Coin Sum Infinite
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
### Solution approach
    As per the problem statement we are not allowed to pick duplicate.
    Take below input as example to understand the problem
    A = {1,2,3}
    B = 4
    We can have following options to build 4 out of available coins
        1 + 3
        3 + 1
        2 + 1 + 1
        1 + 2 + 1
        1 + 1 + 2
        2 + 2
        1 + 1 + 1 + 1
    but as per the problem descrption (i,j) is same (j,i)
    so we can not pick combination with duplicates and we can only pick
        1 + 3
        2 + 1 + 1
        2 + 2
        1 + 1 + 1 + 1
    Approach 1: Brute Force
        As we are not allowed to pick duplicate combination, 
        why cant we think of choosing one index and using it as much as we can so that same combination will not 
        be available for future calculation
        Step 1: Choose any index and given target
        step 2: We have two options either we can choose the respective index or not
        step 3: If we are not choosing that index then we will calculate it with remaining index
        step 4: If we are choosing that index, then taget will be reduced by value of that index 
                and we will calculate remaining target upon same index
        step 5: Total ways to form that specific target on given index would be sum of dont take and take value
        TC : O(2^n)
        SC : Recursion stack space
    Approach 2: Using dynamic programming
        Remove duplicate calculation using dp array
        TC : O(n * B)
        SC : O(B)

![Coin sum infinite](../../../images/CointSumInfinite.png) 

> Note : Above problem will not work with recursion in case of large target and smaller coin. 
It would end up throwing stack overflow error.

### Solution
```java
// Using Top down approach
int[][] coinCounts;
public int coinSumInfinite(int[] A, int B) {
    coinCounts = new int[A.length][B + 1];
    for (int[] arr : coinCounts) Arrays.fill(arr, -1);
    return coinSumInfinite(A, B, A.length - 1);
}

// not possible with recursion for larget input, as recursion stack will be full
public int coinSumInfinite(int[] A, int target, int index) {
    if (target == 0) return 1;
    if (index < 0 || target < 0) return 0;
    if (coinCounts[index][target] != -1) return coinCounts[index][target];
    int dontTake = coinSumInfinite(A, target, index - 1);
    int take = coinSumInfinite(A, (target - A[index]), index);
    int ways = (take + dontTake) % 1000007;
    coinCounts[index][target] = ways;
    return ways;
}

// Using Bottom up approach
public int coinSumInfinite(int[] A, int B) {
    int mod = 1000007;
    int[] dp = new int[B + 1];
    dp[0] = 1;
    for (int coin : A) {
        for (int i = coin; i <= B; i++) {
            dp[i] = (dp[i] + dp[i - coin]) % mod;
        }
    }
    return dp[B];
}
```
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
