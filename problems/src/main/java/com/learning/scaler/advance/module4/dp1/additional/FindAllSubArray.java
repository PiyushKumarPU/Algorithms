package com.learning.scaler.advance.module4.dp1.additional;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubArray {

    int max;

    public static void main(String[] args) {
        System.out.println(new FindAllSubArray().maxProduct(new ArrayList<>(List.of(0, 3, 3, 0))));
    }


    public int maxProduct(final List<Integer> A) {
        int[] prodArr = new int[A.size()];
        prodArr[0] = max = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prodArr[i] = A.get(i) * prodArr[i - 1];
            max = Math.max(max, prodArr[i]);
        }
        maxProductSubArrays(A, prodArr, 1, 1);
        return max;
    }


    void maxProductSubArrays(final List<Integer> A, int[] prodArr, int start, int end) {
        if (end < A.size()) {
            max = Math.max(max, (prodArr[start - 1] > 0 ? (prodArr[end] / prodArr[start - 1]) : 0));
            maxProductSubArrays(A, prodArr, start, end + 1);
        } else if (start < A.size()) {
            maxProductSubArrays(A, prodArr, start + 1, start + 1);
        }
    }
}
