package com.jason.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: 150
 * Difficulty: Medium
 * The purpose of the code in the current editor is to evaluate arithmetic expressions presented in
 * Reverse Polish Notation (RPN), also known as postfix notation.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        List<String> operators = List.of("+", "-", "*", "/");
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(cal(num1, num2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int cal(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else if (operator.equals("/")) {
            return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
