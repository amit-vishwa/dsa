package module.two.dp.two.lecture;

import java.util.Arrays;

// Refer _3ClimbingStairs.java from package module.two.dp.one.assignment.
public class _1ClimbingStairs {

    public static void main(String[] args) {
        printDistinctWaysToClimb(2);
        printDistinctWaysToClimb(3);
        printDistinctWaysToClimb(5);
    }

    private static void printDistinctWaysToClimb(int steps) {
        System.out.println("Distinct ways to climb using recursion: " + approach1(steps));
        System.out.println("Distinct ways to climb using memoization: " + approach2(steps));
        System.out.println("Distinct ways to climb using tabulation: " + approach3(steps));
        System.out.println("Distinct ways to climb using space optimization: " + approach4(steps));
        System.out.println();
    }

    private static int approach1(int steps) {
        return recursion(steps);
    }

    private static int recursion(int steps) {
        if (steps <= 2) {
            return steps;
        }
        return recursion(steps - 1) + recursion(steps - 2);
    }

    private static int approach2(int steps) {
        int[] dp = new int[steps + 1];
        Arrays.fill(dp, -1);
        return memoization(steps, dp);
    }

    private static int memoization(int steps, int[] dp) {
        if (steps <= 2) {
            return steps;
        }
        if (dp[steps] != -1) {
            return dp[steps];
        }
        return dp[steps] = memoization(steps - 1, dp) + memoization(steps - 2, dp);
    }

    private static int approach3(int steps) {
        int[] dp = new int[steps + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= steps; i++) {
            dp[i] += dp[i - 1] + dp[i - 2];
        }
        return dp[steps];
    }

    private static int approach4(int steps) {
        int first = 1, second = 2;
        for (int i = 3; i <= steps; i++) {
            int cur = second + first;
            first = second;
            second = cur;
        }
        return second;
    }

}
