package com.learning.practise.scaler.self.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NobleInteger {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{-4,-2,0,-1,-6}));
    }

    public static int solve(int[] A) {
        int result = 0;
        List<Integer> sorted  = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        if(sorted.get(0) == 0) result++;
        int currentCount = 0;
        for (int index = 1; index < sorted.size(); index++) {
            if(Objects.equals(sorted.get(index), sorted.get(index - 1))){
                if(index == currentCount) result++;
            }else{
                if(index == sorted.get(index)) result++;
                currentCount = index;
            }
        }
        return result == 0 ? -1 : result;
    }
}
