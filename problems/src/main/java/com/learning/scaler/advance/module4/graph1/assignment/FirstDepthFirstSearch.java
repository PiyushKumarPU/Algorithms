package com.learning.scaler.advance.module4.graph1.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
    Given 2 towns find whether you can reach the first town from the second without repeating any edge.
    B C : query to find whether B is reachable from C.
    Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
    There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
    NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints
    1 <= N <= 100000

Input Format
    First argument is vector A
    Second argument is integer B
    Third argument is integer C

Output Format
    Return 1 if reachable, 0 otherwise.

Example Input
    Input 1:
     A = [1, 1, 2]
     B = 1
     C = 2
    Input 2:
     A = [1, 1, 2]
     B = 2
     C = 1

Example Output
    Output 1:
     0
    Output 2:
     1

Example Explanation
    Explanation 1:
     Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
    Explanation 2:
     Tree is 1--> 2--> 3 and hence 2 is reachable from 1.

* */
public class FirstDepthFirstSearch {

    public static void main(String[] args) {
        FirstDepthFirstSearch search = new FirstDepthFirstSearch();

        System.out.println(search.solve(new ArrayList<>(List.of(1, 1, 2)), 1, 2));
        System.out.println(search.solve(new ArrayList<>(List.of(1, 1, 2)), 2, 1));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        if (A.isEmpty() || A.size() < 2) return 0;
        List<List<Integer>> adjList = constructAdjList(A);
        boolean[] visited = new boolean[A.size() + 1];
        Queue<Integer> paths = new LinkedList<>();
        paths.add(C);
        while (!paths.isEmpty()) {
            int current = paths.poll();
            visited[current] = true;
            if (current < adjList.size()) {
                for (int nbr : adjList.get(current)) {
                    if (!visited[nbr]) paths.add(nbr);
                }
            }
        }
        return visited[B] ? 1 : 0;
    }


    private List<List<Integer>> constructAdjList(ArrayList<Integer> A) {
        if (A.isEmpty()) return new ArrayList<>();
        int N = A.size();
        List<List<Integer>> result = new ArrayList<>(N);
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i = 1; i < N; i++) {
            if (result.size() < i + 1) {
                result.add(new ArrayList<>());
            }
            result.get(A.get(i)).add(i + 1);
        }
        return result;
    }


}
