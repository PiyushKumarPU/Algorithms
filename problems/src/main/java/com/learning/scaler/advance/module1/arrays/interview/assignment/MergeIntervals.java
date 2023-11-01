package com.learning.scaler.advance.module1.arrays.interview.assignment;

import com.learning.scaler.advance.module1.arrays.interview.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Problem Description:
    Given a sorted list of overlapping intervals, sorted based on interval start time,
    merge all overlapping intervals and return sorted list of intervals.

Problem Constraints
1 <= Total number of intervals <= 10^5.

Input Format
    First argument is a list of intervals.

Output Format
    Return the sorted list of intervals after merging all the overlapping intervals.

Example Input
    Input 1:
        [1,3],[2,6],[8,10],[15,18]

Example Output
    Output 1:
        [1,6],[8,10],[15,18]

Example Explanation
    Explanation 1:
    Merge intervals [1,3] and [2,6] -> [1,6].
    so, the required answer after merging is [1,6],[8,10],[15,18].
    No more overlapping intervals present.

* */
public class MergeIntervals {

    public static void main(String[] args) {

    }


    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.getStart()));
        ArrayList<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (current.getEnd() >= next.getStart()) {
                current.setEnd(Math.max(current.getEnd(), next.getEnd()));
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result;
    }

}
