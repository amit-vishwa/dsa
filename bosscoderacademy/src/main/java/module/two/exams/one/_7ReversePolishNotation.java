package module.two.exams.one;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation:
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * - The valid operators are '+', '-', '*', and '/'.
 * - Each operand may be an integer or another expression.
 * - The division between two integers always truncates toward zero.
 * - There will not be any division by zero.
 * - The input represents a valid arithmetic expression in a reverse polish notation.
 * - The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * Constraints:
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 * <p>
 * Refer: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class _7ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println("Reverse polish notation evaluation: " + evaluate(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println("Reverse polish notation evaluation: " + evaluate(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println("Reverse polish notation evaluation: " + evaluate(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    /**
     * Approach:
     * - This is a simple approach using Stack.
     * - We are just adding all numbers in the stack and popping top 2 if any operators are encountered.
     * - We are doing the operations and pushing the result in the stack.
     * - At last, we are just popping the last element from the stack that have the result.
     * - Time complexity: O(N) as we are traversing the string array once.
     * - Space complexity: O(N) due to stack.
     */
    private static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (token.equals("+")) {
                    stack.push(num1 + num2);
                }
                if (token.equals("-")) {
                    stack.push(num1 - num2);
                }
                if (token.equals("*")) {
                    stack.push(num1 * num2);
                }
                if (token.equals("/")) {
                    stack.push(num2 == 0 ? 0 : num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
