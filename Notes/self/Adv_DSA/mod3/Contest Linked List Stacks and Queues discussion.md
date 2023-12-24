
## Advance DSA Day 33 Contest Linked List, Stacks & Queues discussion

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [Remove and Add Linked List](#remove-and-add-linked-list)
- [Next Greater element](#next-greater-element)
- [Alex and Treasures](#alex-and-treasures)


## Problems and solutions

1. [Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/33.%20Contest%20Linked%20List,%20Stacks%20&%20Queues%20discussion.pdf)
2. [Class/Lecture Video](https://youtu.be/kf0Zcq7k2Yo)

## Remove and Add Linked List
    Problem Description:
        You are given two linked lists: A and B of sizes N and M respectively, and two integers C and D.Remove linked list A's nodes from the Cth indexed node to the Dth indexed node (0-based indexing), and put the linked list B in their place. Please read the examples given below carefully to better understand the problem.
    
    Problem Constraints:
        0 <= N <= 10^5
        0 <= M <= 10^5
        0 <= A[i], B[i] <= 10^5 
        1 <= C,D <= N- 1
    Input Format:
        First argument A is a linked list.
        Second argument B is a linked list. 
        Third argument C is an integer. 
        Fourth argument D is an integer.
    Output Format:
        Return the final linked list after inserting linked list B in the linked list A.
    Example Input:
        Input 1:
            A = [0, 1, 2, 3, 4, 5]
            B = [0, 1, 2] 
            C = 3 
            D = 4
        Input 2:
            A = [0, 1, 2, 3, 4, 5, 6]
            B = [0, 1, 2, 3, 4] 
            C = 2 
            D = 5
    Example Output:
        Output 1:
            [0, 1, 2, 0, 1, 2, 5]
        Output 2:
            [0, 1, 0, 1, 2, 3, 4, 6]
    Example Explanation:
        Example 1:
            We remove the nodes 3 and 4 and put the entire B in their place.
            Now the list becomes [0, 1, 2] + [0, 1, 2] + [5] = [0, 1, 2, 0, 1, 2, 5]

        Example 2:
            We remove the nodes 2, 3, 4 and 5 and put the entire B in their place.
            Now the list becomes [0, 1] + [0, 1, 2, 3, 4] + [6] = [0, 1, 0, 1, 2, 3, 4, 6]

### Solution approach:
    lets take an exmaple input:
        A = [2,6,8,15,4,7,5]
        B = [0,1,2,3,4]
        C = 2
        D = 5
### Ouput for Above input would be like below:
![Solution](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/83b9a9937c5e7b1fdc2c4aa99542dd7984b6b0ca/Notes/images/Contest_remove_add_LL.png?raw=true)

### Steps to follow in order to acheive the solution
- Consider head of A as start element then we need to jump C times to find the starting nodes that need to be removed but we need to think about prev node of node that needs to be removed so we will do C -1 jump
- We will link C -1 node to the start of LL B
- Consider head of A as start element then we need to jump D times to find the last node that needs to be removed
- We will link last node of result LL to the next node of last removed node

### Solution
```java
    public ListNode solve(ListNode A, ListNode B, int C, int D) {
        ListNode t1 = A;
        int jump = 0;
        // Jump C -1 to find the prev node before first node to remove
        while (jump < (C - 1)) {
            t1 = t1.next;
            jump++;
        }
        // jump D times to find last removed node
        ListNode t2 = A;
        jump = 0;
        while (jump < D) {
            jump++;
            t2 = t2.next;
        }
        // linking second LL to first
        t1.next = B;
        // go till end of LL and assign remaining node
        while (t1.next != null) {
            t1 = t1.next;
        }
        t1.next = t2.next;
        return A;
    }

```


## Next Greater element
    Problem Description:
        Given an array A, find the next greater element G[i] for every element A[i] in the array. The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

        More formally:
            G[i] for an element A[i] = an element A[j] such that
            j is minimum possible AND j > i AND A[j] > A[i]
        Note : Elements for which no greater element exists, consider the next greater element as -1.
    Problem Constraints
        1 <= |A| <= 10^5
        1 <= A[i] <= 10^7
    Input Format
        The first and the only argument of input contains the integer array, A.
    Output Format
        Return an integer array representing the next greater element for each index in A.
    Example Input
        Input 1:
            A = [4, 5, 2, 10]
        Input 2:
            A = [3, 2, 1]

    Example Output
        Output 1:
            [5, 10, 10, -1]
        Output 2:
            [-1, -1, -1]
    Example Explanation
        Explanation 1:
            For 4, the next greater element towards its right is 5.
            For 5 and 2, the next greater element towards their right is 10.
            For 10, there is no next greater element towards its right.

        Explanation 2:
            As the array is in descending order, there is no next greater element for all the elements.

## Alex and Treasures
    Problem Description:
        Once upon a time, there was a great explorer named Alex who had traveled the world in search of treasure and adventure. On one of his journeys, he came across an ancient map that led to a hidden cave deep in the mountains.When Alex arrived at the cave, he found that it was filled with treasures of all kinds. However, he also found a problem. The treasures were scattered all over the cave, and he needed to find the B farthest ones from the cave's entrance.Moreover, Given an array A of points where A[i] = [xi, yi] represents a point on the X-Y plane and an integer B, return the B farthest points to the origin (0, 0).The distance between two points on the X-Y plane is the Euclidean distance (i.e. sqrt((x1 - x2)2 + (y1 - y2)2)).Note: It is guranteed that no two points will have same distance from the origin.
    Problem Constraints
        1 <= A.size() <= 10^5
        -10^4 <= x,y <= 10^4
        1 <= B <= A.size()
    Input Format
        The first argument is an integer array A and the second argument is an integer B.
    Output Format
        Return an 2-d array of integers denoting the farthest B points from the origin.
        Note: The output must be in sorted form.
    Example Input
        Input 1:
            A = [
                [1, 2]
                [1, 4]
                [-1, 0]
            ]
            B = 2
        Input 2:
            A = [
                [1, 5]
                [2, 1]
                [-1, -1]
                [3, 1]
            ]
            B = 3

    Example Output
        Ouput 1: [
                [1, 2]  
                [1, 4]
            ]
        Output 2:[
                [1, 5]
                [2, 1]
                [3, 1]
            ]

    Example Explanation
        Explanation 1:
            The farthest 2 points from origin are [[1, 2], [1, 4]].
        Explanation 2:
            The farthest 3 points from origin are [[1, 5], [2, 1], [3, 1]].

### Solution approach:
* If we observe it carefully, we need to sort point in descending order of distance from (0,0) and then pick first B element from the list.
* After picking the required element from list, we need to sort element by x value and then y value
### Solution
```java
    public List<List<Integer>> solve(final List<List<Integer>> A, final int B) {
        Comparator<List<Integer>> first = Comparator.comparing(integers -> integers.get(0));
        Comparator<List<Integer>> second = Comparator.comparing(integers -> integers.get(1));
        return A.stream().sorted((o1, o2) ->
                        Integer.compare(o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1), o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1)))
                .toList().subList(0, B).stream().sorted(first.thenComparing(second)).toList();
    }
```
