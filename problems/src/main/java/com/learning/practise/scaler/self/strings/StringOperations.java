package com.learning.practise.scaler.self.strings;

public class StringOperations {

    public static void main(String[] args) {
        System.out.println(solve("AbcaZeoB"));
    }

    public static String solve(String A) {
        StringBuilder result = new StringBuilder();
        char[] chars = A.toCharArray();
        for(char ch : chars){
            if(ch < 'A' || ch > 'Z'){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    result.append("#");
                }else{
                    result.append(ch);
                }
            }
        }
        return result + result.toString();
    }
}
