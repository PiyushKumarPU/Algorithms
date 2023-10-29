package com.learning.practise.scaler.self.basics;

import java.math.BigInteger;

public class NextSmallestPalindrome {

    public static void main(String[] args) {
        System.out.println(solve("1740948824551711527614232216857618927954312334113874277931986502860248650900613893446066184963788291"));
    }

    public static String nextSmallestPalindrome(String A) {
        if(isPalindrome(A)){
            // process by adding 1 to middle number
        } else if (containsAll9Char(A)) {
            return new BigInteger(A).add(new BigInteger("2")).toString();
        }else{
            // process like normal string by dividing into left and right part and increase right part
        }

        return "";
    }


    public static boolean containsAll9Char(String str){
        for(int index = 0 ; index < str.length(); index++){
            if(str.charAt(index) != '9') return false;
        }
        return true;
    }

    public static String solve(String A) {
        BigInteger value = new BigInteger(A).add(BigInteger.ONE);
        boolean isNextPalindromeFound = false;
        while(!isNextPalindromeFound){
            isNextPalindromeFound = isPalindrome(value.toString());
            if(isNextPalindromeFound){
                return value.toString();
            }
        }
        return value.toString();
    }

    public static boolean isPalindrome(String A){
        if(A.length() < 2) return false;
        int startIndex = 0;
        int endIndex = A.length() -1;
        while(startIndex < endIndex){
            if(A.charAt(startIndex) != A.charAt(endIndex)){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
