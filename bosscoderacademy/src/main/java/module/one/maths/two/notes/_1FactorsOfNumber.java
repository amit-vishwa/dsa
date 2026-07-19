package module.one.maths.two.notes;

/**
 * Find all factors of a prime number:
 * Given a natural number n, print all distinct divisors of it.
 * <p>
 * Example:
 * Input: n=10
 * Output: 1 2 5 10
 */
public class _1FactorsOfNumber {

    public static void main(String[] args) {
        printNumberFactors(10);
        printNumberFactors(100);
        printNumberFactors(101);
    }

    private static void printNumberFactors(int n) {
        approach1(n);
        approach2(n);
    }

    /**
     * Approach 1: Bruteforce approach
     * - Here, we just have to iterate from 1 to given number N.
     * - While iterating we have to check whether N is divisible by the current natural number.
     * - Print that number if divisible, else proceed further without printing.
     * - Time complexity: O(N), Space complexity: O(1)
     */
    private static void approach1(int n) {
        System.out.print("All factors of " + n + " using approach 1: [1, ");
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println(n + "]");
    }

    /**
     * Approach 2: Optimal approach
     * - Here, we just have to iterate from 1 to square root of given number N.
     * - While iterating we have to check whether N is divisible by the current natural number.
     * - Print that number if divisible, also print the factor i.e. N / i when i != N / i to avoid duplicate print.
     * - Skip printing if number is not divisible by current natural number.
     * - Time complexity: O(sqrt(N)), as we are iterating till square root of N only.
     * - Space complexity: O(1), as no extra space is used.
     */
    private static void approach2(int n) {
        System.out.print("All factors of " + n + " using approach 2: [1, ");
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + ", ");
                if (i != n / i) {
                    System.out.print((n / i) + ", ");
                }
            }
        }
        System.out.println(n + "]");
    }

}