## Advanced DSA Day 22 Contest 3 Sorting, Searching & Two Pointers

## Scope / Agenda
- [First Attempt Problems](#first-attempt-problems)
  

## Problems and solutions
1. [Problems]()

## Class Notes and Videos

1. [Contest Discussion Notes](../../../class_Notes/Advance%20DSA%20Notes/22.%20Contest%203%20Discussion.pdf)
2. [Contest Discussion Video](https://youtu.be/7r_4LT7HJjk)


## First Attempt problems
### Maximum Good Pair
    Problem Description
        You are given 2 string arrays A and B of length N and M respectively. Both of them are in dictionary order(sorted lexicographically).For any pair (i, j) where i is an index of A and j is an index of B, the pair is good if i <= j and A[i] >= B[j] (lexicographically). The score of the pair is defined as the absolute difference between indexes abs(i - j).

        Return the maximum possible scores out of all the good pairs. Return 0 if there are no good pairs.

    Problem Constraints 
        1 <= N, M <= 10^5
        'a' <= A[i], B[j] <= 'z'
    Input Format 
        The two arguments A and B are two strings.
    Output Format 
        Return an integer
    Example Input 
        Input 1:
        A = "bcc"B = "abc"
        Input 2:
        A = "add"B = "abcd"
    Example Output 
        Output 1:
        1
        Output 2:
        2
    Example Explanation 
        Explanation 1:
        The good pairs are (1, 1), (1, 2), (2, 2), (2, 3) and (3, 3).
        Explanation 2:
        The good pairs are (1, 1), (2, 2), (2, 3), (2, 4), (3, 3) and (3, 4).

### Rotated Sorted Array Search
    Problem Description 
        Given a sorted array of integers A of size N and an integer B, where array A is rotated at some pivot unknown beforehand.For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.You can assume that no duplicates exist in the array.NOTE: You are expected to solve this problem with a time complexity of O(log(N)).

    Problem Constraints 
        1 <= N <= 1000000
        1 <= A[i] <= 10^9 
        All elements in A are Distinct.
    Input Format 
        The First argument given is the integer array A.The Second argument given is the integer B.
    Output Format 
        Return index of B in array A, otherwise return -1
    Example Input 
        Input 1: 
        A = [4, 5, 6, 7, 0, 1, 2, 3]
        B = 4 
        Input 2: 
        A : [ 9, 10, 3, 5, 6, 8 ]
        B : 5
    Example Output 
        Output 1: 
        0 
        Output 2: 
        3
    Example Explanation 
        Explanation 1: 
        Target 4 is found at index 0 in A. 
        Explanation 2: 
        Target 5 is found at index 3 in A.


### Minimum Product of three
    Problem Description 
        Given an array of integers A of size N, return the minimum product of any three numbers from the array.
    Problem Constraints 
        3 <= N <= 105
        -1000 <= A[i] <= 1000
    Input Format 
        Single argument which is an integer array A.
    Output Format 
        Return an integer.
    Example Input 
        Input 1:A = [-1, 2, 1, 0]
        Input 2:A = [3, 2, -5, -4]
    Example Output 
        Output 1:-2
        Output 2:-30
    Example Explanation 
        Explanation 1:Minimum Product of three number is 2*1*(-1) = -2
        Explanation 2:Minimum Product of three number is 3*2*(-5) = -30



