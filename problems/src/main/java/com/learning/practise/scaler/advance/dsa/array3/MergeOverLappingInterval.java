package com.learning.practise.scaler.advance.dsa.array3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingInterval {
    public static void main(String[] args) {

        ArrayList<Interval> input = new ArrayList<>();

        input.add(new Interval(5, 28));
        input.add(new Interval(7, 70));
        input.add(new Interval(54, 93));
        input.add(new Interval(5, 98));
        input.add(new Interval(46, 70));
        input.add(new Interval(42, 63));
        input.add(new Interval(5, 91));
        input.add(new Interval(30, 49));
        input.add(new Interval(36, 57));
        input.add(new Interval(31, 95));
        input.add(new Interval(86, 88));
        input.add(new Interval(9, 90));
        input.add(new Interval(5, 53));
        input.add(new Interval(42, 62));
        input.add(new Interval(14, 100));
        input.add(new Interval(59, 75));
        input.add(new Interval(32, 100));
        input.add(new Interval(5, 79));
        input.add(new Interval(31, 31));
        input.add(new Interval(7, 42));
        input.add(new Interval(13, 47));
        input.add(new Interval(44, 87));
        input.add(new Interval(61, 83));
        input.add(new Interval(100, 100));
        input.add(new Interval(96, 98));
        input.add(new Interval(47, 51));
        input.add(new Interval(34, 44));
        input.add(new Interval(6, 53));
        input.add(new Interval(30, 92));
        input.add(new Interval(50, 64));
        input.add(new Interval(37, 57));
        input.add(new Interval(49, 67));
        input.add(new Interval(2, 67));
        input.add(new Interval(36, 50));
        input.add(new Interval(55, 100));
        input.add(new Interval(54, 78));
        input.add(new Interval(58, 70));
        input.add(new Interval(2, 37));
        input.add(new Interval(13, 54));
        input.add(new Interval(7, 60));
        input.add(new Interval(16, 79));
        input.add(new Interval(35, 78));
        input.add(new Interval(17, 57));
        input.add(new Interval(16, 84));
        input.add(new Interval(60, 80));
        input.add(new Interval(10, 54));
        input.add(new Interval(54, 59));
        input.add(new Interval(62, 85));
        input.add(new Interval(7, 37));
        input.add(new Interval(31, 99));
        input.add(new Interval(40, 41));
        input.add(new Interval(4, 99));
        input.add(new Interval(28, 45));
        input.add(new Interval(27, 71));
        input.add(new Interval(14, 64));

        System.out.println(merge(input));
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        ArrayList<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (current.end >= next.start) {
                current.end = Math.max(current.end, next.end);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result;
    }
}
