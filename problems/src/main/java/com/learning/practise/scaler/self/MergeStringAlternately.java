package com.learning.practise.scaler.self;

public class MergeStringAlternately {

    public static void main(String[] args) {

        System.out.println(mergeStringAlternately("abc","pqr"));
        System.out.println(mergeStringAlternately("ab","pqrs"));
        System.out.println(mergeStringAlternately("abcd","pq"));
    }

    private static String mergeStringAlternately(String str1, String str2){
        StringBuffer result = new StringBuffer();
        int index = 0;
        for(; index< str1.length();index++){
            result.append(str1.charAt(index));
            if(index < str2.length()){
                result.append(str2.charAt(index));
            }
        }
        if(index < str2.length()){
            result.append(str2.substring(index));
        }
        return result.toString();
    }
}
