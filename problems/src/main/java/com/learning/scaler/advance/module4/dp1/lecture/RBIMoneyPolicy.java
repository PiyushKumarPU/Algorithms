package com.learning.scaler.advance.module4.dp1.lecture;


import java.util.Arrays;

/*
*
    RBI wants to reduce paper usage for money Imagine you need to withdraw a specific amount
    of money from an ATM The ATM should be programed to give the least number of notes
    Available notes {50 30 53}
    Return minimum number of notes for a given request
    * */
public class RBIMoneyPolicy {

    static final int[] availabelNotes = new int[]{50, 30, 5};

    int[] notesCount;

    public static void main(String[] args) {
        System.out.println(new RBIMoneyPolicy().noOfNotes(65));
    }

    public int noOfNotes(int A) {
        if (A < 5) return 0;
        if (notesCount == null) {
            notesCount = new int[A + 1];
            Arrays.fill(notesCount, -1);
        }
        int first = noOfNotes(A - availabelNotes[0]);
        int second = noOfNotes(A - availabelNotes[1]);
        int third = noOfNotes(A - availabelNotes[2]);
        return 1 + Math.min(Math.min(first, second), third
        );
    }
}
