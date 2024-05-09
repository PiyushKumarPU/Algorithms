package com.learning.scaler.advance.module4.graph3.assignment;

import com.learning.scaler.advance.module4.graph3.Pair;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
    We need to find bridges with minimal cost such that all islands are connected.
    It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
    
Problem Constraints
    1 <= A, M <= 6*10^4
    1 <= B[i][0], B[i][1] <= A
    1 <= B[i][2] <= 10^3

Input Format
    The first argument contains an integer, A, representing the number of islands.
    The second argument contains an 2-d integer matrix, B, of size M x 3 where Island
    B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].

Output Format
    Return an integer representing the minimal cost required.

Example
    Input 1:
         A = 4
         B = [  [1, 2, 1]
                [2, 3, 4]
                [1, 4, 3]
                [4, 3, 2]
                [1, 3, 10]  ]
    Input 2:
         A = 4
         B = [  [1, 2, 1]
                [2, 3, 2]
                [3, 4, 4]
                [1, 4, 3]   ]

Example Output
    Output 1:
         6
    Output 2:
         6

Example Explanation
    Explanation 1:
         We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
    Explanation 2:
         We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
* 
* */
public class CommutableIslands {

    public static void main(String[] args) {
        int A = 3;
        ArrayList<ArrayList<Integer>> B =
                new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1, 2, 10)),
                                new ArrayList<>(List.of(1, 3, 9)),
                                new ArrayList<>(List.of(2, 3, 5))
                        )
                );
        CommutableIslands islands = new CommutableIslands();
        System.out.println(islands.solve(A, B));
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int ans = 0;
        boolean[] visited = new boolean[A + 1];
        List<List<Pair>> adjList = constructAdjList(B, A);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        minHeap.add(new Pair(1, 0));
        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();
            if (visited[current.node]) continue;
            visited[current.node] = true;
            ans += current.weight;
            for (Pair nbr : adjList.get(current.node)) {
                if (visited[nbr.node]) continue;
                minHeap.add(nbr);
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