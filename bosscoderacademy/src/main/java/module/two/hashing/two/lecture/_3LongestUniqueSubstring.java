package module.two.hashing.two.lecture;

import java.util.HashSet;

/**
 * LeetCode 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class _3LongestUniqueSubstring {

    public static void main(String[] args) {
        printLongestUniqueSubstringLength("abcabcbb");
        printLongestUniqueSubstringLength("bbbbb");
        printLongestUniqueSubstringLength("pwwkew");
    }

    private static void printLongestUniqueSubstringLength(String str) {
        System.out.println("Longest substring without repeating characters by approach 1: " + approach1(str));
        System.out.println("Longest substring without repeating characters by approach 2: " + approach2(str));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple bruteforce approach, but not works correctly with substring.
     * - It can work with subsequence but not substring.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(N) due to hashset.
     */
    private static int approach1(String str) {
        int result = 0, n = str.length();
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(str.charAt(j));
            }
            result = Math.max(result, set.size());
        }
        return result;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal approach using sliding window.
     * - The sliding window approach is the combination of hashing and 2 pointers.
     * - Here, we are keeping both pointers at first index and adding char to set.
     * - Then increasing the j pointer and keep on removing elements from set if character already preset in it until it is removed.
     * - After that we are adding the character and updating the result count which is max of result and size of set.
     * - Time complexity: O(N) as we are iterating over the array only once or twice max.
     * - Space complexity: O(N) due to hash set.
     */
    private static int approach2(String str) {
        int i = 0, j = 0, result = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < str.length()) {
            while (set.contains(str.charAt(j))) {
                set.remove(str.charAt(i++));
            }
            set.add(str.charAt(j++));
            result = Math.max(result, set.size());
        }
        return result;
    }

}
