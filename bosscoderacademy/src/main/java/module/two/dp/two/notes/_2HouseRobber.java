package module.two.dp.two.notes;

import java.util.Arrays;

/**
 * House Robber:
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the
 * only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will
 * automatically contact the police if two adjacent houses are broken into on the same night.
 * Given an integer array nums representing the amount of money in each house, return the maximum amount of money you can rob
 * tonight without alerting the police.
 * <p>
 * Example
 * Input: nums = [1,2,3,1]
 * Output: 4
 * <p>
 * Refer _2HouseRobberI.java from package module.two.dp.two.lecture.
 */
public class _2HouseRobber {

    public static void main(String[] args) {
        printMaxRobbedAmount(new int[]{1, 2, 3, 1});
        printMaxRobbedAmount(new int[]{2, 1, 1, 5, 2});
    }

    private static void printMaxRobbedAmount(int[] houses) {
        System.out.println("Maximum robbed amount using recursion:          " + approach1(houses));
        System.out.println("Maximum robbed amount using memoization:        " + approach2(houses));
        System.out.println("Maximum robbed amount using tabulation:         " + approach3(houses));
        System.out.println("Maximum robbed amount using space optimization: " + approach4(houses));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simplest approach.
     * - Just start with the index 0, add the base case if index >= house array length then return 0.
     * - Now in take condition, just add current house value and proceed exploring next of next.
     * - In the not take condition, just proceed exploring next house instead of adding or robbing any house value.
     * - At last, just return the max of take and not take value.
     * - Time complexity: O(2^N) as we are exploring 2 cases here.
     * - Space complexity: O(N) due to recursion depth.
     */
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

    /**
     * Approach 2 - Memoization
     * - This is similar to recursion, only array is added to store results and reduce time complexity.
     * - Time complexity: O(N)
     * - Space complexity: O(N) due to array + O(N) due to recursion stack.
     */
    private static int approach2(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoization(houses, dp, 0, n);
    }

    private static int memoization(int[] houses, int[] dp, int index, int length) {
        if (index >= length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int take = houses[index] + memoization(houses, dp, index + 2, length);
        int notTake = memoization(houses, dp, index + 1, length);
        return dp[index] = Math.max(take, notTake);
    }

    /**
     * Approach 3 - Tabulation
     * - This is better approach which uses the bottom up approach.
     * - We are creating a dp array and setting the first 2 values.
     * - Then starting with the house 3 by checking the take and not take condition.
     * - We are storing the max of both in current index of dp array.
     * - At last, we are just returning the last index of dp array.
     * - Time and space complexity is similar to approach 2, only recursion stack memory is saved here.
     */
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
        for (int i = 2; i < n; i++) {
            int take = houses[i] + dp[i - 2];
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n - 1];
    }

    /**
     * Approach 4 - Space optimization
     * - The approach is the most optimal one.
     * - Here we are setting the values for 2 variables.
     * - Then we are starting from house 3 and calculating the take and not take condition.
     * - After that, we are adding the result in a variable and updating all the variables to proceed with next iteration.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int approach4(int[] houses) {
        int n = houses.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return houses[0];
        }
        int first = houses[0], second = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n; i++) {
            int robbedTillNow = Math.max(houses[i] + first, second);
            first = second;
            second = robbedTillNow;
        }
        return second;
    }

}
