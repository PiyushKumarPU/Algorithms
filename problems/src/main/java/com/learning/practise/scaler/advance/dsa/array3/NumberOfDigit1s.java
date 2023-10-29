package com.learning.practise.scaler.advance.dsa.array3;

public class NumberOfDigit1s {

    public static void main(String[] args) {
        System.out.println(solveWithFormula(10));
        System.out.println(solveWithFormula(11));
        System.out.println(solveWithFormula(926));
    }

    public static int solveWithFormula(int A) {
        int count = 0;
        for (int place = 0; place < String.valueOf(A).length(); place++) {
            long placeVal = (long) Math.pow(10, place);
            count += (int) (((A / (10 * placeVal)) * placeVal) + Math.min(Math.max(A % (10 * placeVal) - (placeVal - 1), 0),
                    placeVal));
        }
        return count;
    }

    private static long power(int exp) {
        return (long) Math.pow(10, exp);
    }

}
