package module.two.dp.two.lecture;

import java.util.Arrays;

/**
 * Refer: https://leetcode.com/problems/house-robber/description/
 */
public class _2HouseRobberI {

    public static void main(String[] args) {
        printMaxRobbedAmount(new int[]{1, 2, 3, 1});
        printMaxRobbedAmount(new int[]{2, 1, 3, 5});
    }

    private static void printMaxRobbedAmount(int[] houses) {
        System.out.println("Max robbed amount using recursion:          " + approach1(houses));
        System.out.println("Max robbed amount using memoization:        " + approach2(houses));
        System.out.println("Max robbed amount using tabulation:         " + approach3(houses));
        System.out.println("Max robbed amount using space optimization: " + approach4(houses));
        System.out.println();
    }

    // TC: O(2^N), SC: O(N) Recursion depth
    private static int approach1(int[] houses) {
        return recursion(houses, 0);
    }

    private static int recursion(int[] houses, int index) {
        if (index >= houses.length) {
            return 0;
        }
        int take = houses[index] + recursion(houses, index + 2);
        int notTake = recursion(houses, index + 1);
        return Math.max(take, notTake);
    }

    // TC: O(N), SC: O(N) + Recursion depth
    private static int approach2(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoization(houses, dp, n, 0);
    }

    private static int memoization(int[] houses, int[] dp, int length, int index) {
        if (index >= length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int take = houses[index] + memoization(houses, dp, length, index + 2);
        int notTake = memoization(houses, dp, length, index + 1);
        dp[index] = Math.max(take, notTake);
        return dp[index];
    }

    // TC: O(N), SC: O(N)
    private static int approach3(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n; i++) {
            int take = houses[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n - 1];
    }

    // TC: O(N), SC: O(1)
    private static int approach4(int[] houses) {
        int n = houses.length;
        int first = houses[0];
        int second = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n; i++) {
            int take = houses[i] + first;
            int notTake = second;
            int robbed = Math.max(take, notTake);
            first = second;
            second = robbed;
        }
        return second;
    }

}
