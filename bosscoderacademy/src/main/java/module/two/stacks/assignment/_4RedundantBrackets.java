package module.two.stacks.assignment;

import java.util.Stack;

/**
 * Expression Redundant Bracket:
 * <p>
 * Given a string of balanced expressions, find if it contains a redundant parenthesis or not. A set of parenthesis is
 * redundant if the same sub-expression is surrounded by unnecessary or multiple brackets. Return true if redundant, else false.
 * <p>
 * Input: str = “((a+b))”
 * Output: true
 * Explanation: ((a+b)) can reduced to (a+b), this Redundant
 * <p>
 * Input: str = “(a+(b)/c)”
 * Output: true
 * <p>
 * Constraints:
 * 1 <= str.length <= 10^5
 */
public class _4RedundantBrackets {

    public static void main(String[] args) {
        System.out.println("Expression contains redundant brackets: " + evaluateExpression("((a+b))"));
        System.out.println("Expression contains redundant brackets: " + evaluateExpression("(a+(b)/c)"));
        System.out.println("Expression contains redundant brackets: " + evaluateExpression("(a+(b/c))"));
    }

    /**
     * Approach:
     * - Iterate over the characters of given expression string.
     * - If current character is not a closing bracket then simply add that to stack.
     * - Else, take top of stack and a true boolean flag.
     * - Now, iterate over the stack until it is empty or top is an opening bracket.
     * - Inside, while loop, check if current top element is among 4 operators, if yes then make flag as false, and update top.
     * - Now, after while loop, check if flag is true, then just return true i.e. duplicate brackets found.
     * - Else, at last, after iterating all characters, just return false i.e. no duplicate brackets found.
     * - Time and space complexity is O(N).
     */
    private static boolean evaluateExpression(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                char top = stack.pop();
                boolean flag = true;
                while (!stack.empty() && top != '(') {
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        flag = false;
                    }
                    top = stack.pop();
                }
                if (flag) {
                    return true; // duplicate brackets found
                }
            } else {
                stack.push(ch);
            }
        }
        return false; // duplicate brackets not found
    }

}