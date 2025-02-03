package com.learning.scaler.advance.module1.arrays.interview.assignment;

/*
Problem Description
    Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
    1 <= N <= 1000000
    -10^9 <= A[i] <= 10^9

Input Format
    First argument is an integer array A.

Output Format
    Returns an integer denoting the first missing positive integer.

Example
    Input 1:
        [1, 2, 0]
    Input 2:
        [3, 4, -1, 1]
    Input 3:
        [-8, -7, -6]

Example
    Output 1:
        3
    Output 2:
        2
    Output 3:
        1

Example Explanation
    Explanation 1:
        A = [1, 2, 0]
        First positive integer missing from the array is 3.
    Explanation 2:
        A = [3, 4, -1, 1]
        First positive integer missing from the array is 2.
    Explanation 3:
        A = [-8, -7, -6]
        First positive integer missing from the array is 1.
* */
public class FirstMissingInteger {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        int temp, i = 0;
        //place each val in range [1,nums.length) at nums[val-1]
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                if (nums[i] == i + 1) {
                    i++;
                }
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
