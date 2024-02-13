package com.learning.scaler.intermediate.carry_forwar_contri.lecture;


/*
    Given a string of lowercase characters and return count of pair (i,j)
    such that i< j and  s[i] = 'a', s[j] ='g'
* */
public class CountPair {

    public static void main(String[] args) {
        System.out.println(countPair("abegag"));
        System.out.println(countPairBruteForce("abegag"));

    }


    public static int countPairBruteForce(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                // count all g available after a
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 'g') count++;
                }
            }
        }
        return count;
    }

    public static int countPair(String str) {
        int count = 0, aCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') aCount++;
            else if (str.charAt(i) == 'g') count += aCount ;
        }
        return count;
    }


}
