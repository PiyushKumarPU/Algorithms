package com.learning.scaler.advance.module4.graph1.assignment;

import java.util.*;

/*
Problem Description
    Given a directed graph having A nodes. A matrix B of size M x 2 is given which represents the
    M edges such that there is an edge directed from node B[i][0] to node B[i][1].
    Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:
    The cycle must contain at least two nodes.
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases.
    If you are using global variables, make sure to clear them.

Problem Constraints
    2 <= A <= 10^5
    1 <= M <= min(200000,A*(A-1))
    1 <= B[i][0], B[i][1] <= A

Input Format
    The first argument given is an integer representing the number of nodes in the graph.
    The second argument given a matrix B of size M x 2 which represents the M edges such that there is an
    edge directed from node B[i][0] to node B[i][1].


Output Format
    Return 1 if cycle is presently else return 0.

Example
    Input 1:
         A = 5
         B = [  [1, 2]
                [4, 1]
                [2, 4]
                [3, 4]
                [5, 2]
                [1, 3] ]
    Input 2:
         A = 5
         B = [  [1, 2]
                [2, 3]
                [3, 4]
                [4, 5] ]

Example
    Output 1:
        1
    Output 2:
        0

Example
    Explanation 1:
        The given graph contains cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
    Explanation 2:
         The given graph doesn't contain any cycle.
* * */
public class CycleInDirectedGraph {

    private Map<Integer, List<Integer>> constructAdjMap(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>(A);
        for (ArrayList<Integer> rows : B) {
            List<Integer> integers = adjMap.getOrDefault(rows.get(0), new ArrayList<>());
            integers.add(rows.get(1));
            adjMap.put(rows.get(0), integers);
        }
        return adjMap;
    }

    boolean hasCycle;

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> adjMap = constructAdjMap(A, B);
        HashSet<Integer> paths = new HashSet<>();
        boolean[] visited = new boolean[A + 1];
        for (int i = 1; i <= A; i++) dfs(i, adjMap, paths, visited);
        return hasCycle ? 1 : 0;
    }

    void dfs(int node, Map<Integer, List<Integer>> adjMap, HashSet<Integer> paths, boolean[] visited) {
        if (hasCycle) return;
        paths.add(node);
        visited[node] = true;
        for (int nbr : adjMap.getOrDefault(node, new ArrayList<>())) {
            if (paths.contains(nbr)) hasCycle = true;
            if (!visited[nbr]) dfs(nbr, adjMap, paths, visited);
        }
        paths.remove(node);
    }

}
