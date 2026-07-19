package module.two.stacks.assignment;

import java.util.Stack;

/**
 * Remove Duplicate Letters:
 * <p>
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result
 * is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 * <p>
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 * <p>
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
public class _6RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println("Distinct letter in lexicographical order: " + distinctLexicographicalLetters("bcabc"));
        System.out.println("Distinct letter in lexicographical order: " + distinctLexicographicalLetters("cbacdcbc"));
    }

    /**
     * Approach:
     * - The approach is little different, then the normal ones.
     * - Here, we are creating a hash array to store last index of characters.
     * - Then we have boolean array to store visited result of characters and then a stack of integers.
     * - Now, we are iterating over characters of given string.
     * - We are checking if current character is already visited, if yes then skip it.
     * - Else, we are checking if stack is not empty and top is greater than current char and index is less than last index.
     * - If yes, then pop out the char from stack and mark it as not visited.
     * - Now, after while loop ends, just add current char in stack and mark it as visited.
     * - After iterating over all characters, just remove all stack chars and store it in string builder.
     * - At last, just reverse the string builder and return it as string result.
     * - Time complexity: O(N) for last index + O(N) for populating stack + O(N) for string builder + O(N) for reverse = O(4N) = O(N)
     * - Space complexity: O(N) for last index + O(N) for boolean + O(N) for stack + O(N) for string builder = O(4N) = O(N)
     */
    private static String distinctLexicographicalLetters(String str) {
        int n = str.length();
        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndex[str.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int cur = str.charAt(i) - 'a';
            if (seen[cur]) {
                continue;
            }
            while (!stack.empty() && stack.peek() > cur && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            stack.push(cur);
            seen[cur] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append((char) (stack.pop() + 'a'));
        }
        return sb.reverse().toString();
    }

}