package com.learning.leet.code;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 2, 1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int ans = 0, start = 0, end = height.length - 1;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            ans = Math.max(ans, area);
            if (height[start] <= height[end]) start++;
            else end--;
        }
        return ans;
    }

    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, ans = 0, sum, min;
        while (left < right) {
            min = Math.min(height[left], height[right]);

            sum = (right - left) * min;
            ans = Math.max(ans, sum);
            while (height[left] <= min && left < right) left++;
            while (height[right] <= min && left < right) right--;
        }
        return ans;
    }

}
