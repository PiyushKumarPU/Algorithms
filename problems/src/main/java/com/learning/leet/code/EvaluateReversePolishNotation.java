package com.learning.leet.code;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN("4,13,5,/,+".split(",")));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                // calculate and push back to stack
                int first = stack.pop();
                int second = stack.pop();
                int result = switch (token) {
                    case "+" -> first + second;
                    case "-" -> second - first;
                    case "*" -> first * second;
                    case "/" -> second / first;
                    default -> 0;
                };
                stack.push(result);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }


}
