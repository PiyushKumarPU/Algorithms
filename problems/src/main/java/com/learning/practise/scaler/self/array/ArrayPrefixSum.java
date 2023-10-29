package com.learning.practise.scaler.self.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPrefixSum {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.set(1,0);
        Collections.swap(list,0,1);
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5,6}));
        System.out.println(Arrays.toString(prefixSum(new int[]{1,2,3,4,5,6})));
    }

    public static int[] prefixSum(int[] arr){
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int index =1; index < arr.length; index++){
            prefixSum[index] = arr[index] + prefixSum[index-1];
        }
        return prefixSum;
    }
}
