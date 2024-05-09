package com.learning.scaler.advance.module4.graph3.assignment;

import java.util.ArrayList;

/*
Problem Description
    Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
    You have to find an integer array D of size A such that:
    D[i]: Shortest distance from the C node to node i.
    If node i is not reachable from C then -1.
    Note:
        There are no self-loops in the graph.
        There are no multiple edges between two pairs of vertices.
        The graph may or may not be connected.
        Nodes are numbered from 0 to A-1.
        Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
    1 <= A <= 10^5
    0 <= B[i][0],B[i][1] < A
    0 <= B[i][2] <= 10^3
    0 <= C < A


Input Format
    The first argument is an integer A, representing the number of nodes in the graph.
    The second argument is a matrix B of size M x 3, where each row represents an edge in the graph.
    The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the
    weight of the edge B[i][2].
    The third argument is an integer C, representing the source node for which the shortest distance to
    all other nodes needs to be found.

Output Format
    Return the integer array D.

Example Input
    Input 1:
        A = 6
        B = [   [0, 4, 9]
                [3, 4, 6]
                [1, 2, 1]
                [2, 5, 1]
                [2, 4, 5]
                [0, 3, 7]
                [0, 1, 1]
                [4, 5, 7]
                [0, 5, 1] ]
        C = 4
    Input 2:
        A = 5
        B = [   [0, 3, 4]
                [2, 3, 3]
                [0, 1, 9]
                [3, 4, 10]
                [1, 3, 8]  ]
        C = 4

Example Output
    Output 1:
        D = [7, 6, 5, 6, 0, 6]
    Output 2:
        D = [14, 18, 13, 10, 0]

Example Explanation
    Explanation 1:
         All Paths can be considered from the node C to get shortest path
    Explanation 2:
         All Paths can be considered from the node C to get shortest path
* */
public class Dijkstra {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        return null;
    }
}
