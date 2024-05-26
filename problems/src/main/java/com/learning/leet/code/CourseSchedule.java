package com.learning.leet.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // calculate indegree and adjlist
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            int source = edge[0];
            int dest = edge[1];
            indegrees[source]++;
            adjList.get(source).add(dest);
            adjList.get(dest).add(source);
        }
        Queue<Integer> sourceQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (indegrees[i] == 0) sourceQueue.add(i);
        while (!sourceQueue.isEmpty()) {
            int current = sourceQueue.poll();
            for (int nbr : adjList.get(current)) {
                indegrees[nbr]--;
                if (indegrees[nbr] == 0) sourceQueue.add(nbr);
            }
        }
        for (int indegree : indegrees) if (indegree > 0) return false;
        return true;
    }
}
