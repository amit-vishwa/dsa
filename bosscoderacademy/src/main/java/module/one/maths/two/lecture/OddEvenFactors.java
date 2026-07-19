package module.one.maths.two.lecture;

/**
 * Find whether N have odd or even number of factors.
 * Approaches have complexities O(sqrt(N)) and O(log(N)), this can be huge difference in terms of performance.
 * So always use optimal approach.
 */
public class OddEvenFactors {

    public static void main(String[] args) {
        printOddOrEven(36);
        printOddOrEven(39);
    }

    private static void printOddOrEven(int n) {
        System.out.println("Factors of " + n + " by approach 1 is " + approach1(n));
        System.out.println("Factors of " + n + " by approach 2 is " + approach2(n));
        System.out.println();
    }

    /**
     * Bruteforce approach:
     * - Simple bruteforce approach is to count factors from 1 till sqrt of N.
     * - Check if it is odd or even and display accordingly.
     * - Time complexity: O(sqrt(N)), Space complexity: O(1)
     */
    private static String approach1(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count = (i != n / i) ? count + 2 : count + 1;
            }
        }
        return ((count & 1) == 1) ? "ODD" : "EVEN";
    }

    /**
     * Optimal approach:
     * - Find the square root of N, fetch int value.
     * - Multiple result by itself and check if it is equal to N.
     * - A perfect number will always have odd number of factors.
     * - So, if it is equal then factors are odd else even.
     * - Time complexity: O(log(N)) for in-built function, Space complexity: O(1)
     */
    private static String approach2(int n) {
        int root = (int) Math.sqrt(n);
        return (root * root == n) ? "ODD" : "EVEN";
    }

}
