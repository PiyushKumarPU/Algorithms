package com.learning.scaler.advance.module2.binary_search.arrays.lecture;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted array of unique elements, search for a target and return its index,
if not present return -1.
* */
public class Problem1 {

    public static void main(String[] args) {
        List<Integer> searchSpace
                = List.of(1, 3, 5, 7, 9, 10, 11, 13, 15, 17, 19, 30, 35, 40);
        Integer target = 5;
        System.out.println(approach2(searchSpace, target));
    }

    // using linear search
    public static int approach1(ArrayList<Integer> list, Integer target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) return i;
        }
        return -1;
    }

    // Using binary search
    public static int approach2(List<Integer> list, Integer target) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int currentElement = list.get(mid);
            if (target.equals(currentElement)) return mid;
            else if (target > currentElement) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
