## Advance DSA Day 5 Bit Manipulation 2

## Scope / Agenda
- [Single number I](#single-number-i)
- [Single number II](#single-number-ii)
- [Single number III](#single-number-iii)
- [Max and Pair](#max-and-pair)
- [Max and Pairs](#max-and-pairs)

## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module1/bitmanipulation2/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module1/bitmanipulation2/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module1/bitmanipulation2/lecture/)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/5.%20Adv%20Bit%20Manipulation%202(06-10-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=TRsl7EmUUSo)


## Single number I
    Problem Description
        Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
        NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Problem Constraints
        1 <= |A| <= 2000000
        0 <= A[i] <= INTMAX

    Input Format
        The first and only argument of input contains an integer array A.

    Output Format
        Return a single integer denoting the single element.

    Example Input
        Input 1:
            A = [1, 2, 2, 3, 1]
        Input 2:
            A = [1, 2, 2]

    Example Output
        Output 1:
            3
        Output 2:
            1

    Example Explanation
        Explanation 1:
            3 occurs once.
        Explanation 2:
            1 occurs once.
### Solution Approach
    Problem statement states that, each number comes twice and only one so we will use XOR operator to cancel matching value and at last only one will be available that would be unique in array
### Solution
```java
public int singleNumber(final int[] A) {
    if (A == null || A.length == 0) return 0;
    int result = A[0];
    for (int i = 1; i < A.length; i++) {
        result = result ^ A[i];
    }
    return result;
}
```
## Single number II
    Problem Description
        Given an array of integers, every element appears thrice except for one, which occurs once.
        Find that element that does not appear thrice.
        NOTE: Your algorithm should have a linear runtime complexity.
        Could you implement it without using extra memory?


    Problem Constraints
        2 <= A <= 5*10^6
        0 <= A <= INTMAX

    Input Format
        First and only argument of input contains an integer array A.

    Output Format
        Returns a single integer.

    Example
        Input 1:
            A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
        Input 2:
            A = [0, 0, 0, 1]

    Example
        Output 1:
            4
        Output 2:
            1

    Example
        Explanation 1:
            4 occurs exactly once in Input 1.
        Explanation 2:
            1 occurs exactly once in Input 2.
### Solution Approach
    Here we are going to use bitwise count for each element. 
    Will start counting set bit from 0 to 31 and if count is greater than 3 it means bit is set for extra number, and by using that set or unset bit we can construct the extra number
### Solution
```java
public int singleNumber(final int[] A) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        int count = 0;
        int leftShift = 1 << i;
        for (int element : A) {
            if ((element & leftShift) > 0) count++;
        }
        if (count % 3 > 0) {
            result += (int) Math.pow(2, i);
        }
    }
    return result;
}
```
## Single number III
    Problem Description
        Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
        Find the two integers that appear only once.
        Note: Return the two numbers in ascending order.

    Problem Constraints
        2 <= |A| <= 100000
        1 <= A[i] <= 10^9

    Input Format
        The first argument is an array of integers of size N.

    Output Format
        Returns an array of two integers that appear only once.

    Example
        Input 1:
            A = [1, 2, 3, 1, 2, 4]
        Input 2:
            A = [1, 2]

    Example
        Output 1:
            [3, 4]
        Output 2:
            [1, 2]

    Example
        Explanation 1:
            3 and 4 appear only once.
        Explanation 2:
            1 and 2 appear only once.
### Solution Approach
    This solution is bit tricky.
    Steps to follow:
        1. Find xor of all the elements in array
        2. At last we will have xor value of only two unique element.
        3. If xor is 0 then we dont have two unique element in the array
        4. Now our job is to separate out both the element from xor value
        5. Find first set bit positiion in xor value and that will give us the start point of number differences
        5. Now separate out numbers based on the set bit position,
        if any number has set bit for specific position then keep it in one part otherwise in second part
        6. Now take xor of first part and second part separately and we got the result.
### Solution
```java
public int[] solve(int[] A) {
    
    int xor = A[0];
    for (int i = 1; i < A.length; i++) {
        xor = xor ^ A[i];
    }
    int pos = 0;
    for (pos = 0; pos < 32; pos++) {
        if ((xor & (1 << pos)) > 1) break;
    }
    int firstNumber = 0, secondNumber = 0;
    for (int j : A) {
        if ((j & (1 << pos)) > 1) {
            firstNumber = firstNumber ^ j;
        } else secondNumber = secondNumber ^ j;
    }
    return new int[]{Math.min(firstNumber, secondNumber),
    Math.max(firstNumber, secondNumber)};
    
}
```
## Max and Pair
## Max and Pairs	