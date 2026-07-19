package module.two.dp.two.assignment;

import java.util.Arrays;

/**
 * Longest Common Subsequence:
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence,
 * return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
 * without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
public class _5LongestCommonSubsequence {

    public static void main(String[] args) {
        printLongestCommonSubsequenceLength("abcde", "ace");
        printLongestCommonSubsequenceLength("abc", "abc");
    }

    private static void printLongestCommonSubsequenceLength(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return;
        }
        System.out.println("Longest common subsequence length using recursion:          " + approach1(text1, text2));
        System.out.println("Longest common subsequence length using memoization:        " + approach2(text1, text2));
        System.out.println("Longest common subsequence length using tabulation:         " + approach3(text1, text2));
        System.out.println("Longest common subsequence length using space optimization: " + approach4(text1, text2));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest bruteforce approach.
     * - Start from first index of both strings and iterate till last of anyone, if last reached then return 0.
     * - If character at current index is same for both strings then add 1 to answer and check for next chars in both.
     * - Else return the max value of checking for next in char in text1 and next char in text2.
     * - Time complexity: O(2^(M+N)) due to recursion tree.
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static int approach1(String text1, String text2) {
        return recursion(text1, text2, 0, 0);
    }

    private static int recursion(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + recursion(text1, text2, i + 1, j + 1);
        }
        return Math.max(recursion(text1, text2, i + 1, j), recursion(text1, text2, i, j + 1));
    }

    /**
     * Approach 2 - Memoization
     * - Only extra array is added here to use top-down approach and avoid re-computations.
     * - Time complexity: O(M*N)
     * - Space complexity: O(M*N) due to 2D array + recursion stack.
     */
    private static int approach2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoization(text1, text2, 0, 0, dp);
    }

    private static int memoization(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + memoization(text1, text2, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(memoization(text1, text2, i + 1, j, dp), memoization(text1, text2, i, j + 1, dp));
    }

    /**
     * Approach 3 - Tabulation
     * - We are using iteration for bottom up approach.
     * - The recursion stack memory is reduced, rest all complexities are similar to approach 2.
     */
    private static int approach3(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // first row and col should be 0
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                dp[r][c] = (text1.charAt(r - 1) == text2.charAt(c - 1)) ? 1 + dp[r - 1][c - 1] : Math.max(dp[r - 1][c], dp[r][c - 1]);
            }
        }
        return dp[m][n];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the most optimal solution here.
     * - We have optimized the space from 2D array to 1D array, rest all complexities are similar to approach 3.
     */
    private static int approach4(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1];
        for (int r = 1; r <= m; r++) {
            int[] curr = new int[n + 1];
            for (int c = 1; c <= n; c++) {
                curr[c] = (text1.charAt(r - 1) == text2.charAt(c - 1)) ? 1 + prev[c - 1] : Math.max(prev[c], curr[c - 1]);
            }
            prev = curr;
        }
        return prev[n];
    }

}