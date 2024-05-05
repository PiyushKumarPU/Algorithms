package com.learning.revision.binary.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WoodCuttingMadeEasy {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(114, 55, 95, 131, 77, 111, 141));
        int B = 95;
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int start = A.get(0), end = A.get(0), ans = 0;
        for (int a : A) {
            start = Math.min(a, start);
            end = Math.max(a, end);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long totalWood = findWoodLength(mid, A);
            if (totalWood >= (long)B) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private static long findWoodLength(int height, ArrayList<Integer> A) {
        long totalWood = 0;
        for (int a : A) {
            if (a > height) {
                totalWood += (a - height);
            }
        }
        return totalWood;
    }

    public long upperHeightSum(int m, ArrayList<Integer> A) {
        long sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > m)
                sum += A.get(i) - m;
        }
        return sum;
    }

    public int solve2(ArrayList<Integer> A, int B) {
        int low = 0;
        int n = A.size();
        int high = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, A.get(i));// calulating max height of tree
        }
        while (low <= high) {              // binary search starts here
            int mid = (low + high) / 2;
            if (upperHeightSum(mid, A) >= (long) B) {//if sum of tree above height mid is more than B
                ans = Math.max(ans, mid);  //update ans
                low = mid + 1;              // try to increase the height
            } else {                       // upper height is lesser than B
                high = mid - 1;           // so need to go down
            }

        }
        return ans;                     // return max possible height
    }


}
