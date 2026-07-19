package module.one.backtracking.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example
 * Input: n=2
 * Output: {}{} {{}}
 */
public class _6GenerateParenthesis {

    public static void main(String[] args) {
        printParenthesis(2);
        printParenthesis(3);
    }

    private static void printParenthesis(int n) {
        System.out.println("Parenthesis by approach 1: " + approach1(0, 0, n, ""));
        System.out.println("Parenthesis by approach 2: " + approach2(0, 0, n, new ArrayList<Character>()));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion:
     * - Generating the parenthesis using a simple recursion call.
     * - Here we are keeping track of open and close parenthesis count, once it is N we got our answer.
     * - We can only explore by adding open parenthesis when it is less than N.
     * - Also, we can only explore by adding close parenthesis when it is less than open.
     * - At last, we can simply return the parenthesis list.
     * - Time complexity: O(2^N) for generating the open and close parenthesis.
     * - Space complexity: O(2^N) for recursion stack.
     */
    private static List<String> approach1(int open, int close, int n, String res) {
        if (open == n && close == n) {
            return new ArrayList<>(List.of(res));
        }
        List<String> parenthesis = new ArrayList<>();
        if (open < n) {
            parenthesis.addAll(approach1(open + 1, close, n, res + "{"));
        }
        if (close < open) {
            parenthesis.addAll(approach1(open, close + 1, n, res + "}"));
        }
        return parenthesis;
    }

    /**
     * Approach 2 - Backtracking:
     * - This is similar to approach 1 but here we are using a list of character to store the parenthesis.
     * - Also, we are backtracking after exploring by adding the open and close parenthesis.
     * - Time and space complexity is similar to approach 1.
     */
    private static List<List<Character>> approach2(int open, int close, int n, List<Character> parenthesis) {
        if (open == n && close == n) {
            return new ArrayList<>(List.of(new ArrayList<>(parenthesis)));
        }
        List<List<Character>> result = new ArrayList<>();
        if (open < n) {
            parenthesis.add('{');
            result.addAll(approach2(open + 1, close, n, parenthesis));
            parenthesis.removeLast();
        }
        if (close < open) {
            parenthesis.add('}');
            result.addAll(approach2(open, close + 1, n, parenthesis));
            parenthesis.removeLast();
        }
        return result;
    }

}
