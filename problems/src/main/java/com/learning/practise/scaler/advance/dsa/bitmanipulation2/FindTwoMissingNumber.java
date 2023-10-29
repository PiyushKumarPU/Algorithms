package com.learning.practise.scaler.advance.dsa.bitmanipulation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTwoMissingNumber {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(2);
        integers.add(4);

        System.out.println(solve(integers));
        integers = new ArrayList<>();
        integers.add(5);
        integers.add(1);
        integers.add(3);
        integers.add(6);
        //System.out.println(solve(integers));
    }

    public static ArrayList<Integer> solve(List<Integer> A) {
        int[] indexCount = new int[A.size() + 2];
        ArrayList<Integer> result = new ArrayList<>(2);
        for (Integer element : A) {
            if (element > 0 && indexCount[element - 1] == 0) {
                indexCount[element - 1] = element;
            }
        }
        for (int i = 0; i <= A.size() + 1; i++) {
            if (indexCount[i] != (i + 1)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
