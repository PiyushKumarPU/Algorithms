## Advance DSA Day 18 Two Pointers

## Scope / Agenda
- [Intro to Two Pointers](#intro-to-two-pointers-technique)
- [Pair With given sum 1](#pair-with-given-sum-1)
- [Pair With given sum 2](#pair-with-given-sum-2)
- [pair With given Difference](#pair-with-given-difference)
- [Subarray with given sum](#subarray-with-given-sum)
- [Container with most water](#container-with-most-water)
  

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Lecture Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/18.%20Adv%20Two%20Pointers%20Technique.pdf)
2. [Class/Lecture Video](https://youtu.be/Ni72YaTQOlU)

## Intro to Two Pointers Technique
    The "two pointers" technique is a common algorithmic approach used in computer science and programming. 
    It involves using two pointers to traverse a data structure, usually an array or a linked list, 
    in a way that helps solve a particular problem more efficiently.
### Common Scenario for two pointers technique
    1. Two pointers on same direction
        a. Scenario: Given a sorted array, find a pair of elements that sum to specific target.
        b. Approach: Use two pointer one at start of the array and other at end of the array,
         move them towards each other until target is reached or pointers meet.
    2. Two Pointers on Opposite Directions
        a. Scenario: Given an array, reverse it in-place.
        b. Approach: Use two pointers starting from opposite ends and swap elements 
        until they meet in the middle
    3. Two Pointers with a Fast and Slow Pointer:
        a. Scenario: Detect a cycle in a linked list.
        b. Approach: Use two pointers, one advancing faster than the other. If there is a cycle, 
        the fast pointer will eventually meet the slow pointer.   
        

### Psuedo code for scenario 1
```java
    int left = 0, right = n - 1;
    while (left < right) {
        int currentSum = A[left] + A[right];
        if (currentSum == target) {
            return true;
        } else if (currentSum < target) {
            left++;
        } else {
            right--;
        }
    }
```
### Psuedo code for scenario 2
```java
    int left = 0,right = n - 1;
    while (left < right) {
        // Swap elements at indices left and right
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
        left++;
        right--;
    }
```
### Code for Scenarion 3
```java
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
```


## Visual Representation of two pointer technique to find targe sum

- ![Target sum](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/47fde838d376eab262a223c329c106d2899353c6/Notes/images/Two_pointers_for_sum1.png?raw=true)
- ![Target Sum](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/47fde838d376eab262a223c329c106d2899353c6/Notes/images/Two_pointers_for_sum.png?raw=true)


## Pair With given sum 1
    Problem Statement:
        Given a sorted array of integer A and an integer k, find any pair (i,j)
        such that A[i] + A[j] = k and (i != j).
        Note : TC should be O(N) and with constant space.
        Example:
            arr1 = {-5,-2,1,8,10,12,15}
            k = 11
            ans = (2,4)
    Approach 1: Brute Force
        Iterate through each pair and find if sum of pair is equal to k and i != j then return indices of pair or return (-1,-1).

    Approach 2:
        Iterate through upper or lower triangle of the pair index like below and return first pair
        TC : O(n^2)
        SC: O(1)
    Approach 3: Using binary search
        If we observe the problem carefully, at any given index i we are looking for k - A[i] to find the sum equals to k.
        Here search space will be [i+1, n-1] and in this search space we will find k - A[i] as target element
        TC : nlogn
        SC: O(1)

### Psuedo code for Approach 2
```java
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(A[i] + A[j] == k) return true;
        }
    }
    return false
```

### Psuedo code for Approach 3
```java
    for(int i = 0; i < n; i++){
        int target = k - A[i];
        // do binary search in [i+1, n-1] search space and if target present then return true else return false.
    }
```
    Approach 4: Using Two Pointer technique
        Steps to follow: Keep in mind that array is sorted and we will use that properties
            a. Will set two pointer one at start(0) and other at end(n-1)
            b. Repeat below steps untill start < end or target is matching
            c. Check if some of start and end element is target element
            d. If yes return true
            e. If no, check id sum is greater than target, if yes reduce end by 1 to
             exclude bigger and include smaller element
            f. if sum is less than target, increase start by 1 to include bigger element
            TC: O(N)
            SC: O(1)
### Solution:
```java
    public List<Integer> pairWithTargetSum(List<Integer> arr, int target) {
        List<Integer> result = new ArrayList<>(2);
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            int sum = arr.get(start) + arr.get(end);
            if (sum == target) {
                result.add(start);
                result.add(end);
                return result;
            } else if (sum < target) {
                start++;
            } else end--;
        }
        return result;
    }
```

## Pair With given sum 2
    Problem Statement:
        Given an sorted array of integer A without duplicates and an integer k,
        find all the pair such that A[i] + A[j] = k and (i != j).
        Note : TC should be O(N) and with constant space.
        Example:
            arr1 = {1,2,3,4,5,6,8}
            k = 10
            ans = 2
        Approach: Using two pointer
            Steps to follow: Keep in mind that array is sorted and we will use that properties
                a. Will set two pointer one at start(0) and other at end(n-1)
                b. Repeat below steps untill start < end
                c. Check if some of start and end element is target element
                d. If yes increase count
                e. If no, check id sum is greater than target, if yes reduce end by 1 to
                exclude bigger and include smaller element
                f. if sum is less than target, increase start by 1 to include bigger element
                TC: O(N)
                SC: O(1)
### Solution
```java
    public static int pairCount(List<Integer> inputs, int target) {
        int start = 0, end = inputs.size() - 1, count = 0;
        while (start < end) {
            int currentSum = inputs.get(start) + inputs.get(end);
            if (currentSum == target) {
                count++;
                start++;
                end--;
            } else if (currentSum < target) start++;
            else end--;
        }
        return count;
    }
```
## Pair with given sum 3
    Problem Statement:
        Given a sorted array of integer A with duplicates and an integer k, 
        find all the pair such that A[i] + A[j] = k and (i != j).
        Note : TC should be O(N) and with constant space.
        Example:
            arr1 = {1, 3, 3, 10,10,10,15}
            k = 13
            ans = 6
        Approach 1:
            a. Create frequency array and store frequency of each element
            b. Use Problem1 approach to find pair, if found then increase count by freq of start * freq of end
            TC: O(N)
            SC: O(N)
        Approach 2:
            Will use two pointer technique
            Steps to follow:
                a. Use problem 1 sum technique to find pair
                b. If current sum == target
                    a. Check frequency for start and end element and increase sum
                c. if sum < target increase start by 1
                d. if sum > target, reduce end by 1

### Solution for approach 1
```java
    public static int countPairApproach1(List<Integer> arr, int target) {
        Map<Integer, Long> freqMap = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> uniqueValues = new ArrayList<>(freqMap.keySet());
        int start = 0, end = uniqueValues.size() - 1, count = 0;
        while (start < end) {
            int sum = uniqueValues.get(start) + uniqueValues.get(end);
            if (sum == target) {
                count += (int) (freqMap.get(uniqueValues.get(start)) * freqMap.get(uniqueValues.get(end)));
                start++;
                end--;
            } else if (sum < target) start++;
            else end--;
        }
        return count;
    }
```
### Solution for approach 2
```java
    public static int countPairApproach2(List<Integer> arr, int target) {
        int start = 0, end = arr.size() - 1, count = 0;
        while (start < end) {
            int currentSum = arr.get(start) + arr.get(end);
            if (currentSum == target) {
                // count freq of start and end element if duplicate present
                int iCopy = start, jCopy = end;
                while (Objects.equals(arr.get(start), arr.get(iCopy))) {
                    iCopy++;
                }
                while (Objects.equals(arr.get(end), arr.get(jCopy))) {
                    jCopy--;
                }
                count += ((iCopy - start) * (end - jCopy));
                start = iCopy;
                end = jCopy;
            } else if (currentSum < target) start++;
            else end--;
        }
        return count;
    }
```
### Pair with given difference
    Problem Statement:
        Given a sorted array of integer A and an integer k, 
        find any pair such that A[j] - A[i] = k and (i != j).
        Note : TC should be O(N) and with constant space.
        Example:
            arr1 = {-5,-2,1,8,10,12,15}
            k = 11
            ans = (2,5)
        Approach 1:
            Check all pair and find the pair with diff k
            TC : O(n^2)
            SC: O(1)
        Approach 2:
            We need to find A[j] - A[i] = K
            Fix i and look for respective j in search space [i+1,n-1]
            TC: nlogn
            SC: O(1)
        Approach 3: Two pointers
            We need to find initial value of start and end so that at one point of time we should update
            only one value
            We can start with first two element or last two element.
            Steps to follow
                a. Decide start and end index and calculate diff
                b. if diff is greater than target then either we need to increase end value or decrease start value
                c. Use above approach to find the solution
            TC : O(N)
            SC : O(1)

### Solution for Approach 3
```java
    public static List<Integer> pairWithGivenDiff(List<Integer> arr, int target) {
        List<Integer> result = new ArrayList<>(2);
        int start = 0, end = 1;
        while (end < arr.size()) {
            int diff = arr.get(end) - arr.get(start);
            if (diff == target) {
                result.add(start);
                result.add(end);
                return result;
            } else if (diff < target) end++;
            else start++;
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
```
## Subarray with given sum
    Problem Statement:
        Given an integer array with +ve elements and an integer k,
        check if there exists a subarray with given sum = k.
        Note : TC should be O(N) and with constant space.
        Example:
            arr1 = {1,3,15,10,20,3,23}
            k = 33
            ans = true
        Approach 1: 
            Iterate through all the subarray and find its sum and compare with target
            TC : O(n^3)
            SC : O(1)
        Approach 2: 
            Using carry forward technique
            TC : O(n^2) 
            SC : O(1)
        Approach 3:
            Using prefix sum
            TC : O(N)
            SC : O(N)  it can be O(1) if same array is used to calculate prefix sum
        Approach 3:
            Dynamic sliding window
                Unlike sliding window technique here window size is not fixed, we will start with 0 window size and 
                keep incresing/decreasing its size and comapre it with target value.
            TC : O(N)
            SC : O(1)
### Solution for approach 3
```java
    public boolean subArraySumWithGivenSum(List<Integer> arr, int target) {
        int start = 0, end = 0, currentSum = arr.get(0);
        while (end < arr.size()) {
            if(currentSum == target){
                return true;
            } else if (currentSum < target) {
                end++;
                if (end == (arr.size())) break;
                currentSum += arr.get(end);
            }else{
                currentSum -= arr.get(start);
                start++;
                if(start > end && start < arr.size()){
                    end++;
                    currentSum += arr.get(end);
                }
            }
        }
        return false;
    }
```
## Container with most water
    Problem Statement:
        Retuen max water that can be stored between any two walls.
        Please take a look at be below diagram and images to understand the question.
        Example:
            arr1 = {4,2,10,6,8,2,6,2}
            ans = 24 between wall height 10 and 6

        Approach 1
            Go to each wall pair and calculate area and return the max available area.
            TC : O(N^2)
            SC : O(1)
        Approach 2:
            Think about a way so that we can eliminate some wall and find two walls with maximum
            area.

        Lets think of below steps:
            a. Set start at 0 and end at n-1 and calculate area by using min(A[start],A[end]) * (end - start)
            b. In order to maximise area either we need to increase width or increase height
            c. We can increase width as we are already on first and last index so we need to think about increasing height
            d. In order to increase height we need to think of shifting wall with lower height
            e. if A[start] <= A[end] then shift start by 1 i.e. start++
            f. Else decrease end by 1 i.e. end--
            TC : O(N)
            SC : O(1)
            
        

### Dry run for above approach

    Given wall heights
        arr1 = {4,2,10,6,8,2,6,2}

    | start  | end   | water area | max area | Operation|
    |--------|-------|------------|----------|----------|
    |   0	 |   7   |   14       |   14     |   end--  |
    |   0	 |   6   |   24       |   24     |  start++ |
    |   1	 |   6   |   10       |   24     |  start++ |
    |   2	 |   6   |   24       |   24     |  end--   |
    |   2	 |   5   |   6        |   24     |  end--   |
    |   2	 |   4   |   16       |   24     |  end--   |
    |   2	 |   3   |   6        |   24     |  end--   |
    |   2	 |   2   |   0        |   24     |  break   |
    |   	 |       |            |          |          |
### Psuedo code for above approach
```java
    start = 0, end = n-1, ans = 0;
    while(start < end){
        area = min(A[start],A[end]) * (end - start)
        ans = max(area,ans)
        if(A[start] <= A[end]) start++
        else end --
    }
```

### Solution for above approach
```java
    public int maxArea(ArrayList<Integer> A) {
        if (A.size() < 2) return 0;
        int ans = 0, start = 0, end = A.size() - 1;
        while (start < end) {
            int area = Math.min(A.get(start), A.get(end)) * (end - start);
            ans = Math.max(ans, area);
            if (A.get(start) <= A.get(end)) start++;
            else end--;
        }
        return ans;
    }
```

![Problem diagram](https://github.com/rajpiyush220/Algorithms/blob/269653cd11e672c9da582590d529b7411a89c475/Notes/images/two_pointer_problems_container.png?raw=true)




![Question visual Representaion](https://github.com/rajpiyush220/Algorithms/blob/c5683e0c5e69df9839c9b57532ea124864b76778/Notes/images/container_with_most_water.gif?raw=true)

