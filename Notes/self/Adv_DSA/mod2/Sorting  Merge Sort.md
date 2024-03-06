## Advance DSA Day 13 Sorting : Merge Sort

## Scope / Agenda
- [Count Sort](#count-sort)
- [Stable and Inplace sorting](#stable-and-inplace-sorting)
- [Merge 2 Sorted Arrays](#merge-2-sorted-arrays)
- [Merge Sort](#merge-sort)
- [Inversion Count](#inversion-count)
- [No of Pairs](#no-of-pairs)
- [No of Open Doors](#no-of-open-doors)

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/13.%20Sorting%20Merge%20Sort.pdf)
2. [Follow Up Notes](../../../class_Notes/Advance%20DSA%20Notes/13.%20Sorting%20Merge%20Sort%20Follow%20Up.pdf)
3. [Class/Lecture Video](https://youtu.be/vMzX_cpGeN0)
4. [Follow Up Class/Lecture Video](https://youtu.be/YhIp0-mBorE)

## Count Sort
>**Counting Sort is a non-comparison-based sorting algorithm that works well when there is limited range of input values. It is particularly efficient when the range of input values is small compared to the number of elements to be sorted. The basic idea behind Counting Sort is to count the frequency of each distinct element in the input array and use that information to place the elements in their correct sorted positions.**
### Working of counting sort algorithm
- Declare an auxiliary array countArray[] of size max(inputArray[])+1 and initialize it with 0.
- Traverse array inputArray[] and map each element of inputArray[] as an index of countArray[] array, i.e., execute countArray[inputArray[i]]++ for 0 <= i < N.
- Calculate the prefix sum at every index of array inputArray[].
- Create an array outputArray[] of size N.
- Traverse array inputArray[] from end and update outputArray[ countArray[ inputArray[i] ] – 1] = inputArray[i]. Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]- 

### Steps to follow in counting sort
- Step 1:
    * Find out the maximum element from the given array.
        ![Step1](../../../images/1.png)
- Step 2 :
    * Initialize a countArray[] of length max+1 with all elements as 0. This array will be used for storing the occurrences of the elements of the input array.
        ![Step1](../../../images/2.png)
- Step 3 :
    * In the countArray[], store the count of each unique element of the input array at their respective indices.
    * For Example: The count of element 2 in the input array is 2. So, store 2 at index 2 in the countArray[]. Similarly, the count of element 5 in the input array is 1, hence store 1 at index 5 in the countArray[].
        ![Step1](../../../images/3.png)
- Step 4 :
    * Store the cumulative sum or prefix sum of the elements of the countArray[] by doing countArray[i] = countArray[i – 1] + countArray[i]. This will help in placing the elements of the input array at the correct index in the output array.
        ![Step1](../../../images/4.png)
- Step 5 :
    * Iterate from end of the input array and because traversing input array from end preserves the order of equal elements, which eventually makes this sorting algorithm stable.
        - Update outputArray[ countArray[ inputArray[i] ] – 1] = inputArray[i].
        - Also, update countArray[ inputArray[i] ] = countArray[ inputArray[i] ]– -. 
        ![Step1](../../../images/5.png)
- Step 6 : For i = 6,
    * Update outputArray[ countArray[ inputArray[6] ] – 1] = inputArray[6]
Also, update countArray[ inputArray[6] ] = countArray[ inputArray[6] ]- –
        ![Step1](../../../images/6.png)
- Step 7 : for i = 5,
    * Update outputArray[ countArray[ inputArray[5] ] – 1] = inputArray[5]
Also, update countArray[ inputArray[5] ] = countArray[ inputArray[5] ]- –
        ![Step1](../../../images/7.png)
- Step 8 : for i = 8
    * Update outputArray[ countArray[ inputArray[4] ] – 1] = inputArray[4]
Also, update countArray[ inputArray[4] ] = countArray[ inputArray[4] ]- 
        ![Step1](../../../images/8.png)
- Step 9 :
    *   Update outputArray[ countArray[ inputArray[3] ] – 1] = inputArray[3]
Also, update countArray[ inputArray[3] ] = countArray[ inputArray[3] ]
        ![Step1](../../../images/9.png)
- Step 10 :
    *  Update outputArray[ countArray[ inputArray[2] ] – 1] = inputArray[2]
Also, update countArray[ inputArray[2] ] = countArray[ inputArray[2] ]
        ![Step1](../../../images/10.png)
- Step 11 :
    * Update outputArray[ countArray[ inputArray[1] ] – 1] = inputArray[1]
Also, update countArray[ inputArray[1] ] = countArray[ inputArray[1] ]-
        ![Step1](../../../images/11.png)
- Step 12 :
    *  Update outputArray[ countArray[ inputArray[0] ] – 1] = inputArray[0]
Also, update countArray[ inputArray[0] ] = countArray[ inputArray[0] ]  
        ![Step1](../../../images/12.png)

### Time and space complexity of sorting algorithm
* Time Complexity: O(N+M), where N and M are the size of inputArray[] and countArray[] respectively.
    - Worst-case: O(N+M).
    - Average-case: O(N+M).
    - Best-case: O(N+M).
* Auxiliary Space: O(N+M), where N and M are the space taken by outputArray[] and countArray[] respectively.

### Advantage of Counting Sort:
* Counting sort generally performs faster than all comparison-based sorting algorithms, such as merge sort and quicksort, if the range of input is of the order of the number of input.
* Counting sort is easy to code
* Counting sort is a stable algorithm.
### Disadvantage of Counting Sort:
* Counting sort doesn’t work on decimal values.
* Counting sort is inefficient if the range of values to be sorted is very large.
* Counting sort is not an In-place sorting algorithm, It uses extra space for sorting the array elements.

### Problems
    Find smallest number that can be formed by rearranging digits given in an array.
    Input:
        arr : {6,3,4,2,7,2,1}
        arr2 : {4,2,7,3,9,0}
    Solution approach;
        Approach 1:
            Sort the array in descending order
            TC : O(nlogn)
            SC: Space taken by sorting algorithm
        Approach 2:
            As it is mentioned in array that it contains only digit so we will take a 10 size array to store frequency of each digit and then we will iterate it and add numbers as per their frequency.
            TC : O(n)
            SC : O(1) --> because we are taking 10 size array irrespective of the input size
### Solution
```java
    public List<Integer> rearrangeUsingCountSort(List<Integer> integers) {
        int[] countArray = new int[10];
        for (int i : integers) countArray[i]++;
        List<Integer> result = new ArrayList<>(integers.size());
        for (int i = 0; i < countArray.length; i++) {
            for (int index = 0; index < countArray[i]; index++) {
                result.add(i);
            }
        }
        return result;
    }
```
## Count sort example
```java
    public List<Integer> countSort(List<Integer> integers) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : integers) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int[] countArray = new int[max - min + 1];
        for (int i : integers) {
            countArray[i - min]++;
        }
        List<Integer> result = new ArrayList<>(integers.size());
        for (int i = 0; i < countArray.length; i++) {
            for (int index = 0; index < countArray[i]; index++) {
                result.add(i + min);
            }
        }
        return result;

    }
```
## Stable and Inplace sorting
## Merge 2 Sorted Arrays
## Merge Sort	
## Inversion Count
## No of Pairs
## No of Open Doors