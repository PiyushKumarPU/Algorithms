package com.learning.scaler.advance.module4.graph3.assignment;


import com.learning.scaler.advance.module4.graph3.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
    Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
    NOTE: Return the answer modulo 10^9+7 as the answer can be large.

Problem Constraints
    1 <= A <= 100000
    0 <= C <= 100000
    1 <= B[i][0], B[i][1] <= N
    1 <= B[i][2] <= 10^9

Input Format
    First argument is an integer A.
    Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]

Output Format
    Return an integer denoting the minimum construction cost.

Example Input
    Input 1:
        A = 3
        B = [   [1, 2, 14]
                [2, 3, 7]
                [3, 1, 2]   ]
    Input 2:
        A = 3
        B = [   [1, 2, 20]
                [2, 3, 17]  ]

Example Output
    Output 1:
        9
    Output 2:
        37

Example Explanation
    Explanation 1:
        We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
        we can reach the 1st node from 2nd and 3rd node using only these two edges.
        So, the total cost of costruction is 9.
    Explanation 2:
        We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
* */
public class ConstructionCost {

    public static void main(String[] args) {
        int A = 3;
        ArrayList<ArrayList<Integer>> B =
                new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1, 2, 14)),
                                new ArrayList<>(List.of(2, 3, 7)),
                                new ArrayList<>(List.of(3, 1, 2))
                        )
                );
        ConstructionCost constructionCost = new ConstructionCost();
        System.out.println(constructionCost.solve(A, B));
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if (B.isEmpty()) return 0;
        boolean[] visitedNodes = new boolean[A + 1];
        List<List<Pair>> adjList = constructAdjList(B, A);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a.weight));
        int totalCost = 0;
        minHeap.add(new Pair(1, 0));
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            if (!visitedNodes[current.node]) {
                visitedNodes[current.node] = true;
                totalCost += (current.weight % 1000000007);
                totalCost = totalCost % 1000000007;
                for (Pair nbr : adjList.get(current.node)) {
                    if (!visitedNodes[nbr.node]) {
                        minHeap.add(nbr);
                    }
                }
            }
        }
        return totalCost;
    }

    private List<List<Pair>> constructAdjList(ArrayList<ArrayList<Integer>> inputs, int nodeCount) {
        if (inputs.isEmpty()) return new ArrayList<>();
        int edgeCount = inputs.size();
        List<List<Pair>> adjList = new ArrayList<>(nodeCount + 1);
        for (int i = 0; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            int src = inputs.get(i).get(0);
            int dest = inputs.get(i).get(1);
            int weight = inputs.get(i).get(2);
            adjList.get(src).add(new Pair(dest, weight));
            adjList.get(dest).add(new Pair(src, weight));
        }
        return adjList;
    }
}
