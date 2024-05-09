package com.learning.scaler.advance.module4.graph3.additional;

import com.learning.scaler.advance.module4.graph3.Pair;

import java.util.*;

/*
Problem Description
    You are the Prime Minister of a country and once you went for a world tour.
    After 5 years, when you returned to your country, you were shocked to see the condition of
    the roads between the cities.
    So, you plan to repair them, but you cannot afford to spend a lot of money.
    The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.
    The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of repairing a
    road between (i, j) and (i, j + 1) is B[j].
    Return the minimum cost of repairing the roads such that all cities can be visited from city indexed (0, 0).
    As the cost can be large, return the cost modulo 10^9+7.

Problem Constraints
    1 <= N, M <= 10^5
    1 <= A[i], B[i] <= 10^3

Input Format
    The first argument will be an integer array, A, of size N.
    The second argument will be an integer array, B, of size M.

Output Format
    Return an integer representing the minimum possible cost.

Example
    Input 1:
         A = [1, 1, 1]
         B = [1, 1, 2]
    Input 2:
         A = [1, 2, 3]
         B = [4, 5, 6]

Example
    Output 1:
         16
    Output 2:
         39

Example
    Explanation 1:
         The minimum cost will be 16 if we repair the roads in the following way:
         Repair the roads from the all cities in row 0 to row 1 i.e. (0, j) to (1, j) (0 <= j <= 3),
         so that the cost will be 4 (A[0] * 4).
         Repair the roads from the all cities in row 1 to row 2 i.e. (1, j) to (2, j) (0 <= j <= 3),
         so that the cost will be 4 (A[1] * 4).
         Repair the roads from the all cities in row 2 to row 3 i.e. (2, j) to (3, j) (0 <= j <= 3),
         so that the cost will be 4 (A[2] * 4).
         Repair the roads (0, 0) to (0, 1), (0, 1) to (0, 2), (0, 2) to (0, 3),
         so that the cost will be B[0] + B[1] + B[2] = 4.
         Total cost will be 16.
    Explanation 2:
         The minimum possible cost will be 39.
* */
public class DamagedRoads {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 3));
        ArrayList<Integer> B = new ArrayList<>(List.of(5, 4));
        System.out.println(solve(A, B));
    }

    static int MOD = 1000000007;

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size(), M = B.size();
        List<List<Pair>> graph = new ArrayList<>(A.size() + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges from (i, j) to (i+1, j) with cost A[i]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                int u = i * (M + 1) + j;
                int v = (i + 1) * (M + 1) + j;
                graph.get(u).add(new Pair(v, A.get(i)));
            }
        }

        // Adding edges from (i, j) to (i, j+1) with cost B[j]
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int u = i * (M + 1) + j;
                int v = i * (M + 1) + j + 1;
                graph.get(u).add(new Pair(v, B.get(j)));
            }
        }

        long[] dist = new long[N * M + M + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingLong(v -> dist[v]));
        pq.add(0);

        while (!pq.isEmpty()) {
            int u = pq.poll();

            for (Pair pair : graph.get(u)) {
                int v = pair.node;
                long weight = pair.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    dist[v] %= MOD;
                    pq.add(v);
                }
            }
        }

        return (int) (dist[N * M + M] % MOD);
    }
}
