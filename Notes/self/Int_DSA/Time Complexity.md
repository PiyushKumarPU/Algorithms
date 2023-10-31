
## Time Complexity

## Scope / Agenda
- [Log Basics](#log-basics)
- [Iteration Problems](#iteration-problems)
- [Comapring Iterations using graphs](#comapring-iterations-using-graphs)
- [Time Complexity : Big O notation](#time-complexity--big-o-notation)
- [Time Limit Exceed i.e. TLE](#time-limit-exceed-ie-tle)
- [Importance of Constraint](#importance-of-constraint)


## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../class_Notes/DSA%20Intermediate%20Notes/2%20Time%20Complexity(%2025-08-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=nz1IwfVC30E)


## Log Basics

    Logarithm is inverse of power or exponent.
    logb^a --> log a to the base b
    i.e. --> What should be the power of b so that result will be a
    b^? = a 

<code><pre>
Example:
    log<sub>2</sub><sup>64</sup> = 6    2^6 = 64
    log<sub>3</sub><sup>27</sup> = 3    3^3 = 27
    log<sub>5</sub><sup>25</sup> = 2    5^2 = 25
    log<sub>2</sub><sup>32</sup> = 5    2^5 = 32
</pre>
</code>

    If log can not be represented in integer power then take the nearest smallest power of respective base.

    Example:
        log2^10 = ? 
            There is no integer power of 2 which will give us 10 in place of that we have following power near to 10
            2^3 ==> 8
            2^4 ==> 16

            In this case 2^3 is nearest smallest to the 10 so the answer will be 3
        log2^10 = 3

        log2^40 = ?
        40 lies between 2^5(32) and 2^6(64) so answer will be 5
        log2^40 = 5


Key points
- If ```2^k == N``` then ```log2^N = k```
- ```loga^a^N = N```
    
    ```log2^2^6 = 6``` <br>
    ```log3^3^5 = 5```


Problem Description: <br>
    How many times do we divide N by 2 so it reaches 1? <br>

Example:<br> Lets take N = 100 <br>
``` 100 --> 50 --> 25 --> 12 --> 6 --> 3 --> 1 ``` Count = 6 <br>
Example : <br> Lets take N = 324 <br>
``` 324 --> 162 --> 81 --> 40 --> 20 --> 10 --> 5 --> 2 --> 1``` count = 8 <br>









## Iteration Problems

## Comapring Iterations using graphs

## Time Complexity : Big O notation

## Time Limit Exceed i.e. TLE

## Importance of Constraint
