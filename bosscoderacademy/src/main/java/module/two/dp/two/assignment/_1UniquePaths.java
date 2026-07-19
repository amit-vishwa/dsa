package module.two.dp.two.assignment;

import java.util.Arrays;

/**
 * Unique Paths:
 * <p>
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot
 * tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any
 * point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
 * bottom-right corner.
 * <p>
 * Input 1:
 * m = 3, n = 2
 * Output 1:
 * 3
 * Explanation 1:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * Right -> Down -> Down
 * Down -> Down -> Right
 * Down -> Right -> Down
 * <p>
 * Input 2:
 * m = 3, n = 7
 * Output 2:
 * 28
 * <p>
 * Constraints:
 * 1 <= m, n <= 102
 */
public class _1UniquePaths {

    public static void main(String[] args) {
        printUniquePaths(3, 2);
        printUniquePaths(3, 7);
    }

    private static void printUniquePaths(int m, int n) {
        System.out.println("Number of unique paths using recursion:          " + approach1(m, n));
        System.out.println("Number of unique paths using memoization:        " + approach2(m, n));
        System.out.println("Number of unique paths using tabulation:         " + approach3(m, n));
        System.out.println("Number of unique paths using space optimization: " + approach4(m, n));
        System.out.println("Number of unique paths using maths:              " + approach5(m, n));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest bruteforce approach using recursion.
     * - We just have to iterate from last step to first step.
     * - If any of m or n reaches 0, then return 1 from there.
     * - Explore this for up and left paths and return their sum.
     * - Very slow due to repeated sub-problems.
     * - Time complexity: O(2^(M+N)) as we have to traverse till sum of row and col.
     * - Space complexity: O(M+N) due to recursion stack.
     */
    private static int approach1(int m, int n) {
        return recursion(m - 1, n - 1);
    }

    private static int recursion(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        return recursion(m - 1, n) + recursion(m, n - 1);
    }

    /**
     * Approach 2 - Memoization
     * - This is better than the approach 1, here we are eliminating the re-computation.
     * - This is the top-down approach.
     * - Time complexity: O(M*N) as we are traversing through row and col.
     * - Space complexity: O(M*N) due to 2D array + O(M+N) due to recursion stack.
     */
    private static int approach2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memoization(m - 1, n - 1, dp);
    }

    private static int memoization(int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        dp[m][n] = memoization(m - 1, n, dp) + memoization(m, n - 1, dp);
        return dp[m][n];
    }

    /**
     * Approach 3 - Tabulation
     * - This is better than the approach 2, it uses bottom up approach.
     * - The recursion stack is eliminated over there, as it uses iteration.
     * - Time complexity: O(M*N) due to traversal on 2D array.
     * - Space complexity: O(M*N) due to 2D array.
     */
    private static int approach3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Approach 4 - Space optimization
     * - This is an optimal solution for this problem.
     * - Here, the space have been optimized from 2D to 1D array.
     * - Time complexity: O(M*N)
     * - Space complexity: O(N) due to 1D array.
     */
    private static int approach4(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * Approach 5 - Maths (combinatorics)
     * - This is the most optimal solution for this problem.
     * - We multiply the next numerator term and divide the next denominator term at each step.
     * - First calculate total steps that can be visited, then calculate the R.
     * - Now, calculate the nCr combination formula gracefully without using factorial.
     * - At last, just return the result.
     * - Time complexity: O(min(M,N)) due to R loop
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach5(int m, int n) {
        int N = m + n - 2; // total steps to move
        int R = Math.min(m - 1, n - 1); // combination of min of right and bottom
        long result = 1;
        for (int i = 1; i <= R; i++) {
            // Below is derived formula for nCr i.e. C(N, R) = N! / (R! * (N - R)!)
            result = result * (N - R + i) / i;
        }
        return (int) result;
    }

}