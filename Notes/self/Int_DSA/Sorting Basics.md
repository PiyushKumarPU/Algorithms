## Day 8 Sorting Basics

## Scope / Agenda
- [Sorting Introduction](#sorting-introduction)
- [Minimum Cost to Delete Element](#minimum-cost-to-delete-element)
- [Count of Noble Element](#count-of-noble-element)
- [Sorting Algorithm](#sorting-algorithm)
	- [Selection Sort](#selection-sort)
	- [Insertion Sort](#insertion-sort)
  

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/intermediate/sorting/basics/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/intermediate/sorting/basics/additional)

## Class Notes and Videos

1. [Class Notes](../../class_Notes/DSA%20Intermediate%20Notes/8%20Sorting%20Basics(8-09-23).pdf)
2. [Class/Lecture Video](https://youtu.be/GhkIq52gtMI)


## Sorting Introduction
> Sorting refers to rearrangement of a given array or list of elements according to a comparison operator on the elements. The comparison operator is used to decide the new order of elements in the respective data structure.
* [More Details](https://www.geeksforgeeks.org/introduction-to-sorting-algorithm/)

### Why do we need sorting?
> Searching becomes easy if data is sorted.
## Minimum Cost to Delete Element
	Given an array of N integers, we have to delete all the elements of the array.
	Before deleting and element, pay cost = sum of all the elements at that point of time.
	Find the min cost to delte all the elements
### Solution approach
	Idea 1:
		In order to keep sum min we should start with highest element and starting deleting it.
		TC : O(nlogn)
		SC : O(1)
	Idea 2:
		Sort array in descending order and calculate contrinution of each element in total cost
		Contribution of any element would be number of times respective element would contribute to total sum.
		TC : O(nlogn)
		SC : O(1)
### Solution
```java
public int idea1(int[] arr) {
	Arrays.sort(arr);
	reverse(arr);
	int totalSum = 0;
	for (int ele : arr) totalSum += ele;
	int minCost = totalSum;
	for (int i = 1; i < arr.length; i++) {
		int sumToReduce = 0;
		int temp = i - 1;
		while (temp >= 0) {
			sumToReduce += arr[temp];
			temp--;
		}
		minCost += (totalSum - sumToReduce);
	}
	return minCost;
}

public int idea2(int[] arr) {
	Arrays.sort(arr);
	reverse(arr);
	int minCost = 0;
	for (int i = 0; i < arr.length; i++) minCost += (arr[i] * (i + 1));
	return minCost;
}

private void reverse(int[] arr) {
	int start = 0, end = arr.length - 1;
	while (start < end) {
		int temp = arr[end];
		arr[end] = arr[start];
		arr[start] = temp;
		start++;
		end--;
	}
}
```
## Count of Noble Element
	Problem Description
		Given an integer array A, find if an integer p exists in the array such that the number of integers 
		greater than p in the array equals p.

	Problem Constraints
		1 <= |A| <= 2*10^5
		-10^8 <= A[i] <= 10^8

	Input Format
		First and only argument is an integer array A.

	Output Format
		Return 1 if any such integer p is present else, return -1.

	Example Input
		Input 1:
			A = [3, 2, 1, 3]
		Input 2:
			A = [1, 1, 3, 3]

	Example Output
		Output 1:
			1
		Output 2:
			-1

	Example Explanation
		Explanation 1:
			For integer 2, there are 2 greater elements in the array.
		Explanation 2:
			There exist no integer satisfying the required conditions.
### Solution approach
	Idea 1: Brute force
		Iterate through each and find number of bigger elemenet for respective element
		TC : O(n^2)
		SC : O(1)
	Idea 2:
		Sort the array in descending order and check if A[i] == i
		TC : O(nlogn)
		SC : O(1)
## Sorting Algorithm
	A Sorting Algorithm is used to rearrange a given array or list of elements according to a comparison operator on the elements. The comparison operator is used to decide the new order of elements in the respective data structure.
## Selection Sort
>Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest (or largest) element from the unsorted portion of the list and moving it to the sorted portion of the list. 
### Solution Approach:
	Start iterating from index 0 and find min element from 0, n-1 and swap min with 0th index value
	Repeat the same process till n-2th element
	TC : O(n^2)
	SC : O(1)
### Solution
```java
public int[] selectionSort(int[] A) {
	for (int i = 0; i < A.length; i++) {
		int currentMin = Integer.MAX_VALUE, currentMinIndex = -1;
		for (int j = i; j < A.length; j++) {
			if (A[j] < currentMin) {
				currentMin = A[j];
				currentMinIndex = j;
			}
		}
		int temp = A[i];
		A[i] = A[currentMinIndex];
		A[currentMinIndex] = temp;
	}
	return A;
}
```
## Insertion Sort
>Insertion sort is a simple sorting algorithm that works similarly to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed in the correct position in the sorted part.
### Solution Approach:
	To sort an array of size N in ascending order iterate over the array and compare the current element (key) to its predecessor, if the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
	TC : O(n^2)
	SC : O(1)
![Insetion](../../images/insertionsort.png)
### Solution
```java
public int[] insertionSort(int[] A) {
	for (int i = 1; i < A.length; i++) {
		int j = i - 1, current = A[i];
		while (j >= 0 && A[j] > current) {
			A[j + 1] = A[j];
			j--;
		}
		A[j + 1] = current;
	}
	return A;
}
```