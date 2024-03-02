package com.learning.scaler.advance.module3.linkedlist2.assignment;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Merge two sorted linked lists, A and B, and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists and should also be
    sorted.

Problem Constraints
    0 <= |A|, |B| <= 10^5

Input Format
    The first argument of input contains a pointer to the head of linked list A.
    The second argument of input contains a pointer to the head of linked list B.

Output Format
    Return a pointer to the head of the merged linked list.

Example Input
    Input 1:
        A = 5 -> 8 -> 20
        B = 4 -> 11 -> 15
    Input 2:
         A = 1 -> 2 -> 3
         B = Null
Example Output
    Output 1:
        4 -> 5 -> 8 -> 11 -> 15 -> 20
    Output 2:
        1 -> 2 -> 3

Example Explanation
    Explanation 1:
        Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
    Explanation 2:
        We don't need to merge as B is empty.
* */
public class MergeTwoSortedList {

    public static void main(String[] args) {
       /* mergeTwoLists(ListNodeConstructor.construct(List.of(5, 8, 20)),
                ListNodeConstructor.construct(List.of(4, 11, 15))).printAll();*/

        ListNode A = ListNodeConstructor.construct(List.of(12, 22, 27, 29, 38, 41, 45, 75, 75, 87, 99, 109, 113, 142, 177, 188, 191, 204, 205, 228, 271, 284, 286, 291, 300, 308, 310, 326, 327, 337, 352, 364, 372, 382, 384, 389, 405, 427, 465, 483, 496, 505, 508, 508, 515, 519, 524, 532, 536, 555, 561, 588, 588, 626, 635, 662, 671, 671, 674, 692, 696, 698, 706, 717, 732, 741, 744, 753, 759, 779, 786, 792, 804, 811, 819, 821, 835, 848, 860, 860, 864, 864, 868, 872, 874, 880, 909, 913, 915, 929, 929, 958, 990));
        ListNode B = ListNodeConstructor.construct(List.of(7, 12, 46, 66, 84, 86, 93, 116, 131, 132, 179, 222, 230, 238, 246, 253, 254, 256, 290, 301, 357, 372, 375, 391, 395, 396, 402, 424, 439, 494, 508, 535, 554, 592, 593, 612, 629, 711, 719, 721, 731, 738, 746, 758, 768, 769, 780, 782, 831, 835, 837, 873, 874, 882, 907, 936, 960, 970, 982, 987, 990));

        mergeTwoListsPlain(A, B).printAll();

    }

    public static ListNode mergeTwoListsPlain(ListNode A, ListNode B) {
        if (A == null && B == null) return null;
        else if (A == null) return B;
        else if (B == null) return A;
        ListNode head = null, temp = null;
        ListNode AStart = A;
        ListNode BStart = B;
        while (AStart != null && BStart != null) {
            int nodeVal = AStart.val;
            boolean isSameVal = false;
            if (AStart.val <= BStart.val) {
                if (AStart.val == BStart.val) {
                    isSameVal = true;
                    BStart = BStart.next;
                }
                AStart = AStart.next;
            } else {
                nodeVal = BStart.val;
                BStart = BStart.next;
            }
            if (head == null) {
                head = new ListNode(nodeVal);
                temp = head;
            } else {
                head.next = new ListNode(nodeVal);
                head = head.next;
            }
            if (isSameVal) {
                head.next = new ListNode(nodeVal);
                head = head.next;
            }
        }

        while (AStart != null) {
            head.next = new ListNode(AStart.val);
            head = head.next;
            AStart = AStart.next;
        }
        while (BStart != null) {
            head.next = new ListNode(BStart.val);
            head = head.next;
            BStart = BStart.next;
        }
        return temp;
    }


    // TODO : Implement using merge sort
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null && B == null) return null;
        else if (A == null) return B;
        else if (B == null) return A;
        ListNode root = null;
        ListNode current = null;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        minHeap.add(new Pair(A.val, A));
        minHeap.add(new Pair(B.val, B));
        while (!minHeap.isEmpty()) {
            Pair currentPoll = minHeap.poll();
            ListNode next = currentPoll.next.next;
            if (next != null) {
                minHeap.add(new Pair(next.val, next));
            }

            if (root == null) {
                root = new ListNode(currentPoll.val);
                current = root;
            } else {
                current.next = new ListNode(currentPoll.val);
                current = current.next;
            }
        }
        return root;
    }

    public ListNode mergeTwoListsScaler(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode head;
        ListNode node = new ListNode(0);
        head = node;
        while (A != null && B != null) {
            // compare both the values
            if (A.val <= B.val) {
                node.next = A;
                A = A.next;
                node = node.next;
            } else {
                node.next = B;
                B = B.next;
                node = node.next;
            }
        }
        if (A == null)
            node.next = B;
        else
            node.next = A;
        head = head.next;
        return head;
    }
}

class Pair {
    int val;
    ListNode next;

    public Pair(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
