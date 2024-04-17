package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Hello world!
 */
public class App {

    public static int numWaysToSendSignal(int A) {
        if (A == 0) return 1;
        if (A == 1) return 2;

        final int MOD = 1000000007;
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[A];
    }

    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;
        int n = A.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = A[i] + A[left] + A[right];
                if (Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                    closestSum = currentSum;
                }

                if (currentSum < B) {
                    left++;
                } else if (currentSum > B) {
                    right--;
                } else {
                    return closestSum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(5, 12, 20, 25, 13, 24, 22, 35));
        insert(list, 10);
        System.out.println(list);
    }

    public static ArrayList<Integer> insert(ArrayList<Integer> list, int insert) {
        list.add(insert);
        int eleIdx = list.size() - 1;
        while (eleIdx >= 0) {
            int parentIdx = (eleIdx - 1) / 2;
            if (list.get(parentIdx) > list.get(eleIdx)) {
                //Collections.swap(list,parentIdx,eleIdx);
                swap(list, parentIdx, eleIdx);
                eleIdx = parentIdx;
            } else break;
        }
        return list;
    }

    public static void swap(ArrayList<Integer> list, int srcIdx, int destIdx) {
        int temp = list.get(srcIdx);
        list.set(srcIdx, list.get(destIdx));
        list.set(destIdx, temp);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, i1 = 0, i2 = 0;
        int l = nums1.length + nums2.length;
        int[] a = new int[(l / 2) + 1];
        while (i < a.length) {
            if (i1 < nums1.length && i2 < nums2.length) {
                a[i++] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
            } else if (i1 < nums1.length) {
                a[i++] = nums1[i1++];
            } else {
                a[i++] = nums2[i2++];
            }
        }
        if (l % 2 == 1) {
            return a[a.length - 1];
        } else {
            double t = (a[a.length - 2] + a[a.length - 1]);
            return t / 2.00;
        }
    }
}


