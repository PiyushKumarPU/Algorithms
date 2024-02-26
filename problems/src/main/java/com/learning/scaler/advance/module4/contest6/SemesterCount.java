package com.learning.scaler.advance.module4.contest6;

import java.util.*;

public class SemesterCount {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(10, 5)),




                        new ArrayList<>(List.of(10, 7)),
                        new ArrayList<>(List.of(4, 35)),
                        new ArrayList<>(List.of(20, 25)),
                        new ArrayList<>(List.of(30, 15)),
                        new ArrayList<>(List.of(22, 34)),
                        new ArrayList<>(List.of(17, 24)),
                        new ArrayList<>(List.of(21, 11)),
                        new ArrayList<>(List.of(32, 12)),
                        new ArrayList<>(List.of(28, 23)),
                        new ArrayList<>(List.of(25, 7)),
                        new ArrayList<>(List.of(13, 5))
                )
        );
        int A = 36;
        SemesterCount semesterCount = new SemesterCount();
        System.out.println(semesterCount.minimumSemesters(A, B));
    }

    public int minimumSemesters(int A, ArrayList<ArrayList<Integer>> B) {
        int[] freq = new int[A + 1];
        List<List<Integer>> adjList = constructAdjList(B, freq, A);
        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 1; i <= A; i++) {
            if (freq[i] == 0) {
                queue.add(new Pair(i, 1));
            }
        }
        if (queue.isEmpty()) return -1;
        int semesterCount = 1;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            semesterCount = Math.max(semesterCount, current.semesterCount);
            for (Integer dep : adjList.get(current.nodeVal)) {
                freq[dep]--;
                if (freq[dep] == 0) {
                    queue.add(new Pair(dep, current.semesterCount + 1));
                }
            }
        }
        return semesterCount;
    }

    public List<List<Integer>> constructAdjList(ArrayList<ArrayList<Integer>> B, int[] freq, int nodeCount) {
        List<List<Integer>> adjList = new ArrayList<>(nodeCount + 1);
        for (int i = 0; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> row : B) {
            int prevCourse = row.get(0);
            int nextCourse = row.get(1);
            freq[nextCourse]++;
            adjList.get(prevCourse).add(nextCourse);
        }
        return adjList;
    }
}

class Pair {
    public int nodeVal;
    public int semesterCount;

    public Pair(int nodeVal, int semesterCount) {
        this.nodeVal = nodeVal;
        this.semesterCount = semesterCount;
    }
}