package com.learning.scaler.advance.module4.greedy.additional;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
    There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
    An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
    Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
    In one jump a person can move to the adjacent seat (if available).

    NOTE: 1. Return your answer modulo 107 + 3.

Problem Constraints
    1 <= N <= 1000000
    A[i] = 'x' or '.'

Input Format
    The first and only argument is a string A of size N.

Output Format
    Return an integer denoting the minimum number of jumps required.

Example Input
    Input 1:
        A = "....x..xx...x.."
    Input 2:
        A = "....xxx"

Example Output
    Output 1:
        5
    Output 2:
        0

Example Explanation
    Explanation 1:
     Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14)
                     . . . . x . . x x . . . x . .
     Now to make them sit together one of approaches is -
                     . . . . . . x x x x . . . . .
     Steps To achieve this:
     1) Move the person sitting at 4th index to 6th index: Number of jumps by him =   (6 - 4) = 2
     2) Bring the person sitting at 12th index to 9th index: Number of jumps by him = (12 - 9) = 3
     So, total number of jumps made: 2 + 3 = 5 which is the minimum possible.

     If we other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

    Explanation 2:
     They are already together. So, the cost is zero.
* */
public class Seats {

    public static void main(String[] args) {
        System.out.println(minJumps(".xxxx..xx.x.xx.....x.xx...xxxx...xxx.x.xxxx.x..x.x.x..x...xxx.x.x.xxx.x.x.x..x.x.....xx.x....x....xx...xxx.x...x..xxx.x.xxxxxxxxxx.xx.x.xx..x.xxx...x.x.x.x.xxxx...x.x.....x.xxxxx..xx.xx.x.xxxxx..xx.x..xxx.......xxx..x.x.x.x..xx..x...xxx..x..xx....x.xxx..x.....x.....x.....xx..xxxx.x..xxxx.xxx..x.........xx.x.x...xx...x.xx.xxxxx.xx.xx.x......x.x......xx.x...x....xxx..x..xxx..x..x.xxxx.xx..x.....x...x......x.xxx...x..x...xx.xxxxx..x..x.xx...x...x.....xxxx..x.xx.xxx.x.xx.xx.xxxxx..xxxx..xx.x...xx..x..xxxxx.x.xx....x..x..........x..x.x.xxxx...x...x.xx.xx.xx......x..xxxxx.xxx.xxxxx.x.xx.x..x..xxxx..xxxxx..xxx....xxxxx.xxxxxx....xx...xx.....x...xxx...xxxx.xxx....xxx.xx.xxx.x.x.x...x.x..x.xx..xxx.x.x...x.xxxxxx.xx..x.xx....xxxxxx.xx..xx.xxx.x.xx.xx..x..x...xx...x..x...xx..x.x.x..x...x....x..xx.x....xxxxxx.x.xxxxxx..x.....x..x.xxx....xx..xxx..x.xxxxx..xx.x...xxx.xxx.x.xxx.x...xx..x.xx.xx.xx..xxx..x.x..xx.x..x.....x.xx....xx..x.x.xx.xx..x.xxx.xxxx..x...xx..x.xxxxx..xxx...x.x.....x.xx..x.xxx.x.xx.x.xxxx.x..x.....xx.xx.x..xx.xxx.x.x..x..xxxxxxx....x.x...xxx..x.....x.x...xxxx.xx.xxxx.x.xxxx.xxxx...xx.x.x.xxx.x...x...xxx.x.x.xxxx..xx.xx..x..x..x..xxx.xx.xxx..xx...xx.x.xx....x.x....xx..x.xxx..x.xx..xxxx.xxx....x.x.x.xxxx.xxxx....xxx.xx.xx.xxxx....xxx.x.xx.xx.xxxxxx.x.x.x.x..xxxx..x.xxxx..x.x.xxxx.x.....x.x.x.....xxx.x.xxxx..xxx.xxxxx..x.xx.xxx......xx.x...xx.xxx..x.xx.x.x.x.xx.x....x..x..xxxxxx..x....x.xxx.....x.xxx.xxx....xx..x..xxx.x..xxxx.x.x..xxxxx.xxxxx.x.xxxx.xxx.........x.x.xx...x..x.x.x....xx.xx.xxxx.x.x..xx..xxxx.x.xx.x.xxxx...xxx.....xx.x.xxx..xx....xx..x.x......x.x...x.x....x..x.x....xx.xxxxx.x..x.xx..x.....x.x.xx....xxx..xx...xx.xxxxx.xxxxxx..x.x.x.xxxx.xxx..xx...x.xx.x.xx.x.xxx..xxxx...xxx.x.x...x.xx.x.xxx..x.x..xx.x.xx..xxxx...x....xxxx.xxxxx.....xxx...xx.xx.xx.x..xx..xxx.......xx.x.x......xxx.x.xx....x..x..xx.x...x.xxxx....xx..x..xxxxxx..x..x....xxx..xx.....xxxx...xx.........x......x..xxxx.......xx..x.....x..xx.x.x...xx.xx.xx.........xxxxx....xx.xxx.x.xxx..xx..xx.x.x.xx..x.x...xx..xxx.xx....xx..x...xx..xx..xxxxxx..x..x..x.x....x.x.xxx.xx..xxx..xx.xx.x....x...xx...x.xx.x......x.x..xxxxx....xx.x.xxx..x..x..x..x...xxxxxxxx..xx.xx.xxx.x..x..xxxxx.x.x.....xx.x.xx....xx..xxx...x.xx..x...xx.x.x..xx.....xxxxxx..xx.xx.xx..xx..x.x..x.xxx....x.....xx....xxxxxx..x.x.x.x....x.....xx..xxx...xx.xxx.x........x..x.xxxx...x.x..x.x...xx.xxx.x..xxxx...x.x.....x.x.xxx...xx.xxx...xx....x..x.x.x....x...xx...xx.x.xx.xxxx...xxxxxxxxxxx..xx.x.x....x.x.xxxx....xxx..xxxxx....x..x.xx..xxx..xx...xxx....x..x.x........x.xx.....xxx.....x..x.xx.xx.x....x..x...xxxxxxxxxxx.x.x....x.x...........xxxxxx.....xx.xx...x....x.xx.xxx.x.x......xx..x.xx.xx....x...xx.......xx....xx....x..x........x..xx.x.xx..xxxxx..x....xxxxxxx.xxx....xxxx..x..x.xx.xxx..x.x..x..x...x.xx.x..xx...x.x...x.x.x..x..x.xxx......xx.x..x.xx.x...x.xx.xxx......x...xx.x...x.....x....xx.xx..x.x..xx.x..xx..x..xxxxxx..x.xx...x...x.x.x.xx..xxx..xxxxxxx..x...xx..xx...xx.x.xx.x.xxx..x...xxx..x.xxx.x.xx..xx..x.x..xxx...xx.x...xx.......xx.x..x.x......xx..x.xx.xx.xx.x.x..x.xxxxxx.xxx.x...xx.......x.xx...xxxxxxx...x..x.x........xxxxxxxx...xxx..xx....x..x..xx.x.x.x.x..x..xx.xxxxxxx.xx.xxx.x......x..xx....xxx...xxx.xxx.x.x..x..x...xx..xxxxx.x.xx...x.xxxxxxxx..x.x..x.xxx.x...x..xx.x...xx..x.xxx.xx...x.xx.xx.x.xxxxx.....x.x.xxx.xx..xx.x.xxxx.xxx.xxxxx.xxx...x..x.xx.xxx.xxx....x.x.x.x.xxxx.xx.xxx...x.x.xx...x.xxxx....x...x.x.xx..xxxx.x..xx..x..x..xx..x......x.x.x....xx.x.xx..x...x.xx..x....x..xx.....x.xx.x..xxxx........xxxxx.xx.xxxx..xxx.x.x....x.xx..xxx.x.xx..xx.xxx.x...xx.x...xx...x...xx.x.xx..x.xxx......x.x.x.........x..x...x.x.......x.xxxx.......xxxx.xx..x..x.....x..x.xx.xx.x.xxx.x...xx.xx..x.....x....x.xx...xxxxxx..x.xx..x.x.x..xxx.x.xx.x.xxx...x...x.xx..xx.x.x.x...xx.x.xxxxx.xx.xxx.xxxx..xxx..xxx.xxx...xx.x...x...xxxxxxx.xx....xxxxxxx.x....x...xxxx...x.xx.xx.xxx...x..x..x..xxx...x.xxx.xxxx..x.xxxx.xx..xxx..xx..xxxxxx.x..xx..x.xxx.xxx...xxxx..xxx..xxxxx..xx.x.xx..x..xxx.xx..x..xx..xxxx..xxx.xx..x.xxxx.xx..x.xx...xxx.x.x...x..x.x.x......x...x...xx..x.xx..xxxx.xxxxxxx....xx.xxxx.x.....xxx.x...xxx.xx.xxx.xxx..x..x...x.x.xx.x.x....xxx.xxxxxx.x.....x.xxxxx.xxx.xxxx.x.xxxx......x..xxxx.xx....xxx...xxx....x..xx.xx.x...x....xxx.x.xxxxxx.....xxx.x..x.......x..x.x.x.xx..xx...xxx.x..x.xxxxxxx.x....xxxx..xx.x.xxxxxx...xxx..xx.xxxxx..x....x.x...xx..xxxxx......xxxxx.xxxx.x..xx..x..xxx.xxx.xxx..x...xx..x...x.xx.x....xxxxx.xx..xx.x..xxxx...xx..x....xxx......xxx..xxx.xxxx..x.......xx.x.....xx.xx.xxx...xxxxxx.xx..x..xx.xxxxxx.x.x....xx.x.xxxxxx.xxx.x.xxxx.x..xx.xx..xx.x.x.x....xxxx..xx....xxx..x....x.xxx.xx...xxx....x.x.x.x.xx.x.xxx..xxxxx.x.xxxxx....x.xxxxx.x.x..x.xxx.x.x.x.xx.xx.x...xx....x.xx....xx..x...x....x..x.xx.x.x.x..x...xx..x.x..x.x.xxxxxxx.x...xxxxx.x..xxx.xxx..xx.x.x.xxxx.x.x....xxx...x.x....x.xxxx...x.x.xx...xxxxxx.x.xx.x...xxxx.xx..x.xx.x.x.x.x...xx...x.x.xx...x.xxx.xx..xx.xx.x..x....xxx.xx..xxxxx..x.xxx..xxxxxxxx.x.xx.x...x.xx.x.xxx.x.xxxx...x.x..x.xx.x..xxx...xx.xxx....xxxx.xxxx....x.x.xx.xx.x.xx..x.x.x.xx....x...xx..xx..xx.......x.x.x...x.xxxx..xxx.xxx.x.xx.xx.xx.xx.x....xx...xxx.x.x....xxxx..xx.x..x..xxxx...xxxx.....xxx.x.xx..x.x.x.x.xx...xx.xx.xxx.xx.x.xx..xx.....xxxx..x....x.x.x....xx.x.x.xx.xxx..xxxxx.x....x..x.x..x..xxxxx..xx...xx.x..x.x.x....xxxx...xxx.x..x.xxx.xx.xx..x.x.x.x.xxx.x.....x...x.xx.x..xxx.x.x.x....x.xx.x..xx...x.xxxx..x....x..xxxx..xxx.x..x.xx...x....xxx.xx..xx.xx..xx.x.x.xx......xxx..xx.x.x.....xxx.x...x..xxxx..x...x.x..x..x...x.xxx..x.x.xx.......xx.xx.x..xx...xx...xxx..x...x.....xx..x.....x.xx.x.x.x..x...x..x.x...x...x.xxx.x.x.x..xxxx..x.xx.xx..x....xxx..xxx.xxx.....xxx.x.xxxxxxxxxx.xxx...x.xx...xxx...xxx...x.x.xxx..xx..x..x...xxxxx.x..x.xxx...xx.x.xxxxx.xxx....x.xx..xx..x..xxx.x.x.xxx....x....x...xx..x....x.xxx...x.xxx.xx.xx.xx..x.xx.xx.xxxxx.x...xx..xxx.x.xx..x.x.xx.x.x.xxxx...x...xx.xxx.xx.xx.x....x.xxx.xx....xxxx..xxx.xxxx.xx.x...xx..x.xx...xxxx..xxx.....x.xx..xx.x.x.xx..x.x..xxx.x..x.xxx.xxxx.xxxxx..xx....xx.xx.x....x.xx..xx...x.......xxxx..xxxxxx.x.xxx..x.x.xx.x..xxx..xxx...xx..x.....xxxx.xxxxx.....xxxxxx..xx.xx..x.xxxx.x.x..xx.x....xx...x.......xx..xx..x.x...x..x.xx.xx.xx.xxx..x.x..xx...x.xx..xxxxx.x....xx...xx.xxx.xxx........xx.xx.xx.....xx...x..xx.x......xx..xxx.xx.xxx.x.xx.x..xx.xx..xxx...xxx.xxx.xx.x.xxxxx..x..x.xxxxx...x.x.x.xx..xx.x.xx.xx..x.xxx.x.x.......x...x.xx.x.x..x..xx.x.....x..x.x.x.xxxxx.x.xx.x.x.....x....xxx.x..xx..x.xxx.x.....x....x.x.x..x.x.xx..xx.xxxx....x.xxx.x.....x.xxx.x....x.x..x...xxx.x..xx....x.x.xx..xx.xx....xx..xxxxx.xx.x........xx..x.xx.....x.x.xxx......x..x..x....xxxxxx..xx..xx.xxxxx...x...x..x.x.x..x.xx...x.x.x..x..xx.x...x.x....x.x.xx...xxx.xx.x.xxxxxxx.xx.xxxx.....x...x.x.....x.x.x...x.x..xx.xx..x....xxxxxx.x.xxxxx..xx....xx...x..x.x.xxx...xxx.xx.......xxxxx...x.x.x.xxxx...xx.xx..xx.x.x..x..x.xx...xx..x.xx...x...xx..x....x.......x...xxxxx.....xxxx.xx...x..x.xxxxxx..x..x..xxx....x.xx..xxxx.x.x...xx.x..xxx.xx.xx...x....x.x.xx.x.xxxx...x.xxx..xx..x..x.......x.xx..x...xxx.xxx......x.x..x....xx.x.xxx......x..x....xx.x.....x.xx...x.x..x.xx.x..x.x..x..x....xxxx..xx.x..xx..xxxx.xxxxx.x.x.x.xx.x.x..x.xxxx.....xx..x.xxxx...x......x.x.x.xx.x.x..xx.....x..........xx..xx.x...x.x...x......xxxxxxx.x.x.xx..x.xx.xx.......xxx.xxx.x...x.xx..xxxx.xxxxxxx..xx.......x.xx..x....x.xxx..xx.x......x...x.xx..x..x...x..xx......x...xx..xxxxx..x..x.xxx..x.xx.x.x...x...xxx.xxxxxx...xxx.x.x.x.xx.x.xx....xxx.xxxxx...x..xx..xx....xxxxxx...xxx..x..xx.x..xxx.xx.x.x...x.x.x.x.x..x...x..xxxx.x..xx.x...x.xxxx.......x....x......xxxxxx.xx...........x..x..x.....x.x.x.x..xx..xx..x.x.x..xx..xx..xx..xxxxx..xxxxx....x....x.x...x..xx..xx.x...xx.x.x..xx..x....x..xx.x.x.xx.xxx..xxx....xx.xx.xxx.xxxxxxx.x.xx...xx..xxx.x...xxxx..x.x.x..xxx.xxx..xxx...x...xx...x.xxxxx.x.....x.x.x..xx..x.xx.x..x.x.xxx.....x.xxxx........x.x....xxxx.xx.xxxx.x..xx.xx..x..x.xx...xxxx.x.xx.....xx..xx..xxxx.xx.x...x....x..x......xxxx..xx....xx...x..xx.x.xx.xx..xxxxx.xx.x.....xx.x.x.xxx.x..x.xxx...x..x..x.......x...x.xx.xxx.....x.x..x.x..x..x..x.x....xx.x..x.x.x..x.xx..xx.xxx.xx.x.xx..x.xxxxxx..xxx...x...x.xx.xxx.xxxx....x..xxx.xxx.xxxxx..xxx.x.x.xxxxx.xx.xx...xx...xx.x....x.x.xxx..x..xxx.xxx.x...xxx.xx..x...xxxxxxx....x...x...xxxx.x.x..xxxx...x..x.x..x..xx...x.x...x.x.x..x.xxx.....xx........x..xx.xxxxxx...x..xxx..x......x..xx...xx.x..xxx.x.x..x..x..x.xx.xx.xx..xxxx....x.x.....x.xx....xxx.xxx.......xxx.xxxx..xxxxx..xxxx...x..x..xx...x.xx.x.xx..x.x.xxxxx.x.xx..x.xx.x.xxxx..x.xx...xxx.x....x.xxx.x...xx.x.x.xx.xxx.xxxx.xxx...x.....x..x..xxxxx..xxxxxx....xx.xx..xx.....xxx..x..x.x.xx...xx.x..xxxxx.xxx...x..xx..x.xx.xxxx.xxx.x..xxx.x....xxxxx.xxxx.....xxx..x.x.x..x..xx..xx.....x..xx....x....x..xxx..xxx.x.xx....xx.xx..x.x..x.x.xxx...x...x..xxx.x...xx..x.x.x.xxx.xxxx.xx.x.x.xx.xxx.xx..x.xxx..x.x.xxx...xx...xxx.xx.xxxx..xx..xxx.x.xxx..x.x.x.x.xx...xx....xxx.x...xx..x.xxxx..xx.xxx.x..xxxxxxxxxxx.x...x.x...x..xx..xx...xxx.xxx.x..x.xx.xx.xx..xx....x.x...xxxx..xx.xx...xx.xxx..x...x.xx...x..xxx....xxx.xx..x.x...x.x..x..x.xxxxx...xxx..x..xx.xxx..x..x.xx...x..x.xxxxx.xxxxxx..xxxxx...x.x.xx.xx..xxxxxxx....xxx...x.x.....xxx.xxx..xxx.x...xxxxx...xx.xx...x.x...xxx.xx.xxx..xx.xxx........x..x.x.x.x...x...xx..x.xx.xxxxx.x.xxxxxx.x..x..xxxxx.x.x.xxxx.x.....xxxx.xxxxx.....xx..x.x.x.xx.xx....xxx..xxxx.xxx..x..x.xx..xx.....xxx...xx.x.x..x..xxx..xxx.xx.xx.xx.xxx.xx.xx..xx.....xx.x.x..x.x...xx.x......xx..xx.....x..xx..x...x.x..x...x..xxx.....x...x.....xx..x..x..x........x.xx.xx.xx.x.xxxxxx.xxx.x..x..xx..x.x...x.x.x.x.x.xxx.x..x.xxx.x.xxxxx.xxxx...xx...x.xxx.x.xx..x.x.x...x.x..xxxxx..xx...x.x.x.xxx....xx..x....xx..xx.xxx.x.xxx..x...x...xx..xxxxx..x..x.xxx..x..xx.xx.x.xx....x...x....xxxx..x....xx....x..x..xx.xx.x.xxx.x.xx..xxxxxxx...x..xx..x.xxx..xx.....xx.x.x..x....xx.x...xxx....xxxx..xxxx.x..x.x..xx....xx..x.x.x.x...xx..xx.....x..x..xx.x.x.x......xxx.x..x..xx.xx...x.x.xxx.xx..x.x.....x....x.xx.xx..x.x...x.....x..x...x....xx...x.xxxxxx.x.x.....xx.x.xx.x.x...x.x.xxxxx.x..x.xx...x.xx..xx..xx.xx...xxx..xx........xx......x.x.xx....x...x.xxxx...."));  // 79
    }


