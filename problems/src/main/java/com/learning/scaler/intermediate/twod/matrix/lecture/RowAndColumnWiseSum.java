package com.learning.scaler.intermediate.twod.matrix.lecture;

import java.util.ArrayList;
import java.util.List;

public class RowAndColumnWiseSum {

    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(1, 2, 3)),
                        new ArrayList<>(List.of(1, 2, 3)),
                        new ArrayList<>(List.of(1, 2, 3)))
        );
        RowAndColumnWiseSum sum = new RowAndColumnWiseSum();
        System.out.println(sum.findRowWiseSum(inputs));
        System.out.println(sum.findColumnWiseSum(inputs));


    }

    public List<List<Integer>> findRowWiseSum(List<List<Integer>> inputs) {
        List<List<Integer>> result = new ArrayList<>(inputs.size());
        for (List<Integer> input : inputs) {
            int currentRowSum = 0;
            for (Integer integer : input) {
                currentRowSum += integer;
            }
            result.add(new ArrayList<>(List.of(currentRowSum)));
        }
        return result;
    }

    public List<Integer> findColumnWiseSum(List<List<Integer>> inputs) {
        List<Integer> result = new ArrayList<>(inputs.get(0).size());
        for (int i = 0; i < inputs.get(0).size(); i++) {
            int currentRowSum = 0;
            for (List<Integer> input : inputs) {
                currentRowSum += input.get(i);
            }
            result.add(currentRowSum);
        }
        return result;
    }
}
