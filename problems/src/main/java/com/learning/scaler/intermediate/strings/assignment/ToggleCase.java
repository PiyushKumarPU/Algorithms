package com.learning.scaler.intermediate.strings.assignment;

/*
Problem Description
    You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
    You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.

Problem Constraints
    1 <= N <= 10^5
    A[i] ∈ ['a'-'z', 'A'-'Z']


Input Format
    First and only argument is a character string A.

Output Format
    Return a character string.

Example Input
    Input 1:
         A = "Hello"
    Input 2:
         A = "tHiSiSaStRiNg"

Example Output
    Output 1:
         hELLO
    Output 2:
         ThIsIsAsTrInG

Example Explanation
    Explanation 1:
         'H' changes to 'h'
         'e' changes to 'E'
         'l' changes to 'L'
         'l' changes to 'L'
         'o' changes to 'O'
    Explanation 2:
         "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
* */
public class ToggleCase {

    public static void main(String[] args) {
        System.out.println(new ToggleCase().solve("Hello"));
    }

    public String solve(String A) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            // lower case ascii 97 to 122 and upper case ascii 65 to 90
            int currentChar = A.charAt(i);
            currentChar = currentChar + ((currentChar >= 65 && currentChar <= 90) ? 32 : -32);
            stringBuilder.append((char)currentChar);
        }
        return stringBuilder.toString();
    }

    public String solveArray(String A) {
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
