## Day 5 Arrays : Carry Forward and Subarrays

## Scope / Agenda
- [TLE and Constraints](#tle-and-constraints)
- [Carry Forward Questions](#carry-forward-questions)
- [Intro to SubArrays](#intro-to-subarrays)
- [Iterating SubArrays](#iterating-subarrays)
- [Questions](#questions)

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../class_Notes/DSA%20Intermediate%20Notes/5%20Carry%20Forward%20And%20SubArrays(1-09-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=_HhbQsnDlVs)


## TLE and Constraints
    Most of the online coding plateform has 1GHZ system and it will give you 1 sec to execute your code and if code can not execute in 1 sec it will throw Time Limit Exceed error.
    * In 1 sec of time utmost 10^9 instruction can be exeucted and if we include other instruction processing time, mostly it will execute 10^7 to 10^8 instruction per second.
### Constraints 
    Examples
        1 <= |A| <= 2000 --> it represent value of A lies between 1 and 2*10^3
    Constraint plays a very useful role while writing program. Based on the constraint, developer can choose appropriate solution among the available one and that should not throw TLE.
## Carry Forward Questions
    In this technique we carry result of any specific requirement which can help us to calculate future result and we will avoid duplicate calculation.
### Problems
* Given a string of lowercase characters and return count of pair (i,j) such that i< j and  s[i] = 'a', s[j] ='g'
    Input
        s = 'abegag'
    Output = 3  ag,ag,ag
### Solution approach
#### Brute force:
    Will count no of g to the right of any 'a' and calculate its count.
    TC : O(n^2)
    SC : O(1)
```java
    public int countPairBruteForce(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                // count all g available after a
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 'g') count++;
                }
            }
        }
        return count;
    }
```
#### Optimized approach
    * Let's maintain a variable call aCount and increase it whenever we find 'a'
    * Whenever we encounr character 'g', caculate no of pair and store it in ans variable.
    * This process will keep going till end of the array.
    TC : O(n)
    SC : O(1)
```java
    public int countPair(String str) {
        int count = 0, aCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') aCount++;
            else if (str.charAt(i) == 'g') count += aCount ;
        }
        return count;
    }
```
## Intro to SubArrays
> A subarray is a contiguous part of array. An array that is inside another array. For example, consider the array [1, 2, 3, 4], 
There are 10 non-empty sub-arrays. The subarrays are (1), (2), (3), (4), (1,2), (2,3), (3,4), (1,2,3), (2,3,4) and (1,2,3,4). In general, for an array/string of size n, there are n*(n+1)/2 non-empty subarrays/substrings.

> Total number of subarray in given array of length n will be n(n+1)/2. Roughly n^2
## Iterating SubArrays
* Total number of subarray in an array of length n is n(n+1)/2
## Questions
    Given a string of lowercase characters and return count of pair (i,j)
    such that i< j and  s[i] = 'a', s[j] ='g'
### Solution
```java
    public int countPairBruteForce(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                // count all g available after a
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 'g') count++;
                }
            }
        }
        return count;
    }
```
```java
    public int countPair(String str) {
        int count = 0, aCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') aCount++;
            else if (str.charAt(i) == 'g') count += aCount ;
        }
        return count;
    }
```
