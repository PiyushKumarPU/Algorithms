## Advance DSA Day 3 Arrays : Interview Problems

## Scope / Agenda
- [Merge Intervals](#merge-intervals)
- [Merge New Intervals](#merge-new-intervals)
- [Find 1st Missing number](#find-1st-missing-number)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module1/arrays/interview/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module1/arrays/interview/additional)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/3.%20Adv%20Arrays%203%20Intevriew%20Problems(29-09-23).pdf)
2. [Class/Lecture Video](https://www.youtube.com/watch?v=-7ATeTDUZi4)


## Merge Intervals
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
```java
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
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
```
## Merge New Intervals
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
```java
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
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
```
## Find 1st Missing number
    Problem Description
    Given an unsorted integer array, A of size N. Find the first missing positive integer.
    Note: Your algorithm should run in O(n) time and use constant space.

    Problem Constraints
        1 <= N <= 1000000
        -10^9 <= A[i] <= 10^9

    Input Format
        First argument is an integer array A.

    Output Format
        Return an integer denoting the first missing positive integer.

    Example Input
        Input 1:
            [1, 2, 0]
        Input 2:    
            [3, 4, -1, 1]
        Input 3:
            [-8, -7, -6]

    Example Output
        Output 1:
            3
        Output 2:
            2
        Output 3:
            1

    Example Explanation
        Explanation 1:
            A = [1, 2, 0]
            First positive integer missing from the array is 3.
        Explanation 2:
            A = [3, 4, -1, 1]
            First positive integer missing from the array is 2.
        Explanation 3:
            A = [-8, -7, -6]
            First positive integer missing from the array is 1.
```java
    public int firstMissingPositive(int[] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            while (A[i] >= 1 && A[i] <= size
                    && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < size; i++)
            if (A[i] != i + 1)
                return (i + 1);
        return (size + 1);
    }
```
