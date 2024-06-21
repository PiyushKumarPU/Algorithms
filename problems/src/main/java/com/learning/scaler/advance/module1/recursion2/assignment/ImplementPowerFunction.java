package com.learning.scaler.advance.module1.recursion2.assignment;

public class ImplementPowerFunction {

    public static void main(String[] args) {
        System.out.println(pow(-1, 1, 20));
    }

    public static int pow(int x, int n, int d) {
        long a = x;
        long res = 1L;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }
            a *= a;
            a %= d;
            n = n >> 1;
        }
        res = (res + d) % d;
        return (int) res;
    }

    public int pow2(int A, int B, int C) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        long ans = pow2(A, B / 2, C);
        ans = (ans * ans) % C;
        if (B % 2 == 1)
            ans = (ans * A);
        ans = (ans + C) % C;
        return (int) ans;
    }
}
