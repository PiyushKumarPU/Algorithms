package com.learning;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().solve(new int[]{16, 7, 3, 5, 9, 8, 6, 15}));
    }

    public int solve(int[] A) {
        int ans = 0;
        int size = A.length;
        //building heap
        for (int i = ((A.length) / 2) - 1; i >= 0; i--) {
            heapify(i, size, A);
        }

        while (size > 1) {
            int a = A[0];
            A[0] = A[size - 1];
            size--;
            heapify(0, size, A);
            int b = A[0];
            int c = a + b;
            A[0] = c;
            ans += c;
            heapify(0, size, A);
        }
        return ans;
    }


    public void heapify(int i, int size, int[] A) {
        int min = i;
        int l_c = (2 * min) + 1;
        int r_c = (2 * min) + 2;

        if (l_c < size && A[l_c] < A[min])
            min = l_c;

        if (r_c < size && A[r_c] < A[min])
            min = r_c;

        if (min != i) {
            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;
            heapify(min, size, A);
        }

    }
}
 