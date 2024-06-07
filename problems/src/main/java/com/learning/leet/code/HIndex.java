package com.learning.leet.code;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {

    public static void main(String[] args) {
        int[] arr = {11, 15};
        System.out.println(new HIndex().hIndex(arr));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] b = new int[n + 1];
        for (int val : citations) {
            if (n <= val) b[n]++;
            else b[val]++;
        }
        int c = 0;
        for (int i = n; i >= 0; i--) {
            c += b[i];
            if (c >= i) return i;
        }
        return 0;
    }

    public int hIndexUsingSort(int[] citations) {
        Integer[] sortedCitations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedCitations, Collections.reverseOrder());

        int hIndex = 0;
        // Iterate through the sorted array to find the h-index
        for (int i = 0; i < sortedCitations.length; i++) {
            if (sortedCitations[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }

        return hIndex;
    }
}
