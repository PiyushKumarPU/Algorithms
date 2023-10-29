package com.learning.practise.scaler.contest;

import java.util.List;

public class Test {


    public static int[][] convert(List<List<Integer>> listList) {
        int[][] result = new int[listList.size()][listList.get(0).size()];
        int start = 0;
        for (List<Integer> integers : listList) {
            int i = 0;
            for (Integer ele : integers) {
                result[start][i] = ele;
                i++;
            }
            start++;
        }
        return result;
    }
}
