package com.learning.scaler.advance.module3.contest4;

import java.util.Comparator;
import java.util.List;

/*
    Problem Description:
        Once upon a time, there was a great explorer named Alex who had traveled the world in search of treasure and adventure. On one of his journeys, he came across an ancient map that led to a hidden cave deep in the mountains.When Alex arrived at the cave, he found that it was filled with treasures of all kinds. However, he also found a problem. The treasures were scattered all over the cave, and he needed to find the B farthest ones from the cave's entrance.Moreover, Given an array A of points where A[i] = [xi, yi] represents a point on the X-Y plane and an integer B, return the B farthest points to the origin (0, 0).The distance between two points on the X-Y plane is the Euclidean distance (i.e. sqrt((x1 - x2)2 + (y1 - y2)2)).Note: It is guranteed that no two points will have same distance from the origin.
    Problem Constraints
        1 <= A.size() <= 10^5
        -10^4 <= x,y <= 10^4
        1 <= B <= A.size()
    Input Format
        The first argument is an integer array A and the second argument is an integer B.
    Output Format
        Return an 2-d array of integers denoting the farthest B points from the origin.
        Note: The output must be in sorted form.
    Example Input
        Input 1:
            A = [
                [1, 2]
                [1, 4]
                [-1, 0]
            ]
            B = 2
        Input 2:
            B = [
                [1, 5]
                [2, 1]
                [-1, -1]
                [3, 1]
            ]
            B = 3

    Example Output
        Ouput 1: [
                [1, 2]
                [1, 4]
            ]
        Output 2:[
                [1, 5]
                [2, 1]
                [3, 1]
            ]

    Example Explanation
        Explanation 1:
            The farthest 2 points from origin are [[1, 2], [1, 4]].
        Explanation 2:
            The farthest 3 points from origin are [[1, 5], [2, 1], [3, 1]].
* */
public class AlexAndTreasures {


    public static void main(String[] args) {

        List<List<Integer>> A = List.of(List.of(1, 2),
                List.of(1, 4),
                List.of(-1, 0));

        List<List<Integer>> B = List.of(List.of(1, 5),
                List.of(2, 1),
                List.of(-1, -1),
                List.of(3, 1));

        System.out.println(solve(A, 2));
        System.out.println(solve(B, 3));
    }

    public static List<List<Integer>> solve(final List<List<Integer>> A, final int B) {
        Comparator<List<Integer>> first = Comparator.comparing(integers -> integers.get(0));
        Comparator<List<Integer>> second = Comparator.comparing(integers -> integers.get(1));
        return A.stream().sorted((o1, o2) ->
                        Integer.compare(o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1), o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1)))
                .toList().subList(0, B).stream().sorted(first.thenComparing(second)).toList();
    }
}
