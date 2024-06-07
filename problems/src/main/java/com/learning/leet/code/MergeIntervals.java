package com.learning.leet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<Interval> result = new ArrayList<>();
        List<Interval> intervalList = new ArrayList<>();
        for (int[] arr : intervals) intervalList.add(new Interval(arr[0], arr[1]));
        intervalList.sort(Comparator.comparingInt((Interval i) -> i.start));
        Interval current = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            Interval next = intervalList.get(i);
            if (current.start <= next.end && current.end >= next.start) {
                current.end = Math.max(current.end, next.end);
                current.start = Math.min(current.start, next.start);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result.stream()
                .map(interval -> new int[]{interval.start, interval.end})
                .toArray(int[][]::new);
    }

    public int[][] mergeFast(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[0]);
        }

        int[] range = new int[max - min + 1];
        for (int[] interval : intervals) {
            range[interval[0] - min] = Math.max(interval[1] - min, range[interval[0] - min]);
        }

        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[]{start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[]{start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }
}

class Interval {
    Integer start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