    static int MOD = 10000003;

    static int minJumps(String A) {
        List<Integer> position = new ArrayList<>();
        int count = 0;
        int len = A.length();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                position.add(i - count);
                count++;
            }
        }

        if (count == len || count == 0) return 0;
        int med_index = (count - 1) / 2;
        int med_val = position.get(med_index);
        int ans = 0;
        for (Integer integer : position) {
            ans = (ans + (Math.abs(integer - med_val) % MOD)) % MOD;
        }
        return ans % MOD;
    }

    public int seats(String A) {
        int n;
        int i;
        int first, last;
        int[] countLeft;
        int total = 0;
        int midVal;

        if (A == null || A.isEmpty())
            return 0;
        n = A.length();
        countLeft = new int[n];
        first = last = -1;

        for (i = 0; i < n; i++) {
            countLeft[i] = i > 0 ? countLeft[i - 1] : 0;
            if (A.charAt(i) == 'x') {
                if (first == -1)
                    first = i;
                last = i;
                countLeft[i]++;
                total++;
            }
        }

        midVal = (total + 1) / 2;

        if (first == -1 || first == last)
            return 0;

        int mid;

        for (i = first; i <= last; i++) {
            if (countLeft[i] == midVal)
                break;
        }
        mid = i;
        long res = 0;
        int count = 0;

        for (i = mid; i >= first; i--) {
            if (A.charAt(i) == 'x') {
                res += (mid - i - count);
                res %= MOD;
                count++;
            }
        }
        count = 0;
        mid++;
        for (i = mid; i <= last; i++) {
            if (A.charAt(i) == 'x') {
                res += (i - mid - count);
                res %= MOD;
                count++;
            }
        }
        return (int) res;
    }
}
