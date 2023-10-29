package com.learning.practise.scaler.advance.dsa.recursion2;

import java.util.ArrayList;

public class TowerOfHanoi {

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        towerOfHanoi(A, 1, 2, 3, result);
        return result;
    }

    private void towerOfHanoi(int A, int src, int aux, int trg, ArrayList<ArrayList<Integer>> result) {
        if (A == 0) {
            return;
        }
        towerOfHanoi(A - 1, src, trg, aux, result);
        ArrayList<Integer> arr = new ArrayList<>(3);
        arr.add(A);
        arr.add(src);
        arr.add(trg);
        result.add(arr);
        towerOfHanoi(A - 1, aux, src, trg, result);
    }


}
