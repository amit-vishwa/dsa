package module.two.dp.one.notes;

/**
 * Dynamic Programming:
 * <p>
 * Dynamic Programming can be described as storing answers to various sub-problems to be used later whenever required to solve
 * the main problem.
 * <p>
 * The two common dynamic programming approaches are:
 * 1. Memoization: Known as the “top-down” dynamic programming, usually the problem is solved in the direction of the main
 * problem to the base cases.
 * 2. Tabulation: Known as the “bottom-up ” dynamic programming, usually the problem is solved in the direction of solving the
 * base cases to the main problem.
 * <p>
 * Note: The base case does not always mean a smaller input. It depends upon the implementation of the algorithm.
 * <p>
 * <p>
 * Recursion vs. Iteration:
 * Concerning iteration, recursion has the following advantages and disadvantages:
 * - Simplicity: often a recursive algorithm is simple and elegant compared to an iterative algorithm
 * - Space-inefficiency: every recursive call adds a layer to the system’s call stack. If the number of stacked recursive calls
 * gets too large, the result is a stack overflow.
 * <p>
 * Fibonacci Series:
 * <p>
 * The following series is called the Fibonacci series:0,1,1,2,3,5,8,13,21,…We need to find the nth Fibonacci number, where n
 * is based on a 0-based index.Every ith number of the series is equal to the sum of (i-1)th and (i-2)th numbers where the
 * first and second number is given as 0 and 1 respectively.
 * <p>
 * Refer _1FibonacciSeries.java from package module.two.dp.one.lecture.
 */
public class _1FibonacciSeries {

    public static void main(String[] args) {
        printNthFibonacciNumber(8);
        printNthFibonacciNumber(6);
        printNthFibonacciNumber(11);
        printNthFibonacciNumber(10);
        printNthFibonacciNumber(40);
    }

    private static void printNthFibonacciNumber(int n) {
        System.out.println(n + "th fibonacci number using memoization:        " + approach1(n));
        System.out.println(n + "th fibonacci number using tabulation:         " + approach2(n));
        System.out.println(n + "th fibonacci number using space optimization: " + approach3(n));
        System.out.println();
    }

    /**
     * Memoisation:
     * <p>
     * As every number is equal to the sum of the previous two terms, the recurrence relation can be written as:
     * f(n) = f(n-1) + f(n-2)
     * If there are two recursive calls inside a function, the program will run the first call, finish its execution, and then
     * run the second call. Due to this reason, every call in the recursive tree will be executed. This gives the recursive code
     * its exponential time complexity. We can improve this.We want to compute f(2) as the second call from f(4), but in the
     * recursive tree, we had already computed f(2) once (in the first recursive call of f(3) ) Similar is the case with f(3),
     * therefore if we somehow store these values, the first time we calculated it then we can simply find its value in constant
     * time whenever we need it. This technique is called Memoization. Here the cases marked in yellow are called overlapping
     * sub-problems and we need to solve them only once during the code execution.Steps to memoize a recursive
     * <p>
     * Solution:
     * 1. Create a dp[n+1] array initialized to -1.
     * 2. Whenever we want to find the answer to a particular value (say n), we first check whether the answer is already
     * calculated using the dp array(i.e. dp[n]!= -1 ). If yes, simply return the value from the dp array.
     * 3. If not, then we are finding the answer for the given value for the first time, we will use the recursive relation as
     * usual but before returning from the function, we will set dp[n] to the solution we get.
     * Time Complexity: O(N)
     * Space Complexity: O(N) + recursive stack space
     */
    private static int approach1(int n) {
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
        if (memo[n] == -1) {
            memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * Tabulation:
     * <p>
     * Tabulation is a ‘bottom-up’ approach where we start from the base case and reach the final answer that we want.
     * Steps to convert Recursive Solution to Tabulation one.
     * - Declare a dp[] array of size n+1.
     * - First initialize the base condition values, i.e. i=0 and i=1 of the dp array as 0 and 1 respectively.
     * - Set an iterative loop that traverses the array( from index 2 to n) and for every index set its value as
     * dp[i-1] + dp[i-2].
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    private static int approach2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * Space Optimization:
     * <p>
     * - Each iteration’s cur_i and prev become the next iteration’s prev and prev2 respectively.
     * - Therefore after calculating cur_i, if we update prev and prev2 according to the next step, we will always get the answer.
     * - After the iterative loop has ended we can simply return prev as our answer.
     * <p>
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static int approach3(int n) {
        int a = 0, b = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = b + a;
            a = b;
            b = fib;
        }
        return fib;
    }

}
