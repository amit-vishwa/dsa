package module.two.dp.two.assignment;

import java.util.List;
import java.util.Arrays;

/**
 * Unique Paths II:
 * <p>
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right
 * at any point in time. An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot
 * include any square that is an obstacle. Return the number of possible unique paths that the robot can take to reach the
 * bottom-right corner.
 * <p>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above. There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * <p>
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * <p>
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class _2UniquePathsII {

    public static void main(String[] args) {
        printUniquePaths(List.of(List.of(0, 0, 0), List.of(0, 1, 0), List.of(0, 0, 0)));
        printUniquePaths(List.of(List.of(0, 1), List.of(0, 0)));
    }

    private static void printUniquePaths(List<List<Integer>> grid) {
        if (grid == null || grid.isEmpty() || grid.get(0).isEmpty()) {
            return;
        }
        System.out.println("Number of unique paths using recursion:          " + approach1(grid));
        System.out.println("Number of unique paths using memoization:        " + approach2(grid));
        System.out.println("Number of unique paths using tabulation:         " + approach3(grid));
        System.out.println("Number of unique paths using space optimization: " + approach4(grid));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest bruteforce approach using recursion.
     * - We are following the same approach as of unique paths.
     * - The difference here is in base cases, if m or n is less than 0, or we encounter obstacle then return 0 by excluding
     * that path.
     * - If we reach at first cell, as we are traversing from last, then return 1 to store the path count in result.
     * - Time complexity: O(2^(M+N))
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static int approach1(List<List<Integer>> grid) {
        if (grid.get(0).get(0) == 1) {
            return 0;
        }
        int m = grid.size(), n = grid.get(0).size();
        return recursion(grid, m - 1, n - 1);
    }

    private static int recursion(List<List<Integer>> grid, int m, int n) {
        if (m < 0 || n < 0 || grid.get(m).get(n) == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        return recursion(grid, m - 1, n) + recursion(grid, m, n - 1);
    }

    /**
     * Approach 2 - Memoization
     * - This is similar to approach 1, but here we have optimized the time complexity.
     * - We are using the top-down approach here.
     * - We are storing the obstacle path answer in dp array along with all answers to avoid re-computation.
     * - Time complexity: O(M*N)
     * - Space complexity: O(M+N) for dp array, O(M+N) due to recursion stack.
     */
    private static int approach2(List<List<Integer>> grid) {
        if (grid.get(0).get(0) == 1) {
            return 0;
        }
        int m = grid.size(), n = grid.get(0).size();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoization(grid, m - 1, n - 1, dp);
    }

    private static int memoization(List<List<Integer>> grid, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (grid.get(m).get(n) == 1) {
            return dp[m][n] = 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        dp[m][n] = memoization(grid, m - 1, n, dp) + memoization(grid, m, n - 1, dp);
        return dp[m][n];
    }

    /**
     * Approach 3 - Tabulation
     * - This is better approach and the actual dynamic programming we can say.
     * - We are using the bottom up approach here.
     * - The logic is quite simple, just do the initial check and create a 2D dp array.
     * - Populate the first cell value as 1, as if we reach at first cell then path count should be considered.
     * - Now, populate the first row and first col, only if no obstacle are there.
     * - After that fill all the remaining cells, if obstacle is not there.
     * - At last, just return the last cell value here.
     * - Time complexity: O(M*N) due to 2D array traversal.
     * - Space complexity: O(M*N) due to 2D array.
     */
    private static int approach3(List<List<Integer>> grid) {
        if (grid.get(0).get(0) == 1) {
            return 0;
        }
        int m = grid.size(), n = grid.get(0).size();
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int r = 1; r < m; r++) {
            if (grid.get(r).get(0) == 0) {
                dp[r][0] = dp[r - 1][0];
            }
        }
        for (int c = 1; c < n; c++) {
            if (grid.get(0).get(c) == 0) {
                dp[0][c] = dp[0][c - 1];
            }
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (grid.get(r).get(c) == 0) {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the most optimal solution.
     * - We are reducing the 2D array to 1D array.
     * - When populating the dp array, we are setting the value to 0 if obstacle encountered, else previous cells value.
     * - Now, we are traversing the grid and setting the first col value as 0 if obstacle encountered.
     * - We are also traversing the columns and setting the current dp cell value.
     * - Time complexity: O(M*N)
     * - Space complexity: O(N)
     */
    private static int approach4(List<List<Integer>> grid) {
        if (grid.get(0).get(0) == 1) {
            return 0;
        }
        int m = grid.size(), n = grid.get(0).size();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int c = 1; c < n; c++) {
            dp[c] = grid.get(0).get(c) == 1 ? 0 : dp[c - 1];
        }
        for (int r = 1; r < m; r++) {
            if (grid.get(r).get(0) == 1) {
                dp[0] = 0;
            }
            for (int c = 1; c < n; c++) {
                dp[c] = grid.get(r).get(c) == 1 ? 0 : dp[c] + dp[c - 1];
            }
        }
        return dp[n - 1];
    }

}