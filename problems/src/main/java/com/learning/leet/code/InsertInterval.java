package com.learning.leet.code;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                result.add(new Interval(interval[0], interval[1]));
            } else if (newInterval[1] < interval[0]) {
                result.add(new Interval(newInterval[0], newInterval[1]));
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(new Interval(newInterval[0], newInterval[1]));
        return result.stream()
                .map(interval -> new int[]{interval.start, interval.end})
                .toArray(int[][]::new);
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        int start = 0;
        int end = 1;

        int i = 0;
        while (i < n && intervals[i][end] < newInterval[start]) {
            ans.add(intervals[i]);
            i++;
        }

        //for middle overlaping
        while (i < n && intervals[i][start] <= newInterval[end]) {
            newInterval[start] = Math.min(newInterval[start], intervals[i][start]);
            newInterval[end] = Math.max(newInterval[end], intervals[i][end]);
            i++;
        }
        ans.add(newInterval);

        //for right non overlaping
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        int[][] orgiAns = new int[ans.size()][];
        for (int j = 0; j < ans.size(); j++) {
            orgiAns[j] = ans.get(j);
        }
        return orgiAns;
    }
}
