package com.learning.scaler.advance.module1.array1d.lecture;


import java.util.List;

/*
Problem Description:
    Given and array of integer with initial value as zero, return final array after Q queries
    Given Queries:
        (i,j,x) -> Add x to each element of the array starting from index i till index j
* */
public class Queries2 {

    public int[] performQueries(int A, List<List<Integer>> queries) {
        int[] result = new int[A];
        for (List<Integer> row : queries) {
            int startIndex = row.get(0), endIndex = row.get(1), value = row.get(2);
            result[startIndex - 1] += value;
            if (endIndex < A) result[endIndex] -= value;
        }
        for (int i = 1; i < result.length; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }
}
