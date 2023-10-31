### Day 10 Hashing Basics

## Scope / Agenda

- [HashMap Intro](#hashmap-intro)
- [Query: Frequency of Elements](#query-frequency-of-elements)
- [First Non Repeating Element](#first-non-repeating-element)
- [No of distinct Element](#no-of-distinct-element)
- [Subarray with 0 sum](#subarray-with-0-sum)

## Problems and solutions

1. [Assignments](/problems/src/main/java/com/learning/scaler/intermediate/hashing/assignment/)
2. [Additional Problems](/problems/src/main/java/com/learning/scaler/intermediate/hashing/additional/)
3. [Self Practise Problems](/problems/src/main/java/com/learning/scaler/intermediate/hashing/extra/)

## Class Notes and Videos

1. [Class Notes](/Notes/class_Notes/DSA%20Intermediate%20Notes/10%20Hashing%20Basics(13-09-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=iMkMZ9u6Xro)


### HashMap Intro
    What is HashMap and why do we need this datastructure?
    
    HashMap is a datastructure which stores data in key and value pair where key will always be unique.

#### Reference for additional info related to HashMap and HashSet

* [Detailed information about HashMap](https://www.scaler.com/topics/java/hashmap-in-java/)
* [Difference between HashMap and HashSet](https://www.scaler.com/topics/hashset-vs-hashmap/)

#### Some of the key properties of HashMap
- TC to search a element in HashMap : O(1)
- Space complexity to store element in HashMap : O(N)
- Key of HashMap will always be unique
- It can have duplicate value but each should be attached to unique key
- **HashMap does not preserve insertion order i.e. key stored in hashmap will not be in order it was inserted.**

### Query: Frequency of Elements

 Problem Description:
    
    Given and array of integers N and set of Queries Q, find the frequency of each query element in give array.
    
    Inputs:
        arr[11] =  {2,6,3,8,2,8,2,3,8,10,6}
        Q : 4
        value associated with Q
            2,8,3,5

    Explanation:
        We have an array arr of size 11 and it may have duplicate value. We have another set of value and we need to find their frequency in given array.


 Idea/approach to solve above problem:

  Idea 1 :
   
    For each element in query, iterate over the array and find the frequency for each query element.
    TC : O(N) and SC : O(1)

    

 Idea 2:
    
    Iterate through array and store frequency of each element in HashMap<Integer,Integer>. Now for each query element find the frequency in hashmap and print/return it.
    TC : O(N+Q) Here no of iteration will be N + Q, N for calculating frequency and Q for searching frequncy in hashmap 
    and SC : O(N)

```java
    // code block to implement idea2
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    for(int i = 0; i < N; i++){
        // Getting the count from hashmap if not present assign it to 0
        Integer currentCount = freqMap.getOrDefault(arr[i],0);
        // adding back the latest frequency in hashmap
        freqMap.put(arr[i], currentCount + 1);
    }

    for(int j = 0; j < Q; j++){
        Integer freqCount = freqMap.getOrDefault(Q[j],0);
        print(freqCount);
    }

```

### First Non Repeating Element
    Problem Description:
    
    Given and array of integers N, find first non repeating element.
    
    Inputs:
        arr[6] =  {1,2,3,1,2,5}
        ans : 3

Idea/approach to solve above problem:

  Idea 1 :
   
    Create Frequency map by iterating through array and find the first key with frequency 1 i.e. first non repeating element
    TC : O(N) SC : O(N)

    There is one hack here, HashMap does not preserve insertion order so first key with frequncy 1 may not be the first non repeating element.

    We need to find some other idea to solve this issue.


 Idea 2:
    
    Iterate through array and store frequency of each element in HashMap<Integer,Integer>. 
    
    Now iterate through array again and look for first element with frequency 1 and that will be the first non repeating element of the given array.
    TC : O(N)
    and SC : O(N)

```java
    // code block to implement idea2
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    for(int i = 0; i < N; i++){
        // Getting the count from hashmap if not present assign it to 0
        Integer currentCount = freqMap.getOrDefault(arr[i],0);
        // adding back the latest frequency in hashmap
        freqMap.put(arr[i], currentCount + 1);
    }

    for(int j = 0; j < N; j++){
        // gettting the frequency of each element and if freq is 1 then that will be the first non repeating element
        if(freqMap.getOrDefault(Q[j],0) == 1){
            return arr[j];
        }
    }

```

### No of distinct Element

Problem Description:
    
    Given and array of integers N, count no of unique element in given array.
    
    Inputs:
        arr[6] =  {1,2,3,1,2,5}
        ans : 4

Idea 1 :
   
    Iterate through array and store its element in HashSet and return the size of HashSet.

    As Hashset key can not be duplicate, if we store same key again and again it wont override the existing one and hashset size remains as it is.
    
    TC : O(N)
    SC : O(N)

    ```java
    // code block to implement above idea
    HashSet<Integer> hashSet = new HashSet<>();
    for(int i = 0; i < N; i++){
        frehashSet.add(arr[i]);
    }

    return hashSet.size();
```

### Subarray with 0 sum

    Problem Description:
    
    Given and array of integers N, check if there is a subarray with sum 0.
    
    Inputs:
        arr[10] =  [2,2,1,-3,4,3,1,-2,-3,2]
        ans : true
            Subarray [1,3] and [3,8] has 0 sum
        arr[3] =  [1,2,3]
        ans : false
        

Idea 1 :
   
    Check each and every subarray of given array and find its sum, if sum is zero then return true.

     No of loops in above idea
        2 loop to fix start and end of subarray
        1 loop to calculate sum of subarray
    
    TC : O(N^3)
    SC : O(1)

Idea 2 :
   
    Use prefix sum technique to calculate sum of given range and if sum is zero array has subarray with zero sum.

     No of loops in above idea
        1 loop to calculate prefix sum
        1 loop to calculate sum of given range
    Points to keep in mind
        1. Check if there is duplicate in prefix sum
        2. Check if pfSum has 0 value at any index
    
    TC : O(N^2)
    SC : O(N) --> Prefix sum array will take space here

Idea 3 :
   
    Use carry forward technique to calcuate subarray with zero sum.
    
    TC : O(N)
    SC : O(1)

   



