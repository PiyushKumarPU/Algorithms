## Advanced DSA Day 23 Quick Sort and Comparator Problems

## Scope / Agenda
- [Pivot Partition](#pivot-partition)
- [Quick Sort](#quick-sort)
- [Comparator Problems](#comparator-problems)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/sort/quick/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/sort/quick/additional)
3. [Self Practise Problems](https://github.com/rajpiyush220/Algorithms/blob/master/problems/src/main/java/com/learning/scaler/advance/module2/sort/quick/lecture)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/23%20Quick%20Sort%20and%20Comparator%20Problems.pdf)
2. [Class/Lecture Video](https://youtu.be/pBX58fe7zgA)


## Pivot Partition
    Given an integer array, consider first element as pivot elemenet. Rearrange the elements in such a way that for all 
    i: 
        if A[i] <= p then it should present on left side
        if A[i] > p then it should present on right side

    Note: Given that all elements are distinct.
### Solution Approach:
    Approach 1:
        Sort the array.
        TC : O(nlogn)
        SC : Space taken by sorting algo
    Approach 2:
        Use two pointer technique
        Step 1: Keep start pointer at 1st index and end pointer at last
        Step 2: Our target is to keep all the element less than or equal to pivot to the left of the array
        and all the element greater than the pivot to the right of the array
        Step 3: Check start element and end element 
            if start is greater than pivot and end is less or equal to pivot then swap
            If start is less or equal to pivot start++
            If end is greater than pivot end--
        Step 4: Repeat this process untill start <= end
        step 5: Swap oth index or pivot element with the end index element
### Solution
```java
public int[] pivot(int[] A) {
    if (A == null || A.length == 1) return A;
    int start = 1, end = A.length - 1, pivot = A[0];
    while (start <= end) {
        if (A[start] > pivot && A[end] <= pivot) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        } else if (A[start] <= pivot) start++;
        else end--;
    }
    A[0] = A[end];
    A[end] = pivot;
    return A;
}
```
## Quick Sort
>QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.

### Working principle
    The key process in quickSort is a partition(). The target of partitions is to place the pivot (any element can be 
    chosen to be a pivot) at its correct position in the sorted array and put all smaller elements to the left of 
    the pivot, and all greater elements to the right of the pivot.

    Partition is done recursively on each side of the pivot after the pivot is placed in its 
    correct position and this finally sorts the array.
![Sort2](../../../images/QuickSort2.png)

### Choice of Pivot:
- Always pick the first element as a pivot.
- Always pick the last element as a pivot
- Pick a random element as a pivot
- Pick the middle as the pivot.

### Steps to follow while performing quick sort
    Step 1: Partion the complete array selecting first element as pivot element
        and partition array around that
    Step 2: Call quick sort separetely on left and right partition
    Step 3: Repeat this process untill any of partiion becomes null i.e. there is only one or 
    zero element present int partition

### Time and space complexity
    Best Case: When selected pivot always comes in middle
        in this case left and right partition size would equal and it will take max on logn 
        height to reach till single element
        TC : O(nlogn)
        SC : O(logn)
    Worst case : When selected parition is either smallest ot largest element
        In this case all the element will go in one partition and it will take n height
        to reach till single element
        TC : O(n^2)   --> N(N+1)/2
        SC : O(n)
### Psuedo code
```java
    void quickSort(int[] arr, int start, int end){
        // if start and end is same that means only one element
        // if start is greater than end  that means its invalid index
        if(Start >= end) return;
        int pivotIndex = partition(arr, int start, int end);    // select pivot element of your choice but
        // randon pivot selection gives best performance of quick sort
        quickSort(arr,start, pivotIndex -1);
        quickSort(arr,pivotIndex +1,end);
    }
```
## Time complexity comparision for first/last element as pivot and random element as pivot
|  | Merge Sort | Quick Sort |
|----------|----------|----------|
| TC | NlogN | Nlogn --> N^2 |
| SC | logN + N | logN --> N |

## Comparator Problems
> Please go through below links to learn more about comparator
- [Comparator](https://www.geeksforgeeks.org/comparator-interface-java/)
- [API](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)
## Ten Digit sorting
    Problem Description
        Given an array A of N integers. Sort the array in increasing order of the value at the tens place
        digit of every number.

        If a number has no tens digit, we can assume value to be 0.
        If 2 numbers have same tens digit, in that case number with max value will come first
        Solution should be based on comparator.

    Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^9

    Input Format
        First argument A is an array of integers.

    Output Format
        Return the array after sorting

    Example Input
        Input 1:
        A = [15, 11, 7, 19]
        Input 2:
        A = [2, 24, 22, 19]

    Example Output
        Output 1:
        [7, 19, 15, 11]
        Output 2:
        [2, 19, 24, 22]

    Example Explanation
        For Input 1:
        The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
        and that of 19, 15 and 11 is 1.
        For Input 2:
        The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
        that of 19 is 1 and that of 22 and 24 is 2.
### SOlution
```java
    public ArrayList<Integer> self(ArrayList<Integer> A) {
        A.sort((o1, o2) -> {
            Integer first = o1, second = o2, firstDigit = 0, secondDigit = 0;
            if(first > 9){
                for(int i = 0; i < 2; i++){
                    firstDigit = first % 10;
                    first /= 10;
                }
            }
            if(second > 9){
                for(int i = 0; i < 2; i++){
                    secondDigit = second % 10;
                    second /= 10;
                }
            }
            return firstDigit.equals(secondDigit) ? o2.compareTo(o1) : firstDigit.compareTo(secondDigit);
        });
        return A;
    }
```
