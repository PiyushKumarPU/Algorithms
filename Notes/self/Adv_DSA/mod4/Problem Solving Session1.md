
## Problem Solving Session1.md

## Scope / Agenda
- [Flip Array](#flip-array)
- [Maximum Sum Value](#maximum-sum-value)
- [Ways to form Max Heap](#ways-to-form-max-heap)
## Problems and solutions

1. [Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/psp1/problems)

## Class Notes and Videos
1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/Problem%20Solving%20Session%201.pdf)
2. [Class/Lecture Video](https://youtu.be/t86c5ldDXic)

## Flip Array
    Problem Description
        Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum 
        of the elements of array should be minimum non-negative
        (as close to zero as possible).

        Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

    Problem Constraints
        1 <= length of(A) <= 100
        Sum of all the elements will not exceed 10,000.

    Input Format
        First and only argument is an integer array A.

    Output Format
        Return an integer denoting the minimum number of elements whose sign needs to be flipped.

    Example Input
        Input 1:
            A = [15, 10, 6]
        Input 2:
            A = [14, 10, 4]

    Example Output
        Output 1:
            1
        Output 2:
            1

    Example Explanation
        Explanation 1:
            Here, we will flip the sign of 15 and the resultant sum will be 1.
        Explanation 2:
            Here, we will flip the sign of 14 and the resultant sum will be 0.
            Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.


## Maximum Sum Value
    Problem Description
        You are given an array A of N integers and three integers B, C, and D.
        You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.

    Problem Constraints
        1 <= N <= 10^5
        -10000 <= A[i], B, C, D <= 10000

    Input Format
        First argument is an array A
        Second argument is an integer B
        Third argument is an integer C
        Fourth argument is an integer D

    Output Format
        Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.

    Example Input
        Input 1:
            A = [1, 5, -3, 4, -2]
            B = 2
            C = 1
            D = -1
        Input 2:
            A = [3, 2, 1]
            B = 1
            C = -10
            D = 3

    Example Output
        Output 1:
            18
        Output 2:
            -4

    Example Explanation
    Explanation 1:
        If you choose i = 2, j = 2, and k = 3 then we will get 
        A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) 
        = 10 + 5 + 3 = 18
    Explanation 2:
        If you choose i = 1, j = 3, and k = 3 then we will get 
        A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) 
        = 3 - 10 + 3 = -4
    
## Ways to form Max Heap
    Problem Description
        Max Heap is a special kind of complete binary tree in which, for every node, the value present in that node is 
        greater than the value present in its children nodes.

        Find the number of distinct Max Heap that can be made from A distinct integers.

        In short, you have to ensure the following properties for the max heap :

        Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, 
        except possibly the last, is completely filled, and all nodes are as far left as possible.)
        Every node is greater than all its children.
        NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.

    Problem Constraints
    1 <= A <= 100

    Input Format
        The first and only argument is an integer A.

    Output Format
        Return an integer denoting the number of distinct Max Heap.

    Example Input
        Input 1:
            A = 4
        Input 2:
            A = 10


    Example Output
        Output 1:
            3
        Output 2:
            3360

    Example Explanation
        Explanation 1:
            Let us take 1, 2, 3, 4 as our 4 distinct integers
            Following are the 3 possible max heaps from these 4 numbers :
                 4            4                     4
                /  \         / \                   / \ 
               3    2   ,   2   3      and        3   1
              /            /                     /    
             1            1                     2
        Explanation 2:
            Number of distinct heaps possible with 10 distinct integers = 3360.    