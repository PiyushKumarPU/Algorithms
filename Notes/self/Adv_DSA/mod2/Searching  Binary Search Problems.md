## Advance DSA Day 16 Searching : Binary Search Problems


## Scope / Agenda
- [Searching in Rotated sorted Array](#searching-in-rotated-sorted-array)
- [Find Square root of a number](#find-square-root-of-a-number)
- [Median of two sorted Array](#median-of-two-sorted-array)

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/16.%20Searching%20Binary%20Search%20Problems.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=LkgoWVguq14)

## Searching in rotated sorted Array
    Problem Statement:
        Find the target and return its index in a rotated sorted array, array has all the unique elements.
        arr = {2,4,8,10,15}
        Rotate it 2 times and that will be input
        arr(final input) = {10,15,2,4,8}
        Target: 2
        ans : 2
## Find Square root of a number
    Problem Statement:
        Given a +ve number N, find floor(sqrt(N)) i.e. find the number such that number * number <= N
        | N  | ans |
        |----------
        | 25 |  5  |
        | 20 |  4  |
        | 10 |  3  |
## Median of two sorted Array
> Median : Middle element of sorted array if array size is even and average of middle elements if array size is odd. 

    Problem Statement:
        Find the median of two sorted array.
        Example :
            arr1 = {1,4,5}
            arr2 = {2,3}
            ans : 3

        Example:
            arr1 = {1,2,3}
            arr2 = {4}
            ans : (2+3)/2 = 2.5
        