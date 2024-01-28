package com.learning.scaler.advance.module3.hashing3.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/*
Problem Description
    Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
    Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.

Problem Constraints
    1 <= |A| <= 10^5

Input Format
    The first and only argument is an integer array A.

Output Format
    Return one integer corresponding to the minimum possible distance between a special pair.

Example Input
    Input 1:
        A = [7, 1, 3, 4, 1, 7]
    Input 2:
        A = [1, 1]

Example Output
    Output 1:
         3
    Output 2:
         1
* */
public class ShaggyAndDistances {

    public static void main(String[] args) {
        ShaggyAndDistances distances = new ShaggyAndDistances();
        System.out.println(distances.solve(new ArrayList<>(List.of(7, 1, 3, 4, 7, 7))));
    }

    public int solve(ArrayList<Integer> A) {
        Map<Integer, List<Integer>> valIndexMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            Integer current = A.get(i);
            List<Integer> existingIndexes = valIndexMap.getOrDefault(current, new ArrayList<>());
            existingIndexes.add(i);
            valIndexMap.put(current, existingIndexes);
        }
        AtomicReference<Integer> minValue = new AtomicReference<>(Integer.MAX_VALUE);
        valIndexMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1).forEach(current -> {
            List<Integer> indexes = current.getValue();
            int i = 0, j = 1;
            while (j < indexes.size()) {
                minValue.set(Math.min(minValue.get(), Math.abs(indexes.get(i) - indexes.get(j))));
                i++;
                j++;
            }
        });
        return minValue.get().equals(Integer.MAX_VALUE) ? -1 : minValue.get();
    }
}
