package com.learning.scaler.intermediate.twod.matrix.lecture;

import java.util.ArrayList;
import java.util.List;

public class PrintAllAntiDiagonal {

    public static void main(String[] args) {
        PrintAllAntiDiagonal diagonal = new PrintAllAntiDiagonal();
        List<List<Integer>> inputs = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(1, 2, 3)),
                        new ArrayList<>(List.of(4, 5, 6)),
                        new ArrayList<>(List.of(7, 8, 9)))
        );
        System.out.println(diagonal.printAllAntiDiagonal(inputs));
    }

    public List<List<Integer>> printAllAntiDiagonal(List<List<Integer>> inputs) {
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < inputs.get(0).size(); j++) {
            result.add(constructRow(inputs, i, j));
        }
        for (i = 1; i < inputs.size(); i++) {
            result.add(constructRow(inputs, i, inputs.get(i).size() - 1));
        }
        return result;
    }

    private List<Integer> constructRow(List<List<Integer>> inputs, int i, int j) {
        int start = i, end = j;
        List<Integer> row = new ArrayList<>();
        while (end > -1 && start < inputs.get(0).size()) {
            row.add(inputs.get(start).get(end));
            start++;
            end--;
        }
        return row;
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
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
}
