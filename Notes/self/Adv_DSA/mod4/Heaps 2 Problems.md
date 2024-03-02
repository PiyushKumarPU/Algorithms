## Advance DSA Day 38 Heaps 2: Problems

## Scope / Agenda
- [Heap sort](#heap-sort)
- [kth Largest Element](#kth-largest-element)
- [Sort Nearly Sorted Array](#sort-nearly-sorted-array)
- [Median of stream of Integers](#median-of-stream-of-integers)


## Problems and solutions
1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/heap2/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/heap2/additional)
3. [Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/heap2/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/38.%20Heaps%202%20Problems.pdf)
2. [Class/Lecture Video](https://youtu.be/7UNVKZZaQwI)


## Heap sort 
    Problem Description:
        Sort the given array using heap
    arr = [3,1,9,4,6,2,10,5]
    Idea 1: 
        Use normal sort and return the result
        TC : O(nlogn)
        SC : Depends upon space taken by sorting algorithm
    Idea 2:
        1. Construct min heap using given array
        2. Extract min/root element and add into another array called ans array
        3. reconstruct min heap using remaining element of array
        4. And keep repeating it until remainig array has no element.
        TC : nlogn + nlogn  nlogn --> to construct min heap using library func and nlogn to extract min element from heap
        SC : O(n)  space taken by ans array
    Idea 3: with constant space
        1. Construct max heap using the element of given array 
        2. Extract max and swap it with the last element of array, basically we are trying to keep max element out of heap to 
            process remaining elements.
        3. repeat same process untill remaining size is zero.
        TC : nlogn + logn  nlogn --> to construct min heap using library func and logn to extract min element from heap
        SC : O(1)  Space optimized

### Psuedo code:
#### Idea 1 : Using min heap
```java
    // construct Priority queue
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.addAll(<array elements>)
    arr[] ans;
    while(!minHeap.isEmpty()){
        ans[index] = minHeap.poll();
    }
    return 
```
## Ath Largest Element
    Problem Description
        Given an integer array B of size N.
        You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
        NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.


    Problem Constraints
        1 <= N <= 100000
        1 <= A <= N
        1 <= B[i] <= INT_MAX

    Input Format
        The first argument is an integer A.
        The second argument is an integer array B of size N.

    Output Format
        Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].

    Example Input
        Input 1:
            A = 4
            B = [1 2 3 4 5 6]
        Input 2:
            A = 2
            B = [15, 20, 99, 1]

    Example Output
        Output 1:
            [-1, -1, -1, 1, 2, 3]
        Output 2:
            [-1, 15, 20, 20]

    Example Explanation
        Explanation 1:
        for i <= 3 output should be -1.
        for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
        for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
        for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
        So, output array is [-1, -1, -1, 1, 2, 3].
        Explanation 2:
        for i <= 1 output should be -1.
        for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
        for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
        for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
        So, output array is [-1, 15, 20, 20].

### Solution approach
## Sort Nearly Sorted Array
## Median of stream of Integers
