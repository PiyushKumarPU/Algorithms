package com.learning.scaler.advance.module3.stack1.assignment;


/*
Problem Description
    An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic
    expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each string may be an integer or an operator.
    Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

Problem Constraints
    1 <= N <= 10^5

Input Format
    The only argument given is string array A.

Output Format
    Return the value of arithmetic expression formed using reverse Polish Notation.

Example
    Input 1:
        A = ["2", "1", "+", "3", "*"]
    Input 2:
        A = ["4", "13", "5", "/", "+"]

Example Output
Output 1:
    9
Output 2:
    6

Example
    Explanation 1:
        starting from backside:
            * : () * ()
            3 : () * (3)
            + : (() + ()) * (3)
            1 : (() + (1)) * (3)
            2 : ((2) + (1)) * (3)
            ((2) + (1)) * (3) = 9
    Explanation 2:
        starting from backside:
            + : () + ()
            / : () + (() / ())
            5 : () + (() / (5))
            13 : () + ((13) / (5))
            4 : (4) + ((13) / (5))
            (4) + ((13) / (5)) = 6
* */
public class EvaluateExpression {

    public int evalRPN(String[] A) {
        return 0;
    }
}
