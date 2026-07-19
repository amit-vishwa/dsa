package module.two.dp.two.assignment;

import java.util.Arrays;

/**
 * Longest Palindromic Subsequence:
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the
 * order of the remaining elements.
 * <p>
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * <p>
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * <p>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class _7LongestPalindromicSubsequence {

    public static void main(String[] args) {
        printLongestPalindromicSubsequenceLength("bbbab");
        printLongestPalindromicSubsequenceLength("cbbd");
    }

    private static void printLongestPalindromicSubsequenceLength(String s) {
        System.out.println("Longest palindromic subsequence length using recursion:          " + approach1(s));
        System.out.println("Longest palindromic subsequence length using memoization:        " + approach2(s));
        System.out.println("Longest palindromic subsequence length using tabulation:         " + approach3(s));
        System.out.println("Longest palindromic subsequence length using space optimization: " + approach4(s));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - The logic is simple bruteforce approach.
     * - We are using the similar logic as of Longest Common Subsequence problem, only here we are using reversed string.
     * - Time complexity: O(2^(M+N)) due to recursion tree.
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static int approach1(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return recursion(s, r, 0, 0);
    }

    private static int recursion(String s, String r, int idx1, int idx2) {
        if (idx1 == s.length() || idx2 == r.length()) {
            return 0;
        }
        if (s.charAt(idx1) == r.charAt(idx2)) {
            return 1 + recursion(s, r, idx1 + 1, idx2 + 1);
        }
        return Math.max(recursion(s, r, idx1 + 1, idx2), recursion(s, r, idx1, idx2 + 1));
    }

    /**
     * Approach 2 - Memoization
     * - Similar to approach 2 of Longest Common Subsequence problem.
     * - Time complexity: O(M*N)
     * - Space complexity: O(M*N) due to 2D array + O(M+N) due to recursion stack.
     */
    private static int approach2(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][r.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoization(s, r, 0, 0, dp);
    }

    private static int memoization(String s, String r, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == s.length() || j == r.length()) {
            return dp[i][j] = 0;
        }
        if (s.charAt(i) == r.charAt(j)) {
            return dp[i][j] = 1 + memoization(s, r, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(memoization(s, r, i + 1, j, dp), memoization(s, r, i, j + 1, dp));
    }

    /**
     * Approach 3 - Tabulation
     * - This is better approach similar to approach 3 of Longest Common Subsequence problem.
     * - Time and space complexity is O(M*N) without any recursion stack, as we are using iteration here.
     */
    private static int approach3(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int m = s.length(), n = r.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (s.charAt(i - 1) == r.charAt(j - 1)) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    /**
     * Approach 4 - Space optimization
     * - The approach is similar to approach 4 of Longest Common Subsequence problem.
     * - Time complexity: O(M*N)
     * - Space complexity: O(N)
     */
    private static int approach4(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        int m = s.length(), n = rs.length();
        int[] prev = new int[n + 1];
        for (int r = 1; r <= m; r++) {
            int[] curr = new int[n + 1];
            for (int c = 1; c <= n; c++) {
                curr[c] = (s.charAt(r - 1) == rs.charAt(c - 1)) ? 1 + prev[c - 1] : Math.max(prev[c], curr[c - 1]);
            }
            prev = curr;
        }
        return prev[n];
    }

}