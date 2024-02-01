## Advance DSA Day 6 Recursion 1

## Scope / Agenda
- [Recursion Introduction](#recursion-introduction)
- [Write Recursive Code](#write-recursive-code)
- [Function Call Tracing](#function-call-tracing)
- [Recursion Problems](#recursion-problems)
- [TC and SC](#tc-and-sc)

  

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/6.%20Adv%20Recursion%201.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=41_7-AT80n8)


## Recursion Introduction
    Recursion is a process of solving bigger problem by breaking into similar smaller subproblems in such a way that merging all smaller problem together will give you solution of bigger problem.
## Write Recursive Code
* Assumption: First decide what does our funnction do
* Main Logic : Recursive relation to code/breaking big problem into smaller one
* Base condition: Smallest problem for which we know answer and it does not require to call itself to get answer
## Function Call Tracing
### Steps to trace funnction call
* Start at the base case. This is the case where the function does not call itself anymore.
* From the base case, follow the recursive calls.
* At each recursive call, make a new box and draw an arrow from the current box to the new box.
* In the new box, write down the parameters of the function call, the local variables of the function, and the return value of the function.
* Continue following the recursive calls until you reach the base case again.

```java
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
```
### Function tracing for above method call
```
    factorial(5)
        factorial(4)
            factorial(3)
                factorial(2)
                    factorial(1)
                        return 1
                    return 2 * 1
                return 3 * 2
            return 4 * 3
        return 5 * 4
    return 120  
```
## Recursion Problems
### Find Factorial
    Problem Description
        Write a program to find the factorial of the given number A using recursion.
        Note: The factorial of a number N is defined as the product of the numbers from 1 to N.

    Problem Constraints
        0 <= A <= 12

    Input Format
        First and only argument is an integer A.

    Output Format
        Return an integer denoting the factorial of the number A.

    Example Input
        Input 1:
            A = 4
        Input 2:
            A = 1

    Example Output
        Output 1:
            24
        Output 2:
            1

    Example Explanation
        Explanation 1:
            Factorial of 4 = 4 * 3 * 2 * 1 = 24
        Explanation 2:
            Factorial of 1 = 1
### Solution
```java
    public int solve(int A) {
        if (A == 1) return 1;
        return solve(A - 1) * A;
    }

    public int solveIterative(int A) {
        int f1 = 1;
        for (int i = 2; i <= A; i++) {
            f1 = i * f1;
        }
        return f1;
    }
```
### Find Fibonacci
    Problem Description
        The Fibonacci numbers are the numbers in the following integer sequence.
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
        In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
            Fn = Fn-1 + Fn-2
        Given a number A, find and return the Ath Fibonacci Number using recursion.
        Given that F0 = 0 and F1 = 1.

    Problem Constraints
        0 <= A <= 20

    Input Format
        First and only argument is an integer A.

    Output Format
        Return an integer denoting the Ath term of the sequence.

    Example Input
        Input 1:
            A = 2
        Input 2:
            A = 9

    Example Output
        Output 1:
            1
        Output 2:
            34

    Example Explanation
        Explanation 1:
            f(2) = f(1) + f(0) = 1
        Explanation 2:
            f(9) = f(8) + f(7) = 21 + 13  = 34
### Solution
```java
    public int findAthFibonacci(int A) {
        if (A == 0 || A == 1) return A;
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }

    public int findAthFibonacciIterative(int A) {
        int f0 = 0, f1 = 1;
        for (int i = 1; i < A; i++) {
            int current = f1 + f0;
            f0 = f1;
            f1 = current;
        }
        return f1;
    }
```
### Find a^n using recursion
### Solution
```java
    public int pow(int base, int exp) {
        if (exp <= 1) return base;
        return base * pow(base, exp - 1);
    }
```
## TC and SC
### TC


### SC
> Below is the image representation of space taken by a recursive call. Mostly it would be space taken by recursive call and it would be the height of recursive call.
![Space taken by recursive call](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/952fc50e281c61476f883f9fd3a97114e61f6237/Notes/images/recursion_SC.png?raw=true)

> Space taken by recursive call would be the same as height and max height would be logN where N is the given input