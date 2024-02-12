## Day 4 Arrays Prefix Sum

## Scope / Agenda
- [Prefix Sum](#prefix-sum)
- [Queries in Range](#queries-in-range)
- [Special Index/Balance Index/Fair Arrays](#special-indexbalance-indexfair-arrays)
	- [Sum of Even indices in the array](#sum-of-even-indices-in-the-array)
	- [Sum Of Odd indices in the array](#sum-of-odd-indices-in-the-array)
  

## Problems and solutions
1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../class_Notes/DSA%20Intermediate%20Notes/4%20Prefix%20Sum(30-08-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=taGp_klxlKQ)


## Prefix Sum
> It is a technique to store result of repeated and similar operation for each index in a separate array and use it whenever required. 
## Queries in Range
	Problem Description
		You are given an integer array A of length N.
		You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
		For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
		More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.


	Problem Constraints
		1 <= N, M <= 10^5
		1 <= A[i] <= 10^9
		0 <= L <= R < N

	Input Format
		The first argument is the integer array A.
		The second argument is the 2D integer array B.

	Output Format
		Return an integer array of length M where ith element is the answer for ith query in B.

	Example Input
		Input 1:
			A = [1, 2, 3, 4, 5]
			B = [[0, 3], [1, 2]]
		Input 2:
			A = [2, 2, 2]
			B = [[0, 0], [1, 2]]

	Example Output
		Output 1:
			[10, 5]
		Output 2:
			[2, 4]

	Example Explanation
	Explanation 1:
		The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
		The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
	Explanation 2:
		The sum of all elements of A[0 ... 0] = 2 = 2.
		The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
### Solution 
```java
		public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
				ArrayList<Long> result = new ArrayList<>(B.size());
				// calculate prefix sum
				ArrayList<Long> prefixSum = new ArrayList<>(A.size());
				prefixSum.add(Long.valueOf(A.get(0)));
				for (int i = 1; i < A.size(); i++) {
					prefixSum.add(prefixSum.get(i - 1) + A.get(i));
				}
				for (ArrayList<Integer> row : B) {
					int L = row.get(0);
					int R = row.get(1);
					result.add(prefixSum.get(R) - (L > 0 ? prefixSum.get(L - 1) : 0));
				}
			return result;
		}
```
## Special Index/Balance Index/Fair Arrays
	Problem Description
		Given an array, arr[] of size N, the task is to find the count of array indices such that removing an
		element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

	Problem Constraints
		1 <= N <= 10^5
		-10^5 <= A[i] <= 10^5
		Sum of all elements of A <= 10^9

	Input Format
		First argument contains an array A of integers of size N

	Output Format
		Return the count of array indices such that removing an element from these indices makes the sum of
		even-indexed and odd-indexed array elements equal.

	Example Input
		Input 1:
			A = [2, 1, 6, 4]
		Input 2:
			A = [1, 1, 1]

	Example Output
		Output 1:
			1
		Output 2:
			3
### Solution
```java
	public int solve(int[] A) {
        long[] PFEven = new long[A.length];
        long[] PFOdd = new long[A.length];
        PFEven[0] = A[0];
        PFOdd[0] = 0;
        int count = 0;
        for (int index = 1; index < A.length; index++) {
            PFEven[index] = PFEven[index - 1] + (index % 2 == 0 ? A[index] : 0);
            PFOdd[index] = PFOdd[index - 1] + (index % 2 != 0 ? A[index] : 0);
        }

        // derived
        long lastEvenIndex = PFEven[A.length - 1];
        long lastOddIndex = PFOdd[A.length - 1];
        for (int index = 0; index < A.length; index++) {
            long evenSum = (index > 0 ? PFEven[index - 1] : 0) + (lastOddIndex - PFOdd[index]);
            long oddSum = (index > 0 ? PFOdd[index - 1] : 0) + (lastEvenIndex - PFEven[index]);
            if (evenSum == oddSum) count++;
        }
        return count;

    }
```
## Sum of Even indices in the array
	Problem Statetement
		Given an array arr[n] and Q queries, for each query[L-R] find sum of all even indices element in given range.
### Solution approach
	We will use same approach as Queries in range problem but there would be a twist, we will calculate prefix sum for only even index element and we will consider odd element value as 0.
## Sum Of Odd indices in the array
	Problem Statetement
		Given an array arr[n] and Q queries, for each query[L-R] find sum of all odd indices element in given range.
### Solution approach
	We will use same approach as Queries in range problem but there would be a twist, we will calculate prefix sum for only odd index element and we will consider even element value as 0.