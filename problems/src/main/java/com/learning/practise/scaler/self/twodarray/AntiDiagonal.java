package com.learning.practise.scaler.self.twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonal {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(diagonal(new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}})));

       System.out.println(diagonal1(
               List.of(
                       List.of(1, 2, 3),
                       List.of(4, 5, 6),
                       List.of(7, 8, 9)
               )));



    }

    static ArrayList<ArrayList<Integer>> diagonal1(List<List<Integer>> A) {
        int n = A.size();
        int N = 2 * n - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N; i++)
            result.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.get(i + j).add(A.get(i).get(j));
            }
        }
        for (ArrayList<Integer> data : result) {
            while (data.size() < n) {
                data.add(0);
            }
        }
        return result;
    }

    public static int[][] diagonal(int[][] A) {
        int arrayLength = A.length;
        int newArrayLength = 2 * arrayLength - 1;
        int[][] result = new int[newArrayLength][arrayLength];
        for (int[] inner : result) {
            Arrays.fill(inner, 0);
        }
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                result[i + j][j] = A[i][j];
            }
        }
        return result;

    }
}
