package module.two.dp.one.assignment;

/**
 * Number Of Ways To Pair People:
 * <p>
 * Given that there are p people in a party. Each person can either join dance as a single individual or as a pair with any
 * other. The task is to find the number of different ways in which p people can join the dance.
 * <p>
 * Input : p = 3
 * Output : 4
 * Explanation: Let the three people be P1, P2 and P3
 * Different ways are: {P1, P2, P3}, {{P1, P2}, P3}, {{P1, P3}, P2} and {{P2, P3}, P1}.
 * <p>
 * Input : p = 2
 * Output : 2
 */
public class _4PairPeople {

    public static void main(String[] args) {
        printNumberOfWaysToPairPeople(3);
        printNumberOfWaysToPairPeople(2);
    }

    private static void printNumberOfWaysToPairPeople(int p) {
        System.out.println("Number of ways to pair people using recursion: " + approach1(p));
        System.out.println("Number of ways to pair people using memoization: " + approach2(p));
        System.out.println("Number of ways to pair people using tabulation: " + approach3(p));
        System.out.println("Number of ways to pair people using space optimization: " + approach4(p));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is the simple approach.
     * - Just add the base case and recurrence relation statement in recursive function.
     * - Time complexity: O(2^N) due to recursion tree.
     * - Space complexity: O(N) due to recursion depth.
     */
    private static int approach1(int p) {
        return recursion(p);
    }

    private static int recursion(int p) {
        if (p <= 2) {
            return p;
        }
        // stay single (p - 1) or get paired (p - 2)
        return recursion(p - 1) + (p - 1) * recursion(p - 2);
    }

    /**
     * Approach 2 - Memoization
     * - This is better approach than recursion.
     * - We are using an array here to store the answer if it is already present for current recursion.
     * - Time complexity: O(N) as we are visiting recursive functions once.
     * - Space complexity: O(N) due to array + O(N) due to recursion depth.
     */
    private static int approach2(int p) {
        int[] dp = new int[p + 1];
        for (int i = 0; i <= p; i++) {
            dp[i] = -1;
        }
        return memoization(p, dp);
    }

    private static int memoization(int p, int[] dp) {
        if (p <= 2) {
            return p;
        }
        if (dp[p] != -1) {
            return dp[p];
        }
        dp[p] = memoization(p - 1, dp) + (p - 1) * memoization(p - 2, dp);
        return dp[p];
    }

    /**
     * Approach 3 - Tabulation
     * - This is better than the memoization approach.
     * - Here, we are using array to store answer with iteration.
     * - For base cases, answer already added in dp array.
     * - Then start iterating with remaining people and use recurrence relation to store to answer in array.
     * - At last just return the answer from pth index of array.
     * - Time and space complexity is similar to memoization, only recursion stack is removed.
     */
    private static int approach3(int p) {
        if (p <= 1) {
            return 1;
        }
        int[] dp = new int[p + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= p; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[p];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the best approach than others.
     * - Here, we have reduced the answer array memory, it is constant now.
     * - Rest all logic is quite similar to tabulation only using iteration.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int approach4(int p) {
        if (p <= 1) {
            return 1;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= p; i++) {
            int cur = b + (i - 1) * a;
            a = b;
            b = cur;
        }
        return b;
    }

}