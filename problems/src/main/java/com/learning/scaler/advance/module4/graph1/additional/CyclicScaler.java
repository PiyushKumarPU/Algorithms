package com.learning.scaler.advance.module4.graph1.additional;

import java.util.ArrayList;

public class CyclicScaler {
    static int maxn = 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited = new int[maxn];
    static int[] recStack = new int[maxn];

    public static void graph() {
        adj = new ArrayList<>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            recStack[i] = 0;
            adj.add(new ArrayList<>());
        }
    }

    public int solve(int A, int[][] B) {
        graph();
        for (int[] row : B)
            adj.get(row[0]).add(row[1]);
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0 && isCyclicUtil(i))
                return 1;
        }
        return 0;
    }

    public static boolean isCyclicUtil(int v) {
        if (visited[v] == 0) {
            // Mark the current node as visited and part of recursion stack
            visited[v] = 1;
            recStack[v] = 1;
            // Recur for all the vertices adjacent to this vertex
            for (int u : adj.get(v)) {
                if (visited[u] == 0 && isCyclicUtil(u))
                    return true;
                else if (recStack[u] == 1)
                    return true;
            }
        }
        recStack[v] = 0; // remove the vertex from recursion stack
        return false;
    }
}
