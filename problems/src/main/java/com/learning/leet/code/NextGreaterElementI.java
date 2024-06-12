package com.learning.leet.code;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // find next greater of each element in nums2
        int[] nextGreater = new int[nums2.length];
        HashMap<Integer, Integer> valIndexMap = new HashMap<>();
        Stack<Integer> largeStack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!largeStack.isEmpty() && largeStack.peek() <= nums2[i]) largeStack.pop();
            nextGreater[i] = largeStack.isEmpty() ? -1 : largeStack.peek();
            largeStack.push(nums2[i]);
            valIndexMap.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater[valIndexMap.get(nums1[i])];
        }
        return res;
    }

}
