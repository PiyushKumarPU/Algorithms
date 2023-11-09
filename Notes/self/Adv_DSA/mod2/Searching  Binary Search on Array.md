## Advance DSA Day 15 Searching: Binary Seach on Array

## Scope / Agenda
- [Intro to Binary search](#intro-to-binary-search)
- [Problem 1](#problem-1)
- [Problem 2](#problem-2)
- [Problem 3](#problem-3)
- [Problem 4](#problem-4)
- [Problem 5](#problem-5)

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/binary_search/arrays/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/binary_search/arrays/additional)
3. [Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module2/binary_search/arrays/lecture)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/15.%20Searching%20%20Binary%20Search%20on%20Array.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=VQjPmB8lGgM)

## Intro to Binary search
    Intro:
        What we need while performing search operation?
            a. Target:- What are we looking for
            b. Search Space :- Where are we looking for target.

    Definition:
        Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half. The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(log N).
    
    
    Condition to apply binary search:
        a. If you are able to divide search space into two parts by rejecting one of the half

    Take a look at proble 1 to understand how does it work.


## Steps to follow while applying binary search
    1. Find min(start) and max(end) value of search space
    2. Find mid element by (start + end)/2
    3. Repeat step 4 to 6 until start <= end
    4. Check of target element present at mid index, if present return the required value.
    5. if target is greater than the value present at mid then discard the left half of the search space by setting start = mid + 1
    6. if target is less then the value present at mid then discard the right half of search space by setting end = mid -1 

## Problem 1
    Problem Statement:
    Given a sorted array of unique elements, search for a target and return its index, if not present return -1.
        Example:
            Given array : {1, 3, 5, 7, 9, 10, 11, 13, 15, 17, 19, 30, 35, 40}
            Target :
                10 -> 5 
                35 -> 12
                37 -> -1 (Not Present)
                
        Approach 1:
            Iterate through whole array and look for the target if present then return index or return -1.
            TC : O(N)
            SC : O(1)
        Approach 2:
            As elements of array is sorted we can apply binary search here and find the target.
            TC : O(logn)
            SC : O(1)
        Approach 2 Exaplanation
         Search space : [0,n-1]
         Targets :
            10 --> 5
        
            Lets apply binary search on above array:
                At start s = 0 and e will be n-1, basically we are taking lower and upper bound of search space
            | s | e |mid|action        |
            |---|---|---|--------------|
            | 0 |13 | 6 | move left    |  Target not found and target is < mid then move left
            | 0 | 5 | 2 | move right   |  Target not found and target is > mid then move right
            | 3 | 5 | 4 | move right   |  Target not found and target is > mid then move right
            | 5 | 5 | 5 | Target found |  Target found then return index

### Solution:
```java
public static int approach2(List<Integer> list, Integer target) {
    int start = 0, end = list.size() - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        int currentElement = list.get(mid);
        if (target.equals(currentElement)) return mid;
        else if (target > currentElement) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return -1;
}
```

## Problem 2
    Problem Statement:
    Find the first occurrence of a element in sorted array with duplicates.

    Given array:
    arr = {2,2,5,5,5,5,8,10,12,15}
    target = 5 --> 2

    Approach 1:
        Perform linear search and return first index of target.
        TC : O(N)
        SC : O(1)
    Approach 2:
        As given array is sorted we can apply binary search here.
        Steps to perform:
            a. Find min and max val of search space, in above case we need to search whole array so start = 0 and end = n-1
            b. find mid index (0 + n -1)/2
            c. repeat step c to f until start <= end
            d. if arr[mid] == target and arr[mid-1] < target then return mid
            e. if arr[mid] >= target, move left by setting end = mid -1
            f. if arr[mid] < target, move right by setting start = mid +1 
### Solution
```java
public int findFirstOccurrence(List<Integer> A, Integer target) {
    int start = 0, end = A.size() - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (Objects.equals(A.get(mid), target) && (mid == 0 || A.get(mid - 1) < target))
            return mid;
        else if (A.get(mid) >= target) end = mid - 1;
        else start = mid + 1;
    }
    return 0;
}
```

## Problem 3
    Problem Statement:
        Given a sorted array where every element appears twice except one element that appears only once, find that unique element.
    
    Given Array:
        arr1 = {2,2,5,7,7,10,10}
            ans : 5
        arr2 = {1,1,5,5,7,7,10,13,13,18,18}
            ans : 10

    Approach 1:
        Create frequency map using array elements and find the element in frequency 1.
            TC : O(N)
            SC : O(N) --> Freq map will take n/2 + 1 space to hold the frequency
    Approach 2:
        Before getting into approach 2, let observe the array carefully.
        index   0  1  2  3  4  5   6
        arr1 = {2, 2, 5, 7, 7, 10, 10}

        index   0  1  2  3  4  5  6   7   8   9   10
        arr2 = {1, 1, 5, 5, 7, 7, 10, 13, 13, 18, 18}
    Observation:
        If we observe the index of array carefully, all the twin element present left to the unique element is in even-odd pair and all the twin element present right to unique element is in odd-even pair.

        Cant we use this observation to discard search space??

    Steps to find unique element:-
        a. Define start = 0 and end = n-1 as search space is [0,n-1]
        b. calculate mid index = start + (end-start)/2
        c. Repeat step d to f untill start <= end
        d. if arr[mid] != arr[mid -1 ] and arr[mid] != arr[mid + 1] return arr[mid]
        e. Find twin index 
            i. if arr[mid] = arr[mid-1] twin index = mid -1
            ii. else twin index = mid
        f. if twin index is even then move right else move left

### Solution 
```java
public int findUniqueElement(List<Integer> A) {
    int start = 0, end = A.size() - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (
                (mid == 0 || !Objects.equals(A.get(mid), A.get(mid - 1))) &&
                        (mid == A.size() - 1 || !Objects.equals(A.get(mid), A.get(mid + 1)))) return A.get(mid);

        int ti = A.get(mid).equals(A.get(mid - 1)) ? mid -1 : mid;
        if(ti % 2 == 0) start = mid + 1;
        else end = mid -1;
    }
    return 0;
}
```

## Problem 4
    Problem Statement:
    Find peak element in increasing-decreasing array.
        Given array:
            arr1 = {1, 3, 8, 10, 7, 4}    Ans --> 10
            arr2 = {1, 5, 9, 11, 7, 6, 2} And --> 11
        Approach 1:
            Find max element in the array and return it
            TC : O(N)
            SC : O(1)
        Approach 2:
        
        Note: Please take a look at Diagram for array 1 and Diagram for array 2 to understand how can we apply binary search here.

        If we look at visul representation carefully, 
        we can see that array is sorted till pick element 
        in ascending order and sorted in descending order from 
        peak element till last element of array.
    Steps to find unique element:-
        a. Define start = 0 and end = n-1 as search space is [0,n-1]
        b. calculate mid index = start + (end-start)/2
        c. Repeat step d to f untill start <= end
        d. if arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1] return arr[mid]
        e. if arr[mid] > arr[mid - 1], it means mid is in ascending order part of array then move right by setting start = mid +1
        f. if arr[mid] > arr[mid + 1], it means mid is in descending order part of array then move left by setting start = mid - 1

### Solution
```java
public int solve(List<Integer> A) {
    int size = A.size();
    if (size == 1) return A.get(0);
    int start = 0, end = size - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if ((mid == 0 || A.get(mid) >= A.get(mid - 1)) && (
                mid == (size - 1) || A.get(mid) > A.get(mid + 1))) return A.get(mid);
        else if (mid == 0 || A.get(mid - 1) < A.get(mid)) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return 0;
}
```

## Problem 5
    Problem Statement:
    Given a sorted array with duplicates, count total occurrences of a given num.
        Approach:
            a. We can create frequency map of given array and find the frequency of target element. 
            b. can we find first index of target and last index of target using binary search and calculate no of occurences?
        Steps to find first index of target :-
            a. Define start = 0 and end = n-1 as search space is [0,n-1]
            b. calculate mid index = start + (end-start)/2
            c. Repeat step d to e untill start <= end
            d. if arr[mid] = target then update first index = mid
            e. if arr[mid] > target or arr[mid - 1] == target, then move left by setting end = mid - 1 otherwise move right by setting start = mid + 1

        ## Use the same strategy to find last index of same target
            To find last index we need to move right untill we find last target

### Solution
```java
public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
    ArrayList<Integer> result = new ArrayList<>(2);
    if (A.size() == 1) {
        if(A.get(0) == B){
            result.add(0);
            result.add(0);
            return result;
        }
        return result;
    }
    int start = 0, end = A.size() - 1, leftMostIndex = Integer.MAX_VALUE, rightMostIndex = Integer.MIN_VALUE;
    while (start <= end) {
        int mid = (start + end) / 2;
        if (A.get(mid) == B) leftMostIndex = Math.min(leftMostIndex, mid);
        if ((A.get(mid) == B && (mid > 0 && A.get(mid - 1) == B)) || A.get(mid) > B) {
            end = mid - 1;
        } else start = mid + 1;
    }
    if(leftMostIndex != Integer.MAX_VALUE){
        start = leftMostIndex;
        end = A.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A.get(mid) == B) rightMostIndex = Math.max(rightMostIndex, mid);
            if ((A.get(mid) == B && (mid < (A.size() - 1) && A.get(mid + 1) == B)) || A.get(mid) < B) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    result.add(leftMostIndex != Integer.MAX_VALUE ? leftMostIndex : -1);
    result.add(rightMostIndex != Integer.MIN_VALUE ? rightMostIndex : -1);
    return result;
}
```

## Diagrams

 ### Diagram for array 1
  ![Viasual Representation of Array](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/e2416ecaa43a3d5789d1c4e6b31c494cbc62bbd8/Notes/images/Peak_dgm_1.png?raw=true)

### Diagram for array 2
![Visual Representation of Array](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/e2416ecaa43a3d5789d1c4e6b31c494cbc62bbd8/Notes/images/Peak_dgm_2.png?raw=true)