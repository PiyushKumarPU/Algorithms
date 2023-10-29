package com.learning.practise.scaler.self;

import java.util.HashMap;
import java.util.Map;

public class MinAppendForPalindrome {

    public static void main(String[] args) {
        System.out.println(minAppendForPalindrome("abede"));
    }

    private static int minAppendForPalindrome(String value){
        Map<Character, Integer> countMap = new HashMap<>();
        for(char ch : value.toCharArray()){
            if(countMap.containsKey(ch)){
                countMap.put(ch, countMap.get(ch)+1);
            }else{
                countMap.put(ch, 1);
            }
        }
        return (int) countMap.values().stream().filter(count -> count%2!=0).count();
    }

    private static boolean isPalindrome(String str){
        for(int i = 0; i < (str.length()/2); i ++){
            if(str.charAt(i) != str.charAt(str.length()-(i +1))){
                return false;
            }
        }
        return true;
    }
}
