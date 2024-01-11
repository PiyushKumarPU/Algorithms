
## Advance DSA Day 37 Heaps 1: Introduction

## Scope / Agenda
- [Connecting the Ropes](#connecting-the-ropes)
- [Heap Introduction](#heap-introduction)
- [Insertion](#insertion)
- [Heapify](#heapify)
- [Extract Min](#extract-min)
- [Build Heap](#build-heap)


## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/37.%20Heaps%20Introduction.pdf)
2. [Class/Lecture Video](https://youtu.be/-bqK0plm4xI)


## Connecting the Ropes
    Problem Description:
        You can connect any two ropes together, there is a cost associated to connect them = sum of length of both ropes that we re connecting.
        Find min cost to connect all the ropes together.
    Input
        Give an array of length of ropes
        2 5 2 6 3
## Heap Introduction
    A Heap is a special Tree-based data structure in which the tree is a complete binary tree.
![Heap](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/497c3a6c0c39310266d80757ecd04f4c69fa8c07/Notes/images/MinHeapAndMaxHeap1.png?raw=true)
### Please follow below links to get more about heap data structure
- [Heap](https://www.geeksforgeeks.org/introduction-to-heap-data-structure-and-algorithm-tutorials/)
- [Problems](https://www.interviewbit.com/courses/programming/heaps-and-maps/)

## Insertion
## Heapify
## Extract Min
## Build Heap
## Merge K Sorted Lists
### Problem Description
    Given a list containing head pointers of N sorted linked lists.
    Merge these given sorted linked lists and return them as one sorted list.

    Problem Constraints
        1 <= total number of elements in given linked lists <= 100000

    Input Format
        The first and only argument is a list containing N head pointers.

    Output Format
        Return a pointer to the head of the sorted linked list after merging all the given linked lists.

    Example Input
        Input 1:
            1 -> 10 -> 20
            4 -> 11 -> 13
            3 -> 8 -> 9
        Input 2:
            10 -> 12
            13
            5 -> 6

    Example Output
        Output 1:
            1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
        Output 2:
            5 -> 6 -> 10 -> 12 ->13

    Example Explanation
        Explanation 1:
            The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
        Explanation 2:
            The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

### Solution approach
    Idea 1: We can use two pointers technique like merge sort and create the sorted list

    Problem with this idea: As input size grow it will be difficult to maintian that many pointer and assicated manipulation will be very very difficult.

    Idea 2: Using mean heap
        Steps to follow:
            1. Create Min heap (with custom comparator that will work on node value) as same size as input size and we will maintain same heap size throughout the solution
            2. Push root node of each input in min heap
            3. Pull the min node value from heap and push it into LinkedList
            4. Push back the next node of linked list to min heap to process next node.
        TC : nlogn (each operation in heap and we are processing n items)
        SC : O(size of input)

### Solution
```java
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int listSize = a.size();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listSize, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < listSize; i++) {
            minHeap.add(a.get(i));
        }
        ListNode root = null, current = null;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            if (min.next != null)
                minHeap.add(min.next);
            ListNode temp = new ListNode(min.val);
            if (root == null) {
                root = temp;
                current = root;
            } else {
                current.next = temp;
            }
            current = temp;
        }
        return root;
    }
```

