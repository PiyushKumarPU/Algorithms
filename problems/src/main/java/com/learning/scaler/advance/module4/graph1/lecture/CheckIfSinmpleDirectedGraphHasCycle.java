package com.learning.scaler.advance.module4.graph1.lecture;

import com.learning.scaler.advance.module4.ConstructGraphs;

import java.util.*;

public class CheckIfSinmpleDirectedGraphHasCycle {

    public static void main(String[] args) {
        List<List<Integer>> inputs = List.of(
                List.of(16, 15),
                List.of(15, 10),
                List.of(2, 15),
                List.of(2, 1),
                List.of(1, 9),
                List.of(2, 3),
                List.of(3, 7),
                List.of(3, 8),
                List.of(8, 4),
                List.of(3, 4),
                List.of(4, 5),
                List.of(5, 6),
                List.of(5, 11),
                List.of(11, 12),
                List.of(11, 13),
                List.of(13, 14)
        );


        List<List<Integer>> adjList = ConstructGraphs.constructAdjList(inputs, false);

        System.out.println(new CheckIfSinmpleDirectedGraphHasCycle().hasCycle(5, adjList,
                new HashSet<>()));
    }


    public boolean hasCycle(int node, List<List<Integer>> inputs, HashSet<Integer> currentPaths) {
        currentPaths.add(node);
        for (int current : inputs.get(node)) {
            if (currentPaths.contains(current)) return true;
            else if (hasCycle(current, inputs, currentPaths)) {
                return true;
            }
        }
        currentPaths.remove(node);
        return false;
    }


}
