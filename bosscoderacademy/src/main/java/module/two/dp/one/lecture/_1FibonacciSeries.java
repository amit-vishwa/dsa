package module.two.dp.one.lecture;

// Find the Nth Fibonacci number
public class _1FibonacciSeries {

    public static void main(String[] args) {
        printNthFibonacciNumber(6);
        printNthFibonacciNumber(10);
        printNthFibonacciNumber(40); // after this recursion takes time
    }

    private static void printNthFibonacciNumber(int n) {
        System.out.println(n + "th Fibonacci Number using recursion:          " + approach1(n));
        System.out.println(n + "th Fibonacci Number using memoization:        " + approach2(n));
        System.out.println(n + "th Fibonacci Number using tabulation:         " + approach3(n));
        System.out.println(n + "th Fibonacci Number using space optimization: " + approach4(n));
        System.out.println();
    }

    /**
     * Approach 1 - Recursion
     * - This is a simple approach using recursion.
     * - It does not involve the actual dynamic programming logic.
     * - We just have to return when base case is reached, else go on exploring further.
     * - Time complexity: O(2^N) as each node creates 2 nodes in recursion tree
     * - Space complexity: O(N) due to recursion tree.
     */
    private static int approach1(int n) {
        if (n <= 1) {
            return n;
        }
        return approach1(n - 1) + approach1(n - 2);
    }

    /**
     * Approach 2 - Memoization
     * - This is a better approach than the recursion.
     * - Here, we are storing the result of recursive function call in an array.
     * - So, that when we are re-exploring the same number, we can just get the answer from array if exits.
     * - Time complexity: O(N) as we won't explore same numbers again and again
     * - Space complexity: O(N + 1) due to extra array and O(N) due to recursion tree = O(N)
     */
    private static int approach2(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return helper(n, memo);
    }

    private static int helper(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int sum = helper(n - 1, memo) + helper(n - 2, memo);
        memo[n] = sum;
        return memo[n];
    }

    /**
     * Approach 3 - Tabulation
     * - This is better than memoization and the actual dynamic programming start here.
     * - We are using iteration to save recursion stack memory.
     * - Iteration is much faster than recursion.
     * - Time and space complexity is similar to memoization, only recursion stack space is reduced.
     */
    private static int approach3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Approach 4 - Space optimization
     * - This is the most optimal solution in dynamic programming.
     * - Here, we don't use any extra array while using iteration.
     * - We are just using few variables to store the answer and at last just returning the answer.
     * - Time complexity: O(N) it will remain same as we have to explore answers till N.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach4(int n) {
        int a = 0, b = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = b + a;
            a = b;
            b = fib;
        }
        return fib;
    }

}
