package com.learning.scaler.advance.module1.array2d.additional;


import java.util.List;

/*
Problem Description
    Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring
    all the numbers less than or equal to B together.
    Note: It is possible to swap any two elements, not necessarily consecutive.

Problem Constraints
    1 <= length of the array <= 100000
    -10^9 <= A[i], B <= 10^9

Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

Output Format
    Return the minimum number of swaps.

Example Input
    Input 1:
         A = [1, 12, 10, 3, 14, 10, 5]
         B = 8
    Input 2:
         A = [5, 17, 100, 11]
         B = 20

Example Output
    Output 1:
         2
    Output 2:
         1

Example Explanation
    Explanation 1:
         A = [1, 12, 10, 3, 14, 10, 5]
         After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
         After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
         Now, all elements less than or equal to 8 are together.
    Explanation 2:
         A = [5, 17, 100, 11]
         After swapping 100 and 11, A => [5, 17, 11, 100].
         Now, all elements less than or equal to 20 are together.
* */
public class MinimumSwaps {

    public int solve(int[] A, int B) {
        int n = A.length;
        int cnt = 0;
        // count number of elements <= B
        for (int x : A)
            if (x <= B)
                cnt++;
        // If there is only one element, No need to swap
        if (cnt <= 1)
            return 0;
        else {
            int l = 0, r = 0, x = 0;
            // Find the count of elements <= B in every window of length cnt using two
            //pointer approach
            while (r < cnt) {
                if (A[r] > B)
                    x++;
                r++;
            }
            int ans = x;
            while (r < n) {
                if (A[r] > B)
                    x++;
                if (A[l] > B)
                    x--;
                ans = Math.min(ans, x);
                r++;
                l++;
            }
            return ans;
        }
    }

    public static int solve(List<Integer> A, int B) {
        int windowSize = 0, currentCount, tempCount = 0, size = A.size();
        for (int ele : A) if (ele <= B) windowSize++;
        for (int i = 0; i < windowSize; i++) if (A.get(i) > B) tempCount++;
        currentCount = tempCount;

        for (int i = 1; i <= (size - windowSize); i++) {
            int current = A.get(i + windowSize - 1), prev = A.get(i - 1);
            if (current > B) tempCount++;
            if (prev > B) tempCount--;

            currentCount = Math.min(currentCount, tempCount);
        }
        return currentCount;
    }
}
