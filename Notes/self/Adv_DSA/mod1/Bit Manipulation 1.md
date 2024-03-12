## Advance DSA Day 4 Bit Manipulation 1

## Scope / Agenda
- [Bitwise Operators and Properties](#bitwise-operators-and-properties)
- [Left and Right Shift operator](#left-and-right-shift-operator)
- [Problems](#problems)
	- [Check ith bit](#check-ith-bit)
	- [Count Set bit](#count-set-bit)
	- [Unset ith bit](#unset-ith-bit)
	- [Set bit in range](#set-bit-in-range)
	- [Toggle ith bit](#toggle-ith-bit)
  

## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module1/bitmanipulation1/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module1/bitmanipulation1/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module1/bitmanipulation1/lecture/)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/4.%20Adv%20Bit%20Manipulation1(04-10-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=gnETCs6_65U)


## Bitwise Operators and Properties
> Please refer [here](https://www.geeksforgeeks.org/bitwise-operators-in-java/) to learn more about bitwise operator.
### Bitwise [logical operator](https://www.geeksforgeeks.org/java-logical-operators-with-examples/) truth table

>**AND Operator (A & B):**

| A | B | R |
|---|---|---|
| 0 | 0 | 0 |
| 0 | 1 | 0 |
| 1 | 0 | 0 |
| 1 | 1 | 1 |

> OR Operator (A | B):

| A | B | R |
|---|---|---|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 1 |

> XOR Operator (A ^ B):

| A | B | R |
|---|---|---|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

> NOT Operator (~A):

| A | R |
|---|---|
| 0 | 1 |
| 1 | 0 |


## Left and Right Shift operator
> Signed Left Shift Operator 

```left_operand  <<  number```

**Explanation**

	Every time we shift left value would be double.
	1 << n, would be 2^n

> Signed Right Shift Operator 

```left_operand  >>  number```

**Explanation**

	Every time we shift right value would be half.
	1 << n, would be 1/2^n
## Problems	
## Check ith bit
	Problem Description
		You are given two integers A and B.
		Return 1 if B-th bit in A is set
		Return 0 if B-th bit in A is unset
		Note:
		The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.

	Problem Constraints
		1 <= A <= 10^9
		0 <= B <= 30

	Input Format
		First argument A is an integer.
		Second argument B is an integer.

	Output Format
		Return an integer.

	Example
		Input 1:
			A = 4
			B = 1
		Input 2:
			A = 5
			B = 2

	Example
		Output 1:
			0
		Output 2:
			1

	Example Explanation
		For Input 1:
			Given N = 4 which is 100 in binary. The 1-st bit is unset
			so we return 0
		For Input 2:
			Given N = 5 which is 101 in binary. The 2-nd bit is set
			so we return 1
### Solution approach
	In order to check if ith bit is set or not we can use bitwise and (&) operator, we will do and with 1 and if bit is set it would return 1 else 0;
### Solution
```java
	// here we are going 1 << B to set 1 at the same bit for which we would like to check
	public int solve(int A, int B) {
        return (A & (1 << B));
    }
```
## Count Set bit
	Problem Description
		Write a function that takes an integer and returns the number of 1 bits present in its binary representation.

	Problem Constraints
		1 <= A <= 10^9

	Input Format
		First and only argument contains integer A

	Output Format
		Return an integer

	Example
		Input 1:
			11
		Input 2:
			6

	Example
		Output 1:
			3
		Output 2:
			2

	Example
		Explanation 1:
			11 is represented as 1011 in binary.
		Explanation 2:
			6 is represented as 110 in binary.
### Solution Approach
	We can use combination of bitwise and operator and right shift operator to could set bit.

### Solution
```java
public int numSetBits(int A) {
	int count = 0;
	while (A > 0) {
		count += (A & 1);
		A = A >> 1;
	}
	return count;
}
```
## Unset ith bit
	Problem Description
		You are given two integers A and B.
		If B-th bit in A is set, make it unset.
		If B-th bit in A is unset, leave as it is.
		Return the updated A value.
		Note:
			The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.

	Problem Constraints
		1 <= A <= 10^9
		0 <= B <= 30

	Input Format
		First argument A is an integer.
		Second argument B is an integer.

	Output Format
		Return an integer.

	Example
		Input 1:
			A = 4
			B = 1
		Input 2:
			A = 5
			B = 2

	Example
		Output 1:
			4
		Output 2:
			1

	Example Explanation
		For Input 1:
			Given N = 4 which is 100 in binary. The 1-st bit is already unset
		For Input 2:
			Given N = 5 which is 101 in binary. We unset the 2-nd bit
			It becomes 001 which is 1 in Decimal.
### Solution approach
	First we will check if bit is set or not, if set then we can do bitwise XOR to toggle the bit
### Solution
```java
public int solve(int A, int B) {
	if((A & (1 << B)) >0){
		A = A ^ (1 << B);
	}
	return A;
}
```
## Set bit in range
	Problem Description
		You are given two integers A and B.
		Set the A-th bit and B-th bit in 0, and return output in decimal Number System.
		Note:
			The bit positions are 0-indexed, which means that the least significant bit (LSB) has index 0.

	Problem Constraints
		0 <= A <= 30
		0 <= B <= 30

	Input Format
		First argument A is an integer.
		Second argument B is an integer.

	Output Format
		Return an integer.

	Example
		Input 1:
			A = 3
			B = 5
		Input 2:
			A = 4
			B = 4

	Example
		Output 1:
			40
		Output 2:
			16

	Example Explanation
		For Input 1:
			The binary expression is 101000 which is 40 in decimal.
		For Input 2:
			The binary expression is 10000 which is 16 in decimal
### Solution approach
	We can use technique of setting bit.
### Solution
```java
public int solve(int A, int B) {
	int result = 0;
	result = result | (1 << A);
	result = result | (1 << B);
	return result;
}
```
## Toggle ith bit
	Problem Description
		You are given two integers A and B.
		If B-th bit in A is set, make it unset
		If B-th bit in A is unset, make it set
		Return the updated A value

	Problem Constraints
		1 <= A <= 10^9
		0 <= B <= 30

	Input Format
		First argument A is an integer.
		Second argument B is an integer.

	Output Format
		Return an integer.

	Example
		Input 1:
			A = 4
			B = 1
		Input 2:
			A = 5
			B = 2

	Example
		Output 1:
			6
		Output 2:
			1

	Example Explanation
		For Input 1:
			Given N = 4 which is 100 in binary. The 1-st bit is unset
			so we make it set
		For Input 2:
			Given N = 5 which is 101 in binary. The 2-nd bit is set
			so we make it unset
### Solution approach
	We will use XOR and left shift operator to toggle the bit
### Solution
```java
 public int solve(int A, int B) {
	return A ^ (1 << B);
}
```