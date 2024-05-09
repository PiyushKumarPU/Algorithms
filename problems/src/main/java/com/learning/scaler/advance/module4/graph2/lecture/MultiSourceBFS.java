package com.learning.scaler.advance.module4.graph2.lecture;

import com.learning.scaler.advance.module4.ConstructGraphs;

import java.util.*;

public class MultiSourceBFS {

    public static void main(String[] args) {
        List<Integer> sources = new ArrayList<>(List.of(11, 7, 2));
        List<Integer> targets = new ArrayList<>(List.of(9, 13, 5));
        List<List<Integer>> edges = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(1, 11)),
                        new ArrayList<>(List.of(11, 6)),
                        new ArrayList<>(List.of(11, 5)),
                        new ArrayList<>(List.of(5, 2)),
                        new ArrayList<>(List.of(5, 4)),
                        new ArrayList<>(List.of(2, 3)),
                        new ArrayList<>(List.of(8, 7)),
                        new ArrayList<>(List.of(7, 10)),
                        new ArrayList<>(List.of(10, 13)),
                        new ArrayList<>(List.of(13, 9)),
                        new ArrayList<>(List.of(9, 3)),
                        new ArrayList<>(List.of(3, 12))
                )
        );
        System.out.println(findNearestSource(sources, targets, 13, edges));
    }

    public static Map<Integer, Integer> findNearestSource(List<Integer> sources, List<Integer> targets,
                                                          int A, List<List<Integer>> edges) {
        Map<Integer, Integer> result = new HashMap<>(sources.size());
        List<List<Integer>> adjList = ConstructGraphs.constructAdjList(edges, A);
        Queue<NodeDistance> queue = new LinkedList<>();
        boolean[] visited = new boolean[A + 1];
        for (int source : sources) {
            queue.add(new NodeDistance(0, source));
            visited[source] = true;
        }
        while (!queue.isEmpty()) {
            NodeDistance current = queue.poll();
            visited[current.node] = true;
            if (targets.contains(current.node)) {
                if (result.containsKey(current.node)) {
                    if (result.get(current.node) > current.distance)
                        result.replace(current.node, current.distance);
                } else result.put(current.node, current.distance);
            } else {
                // add all neighbour
                for (int nbr : adjList.get(current.node)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        queue.add(new NodeDistance(current.distance + 1, nbr));
                    }
                }
            }
        }

        return result;
    }

}

class NodeDistance {
    int distance;
    int node;

    public NodeDistance(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
