## Advance DSA Day 38 Heaps 2: Problems

## Scope / Agenda
- [Heap sort](#heap-sort)
- [kth Largest Element](#kth-largest-element)
- [Sort Nearly Sorted Array](#sort-nearly-sorted-array)
- [Median of stream of Integers](#median-of-stream-of-integers)


## Problems and solutions
1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/38.%20Heaps%202%20Problems.pdf)
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
        TC : nlogn + logn  nlogn --> to construct min heap using library func and logn to extract min element from heap
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
## kth Largest Element
## Sort Nearly Sorted Array
## Median of stream of Integers
