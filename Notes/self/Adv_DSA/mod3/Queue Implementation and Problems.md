## Advanced DSA Day 29 Queue Implementation and Problems

## Scope / Agenda
- [Queue](#queue)
- [Implementation of queue using array](#implementation-of-queue-using-array)
- [Implementation of queue using stack](#implementation-of-queue-using-stack)
- [Queues Perfect No](#queues-perfect-no)
- [Doubly Ended Queue](#doubly-ended-queue)
- [Sliding Window Maximum](#sliding-window-maximum)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/queue/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/queue/additional)
3. [Self Practise Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/queue/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/29%20Queues%20Implementation%20and%20Problems.pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=5merIcBvI0Q)
3. [New Batch Notes](../../../new_batch_notes/Queue.pdf)
4. [New Batch Video](https://youtu.be/8YuCnJ8fgsk)

## Queue
> A Queue Data Structure is a fundamental concept in computer science used for storing and managing data in a specific order. It follows the principle of “First in, First out” (FIFO), where the first element added to the queue is the first one to be removed.
![Queue](../../../images/Queue-Data-structure1.png)
### Functions of Queue
* **Enqueue (Insert):** Adds an element to the rear of the queue.
* **Dequeue (Delete):** Removes and returns the element from the front of the queue.
* **Peek:** Returns the element at the front of the queue without removing it.
* **isEmpty:** Checks if the queue is empty.
* **isFull:** Checks if the queue is full.
## Implementation of queue using array
![Queue using array](../../../images/Queue_using_array.png)
## Implementation of queue using stack
## Queues Perfect No
## Doubly Ended Queue
> Deque or Double Ended Queue is a generalized version of Queue data structure that allows insert and delete at both ends.


| Operation   | Description                          | Time Complexity |
|-------------|--------------------------------------|-----------------|
| push_front()| Inserts the element at the beginning| O(1)            |
| push_back() | Adds element at the end              | O(1)            |
| pop_front() | Removes the first element from the deque | O(1)         |
| pop_back()  | Removes the last element from the deque  | O(1)         |
| front()     | Gets the front element from the deque   | O(1)         |
| back()      | Gets the last element from the deque    | O(1)         |
| empty()     | Checks whether the deque is empty or not | O(1)        |
| size()      | Determines the number of elements in the deque | O(1)     |


## Sliding Window Maximum
