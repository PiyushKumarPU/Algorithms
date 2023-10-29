package com.learning.practise.scaler.self.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderElement {

    public static void main(String[] args) {
        int[] input = new int[]{5, 4};
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(solve(input)));
    }

    public static int[] solve(int[] A) {
        List<Integer> integers = new ArrayList<>();
        int arraySize = A.length;
        int[] PFMax = new int[arraySize];
        PFMax[arraySize-1] = A[arraySize-1];
        for(int index = arraySize-2; index >=0; index--){
            PFMax[index] = Math.max(PFMax[index+1],A[index]);
        }
        for(int index = 0; index < arraySize; index++){
            if(A[index] >= PFMax[index]) integers.add(A[index]);
        }
        int[] result = new int[integers.size()];
        for(int i = 0; i < integers.size(); i ++){
            result[i] = integers.get(i);
        }
        return result;
    }
}
