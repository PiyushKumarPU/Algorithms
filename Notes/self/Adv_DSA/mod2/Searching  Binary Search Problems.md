## Advance DSA Day 16 Searching : Binary Search Problems


## Scope / Agenda
- [Searching in Rotated sorted Array](#searching-in-rotated-sorted-array)
- [Find Square root of a number](#find-square-root-of-a-number)
- [Median of two sorted Array](#median-of-two-sorted-array)
- [Ath magical number](#ath-magical-number)
## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/problems/assignment)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/problems/additional)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/16.%20Searching%20Binary%20Search%20Problems.pdf)
2. [Class/Lecture Video](https://youtu.be/Z1yhISxtoSg)

## Searching in rotated sorted Array
    Problem Statement:
        Find the target and return its index in a rotated sorted array, array has all the unique elements.
        arr = {2,4,8,10,15}
        Rotate it 2 times and that will be input
        arr(final input) = {10,15,2,4,8}
        Target: 2
        ans : 2
#### Solution
    Approach 1:
        Traverse through array and find the target element, if found return index or else return -1.
        TC : O(N)
        SC : O(1)
        Very Naive solution

    Approach 2:
        There could two scenrio here, either array is rotated or it may not be rotated.
        If not rotated we can apply binary search directly and get the target index
        If array is rotated:
            If you observe rotated array carefully, it is divided into two part and each part is
            self sorted array. Now we need to find the way to search target in two part
            arr = [4, 5, 6, 7, 0, 1, 2, 3]
            here part 1 is [4, 5, 6, 7] and part 2 is [0, 1, 2, 3]
        how to apply BS of these two part and how to find the elements of part1 and part2
        How to decide which elements lands on which part?
            If we observe both the part carefully, all the elements in part1 is either equal or greater to the first element of given array
            basically
                part 1 : element >= A[0]
                part 2: element < A[0]

            arr  = [part 1, part 2]
        Here comes the actual approach to apply binary search:
            Basic issue here is when to move left and when to move right??
            Lets list out all the possible scenario here
                a. mid is in part 1 and target is in part 2
                    we need to shift right as target is in part 2 and mid is in part 1
                b. mid is in part 1 and target is in part 1
                    apply bs directly as mid and target is in same part
                c. mid is in part 2 and target is in part 1
                    we need to shift left as target is in part 1 and mid is in part 2
                d. mid is in part 2 and target is in part 2
                    apply bs directly as mid and target is in same part

#### Code of Approch 2
```java
public int solve(final ArrayList<Integer> A, Integer target) {
    int start = 0, end = A.size() - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (A.get(mid).equals(target)) return mid;
        // check if target is in part 1
        if (target >= A.get(0)) {
            // if mid is in part 1
            if (A.get(mid) >= A.get(0)) {
                // apply bs here
                if (A.get(mid) > target) end = mid - 1;
                else start = mid + 1;
            } else {
                end = mid - 1;
            }
        } else {
            // target is in part2
            // if mid is in part 1
            if (A.get(mid) >= A.get(0)) {
                start = mid + 1;
            } else {
                if (A.get(mid) > target) end = mid - 1;
                else start = mid + 1;
            }
        }
    }
    return -1;
}
```
## Find Square root of a number
    Problem Statement:
        Given a +ve number N, find floor(sqrt(N)) i.e. find the number such that number * number <= N
        | N  | ans |
        |----------
        | 25 |  5  |
        | 20 |  4  |
        | 10 |  3  |
    Approach 1:
        Traverse from 1 to N- 1 and check each element
        TC : N
        SC : O(1)
    Approach 2:
        Traverse from 1 to <= sqrt(N)
        TC : O(sqrt(N))
        SC : O(1)
    Approach 3 : Use binary search 
        Define seach space as [1,N] and use binary search to find number
### Solution
```java
public int sqrt(int A) {
    int ans = 0;
    long start = 1, end = A;
    while (start <= end) {
        long mid = (start + end) / 2, square = mid * mid;
        if (square == A) return (int) mid;
        else if (square > A) end = mid - 1;
        else {
            start = mid + 1;
            ans = (int) mid;
        }
    }
    return ans;
}
```
## Median of two sorted Array
> Median : Middle element of sorted array if array size is even and average of middle elements if array size is odd. 

    Problem Statement:
        Find the median of two sorted array.
        Example :
            arr1 = {1,4,5}
            arr2 = {2,3}
            ans : 3

        Example:
            arr1 = {1,2,3}
            arr2 = {4}
            ans : (2+3)/2 = 2.5
    Approach 1:
        merge both the array and sort it and find median
            TC : (M+N)log(M+N) + O(1)  (M+N)log(M+N) --> TC of merge sort
    Approach 2: Using Binary search
        Will divide both the array in partition and then calculate median.
            TC : log(min(M,N))
            SC : O(1)

## Ath magical number
    Problem Statement
        You are given three positive integers, A, B, and C.
        Any positive integer is magical if divisible by either B or C.
        Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
        Note: Ensure to prevent integer overflow while calculating.
    Problem Constraints
        1 <= A <= 10^9
        2 <= B, C <= 40000

    Example
        A = 1
        B = 2
        C = 3
        Output: 2
    Example:
        A = 4
        B = 2
        C = 3
        Output: 6
    
    Approach 1: Bruteforce approach
        start from 1 till min(B,C) * A and check if number is divisible by B and C, if yes then increase count by 1
        for(int i = 1; i <= min(B,C) * A){
            if(i % B == 0 || i % C == 0) {
                count++;
                if(count == A) return i;
            }
        }

        TC : O(min(B,C) * A)

    Approach 2: Using binary search
    Consider a target value x and if we try to find the number of magical number till x it would be 
    X/A + X/B - X/LCM(A,B)
    Exaplanation:
        Lets take A = 3 and B = 2 and find multiple of A and B and observe carefully
        A -> 3 6 9 12 15 18 ....
        B -> 2 4 6 8 10 12 14 16 18 ....
    If we observe it carefully, some of the numbers are duplicate in both the series and we have to count it only once to get the proper result. Those numbers are multiple of LCM(A,B). 

    By following above observation we can derive a range and perform binary search between range to find the required magical number

    Steps to find Ath magical number using binary search
        1. start = 1 and end = min(B,C) * A
        2. find mid and count magical number till mid
        3. if count is greater or equal to the desired count then assign it to answer and try to shrink the range to find any lesser mid which will have same count as desired one
        4. or else increase the range
    
### Psuedo code:
```java
    start = 1, end = min(B,C) * A
    while(start <= end){
        int mid = start + (end - start)/2;
        count magical number till mid
        if( count >= A){
            ans = mid;
            end = mid +1
        }else start = mid +1;
    }
    return ans;
```

### Complete Solution:
```java
    public int solve(int A, int B, int C) {
        long ans = 0, lcm = findLCM(B, C);
        long start = 1, end = (long) A * Math.min(B, C);
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long count = (mid / B) + (mid / C) - (mid / lcm);
            if (count >= A) {
                ans = (mid % 1000000007);
                end = mid - 1;
            } else if (count < mid) {
                start = mid + 1;
            }
        }
        return (int) ans;
    }

    private int findLCM(int a, int b) {
        int greater = Math.max(a, b);
        int smallest = Math.min(a, b);
        for (int i = greater; ; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }
```

        