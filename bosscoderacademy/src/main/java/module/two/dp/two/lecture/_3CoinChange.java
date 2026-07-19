package module.two.dp.two.lecture;

import java.util.Arrays;

/**
 * Coin Change:
 * <p>
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a
 * total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * Refer: https://leetcode.com/problems/coin-change/description/
 */
public class _3CoinChange {

    public static void main(String[] args) {
        printMinNumOfCoins(new int[]{1, 2, 5}, 11);
        printMinNumOfCoins(new int[]{2}, 3);
        printMinNumOfCoins(new int[]{1}, 0);
    }

    private static void printMinNumOfCoins(int[] coins, int amount) {
        System.out.println("Number of coins using recursion: " + approach1(coins, amount));
        System.out.println("Number of coins using memoization: " + approach2(coins, amount));
        System.out.println("Number of coins using tabulation: " + approach3(coins, amount));
        System.out.println("Number of coins using space optimization: " + approach4(coins, amount));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest bruteforce approach.
     * - We are starting from index 0 and adding 2 base cases, when amount is 0 then return 0 and when index exhausts then
     * return the +INF.
     * - Now, consider the take value as +INF, check if coin at current index <= amount, if yes then calculate for updated amount.
     * - Update the take value.
     * - Now update the not take value and return min of both.
     * - Time complexity: O(2^N) as we are exploring 2 ways.
     * - Space complexity: O(N) due to recursion depth.
     */
    private static int approach1(int[] coins, int amount) {
        int ans = recursion(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int recursion(int[] coins, int amount, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index >= coins.length) {
            return Integer.MAX_VALUE;
        }
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int ans = recursion(coins, amount - coins[index], index);
            if (ans != Integer.MAX_VALUE) {
                take = 1 + ans;
            }
        }
        int notTake = recursion(coins, amount, index + 1);
        return Math.min(take, notTake);
    }

    /**
     * Approach 2 - Memoization
     * - This is similar to approach 1, only new 2D array is used to reduce the time complexity.
     * - Time complexity: O(M*N) as we are exploring answers max twice.
     * - Space complexity: O(M*N) where M is coins array length + 1, and N is amount + 1, and recursion depth O(N)
     */
    private static int approach2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = memoization(coins, amount, dp, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int memoization(int[] coins, int amount, int[][] dp, int index) {
        if (amount == 0) {
            return 0;
        }
        if (index >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int ans = memoization(coins, amount - coins[index], dp, index);
            if (ans != Integer.MAX_VALUE) {
                take = 1 + ans;
            }
        }
        int notTake = memoization(coins, amount, dp, index + 1);
        return dp[index][amount] = Math.min(take, notTake);
    }

    /**
     * Approach 3 - Tabulation
     * - This is the better approach that save recursion stack memory.
     * - Create a 2D array and fill first row with +INF and col with 0.
     * - Then iterate over row and col and proceed with take and not take logic.
     * - Not take will have only coins index updated, no change in amount.
     * - Let's consider take as +INF value, then check if coin is less than or equal to amount, then update take value by
     * reducing amount to same coin and adding 1 to final answer.
     * - Now, update current indices dp value to min of take and not take.
     * - At last, just return the last cell at last row and last col.
     * - Time complexity: O(M*N) due to iterating over 2D array.
     * - Space complexity: O(M*N) due to 2D array.
     */
    private static int approach3(int[] coins, int amount) {
        int m = coins.length + 1, n = amount + 1;
        int[][] dp = new int[m][n];
        for (int c = 0; c < n; c++) {
            dp[0][c] = Integer.MAX_VALUE - 1;
        }
        for (int r = 0; r < m; r++) {
            dp[r][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE - 1;
                if (coins[i - 1] <= j) {
                    take = 1 + dp[i][j - coins[i - 1]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dp[m - 1][n - 1];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the optimal approach than all of the above.
     * - Here, we are creating a 1D array only for amount.
     * - Fill all values with +INF, only the first element of array should be 0 for base case.
     * - Now, iterate over coins array, and at the same time iterate over dp array.
     * - Check if dp[i - coin] != +INF, if yes then just update current dp value to min of dp val and 1 + dp[amount - coin]
     * - At last, just return the last index of dp array.
     * - Time complexity: O(M*N)
     * - Space complexity: O(N) due to dp array of length amount + 1.
     */
    private static int approach4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
