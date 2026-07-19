package module.two.dp.two.notes;

import java.util.Arrays;

/**
 * Climbing Stairs:
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example
 * Input: n = 2
 * Output: 2
 * <p>
 * Refer _3ClimbingStairs.java from package module.two.dp.one.assignment.
 */
public class _1ClimbingStairs {

    public static void main(String[] args) {
        printDistinctWaysToClimb(2);
        printDistinctWaysToClimb(3);
        printDistinctWaysToClimb(5);
        printDistinctWaysToClimb(8);
        printDistinctWaysToClimb(10);
    }

    private static void printDistinctWaysToClimb(int steps) {
        System.out.println("Number of ways to reach top using recursion:          " + approach1(steps));
        System.out.println("Number of ways to reach top using memoization:        " + approach2(steps));
        System.out.println("Number of ways to reach top using tabulation:         " + approach3(steps));
        System.out.println("Number of ways to reach top using space optimization: " + approach4(steps));
        System.out.println();
    }

    // TC: O(2^N), SC: O(N) Recursion stack
    private static int approach1(int steps) {
        return recursion(steps);
    }

    private static int recursion(int steps) {
        if (steps <= 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        return recursion(steps - 1) + recursion(steps - 2);
    }

    // TC: O(N), SC: O(N) + Recursion stack
    private static int approach2(int steps) {
        int[] dp = new int[steps + 1];
        Arrays.fill(dp, -1);
        return memoization(steps, dp);
    }

    private static int memoization(int steps, int[] dp) {
        if (steps <= 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        if (dp[steps] != -1) {
            return dp[steps];
        }
        int singleStep = memoization(steps - 1, dp);
        int doubleStep = memoization(steps - 2, dp);
        dp[steps] = singleStep + doubleStep;
        return dp[steps];
    }

    // TC: O(N), SC: O(N)
    private static int approach3(int steps) {
        int[] dp = new int[steps + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[steps];
    }

    // TC: O(N), SC: O(1)
    private static int approach4(int steps) {
        int first = 1, second = 2;
        for (int i = 3; i <= steps; i++) {
            int curStep = second + first;
            first = second;
            second = curStep;
        }
        return second;
    }

}
