package com.learning.scaler.advance.module4.graph1.lecture;

import com.learning.scaler.advance.module4.ConstructGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description:
    Given and undirected graph, source node and destination node. Check if destination node can be visited
    from source node.
* */
public class NodeCanBeVisited {

    public static void main(String[] args) {
        List<List<Integer>> inputs = List.of(

                List.of(6, 7),
                List.of(1, 2),
                List.of(1, 4),
                List.of(2, 4),
                List.of(2, 3),
                List.of(3, 5),
                List.of(5, 0),
                List.of(4, 5)
        );


        List<List<Integer>> adjList = ConstructGraphs.constructAdjList(inputs);

        System.out.println(new NodeCanBeVisited().solve(adjList, 1, 0));
    }


    public boolean solve(List<List<Integer>> graphs, int source, int dest) {
        boolean[] visitedNodes = new boolean[graphs.size()];
        Queue<Integer> paths = new LinkedList<>();
        paths.add(source);
        visitedNodes[source] = true;
        while (!paths.isEmpty() && !visitedNodes[dest]) {
            int current = paths.poll();
            List<Integer> nbrs = graphs.get(current);
            for (Integer nbr : nbrs) {
                if (!visitedNodes[nbr]) {
                    paths.add(nbr);
                    visitedNodes[nbr] = true;
                }
            }
        }
        return visitedNodes[dest];
    }

}
