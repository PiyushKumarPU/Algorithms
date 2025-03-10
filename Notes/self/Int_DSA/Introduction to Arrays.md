## Day 3 Introduction to Arrays

## Scope / Agenda
- [Space Complexity](#space-complexity)
- [Introduction to Arrays](#introduction-to-arrays)
- [Arrays Problems](#arrays-problems)
  

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/intermediate/intro/arrays/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/intermediate/intro/arrays/additional)
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../class_Notes/DSA%20Intermediate%20Notes/3%20Intro%20to%20Arrays(%2028-08-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=T2yu0FGJFmc)


## Space Complexity
> Space complexity is the total space taken by the code for execution, excluding input space and outputspace.

    Space complexity is a parallel concept to time complexity. If we need to create an array of size n, 
    this will require O(n) space. If we create a two-dimensional array of size n*n, 
    this will require O(n^2) space.
### Examples
    Example 1
        int add (int n){
            if (n <= 0){
                return 0;
            }
            return n + add (n-1);
        }

        Here each call add a level to the stack :

        1.  add(4)
        2.    -> add(3)
        3.      -> add(2)
        4.        -> add(1)
        5.          -> add(0)

        Each of these calls is added to call stack and takes up actual memory.
        So it takes O(n) space.

        In recursive calls stack space also counts.
    Example 2
        int addSequence (int n){
        int sum = 0;
            for (int i = 0; i < n; i++){
                sum += pairSum(i, i+1);
            }
            return sum;
        }

        int pairSum(int x, int y){
            return x + y;
        }

        There will be roughly O(n) calls to pairSum. However, those 
        calls do not exist simultaneously on the call stack,
        so you only need O(1) space.

## Introduction to Arrays
* [Refer this for more details](https://www.geeksforgeeks.org/arrays-in-java/)

## Arrays Problems
* [Refer here for more problems](https://www.geeksforgeeks.org/arrays-in-java/#practice)
### Find min/max of array
```java
    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (Integer element : A) {
            min = Math.min(min, element);
            max = Math.max(max, element);
        }
        return min + max;
    }
```
### GoodPair
    Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B).
    Check if any good pair exist or not.
### Solution Approach
    Check for each pair where i != j and check if its sum is equal to target.
    TC : O(n^2)
    SC : O(1)
### Solution
```java
    public int solve(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if(A[i] + A[j] == B) return 1;
            }
        }
        return 0;
    }
```
