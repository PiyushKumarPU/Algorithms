package com.learning.leet.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(heights));

        String str  = "";
        str.indexOf("   ");
    }

    int[][] minEffort;
    int[] rows = {-1, 1, 0, 0};
    int[] cols = {0, 0, -1, 1};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        minEffort = new int[m][n];
        for (int[] arr : minEffort) Arrays.fill(arr, Integer.MAX_VALUE);
        minEffort[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        pq.offer(new Triplet(0, 0, 0));

        while (!pq.isEmpty()) {
            Triplet current = pq.poll();
            int x = current.x, y = current.y, effort = current.effort;
            if (x == m - 1 && y == n - 1) return effort;

            for (int k = 0; k < 4; k++) {
                int ni = x + rows[k];
                int nj = y + cols[k];

                if (isValidIndex(ni, nj, heights)) {
                    int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[ni][nj]));

                    if (newEffort < minEffort[ni][nj]) {
                        minEffort[ni][nj] = newEffort;
                        pq.offer(new Triplet(ni, nj, newEffort));
                    }
                }
            }
        }
        return -1; // Should not reach here
    }

    private boolean isValidIndex(int i, int j, int[][] heights) {
        return (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length);
    }

}

class Triplet {
    int x, y, effort;

    public Triplet(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}
