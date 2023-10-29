package com.learning.practise.scaler.self.twodarray;

import java.util.List;

public class RotatedSortedArray {

    public static void main(String[] args) {
     //   System.out.println(search(List.of(9, 10, 3, 5, 6, 8 ),5));
    }

    public static int search(final List<Integer> A, int B) {
        return A.contains(B) ? A.indexOf(B) : -1;
    }
}
