package com.learning.practise.scaler.self.strings;

public class IsAlphaNum {

    public static void main(String[] args) {
        System.out.println(solve(new char[]{'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'}));
        System.out.println(solve(new char[]{'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'}));
    }

    public static int solve(char[] A) {
        for (char ch : A) {
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))) return 0;
        }
        return 1;
    }
}
