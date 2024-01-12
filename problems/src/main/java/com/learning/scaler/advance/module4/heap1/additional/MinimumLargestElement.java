package com.learning.scaler.advance.module4.heap1.additional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
Problem Description
    Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
    Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
    Find the minimum possible largest element after B operations.

Problem Constraints
    1 <= N <= 10^6
    0 <= B <= 10^5
    -10^4 <= A[i] <= 10^4

Input Format
    The first argument is an integer array A.
    The second argument is an integer B.

Output Format
    Return an integer denoting the minimum possible largest element after B operations.

Example Input
    Input 1:
         A = [1, 2, 3, 4]
         B = 3
    Input 2:
         A = [5, 1, 4, 2]
         B = 5

Example Output
    Output 1:
        4
    Output 2:
        5

Example Explanation
    Explanation 1:
         Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
         Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
         Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
         Minimum possible largest element after 3 operations is 4.
    Explanation 2:
         Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
         Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
         Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
         Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
         Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
         Minimum possible largest element after 5 operations is 5.
* */
public class MinimumLargestElement {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(8, 6, 4, 2)), 8));
        //System.out.println(solve(new ArrayList<>(List.of(5, 1, 4, 2)), 5));

    }

    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getImpact));
        minHeap.addAll(A.stream().map(val -> new Pair(val, val)).collect(java.util.stream.Collectors.toList()));
        int remainingOps = B;
        while (!minHeap.isEmpty() && remainingOps > 0) {
            Pair pair = minHeap.poll();
            System.out.println(pair);
            minHeap.add(new Pair(pair.currentValue + pair.actualValue, pair.actualValue));
            remainingOps--;
        }
        return minHeap.stream().map(pair1 -> pair1.currentValue).max(Comparator.naturalOrder()).orElse(0);
    }
}

class Pair {
    Integer currentValue;
    Integer actualValue;

    private Integer impact;

    public Pair(Integer currentValue, Integer actualValue) {
        this.currentValue = currentValue;
        this.actualValue = actualValue;
    }

    public Integer getImpact() {
        return currentValue + actualValue;
    }
}
