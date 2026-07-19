package module.two.dp.two.notes;

import java.util.Arrays;

/**
 * House Robber II:
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses are
 * broken into on the same night. Given an integer array nums representing the amount of money for each house, return the
 * maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example
 * Input: nums = [2,3,2]
 * Output: 3
 * <p>
 * Approaches: The approach is similar, only here we have to calculate twice, first from 0 to n - 2, then from 1 to n - 1.
 */
public class _3HouseRobberII {

    public static void main(String[] args) {
        printRobbedAmount(new int[]{2, 3, 2});
        printRobbedAmount(new int[]{1, 2, 3, 1});
        printRobbedAmount(new int[]{2, 1, 1, 5});
    }

    private static void printRobbedAmount(int[] houses) {
        System.out.println("Maximum robbed amount using recursion:          " + approach1(houses));
        System.out.println("Maximum robbed amount using memoization:        " + approach2(houses));
        System.out.println("Maximum robbed amount using tabulation:         " + approach3(houses));
        System.out.println("Maximum robbed amount using space optimization: " + approach4(houses));
        System.out.println();
    }

    private static int approach1(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }
        int robbedFromFirstHouse = recursion(houses, 0, n - 2);
        int robbedFromSecondHouse = recursion(houses, 1, n - 1);
        return Math.max(robbedFromFirstHouse, robbedFromSecondHouse);
    }

    private static int recursion(int[] houses, int start, int end) {
        if (start > end) {
            return 0;
        }
        int take = houses[start] + recursion(houses, start + 2, end);
        int notTake = recursion(houses, start + 1, end);
        return Math.max(take, notTake);
    }

    private static int approach2(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int startFromFirst = memoization(houses, dp, 0, n - 2);
        Arrays.fill(dp, -1);
        int startFromSecond = memoization(houses, dp, 1, n - 1);
        return Math.max(startFromFirst, startFromSecond);
    }

    private static int memoization(int[] houses, int[] dp, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        int take = houses[start] + memoization(houses, dp, start + 2, end);
        int notTake = memoization(houses, dp, start + 1, end);
        return dp[start] = Math.max(take, notTake);
    }

    private static int approach3(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n - 1; i++) {
            int take = houses[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(notTake, take);
        }
        int startFromFirst = dp[n - 2];
        dp[1] = houses[1];
        dp[2] = Math.max(houses[1], houses[2]);
        for (int i = 3; i < n; i++) {
            int take = houses[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(notTake, take);
        }
        int startFromSecond = dp[n - 1];
        return Math.max(startFromFirst, startFromSecond);
    }

    private static int approach4(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }
        int first = houses[0];
        int second = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n - 1; i++) {
            int robbed = Math.max(second, houses[i] + first);
            first = second;
            second = robbed;
        }
        int startFromFirst = second;
        first = houses[1];
        second = Math.max(houses[1], houses[2]);
        for (int i = 3; i < n; i++) {
            int robbed = Math.max(second, houses[i] + first);
            first = second;
            second = robbed;
        }
        int startFromSecond = second;
        return Math.max(startFromFirst, startFromSecond);
    }

}
