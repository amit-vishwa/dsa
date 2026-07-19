package module.two.queues.assignment;

import java.util.Stack;

/**
 * Longest Valid Parentheses:
 * <p>
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring.
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * <p>
 * Constraints:
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class _2LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println("Longest valid parentheses size: " + longestValidParentheses("(()"));
        System.out.println("Longest valid parentheses size: " + longestValidParentheses(")()())"));
    }

    /**
     * Approach:
     * - It is an optimal approach and below link can be referred for explanation.
     * - Time and space complexity is O(N).
     * - Refer: https://leetcode.com/problems/longest-valid-parentheses/solutions/5373015/stack-solution-video-explanation-by-niit-x3ct/
     */
    private static int longestValidParentheses(String s) {
        Stack<Integer> indicesStack = new Stack<>();
        indicesStack.push(-1); // to handle case when closed bracket found at 0 index
        int longestParentheses = 0; // to check max length
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // open bracket, just push it
                indicesStack.push(i);
            } else {
                indicesStack.pop(); // closing encountered, pop an element
                if (indicesStack.isEmpty()) { // stack empty, just push current index
                    indicesStack.push(i);
                } else { // else compare longest parentheses
                    longestParentheses = Math.max(longestParentheses, i - indicesStack.peek());
                }
            }
        }
        return longestParentheses;
    }

}