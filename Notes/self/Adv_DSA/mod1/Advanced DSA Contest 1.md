## Advance DSA Day 8 Contest 1 Discussion

## Scope / Agenda
- [Search in Rowwise and columnwise sorted matrix](#search-in-rowwise-and-columnwise-sorted-matrix)
- [Count of AND Pairs](#count-of-and-pairs)
- [Decreasing Dishes](#decreasing-dishes)


## Problems and solutions

1. [Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module1/contest1)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/8.%20Adv%20DSA%20Contest%201%20Discussion.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=juM5ocpNmgQ)

>Note: ***Solution approch is not added to think about it before looking at solution and its approach.***


## Search in Rowwise and columnwise sorted matrix
    Problem Statement:
    Given a matrix of integers A of size N x M and an integer B.
    In the given matrix every row and column is sorted in non-decreasing order. Find and return the position of B in the matrix in the given form:
        * If A[i][j] = B then return (i * 1009 + j)
        * If B is not present return -1.
    Note :
        1: Rows are numbered from top to bottom and columns are numbered from left to right.
        2: If there are multiple B in A then return the smallest value of (i*1009 +j) such that A[i][j]=B.
        3: Expected time complexity is linear
        4: Use 1-based indexing

    Problem Constraints
        1 <= N, M <= 1000
        -100000 <= A[i] <= 100000
        -100000 <= B <= 100000

    Input Format:
        The first argument given is the integer matrix A.
        The second argument given is the integer B.

    Output Format:
        Return the position of B and if it is not present in A return -1 instead.


    Example Input:
        Input 1:-
            A = [[1, 2, 3]
                [4, 5, 6]
                [7, 8, 9]]
            B = 2
        Input 2:-
            A = [[1, 2]
                [3, 3]]
            B = 3
    Example Output:
        Output 1:-
            1011
        Output 2:-
            2019
    Example Explanation:
        Explanation 1:-
            A[1][2] = 2
                1 * 1009 + 2 = 1011
        Explanation 2:-
            A[2][1] = 3
                2 * 1009 + 1 = 2019
            A[2][2] = 3
            2 * 1009 + 2 = 2020
            The minimum value is 2019

```java
    public int solve(List<List<Integer>> A, int B) {
        int ans = -1, i = 0, j = A.get(0).size() - 1;
        while (i < A.size() && j >= 0) {
            int currentElement = A.get(i).get(j);
            if (currentElement >= B) {
                if (currentElement == B) {
                    int temp = (i + 1) * 1009 + (j + 1);
                    if (ans < 0) ans = temp;
                    else ans = Math.min(ans, temp);
                }
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
```
## Count of AND Pairs
    Problem Statement:
    You are given an array of N integers A. You are also given Q queries given the array B. 
    For every query B[i], you need to find the count of pairs from the array A such that 
    the bitwise AND of them has the B[i]-th bit set i.e. 1 (a bit is considered "set" when it has a value of 1).

    Note: It is guaranteed that the answer will fit in 32 bits

    Constraints:
        1 <= N <= 10^5
        1 <= Q <= 50
        0 <= B[i] <= 31
        0 <= A[i] <= 10^9

    Example Input:
        Input 1:
            A = [1,2,3]
            B = [0,1,2]
        Input 2:
        A = [2,5,6,7]
        B = [1,2]

    Example Output:
        Output 1:
            [1,1,0]
        Output 2:
            [3,3]

    Output Explanation:
        Output 1:
            The pair with 0-th bit set is (1, 3).
            The pair with 1-th bit set is (2, 3).
            There are no pairs with 2-th bit set.
        Output 2:
            The pairs with 1-th bit set are (2, 6), (2, 7) and (6, 7).
            The pairs with 2-th bit set are (5, 6), (5, 7) and (6, 7).

Approach 1:
```java
    public List<Integer> approach1(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        for (Integer query : B) {
            int count = 0, temp = (1 << query);
            for (int currentElement : A) {
                if ((currentElement & temp) > 0) {
                    count++;
                }
            }
            result.add(((count * (count - 1)) / 2));
        }
        return result;
    }
```

Approach 2: Optimization in prev approach
```java
    public List<Integer> approach2(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        List<Integer> countPairs = new ArrayList<>();
        for (int pos = 0; pos < 32; pos++) {
            int count = 0;
            for (int currentElement : A) {
                if ((currentElement & (1 << pos)) != 0) {
                    count++;
                }
            }
            countPairs.add((((count - 1) * count) / 2));
        }
        for (Integer query : B) {
            result.add(countPairs.get(query));
        }
        return result;
    }
```

## Decreasing Dishes
    Problem Statement:
    Given an array of N positive integers representing the weights of ingredients in a dish.
    Find the maximum possible sum of a subarray with decreasing weights.

    Problem Constraints:
        1 <= N <= 10^5
        0 <= A[i] <= 10^5
        Sum of all elements of A <= 10^9

    Input format:
        First argument A is an array of integers.
    Output Format;
        Return an integer denoting maximum possible sum of a subarray with decreasing weights.

    Example Input:
        Input 1:
            A = [3, 2, 1]
        Input 2:
            A = [3, 3, 5, 0, 1]

    Example Output:
        Output 1: 6
        Output 2: 5

    Example Explanation:
        Example 1:
            We can take the subarray indexed [0-2] which are in decreasing order the sum the elements are 3+2+1=6.
        Example 2:
            We can take the subarray indexed [2-3] which are in decreasing order the sum of the elements are 5+0=5.
```java
    public int solve(List<Integer> A) {
        int sum = Integer.MIN_VALUE, currentSum = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            if (currentSum < 1) currentSum = A.get(i);
            if (A.get(i) > A.get(i + 1)) {
                currentSum = currentSum + A.get(i + 1);
                sum = Math.max(sum, currentSum);
            } else {
                currentSum = 0;
            }
        }
        if (A.get(A.size() - 1) > A.get(A.size() - 2)) {
            sum = Math.max(sum, A.get(A.size() - 1));
        }
        return sum;
    }
```
