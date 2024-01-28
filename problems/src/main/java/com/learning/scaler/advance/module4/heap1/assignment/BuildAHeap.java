package com.learning.scaler.advance.module4.heap1.assignment;


import javax.swing.plaf.ButtonUI;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
Problem Description
    Given an array A of N integers, convert that array into a min heap and return the array.
    NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.

Problem Constraints
    1 ≤ N ≤ 10^5
    1 ≤ A[i] ≤ 10^9

Input Format
    First and only argument of input contains a single integer array A of length N.

Output Format
    Return the reordered array A such that it forms a min heap.

Example Input
    Input:
        A = [5, 13, -2, 11, 27, 31, 0, 19]

Example Output
    Output:
        A = [-2, 0, 5, 11, 13, 19, 27, 31]

Example Explanation
    Explanation:
        The output gives a valid min heap.
        It can be seen that each parent has a value smaller than its children.
* */
public class BuildAHeap {

    public static void main(String[] args) {
        int[] input = {5, 13, -2, 11, 27, 31, 0, 19};

        BuildAHeap buildAHeap = new BuildAHeap();

        System.out.println(Arrays.toString(buildAHeap.buildHeapUsingSort(input)));
        System.out.println(Arrays.toString(buildAHeap.buildHeapUsingInBuildClass(input)));

    }

    /*
    TC : nlogn
    SC : Space taken by sorting algo
    * */
    public int[] buildHeapUsingSort(int[] A) {
        java.util.Arrays.sort(A);
        return A;
    }


    public Integer[] buildHeapUsingInBuildClass(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A.length);
        for (int ele : A) {
            minHeap.add(ele);
        }
        return minHeap.toArray(Integer[]::new);
    }

    public Integer[] buildHeapUsingCustomLogic(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A.length);
        for (int ele : A) {
            minHeap.add(ele);
        }
        return minHeap.toArray(Integer[]::new);
    }


}
