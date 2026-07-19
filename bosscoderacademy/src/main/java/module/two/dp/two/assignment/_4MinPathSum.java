package module.two.dp.two.assignment;

import java.util.List;
import java.util.Arrays;

/**
 * Minimum Path Sum:
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of
 * all numbers along its path.
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * <p>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class _4MinPathSum {

    public static void main(String[] args) {
        printMinPathSum(List.of(List.of(1, 3, 1), List.of(1, 5, 1), List.of(4, 2, 1)));
        printMinPathSum(List.of(List.of(1, 2, 3), List.of(4, 5, 6)));
    }

    private static void printMinPathSum(List<List<Integer>> grid) {
        if (grid == null || grid.isEmpty() || grid.get(0).isEmpty()) {
            return;
        }
        System.out.println("Minimum path sum using recursion:          " + approach1(grid));
        System.out.println("Minimum path sum using memoization:        " + approach2(grid));
        System.out.println("Minimum path sum using tabulation:         " + approach3(grid));
        System.out.println("Minimum path sum using space optimization: " + approach4(grid));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest bruteforce approach where we are using recursion.
     * - We are traversing from last cell to first cell of the grid.
     * - If row or col index becomes less than 0, then we are returning +INF.
     * - If we successfully reached the first cell, then we are returning that cell value.
     * - Now we are calculating the sum of path going upward and left side.
     * - We are taking the min of both, if both are +INF, then we are returning the same else we are adding current cell
     * value to the answer and returning.
     * - Time complexity: O(2^(M+N)) as it is a simple recursion, we are exploring 2 ways till row and col times.
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static int approach1(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        return recursion(grid, m - 1, n - 1);
    }

    private static int recursion(List<List<Integer>> grid, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        int gridValue = grid.get(m).get(n);
        if (m == 0 && n == 0) {
            return gridValue;
        }
        int up = recursion(grid, m - 1, n);
        int left = recursion(grid, m, n - 1);
        int minPrev = Math.min(up, left);
        return minPrev == Integer.MAX_VALUE ? minPrev : minPrev + gridValue;
    }

    /**
     * Approach 2 - Memoization
     * - This is better than recursion, we are using top-down approach and 2D array to store answers and avoid re-computation.
     * - We have reduced the time complexity from exponential to quadratic.
     * - We are storing the final answers as well as the valid base case in dp array, whose default value is +INF.
     * - Time complexity: O(M*N) due to row col exploration.
     * - Space complexity: O(M*N) due to 2D array + O(M+N) due to recursion stack.
     */
    private static int approach2(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return memoization(grid, m - 1, n - 1, dp);
    }

    private static int memoization(List<List<Integer>> grid, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[m][n] != Integer.MAX_VALUE) {
            return dp[m][n];
        }
        int gridValue = grid.get(m).get(n);
        if (m == 0 && n == 0) {
            return dp[m][n] = gridValue;
        }
        int up = memoization(grid, m - 1, n, dp);
        int left = memoization(grid, m, n - 1, dp);
        int minPrev = Math.min(up, left);
        dp[m][n] = (minPrev == Integer.MAX_VALUE) ? minPrev : minPrev + gridValue;
        return dp[m][n];
    }

    /**
     * Approach 3 - Tabulation
     * - This is the better approach than above all.
     * - We are using the bottom-up approach here and removing the stack memory using iteration.
     * - We have created a 2D array and storing the first cell value in first cell of this array.
     * - Then we are filling the first row and first col using prefix sum.
     * - After that, we are filling the rest dp array with min of prev row and col + current cell value.
     * - At last, we are just returning the last cell value.
     * - Time and space complexity is similar to approach 2, only recursion stack memory is removed here.
     */
    private static int approach3(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        // min path sum till ith row and jth col
        int[][] dp = new int[m][n];
        dp[0][0] = grid.get(0).get(0);
        for (int r = 1; r < m; r++) {
            dp[r][0] = dp[r - 1][0] + grid.get(r).get(0);
        }
        for (int c = 1; c < n; c++) {
            dp[0][c] = dp[0][c - 1] + grid.get(0).get(c);
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid.get(r).get(c);
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the optimal approach than all of the above.
     * - Here, we have reduced the 2D array to 2 different rows.
     * - After that, all the logic are similar to approach 3.
     * - Time complexity: O(M*N)
     * - Space complexity: O(2*N) = O(N)
     */
    private static int approach4(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        // min path sum till jth col
        int[] curr;
        int[] prev = new int[n];
        prev[0] = grid.get(0).get(0);
        for (int c = 1; c < n; c++) {
            prev[c] = prev[c - 1] + grid.get(0).get(c);
        }
        for (int r = 1; r < m; r++) {
            curr = new int[n];
            curr[0] = prev[0] + grid.get(r).get(0);
            for (int c = 1; c < n; c++) {
                curr[c] = Math.min(curr[c - 1], prev[c]) + grid.get(r).get(c);
            }
            prev = curr;
        }
        return prev[n - 1];
    }

}