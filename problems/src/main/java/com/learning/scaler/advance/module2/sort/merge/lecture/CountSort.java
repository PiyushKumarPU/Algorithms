package com.learning.scaler.advance.module2.sort.merge.lecture;

import java.util.ArrayList;
import java.util.List;

public class CountSort {

    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>(List.of(1, 3, 5, 2, 3, 4, 19, -9, -9, -5, -5, -67));

        System.out.println(countSort(inputs));
    }

    public static List<Integer> countSort(List<Integer> integers) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : integers) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int[] countArray = new int[max - min + 1];
        for (int i : integers) {
            countArray[i - min]++;
        }
        List<Integer> result = new ArrayList<>(integers.size());
        for (int i = 0; i < countArray.length; i++) {
            for (int index = 0; index < countArray[i]; index++) {
                result.add(i + min);
            }
        }
        return result;

    }
}
