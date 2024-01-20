package com.learning.scaler.advance.module4.contest5;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*




Problem Description

    In a faraway galaxy, there is a spaceship traveling through the asteroid field.
    The spaceship has a shield with a certain amount of energy.
    You are given an integer energy A, which represents the original energy of the shield.
    You are further given an integer array B of size N, where B[i] is the energy of the i-th asteroid.
    You can arrange for the spaceship to collide with the asteroids in any arbitrary order.
    If the energy of the shield is greater than or equal to the energy of the asteroid,
    the asteroid is destroyed and the shield gains the energy of the asteroid. Otherwise, the shield is destroyed.
    Return 1 if all asteroids can be destroyed. Otherwise, return 0.
Problem Constraints
    1 <= A <= 10^9
    1 <= N <= 10^5
    1 <= B[i] <= 10^9
Input Format
    First argument A is an integer. Second argument B is an integer array.
Output Format
    Return an integer.
Example Input
    Input 1:
        A = 10
        B = [14, 3, 2]
    Input 2:
        A = 4
        B = [2, 9, 2]
Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
        The spaceship can collide with the asteroids in the order [3, 2, 14]. It will destroy all the asteroids.

    Explanation 2:
        The spaceship will not be able to destroy the second asteroid.

* */
public class AsteroidDestruction {

    /* Using min heap*/
    public int solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        java.math.BigInteger actual = java.math.BigInteger.valueOf(A);
        minHeap.addAll(B);
        while(!minHeap.isEmpty()){
            if(A <= 0) return 0;
            java.math.BigInteger current = java.math.BigInteger.valueOf(minHeap.poll());
            if(current.compareTo(actual) > 0) return 0;
            actual = actual.add(current);
        }
        return 1;
    }

    public int solveUsingSort(int A, ArrayList<Integer> B) {

        return 1;
    }
}
