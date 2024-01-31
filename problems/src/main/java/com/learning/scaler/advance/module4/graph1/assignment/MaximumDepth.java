package com.learning.scaler.advance.module4.graph1.assignment;

import java.lang.reflect.Array;
import java.util.*;

/*
Problem Description
    Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.
    You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level
    L mod (MaxDepth + 1) and has value greater than or equal to X.
    Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

    NOTE:
        Level and Depth of the root is considered as 0.
        It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
        Please read the input format for more clarification.

Problem Constraints
    2 <= A, Q(size of array E and F) <= 10^5
    1 <= B[i], C[i] <= A
    1 <= D[i], E[i], F[i] <= 10^6


Input Format
    The first argument is an integer A denoting the number of nodes.
    The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.
    The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node
    The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.

Output Format
    Return an array of integers where the ith element denotes the answer to ith query.

Example Input
    Input 1:
     A = 5
     B = [1, 4, 3, 1]
     C = [5, 2, 4, 4]
     D = [7, 38, 27, 37, 1]
     E = [1, 1, 2]
     F = [32, 18, 26]
    Input 2:
     A = 3
     B = [1, 2]
     C = [3, 1]
     D = [7, 15, 27]
     E = [1, 10, 1]
     F = [29, 6, 26]

Example Output
    Output 1:
     [37, 37, 27]
    Output 2:
     [-1, 7, 27]

Example Explanation
    Explanation 1:
          1[7]
         /    \
       5[1]  4[37]
            /    \
           2[38]  3[27]

     Query 1:
        L = 1, X = 32
        Nodes for level 1 are 5, 4
        Value of Node 5 = 1 < 32
        Value of Node 4 = 37 >= 32
        Ans = 37
    Explanation 2:
          1[7]
         /    \
       2[15]  3[27]

     Query 1:
        L = 1, X = 6
        Nodes for level 1 are 2, 3 having value 15 and 27 respectively.
        Answer = -1 (Since no node is greater or equal to 29).
     Query 1:
        L = 10 % 2 = 0, X = 6
        Nodes for level 0 is 1 having value 7.
        Answer = 7.
* */
public class MaximumDepth {

    public static void main(String[] args) {
        MaximumDepth maximumDepth = new MaximumDepth();

        int A = 5;
        ArrayList<Integer> B = new ArrayList<>(List.of(1, 4, 3, 1));
        ArrayList<Integer> C = new ArrayList<>(List.of(5, 2, 4, 4));
        ArrayList<Integer> D = new ArrayList<>(List.of(7, 38, 27, 37, 1));
        ArrayList<Integer> E = new ArrayList<>(List.of(1, 1, 2));
        ArrayList<Integer> F = new ArrayList<>(List.of(32, 18, 26));

        System.out.println(maximumDepth.solve(A, B, C, D, E, F));
    }

    // A denotes number of nodes
    //  B and C denoted start and end node of edges
    // D denotes the node value of i + 1 node
    // E denotes L value of query
    // F denotes X value of query

    // criteria to find min value node of level L mode (maxDepth of tree + 1) and value should be greater or
    // equal and return -1 if all value is less


    // trying brute force
    /*
     *  Step 1 : Construct directed and weighted graph adj list for given input
     *
     * */
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D,
                                    ArrayList<Integer> E, ArrayList<Integer> F) {
        Map<Integer, List<Integer>> nbrMap = new HashMap<>(A + 1);
        for (int i = 0; i < B.size(); i++) {
            int start = B.get(i);
            int end = C.get(i);
            List<Integer> existing = new ArrayList<>();
            if (!nbrMap.containsKey(start) && nbrMap.containsKey(end)) {
                existing = nbrMap.getOrDefault(end, existing);
                existing.add(start);
                nbrMap.put(end, existing);
            } else {
                existing = nbrMap.getOrDefault(start, existing);
                existing.add(end);
                nbrMap.put(start, existing);
            }
        }
        Map<Integer, List<Integer>> levelValuesMap = new HashMap<>();
        Queue<Pair> levelOrder = new LinkedList<>();
        levelOrder.add(new Pair(0, 1));

        while (!levelOrder.isEmpty()) {
            Pair current = levelOrder.poll();
            List<Integer> existing = levelValuesMap.getOrDefault(current.level, new ArrayList<>());
            existing.add(D.get(current.value - 1));
            levelValuesMap.put(current.level, existing);
            if (nbrMap.containsKey(current.value)) {
                for (Integer nbr : nbrMap.get(current.value)) {
                    levelOrder.add(new Pair(current.level + 1, nbr));
                }
            }
        }

        int maxDepth = levelValuesMap.keySet().size();
        ArrayList<Integer> result = new ArrayList<>(E.size());
        for (int i = 0; i < E.size(); i++) {
            int L = E.get(i);
            int X = F.get(i);
            int reqLevel = L % (maxDepth + 1);
            List<Integer> nodeValueAtL = levelValuesMap.getOrDefault(reqLevel, new ArrayList<>());
            if (nodeValueAtL.isEmpty()) {
                result.add(-1);
            } else {
                result.add(nodeValueAtL.stream().filter(val -> val >= X).min(Comparator.naturalOrder()).orElse(-1));
            }
        }
        return result;
    }
}

class Pair {
    public int level;
    public int value;

    public Pair(int level, int value) {
        this.level = level;
        this.value = value;
    }
}
