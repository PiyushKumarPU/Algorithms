package com.learning.problems.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        System.out.println(countAliveFishes(new int[]{16, 3, 3, 6, 7, 8, 17, 13, 7}, "LRLRLLRRl"));
    }


    public static int countAliveFishes(int[] A, String B) {
        int N = A.length;
        int aliveCount = N;  // Initially, all fishes are alive
        int leftFishSize = 0; // Size of the left-moving fish encountered

        for (int i = 0; i < N; i++) {
            if (B.charAt(i) == 'L') {
                // Fish moving left
                if (leftFishSize != 0 && A[i] > leftFishSize) {
                    // Fish moving left is larger, so it eats the fish moving right
                    aliveCount--;
                } else {
                    // Fish moving right is larger or no fish moving left encountered
                    leftFishSize = A[i]; // Update the size of left-moving fish encountered
                }
            } else {
                // Fish moving right
                leftFishSize = 0; // Reset the size of left-moving fish encountered
            }
        }

        return aliveCount;
    }

    public static int canCompleteCircuit(final int[] A, final int[] B) {
        if (A.length == 1 && A[0] == B[0]) return 0;
        for (int i = 0; i < A.length; i++) {
            if (canTravel(i, A, B)) return i;
        }
        return -1;

    }

    private static boolean canTravel(int index, int[] A, int[] B) {
        int start = index + 1, currentGas = A[index] - B[index];
        if (currentGas < 0) return false;
        start = start % A.length;
        while (currentGas >= 0 && index != start) {
            currentGas += A[start] - B[start];
            start = (start + 1) % A.length;
        }
        return currentGas >= 0;
    }
}
