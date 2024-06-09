package com.learning.leet.code;

import java.util.List;

public class GasStation {


    public int canCompleteCircuitOn(int[] gas, int[] cost) {
        int totalTank = 0,currentTank = 0,startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        return totalTank >= 0 ? startStation : -1;
    }
}
