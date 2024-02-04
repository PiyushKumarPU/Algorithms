
## Day 1 Introduction to problem solving

## Scope / Agenda
  - [Factors or count the factor](#factors-or-count-the-factor)
  - [Optimization of counting factors](#optimization-of-counting-factors)
  - [Prime number/ check if number is prime](#prime-number)
  - [Sum of N natural number](#sum-of-n-natural-number)
  - [Basic Math Properties](#basic-math-properties)
  - [Find number of iterations or no of time a code piece executes](#iterations-or-no-of-time-a-code-piece-executes)
  - [Definition of AP(Arithmetic Progression) and GP(Geometric Progression)](#definition-of-ap-and-gp)
  - [Comparision of algorithms](#comparision-of-algorithms)

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/intermediate/problem/solving/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/intermediate/problem/solving/additional)

## Class Notes and Videos

1. [Class Notes](../class_Notes/DSA%20Intermediate%20Notes/1%20Intro%20to%20Problem%20Solving(23-08-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=2lnt8YCgZLo&list=PLY7YPSlgGFgwd2idzGC67pQDAwiMfu7XE&index=1&pp=iAQB)


## Factors or Count the factor
  **What is factor?**
    Any number **i** is the factor of **N** if and only if **N % i == 0**

    e.g.
    2 is the factor of 10 because 10 % 2 == 0

  Factors of **24** is **1, 2, 3, 4, 6, 8, 12, 24**  (Factor Count is 8)

  ```java
    // Brute force approach to count number of factor of number N
    function countFactor(N){
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(N % i == 0) count++;
        }
        return count;
    }

  ```

  > Note: Any online plateform allowed 1 sec to execute any of the test cases and it allows to execute $10^9$ instruction in 1 sec. Generally online plateform has machine capacity of 1GHZ.

| N | Iterations | Execution Time|
| --- | ----------- | ---- |
| $10^8$ | $10^8$ | 1 sec |
| $10^9$ | $10^9$ | 10 sec|
| $10^{18}$ | $10^{18}$ |$10^{10}$ Sec --> same as **317 Years**

<span style="color:red">**By Looking at above table we definately need to optimize our solution to make it feasible for large input**</span>.

### Optimization of counting factors

 > Way to optimize exisitng solutions
   
```
if i * j == N then i and j are factors of N
j = N / i, i.e. i and N/i are factors of N

if i is one factor then N/i will be another factor of N
```

Lets take exmaple of N = 24 and N = 100

<span style="color:red">Example 1 for N = 24</span>
| N(For N = 24) | N/i
| --- | ---------
|1    | 24
|2    | 12
|3    | 8
|4    | 6     (After this N and N/i pair numbers are repating)
|6    | 4
|12    | 2
|24    | 1

<span style="color:red">Example 2 for N = 100</span>
| N(For N = 100) | N/i
| --- | ---------
|1    | 100
|2    | 50
|4    | 25
|5    | 20     
|10   | 10    (After this N and N/i pair numbers are repating)
|20   | 5
|25   | 4
|50   | 2
|100  | 1

>By looking at above calculation we can define below constraint<br>
 ```i <= N/i  ==>  i^2 <= N  ==> i <= sqrt(N)```<br>
 **basically i goes from [i,sqrt(N)]**<br>

```java
// Optimized approach to count number of factor of number N
function countFactor(N){
    int count = 0;
    for(int i = 1; i * i <= N; i++){
        if(N % i == 0) {
            count += (i == (N/i)) ? 1 : 2;
        }
    }
    return count;
}

```

### Prime number
 **What is a prime number?** 
    
    Any number can be called as prime number if it has utmost two factor, 1 and the number itself. Any other number which is not prime will be called composite number.
    1 is the exception here, it is neither prime nor composite

Example of Prime Number

    lets take example of 11, it has only two factor 1 and 11 so it will be called as prime number
    lets take another example of 6, it has 4 factor(1,2,3,6) so it will not be called prime number, it will be called composite number.

```java
// Approach to check if given number is prime or not
function isPrime(N){
    return countFactor(N) == 2;
}

```

### Sum of N natural number

> 1 + 2 + 3 + 4 + 5 + 6 + 7 + .... 100 = ?

```java
    s = 1 + 2 + 3 + 4 + 5 + 6 + 7 + .... 100
    s = 100 + 99 + 98 + 97 + 96 + 95 + .... 1
    -----------------------------------------
    2s = 101 + 101 + 101 .................+ 101
    2s = 100 * 101
    s = (100 * 101) / 2
```

>If we generalize above findings it would look like below <br><br>
2s = (N+1) + (N+1) + (N+1) + (N+1) + (N+1) + (N+1) + ... N times<br>
2s = (N+1) * N<br>
s = (N * (N+1)) / 2<br>
Sum if first N natural number is **(N * (N +1))/2**<br>

### Basic Math Properties
    [a,b] --> represent a range including a and b
    (a,b) --> represent a range excluding a and b
    [a,b) --> represent a range including a and excluding b

```java
// Example of basic math properties

1. No of element in given range
    a. [a,b] --> Here a and b are included so the count of number in range will be b-a+1
    b. (a,b] --> here a is excluded and b is included so the count of number in range will be, b - a 
```

### Iterations or no of time a code piece executes

> No of time a code block executes

```java
for(int i = 0; i < N; i++){
    // any statements
}

// in above code block loop executes N times or we can say N iteration is being performed here.
```
> No of Iterations example

```java
// Example 1
for(int i = 0; i < 100; i++){
    s = s + i + (i * i)
}

// In above code block loop executes 100 times

```

```java
// Example 2
for(int i = 0; i < N; i++){
   if(i % 2 == 0) print(i)
}

for(j = 1; j <= M; j++){
    if(j % 2 <> 0) print(j);
}

// In above code block first loop executes N - 1 + 1 times and loop 2 executes M - 1 + 1 times so total number of iterations is N + M

// No of iterations is M +N
```

Steps to follow while calculating no of iterations

    1. If there are nested loops then calculate no of iteration for each loop and multiply together.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // some instructions
            }
        }
        In above code block outer loop executes N times and inner loop executes M times for each iteration of outer loop so no of iteration for above code block will be N * M

    2. If there are set of parallel loop then calculate no of iteration for each loop separately and add together
        for(int i = 0; i < N; i++){
            // some instructions
        }
        for(int j = 0; j < M; j++){
            // some instructions
        }
        In above code block loop1 executes N times and loop2 executes M times and there is no relation between loop1 and loop2 so for this code block no of iteration will be N + M

### Definition of AP and GP

- Arithmetic Progression aka AP
    
    - An arithmetic progression (AP) is a sequence of numbers where the difference between any two consecutive numbers is a constant value. 
    ![AP Terms](https://github.com/rajpiyush220/Algorithms/blob/b66809c1c4ee80fd417447f365314c85e8ef3179/Notes/images/AP_Terms.png?raw=true)
    - The generic notation of an AP is **a, a + d, a + 2d, a + 3d**
    - The fixed number that is added to the previous term is known as the **common difference** and is denoted by **d**
    - Formula to find $n{th}$ term in any AP is **a(n) = (a + (n - 1)d)** (where n denotes nth term and d denotes common differences)

- Geometric Progression aka GP
   - Sequence of non zero element where next element is calculated by multiplying a fixed number in prev number of the sequence and the fixed number that is being multiplied to find next is called as **common ratio**.
   ![Gp Terms](https://github.com/rajpiyush220/Algorithms/blob/b66809c1c4ee80fd417447f365314c85e8ef3179/Notes/images/Gp_terms.png?raw=true)
   - Generic notation of gp is a, ar, $ar^2$, $ar^3$, $ar^4$, $ar^5$, .. $ar^{n-1}$
   - E.x **1, 2, 4, 8, 16, 32** is a GP with common ratio **2**
   - Formula to calucalte sum of $n^{th}$ terms of GP
        > Sn = a($r^n$ - 1) / (r - 1) when r ≠ 1 <br>
          Sn = na when r = 1.

### Comparision of algorithms
    For time being we will compare algorithms based on the number of iterations and in later classes we will learn to compare using time complexity and other criterias.

    Ex. 1 
        int factorCount = 0;
        for(int index = 1; index <= N; index++){
            if(N % index == 0) factorCount++;
        }
        Total no of iteration in above function is N becasue we are iterating through each number from 1 to N and checking if current number is factor of N
    Ex. 2
        int factorCount = 0;
        for(int index = 1; index * index <= n; index++){
            if(N % i ==0){
                factorCount += (N%i) == i ? 1 : 2;
            }
        }
        Total no of iteration in above function is sqrt(N) becasue we are iterating through each number from 1 to sqrt(N) and checking if current number is factor of N

    By looking at above example we can conclude that algo2 is taking less no of iterations so it is best algo between algo1 and algo2

> Basically algorithms will be compared with respect to input size and it wont be dependent on machine it is running and other variable aspect like language, env etc.

