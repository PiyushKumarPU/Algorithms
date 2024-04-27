package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Hello world!
 */
public class App {

    public static int numWaysToSendSignal(int A) {
        if (A == 0) return 1;
        if (A == 1) return 2;

        final int MOD = 1000000007;
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[A];
    }

    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;
        int n = A.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = A[i] + A[left] + A[right];
                if (Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                    closestSum = currentSum;
                }

                if (currentSum < B) {
                    left++;
                } else if (currentSum > B) {
                    right--;
                } else {
                    return closestSum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {

        System.out.println();
    }

    int[][] healthPoints;

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        healthPoints = new int[A.size()][A.get(0).size()];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int damage = A.get(i).get(j);
                int nextHealth = calculateNextHealth(healthPoints, i, j, damage);
                healthPoints[i][j] = Math.max(1, nextHealth);
            }
        }
        return healthPoints[0][0];
    }

    private int calculateNextHealth(int[][] healthPoints, int i, int j, int damage) {
        if (i == healthPoints.length - 1 && j == healthPoints[0].length - 1) {
            return 1; // Bottom-right corner
        } else if (i == healthPoints.length - 1) {
            return healthPoints[i][j + 1] - damage; // Last row
        } else if (j == healthPoints[0].length - 1) {
            return healthPoints[i + 1][j] - damage; // Last column
        } else {
            return Math.min(healthPoints[i][j + 1], healthPoints[i + 1][j]) - damage; // Normal case
        }
    }


}


