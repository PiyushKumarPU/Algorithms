package com.learning.scaler.advance.module1.arrays.interview.assignment;



import com.learning.scaler.advance.module1.arrays.interview.Interval;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
You have a set of non-overlapping intervals. You are given a new interval [start, end],
insert this new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
    0 <= |intervals| <= 10^5

Input Format
    First argument is the vector of intervals
    Second argument is the new interval to be merged

Output Format
    Return the vector of intervals after merging

Example Input
    Input 1:
        Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:
    Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
    Output 1:
        [[1, 5], [6, 9]]
Output 2:
     [[1, 9]]

Example Explanation
    Explanation 1:
        (2,5) does not completely merge the given intervals
Explanation 2:
        (2,6) completely merges the given intervals

* */
public class MergeNewIntervals {


    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        boolean isAdded = false;
        for (int i = 0; i < intervals.size() && !isAdded; i++) {
            Interval currentInterval = intervals.get(i);
            if (newInterval.getStart() <= currentInterval.getStart()) {
                intervals.add(i, newInterval);
                isAdded = true;
            }
        }
        if (!isAdded) {
            intervals.add(newInterval);
        }
        int currentIndex = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(currentIndex);
            Interval i2 = intervals.get(i);
            if (i1.getEnd() >= i2.getStart()) {
                intervals.get(currentIndex).setEnd(Math.max(i1.getEnd(), i2.getEnd()));
            } else {
                currentIndex++;
                intervals.set(currentIndex, intervals.get(i));
            }
        }
        return new ArrayList<>(intervals.subList(0, currentIndex + 1));
    }
}
