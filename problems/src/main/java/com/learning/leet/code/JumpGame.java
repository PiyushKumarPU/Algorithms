package com.learning.leet.code;

public class JumpGame {


    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return true;
        int length = nums.length;
        boolean[] reachableArray = new boolean[length];
        reachableArray[length - 1] = true;
        for (int i = length - 2; i >= 0; i--) {
            int currentVal = nums[i];
            if (currentVal == 0) continue;
            // check if directly reachable
            if (i + nums[i] >= length)
                reachableArray[i] = true;
            if (!reachableArray[i]) {
                for (int j = 1; j <= currentVal; j++) {
                    int nextJump = i + j;
                    if (nextJump < length && reachableArray[nextJump]) {
                        reachableArray[i] = true;
                        break;
                    }
                }
            }
        }
        return reachableArray[0];
    }
}
