package module.two.dp.one.assignment;

/**
 * Climbing Stairs:
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Input: n = 3
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= n <= 45
 */
public class _3ClimbingStairs {

    public static void main(String[] args) {
        printDistinctWaysToClimb(2);
        printDistinctWaysToClimb(3);
        printDistinctWaysToClimb(5);
        printDistinctWaysToClimb(8);
        printDistinctWaysToClimb(10);
    }

    private static void printDistinctWaysToClimb(int steps) {
        System.out.println("Distinct ways to climb using recursion: " + approach1(steps));
        System.out.println("Distinct ways to climb using memoization: " + approach2(steps));
        System.out.println("Distinct ways to climb using tabulation: " + approach3(steps));
        System.out.println("Distinct ways to climb using space optimization: " + approach4(steps));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is a simple bruteforce approach using recursion.
     * - We are adding the base cases first then return the answer for steps 1 and 2.
     * - Time complexity: O(2^N)
     * - Space complexity: O(N) due to recursion stack
     */
    private static int approach1(int steps) {
        return recursion(steps, 0);
    }

    private static int recursion(int steps, int curStep) {
        if (curStep > steps) {
            return 0;
        }
        if (curStep == steps) {
            return 1;
        }
        return recursion(steps, curStep + 1) + recursion(steps, curStep + 2);
    }

    /**
     * Approach 2 - Memoization
     * - This is better approach than the bruteforce one.
     * - We are using the top-down approach here.
     * - We have added an array to store the results at current step.
     * - Time complexity: O(N) as we won't visit steps more than twice.
     * - Space complexity: O(N) due to array + O(N) due to recursion stack
     */
    private static int approach2(int steps) {
        int[] dp = new int[steps + 1];
        for (int i = 0; i <= steps; i++) {
            dp[i] = -1;
        }
        return memoization(steps, 0, dp);
    }

    private static int memoization(int steps, int curStep, int[] dp) {
        if (curStep > steps) {
            return 0;
        }
        if (curStep == steps) {
            return 1;
        }
        if (dp[curStep] != -1) {
            return dp[curStep];
        }
        dp[curStep] = memoization(steps, curStep + 1, dp) + memoization(steps, curStep + 2, dp);
        return dp[curStep];
    }

    /**
     * Approach 3 - Tabulation
     * - This is better approach than memoization.
     * - We are using the bottom up approach here along with iteration.
     * - So, recursion stack memory usage is reduced.
     * - Time complexity: O(N)
     * - Space complexity: O(N) and no recursion stack memory is used
     */
    private static int approach3(int steps) {
        int[] dp = new int[steps + 1];
        dp[steps] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            dp[i] += dp[i + 1];
            if (i + 1 < steps) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the most optimal approach.
     * - We are using the similar approach like tabulation without any array.
     * - We are using 2 pointers to calculate the answer and store in current step.
     * - After that we are just updating the variables.
     * - Time complexity: O(N)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach4(int steps) {
        int next = 1;
        int nextOfNext = 0;
        for (int i = steps - 1; i >= 0; i--) {
            int curStep = next;
            if (i + 1 < steps) {
                curStep += nextOfNext;
            }
            nextOfNext = next;
            next = curStep;
        }
        return next;
    }

}