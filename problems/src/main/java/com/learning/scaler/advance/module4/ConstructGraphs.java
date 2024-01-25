package com.learning.scaler.advance.module4;

import java.util.ArrayList;
import java.util.List;

public class ConstructGraphs {


    public static List<List<Integer>> constructAdjList(List<List<Integer>> inputs) {
        if (inputs.isEmpty()) return new ArrayList<>();
        int nodeCount = inputs.get(0).get(0),
                edgeCount = inputs.get(0).get(1);
        List<List<Integer>> adjList = new ArrayList<>(nodeCount);
        for (int i = 1; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i <= edgeCount; i++) {
            int src = inputs.get(i).get(0);
            int dest = inputs.get(i).get(1);
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        return adjList;
    }
}
