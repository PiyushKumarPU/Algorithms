package com.learning.leet.code;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse1(1534236469));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }
        return result;
    }

    public static int reverse1(int x) {
        int ans = 0,pre = 0;
        while (x != 0) {
            pre = ans;
            ans = ans * 10 + x % 10;
            if (ans / 10 != pre) return 0;
            x = x / 10;
        }
        return ans;
    }
}
