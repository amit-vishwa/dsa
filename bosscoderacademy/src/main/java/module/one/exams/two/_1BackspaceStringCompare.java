package module.one.exams.two;

import java.util.Stack;

/**
 * LeetCode 844. Backspace String Compare
 * Refer: https://leetcode.com/problems/backspace-string-compare/description/
 */
public class _1BackspaceStringCompare {

    public static void main(String[] args) {
        printResult("ab#c", "ad#c");
        printResult("ab##", "c#d#");
        printResult("a#c", "b");
    }

    private static void printResult(String s, String t) {
        System.out.println("Approach 1: Are strings equal? " + approach1(s, t));
        System.out.println("Approach 2: Are strings equal? " + approach2(s, t));
        System.out.println("Approach 3: Are strings equal? " + approach3(s, t));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is the worst bruteforce approach.
     * - Here we are creating new updated strings from given strings, where only comparable characters are there.
     * - Since we are adding characters and removing if '#' found from new string at the same time, the complexity is
     * getting increased to quadratic i.e. nested loops.
     * - At last, we are just comparing the strings which is still O(N) time complexity.
     * - Time: O(n^2 + m^2) — Java String concatenation (str += ...) and substring copies make this quadratic in the
     * worst case.
     * - Space: O(n + m) — final built strings dominate extra space.
     */
    private static boolean approach1(String s, String t) {
        String str1 = "", str2 = "";
        for (int i = 0; i < s.length(); i++) {
            str1 += s.charAt(i);
            if (s.charAt(i) == '#' && str1.length() > 1) {
                str1 = str1.substring(0, str1.length() - 2);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            str2 += t.charAt(i);
            if (t.charAt(i) == '#' && str2.length() > 1) {
                str2 = str2.substring(0, str2.length() - 2);
            }
        }
        return str1.equals(str2);
    }

    /**
     * Approach 2 - Better approach
     * - This is better approach than above bruteforce one.
     * - Here we are using stack to add remove characters as per the given logic.
     * - And at last, we are just comparing the stack.
     * - Time: O(n + m) — each character is pushed/popped at most once; comparing two stacks is linear.
     * - Space: O(n + m) — two stacks may store all characters.
     */
    private static boolean approach2(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }
        return stack1.equals(stack2);
    }

    /**
     * Approach 3 - Optimal approach
     * - The approach is quite optimal and involves two pointers.
     * - Here we are keeping pointers at end of both strings and count skipping characters.
     * - If encountered '#' then increase skip count and try to reduce it by moving pointers ahead.
     * - After finally completing it we will be left with actual real character that can be compared.
     * - Compare the characters if both strings are not empty that both pointers are positive.
     * - Time: O(n + m) — each character is examined at most once using backward two-pointer skip logic.
     * - Space: O(1) extra — only a few integer counters/pointers used.
     */
    private static boolean approach3(String s, String t) {
        // take variables for indexes and skip counts
        int i = s.length() - 1, j = t.length() - 1, sSkip = 0, tSkip = 0;
        while (i >= 0 || j >= 0) { // loop till both string traversal is complete
            i = comparingIndex(s, i, sSkip); // get comparable index from string 1
            j = comparingIndex(t, j, tSkip); // get comparable index from string 2
            if (i < 0 && j < 0) { // if indexes are less than 0 that means strings are empty now
                return true;
            }
            // if any one string is not empty or both not empty but characters are different
            if (i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // else update pointers from both strings
            i--;
            j--;
        }
        return true;
    }

    private static int comparingIndex(String str, int index, int skipCount) {
        // if index >= 0 and skipCount is already greater than 0 or character is '#', update pointer
        while (index >= 0 && (skipCount > 0 || str.charAt(index) == '#')) {
            if (str.charAt(index) == '#') {
                skipCount++;
            } else {
                skipCount--;
            }
            index--;
        }
        return index;
    }

}
