package com.learning.practise.scaler.self.strings;

public class ToggleCase {

    public static void main(String[] args) {
        System.out.println(solve("tHiSiSaStRiNg"));
    }

    public static String solve(String A) {
        char[] chars = A.toCharArray();
        for(int i = 0; i < A.length(); i++){
           if(chars[i] >= 'A' && chars[i] <= 'Z'){
               chars[i] += 32;
           }else{
               chars[i] -= 32;
           }
        }
        return new String(chars);
    }
}
