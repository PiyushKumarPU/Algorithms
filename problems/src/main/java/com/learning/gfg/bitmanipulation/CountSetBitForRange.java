package com.learning.gfg.bitmanipulation;


/*
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 * https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
 */
public class CountSetBitForRange {

    public static void main(String[] args) {

    }

    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if ((temp & 1) > 0) count++;
                temp = temp >> 1;
            }
        }
        return count;

    }
}
