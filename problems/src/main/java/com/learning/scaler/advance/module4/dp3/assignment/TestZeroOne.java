package com.learning.scaler.advance.module4.dp3.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class TestZeroOne {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> newA = new ArrayList<>();
        ArrayList<Integer> newB = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) <= C) {
                newA.add(A.get(i));
                newA.add(B.get(i));
            }
        }
        A = newA;
        B = newA;
        if (A.isEmpty()) return 0;
        return solveIterative(A, B, C);
    }

    public int solveIterative(ArrayList<Integer> values, ArrayList<Integer> weights, int C) {
        int[][] indexWeightPair = new int[values.size() + 1][C + 1];
        int maxValue = 0;
        for(int i = 1; i <= C; i++){
            
        }
        return maxValue;
    }
}
