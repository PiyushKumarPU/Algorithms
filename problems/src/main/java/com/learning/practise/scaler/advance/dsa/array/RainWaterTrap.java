package com.learning.practise.scaler.advance.dsa.array;

import java.util.List;

public class RainWaterTrap {

    public static void main(String[] args) {
        System.out.println(trap(List.of(0, 1, 0, 2)));
        //System.out.println(trap(List.of(1, 2)));
    }

    public static int trap(final List<Integer> A) {
        int size = A.size();
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = 0;
        rightMax[size - 1] = 0;
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(A.get(i - 1), leftMax[i - 1]);
        }

        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(A.get(i + 1), rightMax[i + 1]);
        }

        int trapCount = 0;
        for (int i = 1; i < size - 1; i++) {
            int boundary = Math.min(leftMax[i], rightMax[i]);
            trapCount += (A.get(i) > boundary ? 0 : boundary - A.get(i));
        }
        return trapCount;
    }

    public int trap(int[] height) {
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = 0;
        rightMax[size - 1] = 0;
        for (int i = 1; i < size; i++) {
                leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
        }

        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
        }

        int trapCount = 0;
        for (int i = 1; i < size - 1; i++) {
            int boundary = Math.min(leftMax[i], rightMax[i]);
            trapCount += (height[i] > boundary ? 0 : boundary - height[i]);
        }
        return trapCount;
    }
}
