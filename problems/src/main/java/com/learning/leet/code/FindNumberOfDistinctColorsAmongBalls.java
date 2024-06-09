package com.learning.leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindNumberOfDistinctColorsAmongBalls {

    public static void main(String[] args) {
        FindNumberOfDistinctColorsAmongBalls balls = new FindNumberOfDistinctColorsAmongBalls();
        System.out.println(Arrays.toString(balls.queryResultsN(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));
    }

    // O(n^2)
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        int[] color = new int[limit + 1];
        Arrays.fill(color, -1);
        int index = 0;
        for (int[] query : queries) {
            color[query[0]] = query[1];
            result[index++] = countColor(color);
        }
        return result;
    }

    public int[] queryResultsN(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        HashMap<Integer, Integer> colorCountMap = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColorMap.containsKey(ball)) {
                int existingColor = ballColorMap.get(ball);
                colorCountMap.put(existingColor, colorCountMap.get(existingColor) - 1);
                if (colorCountMap.get(existingColor) == 0) {
                    colorCountMap.remove(existingColor);
                }
            }
            ballColorMap.put(ball, color);
            colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);
            result[i] = colorCountMap.size();
        }
        return result;
    }

    public int[] queryResultsFast(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> ballMap = new HashMap<>((int) (queries.length / 0.75 + 1));
        Map<Integer, Integer> colorMap = new HashMap<>((int) (queries.length / 0.75 + 1));

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballMap.containsKey(ball)) {
                int oldColor = ballMap.get(ball);

                if (color != oldColor) {
                    int oldColorCount = colorMap.get(oldColor);
                    ballMap.put(ball, color);
                    colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

                    if (oldColorCount == 1) {
                        colorMap.remove(oldColor);
                    } else {
                        colorMap.put(oldColor, oldColorCount - 1);
                    }
                }
            } else {
                ballMap.put(ball, color);
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            }
            result[i] = colorMap.size();
        }
        return result;
    }


    private int countColor(int[] colors) {
        HashSet<Integer> count = new HashSet<>();
        for (int color : colors) if (color > 0) count.add(color);
        return count.size();
    }

}
