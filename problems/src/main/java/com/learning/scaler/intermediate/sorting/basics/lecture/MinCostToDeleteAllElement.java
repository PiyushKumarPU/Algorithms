package com.learning.scaler.intermediate.sorting.basics.lecture;

import java.util.Arrays;
import java.util.Comparator;

public class MinCostToDeleteAllElement {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4};
        MinCostToDeleteAllElement cost = new MinCostToDeleteAllElement();
        System.out.println(cost.idea1(arr));
        System.out.println(cost.idea2(arr));
    }

    public int idea1(int[] arr) {
        Arrays.sort(arr);
        reverse(arr);
        int totalSum = 0;
        for (int ele : arr) totalSum += ele;
        int minCost = totalSum;
        for (int i = 1; i < arr.length; i++) {
            int sumToReduce = 0;
            int temp = i - 1;
            while (temp >= 0) {
                sumToReduce += arr[temp];
                temp--;
            }
            minCost += (totalSum - sumToReduce);
        }
        return minCost;
    }

    public int idea2(int[] arr) {
        Arrays.sort(arr);
        reverse(arr);
        int minCost = 0;
        for (int i = 0; i < arr.length; i++) minCost += (arr[i] * (i + 1));
        return minCost;
    }

    private void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
