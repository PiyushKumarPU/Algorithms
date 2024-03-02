## Advance DSA Day 11 Combinatorics Basics

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [Addition and Multiplication Rules](#addition-and-multiplication-rules)
- [Permutation Basics](#permutation-basics)
- [Combination Basics and Properties](#combination-basics-and-properties)
- [Pascal Triangle](#pascal-triangle)
- [Find nth column title](#find-nth-column-title)


## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module2/combinatorics/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/combinatorics/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/combinatorics/lecture/)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/11.%20Adv%20Combinatorics%20Basic(20-10-23).pdf)
2. [Class/Lecture Video](https://youtu.be/oYTzvJN48V0)


## Addition and Multiplication Rules
## Permutation Basics
## Combination Basics and Properties
## Pascal Triangle
    Problem Description
        Write a program to print the pascal triangle up to A rows.

    Problem Constraints
        1 <= A <= 25

    Input Format
        The first argument is an integer A.

    Output Format
        Return a 2D array consisting of A rows whose each row contains A integers.

    Example Input
        Input 1:
            A = 3
        Input 2:
            A = 5

    Example Output
        Output 1:
            1 0 0
            1 1 0
            1 2 1
        Output 2:
            1 0 0 0 0
            1 1 0 0 0
            1 2 1 0 0
            1 3 3 1 0
            1 4 6 4 1

    Example Explanation
        Explanation 1:
            Row 1 = 1 0 0
            Row 2 = 1C0 1C1 0 = 1 1 0
            Row 3 = 2C0 2C1 2C2 = 1 2 1
## Find nth column title
    Problem Description
        Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
        For example:

            1 -> A
            2 -> B
            3 -> C
            ...
            26 -> Z
            27 -> AA
            28 -> AB
### Solution
```java
    public String convertToTitle(int A) {
        String result = "";
        while (A > 0) {
            int rem = A % 26;
            if (rem == 0) {
                result = "Z" + result;
                A = (A / 26) - 1;
            }else{
                result = ((char)((rem - 1) + 'A')) + result;
                A = A / 26;
            }
        }
        return result;
    }
```