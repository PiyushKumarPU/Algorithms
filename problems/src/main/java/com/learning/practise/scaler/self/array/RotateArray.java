package com.learning.practise.scaler.self.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateArray {

    public static void main(String[] args) {

        //System.out.println(rotateLeft(List.of(1, 2, 3, 4, 5), 6));

        // 12345 -> 51234 --> 45123 --> 34512 --> 23451 --> 12345 --> 51234

    }

    public static List<Integer> rotateLeft(List<Integer> arr, int distance) {
        if (distance <= 0) {
            return arr;
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        int arrSize = arr.size();
        for (int i = 0; i < arrSize; i++) {
            if(distance > arrSize){
                int newIndex = distance-arrSize;
            }else{

            }
        }


        return null;
    }
}
