package com.learning.scaler.advance.module4.graph3.assignment;


import com.learning.scaler.advance.module4.graph3.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the
    edges in the graph.
    Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every
    other node from the 1st node.
    NOTE: Return the answer modulo 10^9+7 as the answer can be large.

Problem Constraints
    1 <= A <= 100000
    0 <= C <= 100000
    1 <= B[i][0], B[i][1] <= N
    1 <= B[i][2] <= 10^9

Input Format
    First argument is an integer A.
    Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected
    by ith edge with weight B[i][2]

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
        int MOD = 1000000000 + 7;
        List<List<Pair>> adjList = constructAdjList(B, A);
        boolean[] visited = new boolean[A + 1];
        PriorityQueue<Pair> minWeightHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        int ans = 0;
        minWeightHeap.add(new Pair(1, 0));
        while (!minWeightHeap.isEmpty()) {
            Pair current = minWeightHeap.poll();
            if (visited[current.node]) continue;
            ans += current.weight;
            ans = ans % MOD;
            visited[current.node] = true;
            for (Pair nbr : adjList.get(current.node)) {
                if (visited[nbr.node]) continue;
                minWeightHeap.add(nbr);
            }
        }
        return ans;
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
