package module.two.stacks.lecture;

import java.util.HashMap;
import java.util.Stack;

/**
 * Valid Parentheses:
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * <p>
 * Example 5:
 * Input: s = "([)]"
 * Output: false
 * <p>
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class _2ValidParentheses {

    public static void main(String[] args) {
        printValidParenthesesResult("()");
        printValidParenthesesResult("()[]{}");
        printValidParenthesesResult("(]");
        printValidParenthesesResult("([])");
        printValidParenthesesResult("([)]");
        printValidParenthesesResult("]]]((){)[[}[");
    }

    private static void printValidParenthesesResult(String s) {
        System.out.println("Valid parentheses by approach 1: " + approach1(s));
        System.out.println("Valid parentheses by approach 2: " + approach2(s));
        System.out.println();
    }

    /**
     * Approach 1 - HashMap
     * - The approach is not working for all testcases, so always use stack.
     * - We are using hashmap to store occurrences of opening brackets or parentheses.
     * - Then if we get closing parentheses then just check if we have opening parentheses.
     * - If yes just decrease occurrence count, else skip.
     * - At last, just iterate over the values of map and check if any of it is not zero then return false.
     * - Else at last just return true.
     * - Time and space complexity is O(N).
     */
    private static boolean approach1(String str) {
        HashMap<Character, Integer> parenthesesMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                parenthesesMap.put(ch, parenthesesMap.getOrDefault(ch, 0) + 1);
            } else if (ch == ']' && parenthesesMap.containsKey('[')) {
                parenthesesMap.put('[', parenthesesMap.getOrDefault('[', 0) - 1);
            } else if (ch == ')' && parenthesesMap.containsKey('(')) {
                parenthesesMap.put('(', parenthesesMap.getOrDefault('(', 0) - 1);
            } else if (ch == '}' && parenthesesMap.containsKey('{')) {
                parenthesesMap.put('{', parenthesesMap.getOrDefault('{', 0) - 1);
            }
        }
        parenthesesMap.values();
        for (Integer val : parenthesesMap.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2 - Stack
     * - This is the expected approach.
     * - Here, we just have to push all opening parentheses.
     * - If closing parentheses encountered, just check if stack is not empty and top char is corresponding opening parentheses.
     * - If it is true the do pop, else just return false.
     * - After all string traversal, just return is stack is empty or not.
     * - Time and space complexity is O(N).
     */
    private static boolean approach2(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if ((ch == ']' && stack.peek() == '[') || (ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{')) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
