package com.learning.scaler.advance.module4.graph2.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    There are a total of A courses you have to take, labeled from 1 to A.
    Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
    So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
    Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Problem Constraints
    1 <= A <= 6*10^4
    1 <= length(B) = length(C) <= 10^5
    1 <= B[i], C[i] <= A

Input Format
    The first argument of input contains an integer A, representing the number of courses.
    The second argument of input contains an integer array, B.
    The third argument of input contains an integer array, C.

Output Format
    Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.

Example Input
    Input 1:
         A = 3
         B = [1, 2]
         C = [2, 3]
    Input 2:
         A = 2
         B = [1, 2]
         C = [2, 1]

Example Output
    Output 1:
         1
    Output 2:
         0

Example Explanation
    Explanation 1:
         It is possible to complete the courses in the following order:
            1 -> 2 -> 3
    Explanation 2:
         It is not possible to complete all the courses.
* */
public class PossibilityOfFinishing {

    public static void main(String[] args) {
        int A = 3;
        ArrayList<Integer> B = new ArrayList<>(List.of(1, 2));
        ArrayList<Integer> C = new ArrayList<>(List.of(2, 3));
        System.out.println(new PossibilityOfFinishing().solve(A, B, C));
    }

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        if (B.isEmpty() || C.isEmpty()) return 1;
        int[] nodes = new int[A + 1];
        List<List<Integer>> adjList = constructAdjList(B, C, A, nodes);
        Queue<Integer> paths = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if (nodes[i] == 0) paths.add(i);
        }
        while (!paths.isEmpty()) {
            int current = paths.poll();
            nodes[current]--;
            for (int nbr : adjList.get(current)) {
                nodes[nbr]--;
                if (nodes[nbr] == 0) paths.add(nbr);
            }
        }
        for (int i = 1; i <= A; i++) {
            if (nodes[i] > 0) return 0;
        }
        return 1;
    }

    private List<List<Integer>> constructAdjList(List<Integer> startNodes, List<Integer> endNodes, int nodeCount, int[] nodes) {
        if (startNodes.isEmpty() || endNodes.isEmpty()) return new ArrayList<>();
        int edgeCount = startNodes.size();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i <= edgeCount; i++) {
            int src = startNodes.get(i - 1);
            int dest = endNodes.get(i - 1);
            nodes[dest]++;
            adjList.get(src).add(dest);
        }
        return adjList;
    }
}
