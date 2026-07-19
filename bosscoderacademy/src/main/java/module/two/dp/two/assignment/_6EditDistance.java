package module.two.dp.two.assignment;

import java.util.Arrays;

/**
 * Edit Distance:
 * <p>
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * <p>
 * Constraints:
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class _6EditDistance {

    public static void main(String[] args) {
        printMinNumOperations("horse", "ros");
        printMinNumOperations("intention", "execution");
    }

    private static void printMinNumOperations(String word1, String word2) {
        System.out.println("Minimum number of operations required using recursion:          " + approach1(word1, word2));
        System.out.println("Minimum number of operations required using memoization:        " + approach2(word1, word2));
        System.out.println("Minimum number of operations required using tabulation:         " + approach3(word1, word2));
        System.out.println("Minimum number of operations required using space optimization: " + approach4(word1, word2));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the worst bruteforce approach.
     * - We are using a simple recursion by adding base cases and calling the recursive functions.
     * - When word1 is traversed fully, then just return the index of word2 as we have to insert all remaining chars from
     * word2 to word1.
     * - When word2 is traversed fully, then just return the index of word1 as we have to remove all remaining chars from
     * word1 to make it word2.
     * - When chars from both words are same then proceed with exploring next chars i.e. just replace chars and return.
     * - Else, perform insertion, deletion and replacement.
     * - After that just return the min among 3 results and add 1 to it.
     * - Time complexity: O(3^(M+N)) as we are performing 3 operations without any conditions
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static int approach1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        return recursion(word1, word2, m, n);
    }

    private static int recursion(String word1, String word2, int idx1, int idx2) {
        if (idx1 == 0) {
            return idx2; // insert all
        }
        if (idx2 == 0) {
            return idx1; // delete all
        }
        if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)) {
            return recursion(word1, word2, idx1 - 1, idx2 - 1);
        }
        int insert = recursion(word1, word2, idx1, idx2 - 1);
        int delete = recursion(word1, word2, idx1 - 1, idx2);
        int replace = recursion(word1, word2, idx1 - 1, idx2 - 1);
        return 1 + Math.min(insert, Math.min(delete, replace));
    }

    /**
     * Approach 2 - Memoization
     * - This approach uses the top-down approach and reduces the time complexity.
     * - A 2D array is used to store the results, so that re-computation can be avoided.
     * - Time complexity: O(M*N)
     * - Space complexity: O(M*N) due to 2D array + recursion stack.
     */
    private static int approach2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoization(word1, word2, m, n, dp);
    }

    private static int memoization(String word1, String word2, int idx1, int idx2, int[][] dp) {
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (idx1 == 0) {
            return dp[idx1][idx2] = idx2;
        }
        if (idx2 == 0) {
            return dp[idx1][idx2] = idx1;
        }
        if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = memoization(word1, word2, idx1 - 1, idx2 - 1, dp);
        }
        int insert = memoization(word1, word2, idx1, idx2 - 1, dp);
        int delete = memoization(word1, word2, idx1 - 1, idx2, dp);
        int replace = memoization(word1, word2, idx1 - 1, idx2 - 1, dp);
        return dp[idx1][idx2] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    /**
     * Approach 3 - Tabulation
     * - This is better approach than recursion and memoization as it used iteration and bottom up approach.
     * - Here, we have reduced the recursion calls and recursion stack memory.
     * - We are first setting the first row and col by adding the index numbers, then filling the rest dp array.
     * - When chars in both strings at current index is same then do replacement and store answer.
     * - Else store min of insert, delete and replace operations + 1.
     * - At last, just return the last cell value.
     * - Time and space complexity is similar to approach 2, here recursion stack memory is reduced.
     */
    private static int approach3(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int r = 0; r <= m; r++) {
            dp[r][0] = r;
        }
        for (int c = 0; c <= n; c++) {
            dp[0][c] = c;
        }
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1]));
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Approach 4 - Space optimization
     * - This is similar to approach 3, only here we have optimized the space.
     * - We have reduced the space from 2D array to 1D array.
     */
    private static int approach4(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] prev = new int[n + 1];
        for (int c = 0; c <= n; c++) {
            prev[c] = c;
        }
        for (int r = 1; r <= m; r++) {
            int[] curr = new int[n + 1];
            curr[0] = r;
            for (int c = 1; c <= n; c++) {
                curr[c] = (word1.charAt(r - 1) == word2.charAt(c - 1)) ? prev[c - 1] : 1 + Math.min(prev[c - 1], Math.min(prev[c], curr[c - 1]));
            }
            prev = curr;
        }
        return prev[n];
    }

}