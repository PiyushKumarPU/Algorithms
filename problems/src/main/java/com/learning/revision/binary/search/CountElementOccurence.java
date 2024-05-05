package com.learning.revision.binary.search;

public class CountElementOccurence {

    public static void main(String[] args) {

        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;

        System.out.println(findCount(A, B));

    }

    public static int findCount(final int[] A, int B) {
        int leftIndex = -1, rightIndex = -1, start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) {
                leftIndex = mid;
                end = mid - 1;
            } else if (A[mid] < B) start = mid + 1;
            else end = mid - 1;
        }
        // find rightIndex
        start = leftIndex;
        end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) {
                rightIndex = mid;
                start = mid + 1;
            } else if (A[mid] > B) end = mid - 1;
            else start = mid + 1;
        }
        return leftIndex < 0 ? 0 : (rightIndex - leftIndex + 1);
    }

}
