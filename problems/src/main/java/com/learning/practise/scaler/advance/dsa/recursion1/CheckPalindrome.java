package com.learning.practise.scaler.advance.dsa.recursion1;

/*
 *
 * Write a recursive function that checks whether string A is a palindrome or Not.
 * Return 1 if the string A is a palindrome, else return 0.
 * Note: A palindrome is a string that's the same when read forward and backward.
 * */
public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(solve("naman"));
        System.out.println(solve("strings"));

    }

    public static int solve(String A) {
        return solve(A.toLowerCase(), 0, A.length() - 1) ? 1 : 0;
    }

    private static boolean solve(String A, int x, int y) {
        if (x == y) return true;
        if (A.charAt(x) != A.charAt(y)) return false;
        if (x < (y + 1)) return solve(A, x + 1, y - 1);
        return true;
    }


}
