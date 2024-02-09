package com.learning.scaler.advance.module4.contest6;

/*
Problem Description

 In a parallel universe, there is a kingdom that is known for its unique way of writing letters. In this kingdom, there is a famous historian who is interested in studying palindromes in ancient texts. The historian wants to know the number of palindromic substrings in a given ancient text A.Can you help the historian by writing a function that returns the number of palindromic substrings in the given ancient text?

Problem Constraints

 1 <= A.size() <= 1000

Input Format

 First argument is a single string A.

Output Format

 Second argument denotes the total number of palindromic substrings in the string A.

Example Input

 Input 1:

A = "aba"

Input 2:

A = "abcb"



Example Output

 Output 1:

4

Output 2:

5

Example Explanation

 Explanation 1:

The palindromic substrings in string "aba" are ["a", "b", "a", "aba"].

Explanation 2:

The palindromic substrings in string "abcb" are ["a", "b", "c", "b", "bcb"].


* */
public class AncientTexts {

    public int solve(String A) {
        int size = A.length(), count = 0;
        for(int start = 0; start < size; start++){
            for(int end = start; end < size; end++){
                if(isPalindrome(A.substring(start, end +1))) count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String A){
        int len = A.length(), start = 0, end = len -1;
        while(start < end){
            if(A.charAt(start) == A.charAt(end)){
                start++;
                end--;
            }else return false;
        }
        return true;
    }
}
