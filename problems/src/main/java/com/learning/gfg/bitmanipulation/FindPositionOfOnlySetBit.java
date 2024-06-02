package com.learning.gfg.bitmanipulation;


/*
 * Given a number N having only one ‘1’ and all other ’0’s in its binary representation,
 * find position of the only set bit. If there are 0 or more than 1 set bit the answer should be -1.
 * Position of  set bit '1' should be counted starting with 1 from LSB side in binary representation of the number.
 * https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
 * */
public class FindPositionOfOnlySetBit {

    public static void main(String[] args) {

    }

    static int findPosition(int N) {
        int position = 0, count = 0;
        while (N > 0) {
            if ((N & 1) > 0) {
                count++;
                if (count > 1) return -1;
            }
            N = N >> 1;
        }
        return position;
    }


}
