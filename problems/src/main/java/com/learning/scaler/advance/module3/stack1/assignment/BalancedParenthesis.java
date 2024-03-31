package com.learning.scaler.advance.module3.stack1.assignment;


import java.util.HashMap;
import java.util.Stack;

/*
Problem Description
    Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
    Refer to the examples for more clarity.

Problem Constraints
    1 <= |A| <= 100

Input Format
    The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
    Return 0 if the parenthesis sequence is not balanced.
    Return 1 if the parenthesis sequence is balanced.

Example
    Input 1:
         A = {([])}
    Input 2:
         A = (){
    Input 3:
         A = ()[]

Example
    Output 1:
         1
    Output 2:
         0
    Output 3:
         1

Example Explanation
    You can clearly see that the first and third case contain valid parenthesis.
    In the second case, there is no closing bracket for {, thus the parenthesis sequence is invalid.
* */
public class BalancedParenthesis {
    public int solve(String A) {
        Stack<Character> paranthesisStack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            Character current = A.charAt(i);
            if (current.equals('(') || current.equals('{') || current.equals('[')) paranthesisStack.push(current);
            else {
                if (paranthesisStack.isEmpty()) return 0;
                // pull current from stack
                Character prev = paranthesisStack.pop();
                if ((prev.equals('(') && !current.equals(')')) ||
                        (prev.equals('{') && !current.equals('}')) ||
                        (prev.equals('[') && !current.equals(']'))
                ) return 0;
            }
        }
        if (!paranthesisStack.isEmpty()) return 0;
        return 1;
    }

    public int solveScaler(String A) {
        HashMap<Character, Character> mp = new HashMap<>();
        Stack<Character> st = new Stack<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (st.empty() || st.peek() != mp.get(c)) {
                return 0;
            } else {
                st.pop();
            }
        }
        // checks if all the opening brackets are paired
        if (st.empty())
            return 1;
        return 0;
    }

}
