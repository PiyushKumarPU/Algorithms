package com.learning.scaler.advance.module2.sort.quick.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
Problem Description
    We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
    Here, the distance between two points on a plane is the Euclidean distance.
    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
    NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

Problem Constraints
    1 <= B <= length of the list A <= 10^5
    -10^5 <= A[i][0] <= 10^5
    -10^5 <= A[i][1] <= 10^5

Input Format
    The argument given is list A and an integer B.

Output Format
    Returns the B closest points to the origin (0, 0) in any order.

Example Input
    Input 1:
     A = [
           [1, 3],
           [-2, 2]
         ]
     B = 1
    Input 2:
     A = [
           [1, -1],
           [2, -1]
         ]
     B = 1

Example Output
    Output 1:
     [ [-2, 2] ]
    Output 2:
     [ [1, -1] ]

Example Explanation
    Explanation 1:

     The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
     So one closest point will be [-2,2].
    Explanation 2:

     The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
     So one closest point will be [1,-1].

* */
public class BClosestPointToOrigin {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        return A.stream()
                .sorted(Comparator.comparingInt(o -> o.get(0) * o.get(0) + o.get(1) * o.get(1))).limit(B)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
