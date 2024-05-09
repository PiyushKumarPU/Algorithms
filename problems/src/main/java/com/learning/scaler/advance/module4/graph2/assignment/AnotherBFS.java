package com.learning.scaler.advance.module4.graph2.assignment;

import com.learning.scaler.advance.module4.graph3.Pair;

import java.util.*;

/*
Problem Description
    Given a weighted undirected graph having A nodes, a source node C and destination node D.
    Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
    You are expected to do it in Time Complexity of O(A + M).
    Note:
        There are no self-loops in the graph.
        No multiple edges between two pair of vertices.
        The graph may or may not be connected.
        Nodes are Numbered from 0 to A-1.
        Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

Problem Constraints
    1 <= A <= 10^5
    0 <= B[i][0], B[i][1] < A
    1 <= B[i][2] <= 2
    0 <= C < A
    0 <= D < A

Input Format
    The first argument given is an integer A, representing the number of nodes.
    The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
    The third argument given is an integer C, representing the source node.
    The fourth argument is an integer D, representing the destination node.
    Note: B[i][2] will be either 1 or 2.

Output Format
    Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.

Example Input
    Input 1:
        A = 6
        B = [   [2, 5, 1]
                [1, 3, 1]
                [0, 5, 2]
                [0, 2, 2]
                [1, 4, 1]
                [0, 1, 1] ]
        C = 3
        D = 2
    Input 2:
            A = 2
            B = [   [0, 1, 1]
                ]
            C = 0
            D = 1

Example Output
    Output 1:
         4
    Output 2:
         1

Example Explanation
    Explanation 1:
        The path to be followed will be:
            3 -> 1 (Edge weight : 1)
            1 -> 0 (Edge weight : 1)
            0 -> 2 (Edge weight : 2)
        Total length of path = 1 + 1 + 2 = 4.
    Explanation 2:
         Path will be 0-> 1.
* */
public class AnotherBFS {

    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        List<List<Pair>> adjList = constructAdjList(B, A);
        int[] distances = new int[A + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        minHeap.add(new Pair(C, 0));
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            if (current.weight > distances[current.node]) continue;
            distances[current.node] = current.weight;
            for (Pair nbr : adjList.get(current.node)) minHeap.add(new Pair(nbr.node, nbr.weight + current.weight));
        }
        return distances[D] == Integer.MAX_VALUE ? -1 : distances[D];
    }

    private List<List<Pair>> constructAdjList(ArrayList<ArrayList<Integer>> B, int nodeCount) {
        List<List<Pair>> result = new ArrayList<>(nodeCount + 1);
        for (int i = 0; i <= nodeCount; i++) {
            result.add(new ArrayList<>());
        }
        for (ArrayList<Integer> row : B) {
            result.get(row.get(0)).add(new Pair(row.get(1), row.get(2)));
            result.get(row.get(1)).add(new Pair(row.get(0), row.get(2)));
        }
        return result;
    }
}
