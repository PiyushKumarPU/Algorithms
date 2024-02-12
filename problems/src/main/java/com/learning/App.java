package com.learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> integers = new ArrayDeque<>(B);
        for (int i = 0; i < B; i++) {
            integers.addFirst(A.get(i));
        }
        while (!integers.isEmpty()) {
            result.add(integers.poll());
        }
        for (int i = B; i < A.size(); i++) {
            result.add(A.get(i));
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int line = 0; line < A; line++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i <= line; i++)
                row.add(binomialCoeff(line, i));
            if (row.size() < A) {
                int temp = A - row.size();
                while (temp >= 0) row.add(0);
            }
            result.add(row);
        }
        return result;
    }

    static int binomialCoeff(int n, int k) {
        int res = 1;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
