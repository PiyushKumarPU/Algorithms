package com.learning.practise.scaler.advance.dsa.array3;

import java.util.ArrayList;

public class MergeNonOverlappingIntervals {

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        boolean isAdded = false;
        for (int i = 0; i < intervals.size() && !isAdded; i++) {
            Interval currentInterval = intervals.get(i);
            if (newInterval.start <= currentInterval.start) {
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
            if (i1.end >= i2.start) {
                intervals.get(currentIndex).end = Math.max(i1.end, i2.end);
            } else {
                currentIndex++;
                intervals.set(currentIndex, intervals.get(i));
            }
        }
        return new ArrayList<>(intervals.subList(0, currentIndex + 1));
    }


    public static ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        Interval current = newInterval;
        if(newInterval.start > newInterval.end){
            current.start = newInterval.end;
        }
        for (Interval next : intervals) {
            if (current.end >= next.start) {
                current.end = Math.max(current.end, next.end);
                //current.start = Math.min(current.start, next.start);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval newInterval;

        newInterval = new Interval(1, 2);
        intervals.add(newInterval);
        newInterval = new Interval(3, 6);
        intervals.add(newInterval);

        newInterval = new Interval(10, 8);

        System.out.println(insert1(intervals, newInterval));
    }


}


