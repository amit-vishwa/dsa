package module.two.stacks.assignment;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation:
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Time and space complexity is O(N).
 */
public class _1EvaluateNotation {

    public static void main(String[] args) {
        System.out.println("Evaluation result: " + evaluateNotation(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println("Evaluation result: " + evaluateNotation(new String[]{"4", "13", "5", "/", "+"}));
    }

    private static int evaluateNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = switch (token) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num2 == 0 ? 0 : num1 / num2;
                    default -> 0;
                };
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}