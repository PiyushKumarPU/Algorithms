package com.learning.scaler.advance.module2.combinatorics.additional;


/*
Problem Description
    Given a column title as appears in an Excel sheet, return its corresponding column number.

Problem Constraints
    1 <= length of the column title <= 5

Input Format
    The only argument is a string that represents the column title in the excel sheet.

Output Format
    Return a single integer that represents the corresponding column number.

Example Input
    Input 1:
         AB
    Input 2:
         BB

Example Output
    Output 1:
         28
    Output 2:
         54

Example Explanation
Explanation 1:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
Explanation 2:
     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     ...
     AZ -> 52
     BA -> 53
     BB -> 54
* */
public class ExcelColumnNumber {

    public int titleToNumber(String A) {
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            result *= 26;
            result += A.charAt(i) - 'A' + 1;
        }
        return result;
    }
}
