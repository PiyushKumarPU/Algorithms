package com.learning.practise.scaler.self.twodarray;

import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        //printResult(buildSpiral(3));
        System.out.println(buildSpiral(3));
        //generateSpiral(3).forEach(System.out::println);

        /*printResult(buildSpiral(4));
        System.out.println();
        printResult(buildSpiral(5));
        System.out.println();*/
    }

    private static ArrayList<ArrayList<Integer>> buildSpiral(int size) {
        Integer[][] result = new Integer[size][size];
        int startElement = 0, topIndex = 0, rightIndex = size, leftIndex = 0, bottomIndex = size;
        while (startElement < (size * size)) {
            // Left to right
            for (int index = leftIndex; index < rightIndex; index++) {
                result[topIndex][index] = ++startElement;
            }
            topIndex++;

            // Top to Bottom
            for (int index = topIndex; index < bottomIndex; index++) {
                result[index][rightIndex - 1] = ++startElement;
            }
            rightIndex--;

            //Right to left
            for (int index = rightIndex - 1; index >= leftIndex; index--) {
                result[bottomIndex - 1][index] = ++startElement;
            }
            bottomIndex--;

            // Bottom to top
            for (int index = bottomIndex - 1; index >= topIndex; index--) {
                result[index][leftIndex] = ++startElement;
            }
            leftIndex++;
        }


        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (Integer[] array : result) {
            ArrayList<Integer> row = new ArrayList<>();
            for (Integer val : array) {
                row.add(val);
            }
            list.add(row);
        }
        return list;
    }

    private static ArrayList<ArrayList<Integer>> generateSpiral(int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(new ArrayList<>(size));
        }
        int startElement = 0, topIndex = 0, rightIndex = size, leftIndex = 0, bottomIndex = size, index = 0;
        while (startElement < (size * size)) {
            // Left to right
            for (index = leftIndex; index < rightIndex; index++) {
                result.get(topIndex).add(index, ++startElement);
            }
            topIndex++;

            // Top to Bottom
            for (index = topIndex; index < bottomIndex; index++) {
                result.get(index).add(rightIndex - 1, ++startElement);
            }
            rightIndex--;

            //Right to left
            for (index = rightIndex - 1; index >= leftIndex; index--) {
                result.get(bottomIndex - 1).add(index, ++startElement);
            }
            bottomIndex--;

            // Bottom to top
            for (index = bottomIndex - 1; index >= topIndex; index--) {
                result.get(index).add(leftIndex, ++startElement);
            }
            leftIndex++;
        }
        return result;
    }

    private static void printResult(int[][] results) {
        int size = results.length;
        for (int index = 0; index < size; index++) {
            for (int val : results[index]) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
