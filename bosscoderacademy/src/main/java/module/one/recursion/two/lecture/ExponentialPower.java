package module.one.recursion.two.lecture;

/**
 * Return the power: [Leetcode 50. Pow(x, n)]
 * <p>
 * Given a number num1 and num2, return the num1 raised to num2 value.
 * We have multiple approaches to solve this problem using recursion.
 */
public class ExponentialPower {

    public static void main(String[] args) {
        printPower(2, 4);
        printPower(6, 3);
    }

    private static void printPower(int a, int b) {
        System.out.println(a + " raised to " + b + " by approach 1: " + approach1(a, b));
        System.out.println(a + " raised to " + b + " by approach 2: " + approach2(a, b));
        System.out.println(a + " raised to " + b + " by approach 3: " + approach3(a, b));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - The approach is simple, just multiply the given number a till number b times.
     * - Time complexity: O(b) as we are reducing the b till it becomes 0.
     * - Space complexity: O(b) due to recursion stack.
     */
    private static int approach1(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * approach1(a, b - 1);
    }

    /**
     * Approach 2 - Different version of approach 1
     * - The approach is similar to approach 1.
     * - Here, we are calculating the results in halves.
     * - However, we are calculating the whole result, so time and space complexity will be same.
     */
    private static int approach2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if ((b & 1) == 0) {
            return approach2(a, b / 2) * approach2(a, b / 2);
        }
        return approach2(a, b / 2) * approach2(a, b / 2) * a;
    }

    /**
     * Approach 3 - Optimal approach
     * - The approach is most optimal one.
     * - Here, we are simply fetching the result of half of the power.
     * - We are keeping on reducing the power values until we get result as 1.
     * - Now, if b is odd then multiply the result twice and multiply again with a to get whole result.
     * - If b is even then simply multiply the result twice to get the whole result.
     * - Time complexity: O(log(b)) as we are keep on reducing b into halves.
     * - Space complexity: O(log(b)) due to recursion stack.
     */
    private static int approach3(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int res = approach2(a, b / 2);
        return (b & 1) == 1 ? res * res * a : res * res;
    }

}
