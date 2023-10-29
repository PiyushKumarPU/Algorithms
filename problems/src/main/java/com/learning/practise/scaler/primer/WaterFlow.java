package com.learning.practise.scaler.primer;

public class WaterFlow {

    public static void main(String[] args) {
        /*System.out.println(solve(new int[][]{
                {2, 2},
                {2, 2}
        }));*/

        System.out.println(solve(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

    public static int solve(int[][] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (isEligibleToFlow(A, i, j)) count++;
            }
        }
        return count;
    }

    private static boolean isEligibleToFlow(int[][] A, int i, int j) {
        int currentVal = A[i][j];
        // check row
        int index = j - 1;
        boolean isLeftFlowable = true;
        while (index >= 0) {
            if (A[i][index] > currentVal) {
                isLeftFlowable = false;
                break;
            }
            index--;
        }
        boolean isRightFlowable = true;
        index = j + 1;
        while (index < A[0].length) {
            if (A[i][index] > currentVal) {
                isRightFlowable = false;
                break;
            }
            index++;
        }

        boolean isTopFlowable = true;
        index = i - 1;
        while (index >= 0) {
            if (A[index][j] > currentVal) {
                isTopFlowable = false;
                break;
            }
            index--;
        }

        boolean isBottomFlowable = true;
        index = i + 1;
        while (index < A.length) {
            if (A[index][j] > currentVal) {
                isBottomFlowable = false;
                break;
            }
            index++;
        }
        boolean isFlowableIndex = (isLeftFlowable && isRightFlowable) && (isTopFlowable && isBottomFlowable);
        if (isFlowableIndex) {
            System.out.println("Index " + i + " " + j + " with value " + A[i][j]);
        }
        return isFlowableIndex;
    }
}
