package com.learning.leet.code;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort the points by the end coordinate
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1; // We need at least one arrow
        int currentEnd = points[0][1]; // End point of the first balloon

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currentEnd) {
                // If the current balloon starts after the end of the previous one
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }
}

