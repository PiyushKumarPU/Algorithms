package com.learning.scaler.advance.module2.sort.merge.assignment;


/*
Problem Description
    Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
    Note: A linear time complexity is expected and you should avoid use of any library function.

Problem Constraints
    -2×10^9 <= A[i], B[i] <= 2×10^9
    1 <= |A|, |B| <= 5×10^4

Input Format
    First Argument is a 1-D array representing  A.
    Second Argument is also a 1-D array representing B.

Output Format
    Return a 1-D vector which you got after merging A and B.

Example
    Input 1:
        A = [4, 7, 9]
        B = [2, 11, 19]
    Input 2:
        A = [1]
        B = [2]

Example
    Output 1:
        [2, 4, 7, 9, 11, 19]
    Output 2:
        [1, 2]

Example
    Explanation 1:
        Merging A and B produces the output as described above.
    Explanation 2:
         Merging A and B produces the output as described above.
* */
public class MergeTwoSortedArrays {

    public static int[] merge(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[] result = new int[m + n];
        int index1 = 0, index2 = 0, currentIndex = 0;
        while (index1 < m && index2 < n) {
            int first = A[index1];
            int second = B[index2];
            if (first <= second) {
                result[currentIndex++] = first;
                index1++;
                if (first == second) {
                    result[currentIndex++] = second;
                    index2++;
                }
            } else {
                result[currentIndex++] = second;
                index2++;
            }
        }

        // check for a remaining element of a larger array
        if (index1 < m) {
            while (index1 < m) {
                result[currentIndex++] = A[index1];
                index1++;
            }
        }
        if (index2 < n) {
            while (index2 < n) {
                result[currentIndex++] = B[index2];
                index2++;
            }
        }
        return result;
    }
}
