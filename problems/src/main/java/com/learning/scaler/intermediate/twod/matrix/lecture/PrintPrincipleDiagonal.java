package com.learning.scaler.intermediate.twod.matrix.lecture;

import java.util.ArrayList;
import java.util.List;

public class PrintPrincipleDiagonal {

    public List<Integer> printPrincipleDiagonal(List<List<Integer>> inputs) {
        List<Integer> result = new ArrayList<>(inputs.size());
        for (int i = 0; i < inputs.get(0).size(); i++) {
            for (int j = 0; j < inputs.get(i).size(); j++) {
                if (i == j) result.add(inputs.get(i).get(j));
            }
        }
        return result;
    }

}
