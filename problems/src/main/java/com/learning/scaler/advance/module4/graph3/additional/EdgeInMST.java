package com.learning.scaler.advance.module4.graph3.additional;


import com.learning.scaler.advance.module4.graph3.Pair;

import java.lang.reflect.Array;
import java.util.*;

/*
Problem Description
    Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of
    size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
    For each edge check whether it belongs to any of the possible minimum spanning tree or not ,
    return 1 if it belongs else return 0.
    Return an one-dimensional binary array of size M denoting answer for each edge.
    NOTE:
        The graph may be disconnected in that case consider mst for each component.
        No self-loops and no multiple edges present.
        Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].

Problem Constraints
    1 <= A, M <= 3*10^5
    1 <= B[i][0], B[i][1] <= A
    1 <= B[i][1] <= 10^3

Input Format
    The first argument given is an integer A representing the number of nodes in the graph.
    The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].

Output Format
    Return an one-dimensional binary array of size M denoting answer for each edge.

Example Input
    Input 1:
         A = 3
         B = [ [1, 2, 2]
               [1, 3, 2]
               [2, 3, 3]
             ]
Example
    Output 1:
         [1, 1, 0]

Example
Explanation 1:
 Edge (1, 2) with weight 2 is included in the MST           1
                                                          /   \
                                                         2     3
 Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 So we will return [1, 1, 0]
* */
public class EdgeInMST {

    public static void main(String[] args) {
        int A = 3;
        ArrayList<ArrayList<Integer>> B =
                new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1, 2, 2)),
                                new ArrayList<>(List.of(1, 3, 2)),
                                new ArrayList<>(List.of(2, 3, 3))
                        )
                );

        EdgeInMST edgeInMST = new EdgeInMST();
        System.out.println(edgeInMST.solve(A, B));
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        List<List<Triplet>> adjList = constructAdjList(B, A);
        boolean[] visited = new boolean[A + 1];
        HashSet<String> usedEdges = new HashSet<>();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                solve1(1, adjList, visited, usedEdges);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> edge : B) {
            String key1 = edge.get(0) + "_" + edge.get(1) + "_" + edge.get(2);
            String key2 = edge.get(1) + "_" + edge.get(0) + "_" + edge.get(2);
            result.add(usedEdges.contains(key1) || usedEdges.contains(key2) ? 1 : 0);
        }
        return result;
    }

    private void solve1(int A, List<List<Triplet>> adjList, boolean[] visited,
                       HashSet<String> usedEdges) {
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>(Comparator.comparing(t -> t.weight));
        minHeap.add(new Triplet(0, 1, 0));
        while (!minHeap.isEmpty()) {
            Triplet current = minHeap.poll();
            if (visited[current.dest]) continue;
            visited[current.dest] = true;
            usedEdges.add(current.source + "_" + current.dest + "_" + current.weight);
            for (Triplet nbr : adjList.get(current.dest)) {
                if (visited[nbr.dest]) continue;
                minHeap.add(nbr);
            }
        }
    }

    private List<List<Triplet>> constructAdjList(ArrayList<ArrayList<Integer>> B, int nodeCount) {
        List<List<Triplet>> result = new ArrayList<>(nodeCount + 1);
        for (int i = 0; i <= nodeCount; i++) {
            result.add(new ArrayList<>());
        }
        for (ArrayList<Integer> row : B) {
            result.get(row.get(0)).add(new Triplet(row.get(0), row.get(1), row.get(2)));
            result.get(row.get(1)).add(new Triplet(row.get(1), row.get(0), row.get(2)));
        }
        return result;
    }
}

class Triplet {
    int source, dest, weight;

    public Triplet(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
