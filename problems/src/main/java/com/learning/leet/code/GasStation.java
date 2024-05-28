package com.learning.leet.code;

import java.util.List;

public class GasStation {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (isValidIndex(i, gas, cost)) return i;
        }
        return -1;
    }

    private boolean isValidIndex(int index, int[] gas, int[] cost) {
        int remainingGas = gas[index] - cost[index];
        if (remainingGas < 0) return false;
        int start = (index + 1) % gas.length;
        while (start != index && remainingGas >= 0) {
            remainingGas += gas[start] - cost[start];
            start = (start + 1) % gas.length;
        }
        return remainingGas >= 0;
    }

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        for (int i = 0; i < A.size(); i++) {
            if (isValidIndex(i, A, B)) return i;
        }
        return -1;
    }

    private boolean isValidIndex(int index, final List<Integer> A, final List<Integer> B) {
        int remainingGas = A.get(index) - B.get(index);
        if (remainingGas < 0) return false;
        int start = (index + 1) % A.size();
        while (start != index && remainingGas >= 0) {
            remainingGas += A.get(start) - B.get(start);
            start = (start + 1) % A.size();
        }
        return remainingGas >= 0;
    }
}
