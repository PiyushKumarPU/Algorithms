package com.learning.scaler.advance.module4.graph2.assignment;

import java.util.*;

/*
Problem Description
    Given a directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents
    the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
    Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such
    that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting
    for a graph is not possible if the graph is not a DAG.
    Return the topological ordering of the graph and if it doesn't exist then return an empty array.
    If there is a solution return the correct ordering. If there are multiple solutions print
    the lexographically smallest one.
    Ordering (a, b, c) is said to be lexographically smaller than ordering
    (e, f, g) if a < e or if(a==e) then b < f and so on.
    NOTE:
        There are no self-loops in the graph.
        The graph may or may not be connected.
        Nodes are numbered from 1 to A.
        Your solution will run on multiple test cases. If you are using global variables
        make sure to clear them.

Problem Constraints
    2 <= A <= 10^4
    1 <= M <= min(100000,A*(A-1))
    1 <= B[i][0], B[i][1] <= A

Input Format
    The first argument given is an integer A representing the number of nodes in the graph.
    The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
    Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

Example
    Input 1:
         A = 6
         B = [  [6, 3]
                [6, 1]
                [5, 1]
                [5, 2]
                [3, 4]
                [4, 2] ]
    Input 2:
         A = 3
         B = [  [1, 2]
                [2, 3]
                [3, 1] ]

Example Output
    Output 1:
         [5, 6, 1, 3, 4, 2]
    Output 2:
         []

Example
    Explanation 1:
         The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
    Explanation 2:
         The given graph contain cycle so topological ordering not possible we will return empty array.
* */
public class TopologicalSort {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        inputs.add(new ArrayList<>(List.of(1, 4)));
        inputs.add(new ArrayList<>(List.of(1, 2)));
        inputs.add(new ArrayList<>(List.of(4, 2)));
        inputs.add(new ArrayList<>(List.of(4, 3)));
        inputs.add(new ArrayList<>(List.of(3, 2)));
        inputs.add(new ArrayList<>(List.of(5, 2)));
        inputs.add(new ArrayList<>(List.of(3, 5)));
        inputs.add(new ArrayList<>(List.of(8, 2)));
        inputs.add(new ArrayList<>(List.of(8, 6)));

        TopologicalSort topologicalSort = new TopologicalSort();
        System.out.println(topologicalSort.solve(8, inputs));
        System.out.println(new ArrayList<>(List.of(1, 4, 3, 5, 7, 8, 2, 6)));
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[A + 1];
        for (ArrayList<Integer> row : B) {
            int start = row.get(0);
            int end = row.get(1);
            indegree[end]++;
            adjList.get(start).add(end);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) minHeap.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int current = minHeap.poll();
            result.add(current);
            for (int nbr : adjList.get(current)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) minHeap.add(nbr);
            }
        }
        return result;
    }
}
