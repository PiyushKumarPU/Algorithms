package com.learning.scaler.advance.module2.sort.merge.lecture;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Find smallest number that can be formed by rearranging digits given in an array.
* */
public class RearrangeToFindMin {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(6, 3, 4, 2, 7, 2, 1));
        System.out.println(rearrangeUsingLibrary(integers));
        System.out.println(rearrangeUsingCountSort(integers));
    }

    public static List<Integer> rearrangeUsingLibrary(List<Integer> integers) {
        integers.sort(Comparator.naturalOrder());
        return integers;
    }

    public static List<Integer> rearrangeUsingCountSort(List<Integer> integers) {
        int[] countArray = new int[10];
        for (int i : integers) countArray[i]++;
        List<Integer> result = new ArrayList<>(integers.size());
        for (int i = 0; i < countArray.length; i++) {
            for (int index = 0; index < countArray[i]; index++) {
                result.add(i);
            }
        }
        return result;
    }
}
