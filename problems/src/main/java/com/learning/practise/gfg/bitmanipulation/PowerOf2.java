package com.learning.practise.gfg.bitmanipulation;


/*
 * Given a non-negative integer N. The task is to check if N is a power of 2. More formally,
 * check if N can be expressed as 2x for some integer x.
 * Return true if N is power of 2 else return false.
 * https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
 * */
public class PowerOf2 {

    public static void main(String[] args) {
        System.out.println(isPowerofTwo(2));
        System.out.println(isPowerofTwo(98));
        System.out.println(isPowerofTwo(256));

    }

    public static boolean isPowerofTwo(long n) {
        if(n < 1) return false;
        int count = 0;
        while (n > 0) {
            if ((n & 1) > 0) {
                count++;
                if (count > 1) return false;
            }
            n = n >> 1;
        }
        return true;

    }


}
