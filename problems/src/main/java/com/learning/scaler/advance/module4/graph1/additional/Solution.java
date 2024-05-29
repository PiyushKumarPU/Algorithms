package com.learning.scaler.advance.module4.graph1.additional;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static int maxn = 100009;
    static int n, q;
    static int mx = 0;
    static int[] val = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<ArrayList<Integer>> lvl;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        lvl = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<Integer>());
            lvl.add(new ArrayList<Integer>());
        }
        mx = 0;
    }

    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        graph();
        n = A;
        q = F.length;
        for (int i = 0; i < n; i++)
            val[i + 1] = D[i];
        for (int i = 0; i < n - 1; i++) {
            adj.get(B[i]).add(C[i]);
            adj.get(C[i]).add(B[i]);
        }
        mx = 0;
        dfs(1, 1, 0);
        for (int i = 0; i < maxn; i++) {
            Collections.sort(lvl.get(i));
        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = E[i];
            int x = F[i];
            l %= (mx + 1);
            int it = lowerBound(lvl.get(l), 0, lvl.get(l).size(), x);
            if (it == lvl.get(l).size())
                res[i] = -1;
            else res[i] = lvl.get(l).get(it);
        }
        return res;
    }

    public static void dfs(int u, int v, int d) {
        mx = Math.max(mx, d);
        lvl.get(d).add(val[u]);
        for (int i : adj.get(u)) {
            if (i == v) continue;
            dfs(i, u, d + 1);
        }
    }

    static int lowerBound(ArrayList<Integer> a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
