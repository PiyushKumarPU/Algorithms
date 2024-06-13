## Advance DSA Day 7 Recursion 2

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [Time Complexity(Using Recurrance relation)](#time-complexityusing-recurrance-relation)
- [Space Complexity](#space-complexity)
- [Recursion Quiz](#recursion-quiz)
- [Tower Of Hanoi](#tower-of-hanoi)
- [Print Valid Parenthesis](#print-valid-parenthesis)

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module1/recursion2/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module1/recursion2/additional)
3. [Self Practise Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module1/recursion2/lecture)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/7.%20Adv%20Recursion%202.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=oRn0Eq_04Qc)
3. [New Batch Notes](../../../new_batch_notes/Recursion2.pdf)
4. [New Batch Lecture Video](https://youtu.be/7jUD7esuCwg)

## Time Complexity(Using Recurrance relation)
    We will use recurrance relation/recursive call stack to calculate time complexity of factorial function
![Factorial](../../../images/TC_using_recurrance_relation.png?raw=true)
         
## Space Complexity
## Recursion Quiz
## Tower Of Hanoi
    Problem Description
        In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
        The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
        You have the following constraints:

        Only one disk can be moved at a time.
        A disk is slid off the top of one tower onto another tower.
        A disk cannot be placed on top of a smaller disk.
        You have to find the solution to the Tower of Hanoi problem.
        You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
        In each row, there should be 3 integers (disk, start, end), where:

        disk - number of the disk being moved
        start - number of the tower from which the disk is being moved
        end - number of the tower to which the disk is being moved

    Problem Constraints
        1 <= A <= 18


    Input Format
        The first argument is the integer A.

    Output Format
        Return a 2D array with dimensions M x 3 as mentioned above in the description.

    Example Input
        Input 1:
            A = 2
        Input 2:
            A = 3

    Example Output
        Output 1:
            [1 1 2 ] [2 1 3 ] [1 2 3 ]
        Output 2:
            [1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ]

    Example Explanation
        Explanation 1:
            We shift the first disk to the middle tower.
            We shift the second disk to the last tower.
            We, finally, shift the first disk from the middle tower to the last tower.
        Explanation 2:
            We can see that this was the only unique path with minimal moves to move all disks from the first to the third tower.

## Print Valid Parenthesis