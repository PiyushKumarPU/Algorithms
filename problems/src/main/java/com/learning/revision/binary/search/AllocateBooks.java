package com.learning.revision.binary.search;

public class AllocateBooks {

    public static void main(String[] args) {
        int[] A = {97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24};
        int B = 26;
        AllocateBooks allocateBooks = new AllocateBooks();
        System.out.println(allocateBooks.books(A, B));
    }


    public int books(int[] A, int B) {
        if (A == null || A.length < B) return -1;
        int start = Integer.MIN_VALUE, end = 0, ans = 0;
        for (int a : A) {
            start = Math.max(start, a);
            end += a;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidPage(A, B, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValidPage(int[] A, int students, int pageCount) {
        int count = 1, assignedPages = 0;
        for (int page : A) {
            if (assignedPages + page <= pageCount) {
                assignedPages += page;
            } else {
                count++;
                assignedPages = page;
                if (count > students) return false;
            }
        }
        return count <= students;
    }

}
