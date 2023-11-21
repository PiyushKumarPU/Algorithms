package com.learning.scaler.advance.module2.binary_search.bs_answers.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
Given N tasks and k workers. Time taken to complete ith task --> A[i],
        Find minimum time to complete all tasks:
        Notes:
            a. One task can be done by only one worker
            b. A worker can only do continuos task
            c. Worker works parallely

         Given array
            arr = {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6}
            k = 3 (No of painter)

* */
public class PainterPartitionProblem {

    public static void main(String[] args) {
        System.out.println(minTime(List.of(3, 5, 1, 7, 8, 2, 5, 3, 10, 1, 4, 7, 5, 4, 6), 3));
        System.out.println(minTime(List.of(185, 186, 938, 558, 655, 461, 441, 234, 902, 681), 3));
    }


    public static int minTime(List<Integer> boards, int painters) {
        int start = 0, end = 0, ans = 0;
        for (Integer boardLength : boards) {
            start = Math.max(start, boardLength);
            end += boardLength;
        }

        /*
        Idea is to start with min time required to paint a board and max time required to paint all board
        and check if all the boards with given painters can be painted in specified time
        * Lets say all the boards cant be painted in x amount of time then we will increase value of x (because if all
        the boards can be painted in x amount of time then it can not be painted in any time < x)
        * Similarlly, if all the boards can be painted in y amount of time and we will check if there is any lesser
        value than y, all boards can be painted in that point of time
        * */
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidTime(mid, painters, boards)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    public static boolean isValidTime(int time, int painters, List<Integer> boards) {
        int currentCount = 1, workDone = 0;
        for (Integer board : boards) {
            if (workDone + board <= time) {
                workDone += board;
            } else {
                currentCount++;
                workDone = board;
            }
            if (currentCount > painters) return false;
        }
        return currentCount <= painters;
    }


}
