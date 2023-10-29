package com.learning.practise.scaler.self.ps;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(11));
        System.out.println(isPrime(12));
    }

    public static Boolean isPrime(int n) {
        int i = 2;
        while (i * i < n) {
            if (n % i == 0) return false;
            i++;
        }
        return true;
    }
}
