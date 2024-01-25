package com.learning.scaler.advance.module4.graph1.lecture;

import com.learning.scaler.advance.module4.ConstructGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

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

        System.out.println(new BFS().bfsSearch(adjList, 1));
    }


    public List<Integer> bfsSearch(List<List<Integer>> graphs, int root) {
        List<Integer> result = new ArrayList<>();
        boolean[] visitedNodes = new boolean[graphs.size()];
        Queue<Integer> paths = new LinkedList<>();
        paths.add(root);
        visitedNodes[root] = true;
        while (!paths.isEmpty()) {
            int current = paths.poll();
            result.add(current);
            List<Integer> nbrs = graphs.get(current);
            for (Integer nbr : nbrs) {
                if (!visitedNodes[nbr]) {
                    paths.add(nbr);
                    visitedNodes[nbr] = true;
                }
            }
        }
        return result;
    }
}
