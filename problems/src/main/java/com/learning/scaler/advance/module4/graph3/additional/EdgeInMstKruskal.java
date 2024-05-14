package com.learning.scaler.advance.module4.graph3.additional;

import java.util.*;

public class EdgeInMstKruskal {

    public static int[] findMST(int A, int[][] B) {

        List<Integer> results = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (int[] edge : B) {
            edges.add(new Edge(edge[0] - 1, edge[1] - 1, edge[2]));
        }
        Collections.sort(edges);

        DisjointSet dsu = new DisjointSet(A);
        Set<Edge> mstEdges = new HashSet<>();

        for (Edge edge : edges) {
            if (dsu.find(edge.source) != dsu.find(edge.destination)) {
                dsu.union(edge.source, edge.destination);
                mstEdges.add(edge);
            }
        }

        for (int[] edge : B) {
            Edge e = new Edge(edge[0] - 1, edge[1] - 1, edge[2]);
            results.add(mstEdges.contains(e) ? 1 : 0);
        }
        int[] result = new int[results.size()];
        int index = 0;
        for(Integer i : results){
            result[index++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] B = {
                {1, 2, 1},
                {2, 3, 2},
                {3, 4, 1},
                {4, 1, 3}
        };

    }

}

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) return;

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}
