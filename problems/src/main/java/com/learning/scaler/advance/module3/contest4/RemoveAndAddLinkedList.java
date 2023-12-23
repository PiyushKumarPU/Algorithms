package com.learning.scaler.advance.module3.contest4;

import com.learning.scaler.advance.module3.ListNode;

/*
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
* */
public class RemoveAndAddLinkedList {

    public ListNode solve(ListNode A, ListNode B, int C, int D) {

        return null;
    }


}
