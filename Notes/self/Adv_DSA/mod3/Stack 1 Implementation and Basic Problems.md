
## Adv DSA Day 27 Stack Implementation and Basic Problems

## Scope / Agenda
- [Stack Introduction](#stack-introduction)
- [Operations on Stack](#operations-on-stack)
- [Implementation of Stack](#implementation-of-stack)
- [Balanced Paranthesis](#balanced-paranthesis)
- [Double Char trouble](#double-char-trouble)
- [Postfix expression](#postfix-expression)

## Problems and solutions
1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/stack1/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/stack1/additional)
3. [Self Practise Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module3/stack1/lecture)

## Class Notes and Videos
1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/27%20Stack%20Implementation%20and%20Basic%20Problems.pdf)
2. [Class/Lecture Video](https://youtu.be/oZ06N3evwrY)


## Stack Introduction
    A stack is a linear data structure in which the insertion of a new element and removal of an existing 
    element takes place at the same end represented as the top of the stack.

    Stack follow LIFO(Last in first out strategies because we perform all the operations(pop and push) 
    from same end)

### For more information on stack please refer below links:
* [Intro to Stack](https://www.geeksforgeeks.org/introduction-to-stack-data-structure-and-algorithm-tutorials/)
* [Stack Wikipedia](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))

## Operations on Stack
![Stack Operations](../../../images/StackOperations.gif?raw=true)

 * push --> Push data at the top of the stack.
 * pop --> Delete data from top of the stack.
 * peek --> Return data present at top of the element.
 * isEmpty --> Check whether stack is empty or not
 * size --> Returns size of the stack

 Note:- 
    Underlying datastructure of Stack in Java is array and it is child class of Vector and List.

    Return type of push, pop and peek depends upon language choosen.

## Implementation of Stack
### Solution
```java
public class StackUsingDynamicArray<T> {
    private ArrayList<T> stack;
    int currentIndex = -1;
    public StackUsingDynamicArray(int capacity) {
        stack = new ArrayList<>(capacity);
    }

    public void push(T val) {
        currentIndex++;
        stack.add(currentIndex, val);
    }

    public T peek() {
        if (currentIndex >= 0)
            return stack.get(currentIndex);
        return null;
    }

    public T pop() {
        if (currentIndex >= 0) {
            return stack.get(currentIndex--);
        }
        return null;
    }

    public boolean isEmpty() {
        return currentIndex < 0;
    }

    public int size() {
        return currentIndex + 1;
    }
}
// Using Linked List
public class StackUsingLinkedList {
    private ListNode head;
    int size = 0;

    public void push(Integer val) {
        ListNode current = new ListNode(val);
        if (head != null) {
            current.next = head;
        }
        head = current;
        size++;
    }

    public Integer peek() {
        if (size > 0)
            return head.val;
        return null;
    }

    public Integer pop() {
        if (size > 0) {
            int currentVal = head.val;
            size--;
            head = head.next;
            return currentVal;
        }
        return null;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }
}
```
## Balanced Paranthesis
    Problem Description
        Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
        Refer to the examples for more clarity.

    Problem Constraints
        1 <= |A| <= 100

    Input Format
        The first and the only argument of input contains the string A having the parenthesis sequence.

    Output Format
        Return 0 if the parenthesis sequence is not balanced.
        Return 1 if the parenthesis sequence is balanced.

    Example
        Input 1:
            A = {([])}
        Input 2:
            A = (){
        Input 3:
            A = ()[]

    Example
        Output 1:
            1
        Output 2:
            0
        Output 3:
            1

    Example Explanation
        You can clearly see that the first and third case contain valid parenthesis.
        In the second case, there is no closing bracket for {, thus the parenthesis sequence is invalid.

### Solution approach
    As per the problem statment a set of paranthesis can be called as balance if and only if all the opening parenthesis has 
    proper closing paranthesis.
    We will be using stack to check the paranthesis, if current one is openinng parenthesis will push it to stack and if it 
    closing paranthesis then it should match with last opening paranthesis.
    TC : O(n)
    SC : O(n)

### Solution


## Double Char trouble
    You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent 
    and equal letters and removing them.
    We repeatedly make duplicate removals on s until we no longer can.
    Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
    
### Solution approach
    We can use similar approach like balanced paranthesis. Check every character with previous if same the pop it out from stack. 
    At last convert stack content back into string.
### Solution
```java
public String removeDuplicates(String s) {
    if (s == null || s.length() == 1) return s;
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!charStack.isEmpty() && charStack.peek() == current) charStack.pop();
            else charStack.push(current);
        }
        return charStack.stream().map(String::valueOf)
                .collect(Collectors.joining());
}
```
## Postfix expression