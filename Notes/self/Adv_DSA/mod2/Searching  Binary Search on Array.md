## Advance DSA Day 15 Searching: Binary Seach on Array

## Scope / Agenda
- [Intro to Binary search](#intro-to-binary-search)
- [Problem 1](#problem-1)
- [Problem 2](#problem-2)
- [Problem 3](#problem-3)
- [Problem 4](#problem-4)
- [Problem 5](#problem-5)

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/binary_search/arrays/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/binary_search/arrays/additional)
3. [Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/binary_search/arrays/lecture)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/15.%20Searching%20%20Binary%20Search%20on%20Array.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=VQjPmB8lGgM)

## Intro to Binary search
    Intro:
        What we need while performing search operation?
            a. Target:- What are we looking for
            b. Search Space :- Where are we looking for target.
## Problem 1
    Problem Statement:
    Given a sorted array of unique elements, search for a target and return its index, if not present return -1.
        Example:
            Given array : {1, 3, 5, 7, 9, 10, 11, 13, 15, 17, 19, 30, 35, 40}
            Target :
                10 -> 5 
                35 -> 12
                37 -> -1 (Not Present)
                
        Approach 1:
            Iterate through whole array and look for the target if present then return index or return -1.
            TC : O(N)
            SC : O(1)
        Approach 2:
            As elements of array is sorted we can apply binary search here and find the target.
            TC : O(logn)
            SC : O(1)

## Problem 2
    Problem Statement:
    Find the first occurrence of a element in sorted array with duplicates.
## Problem 3
    Problem Statement:
    Given a sorted array where every element appears twice except one element that appears only once, find that unique element.
## Problem 4
    Problem Statement:
    Find peak element in increasing-decreasing array.
## Problem 5
    Problem Statement:
    Given a sorted array with duplicates, count total occurrences of a given num.