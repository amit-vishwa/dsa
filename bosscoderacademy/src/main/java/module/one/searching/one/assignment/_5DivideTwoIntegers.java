package module.one.searching.one.assignment;

/**
 * Divide Two Integers: [Leetcode 29. Divide Two Integers]
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be
 * truncated to 8, and -2.7335 would be truncated to -2.
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * <p>
 * Constraints:
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 */
public class _5DivideTwoIntegers {

    public static void main(String[] args) {
        printQuotient(10, 3);
        printQuotient(7, -3);
    }

    private static void printQuotient(int dividend, int divisor) {
        System.out.println("Quotient by approach 1: " + approach1(dividend, divisor));
        System.out.println("Quotient by approach 2: " + approach2(dividend, divisor));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - A simple bruteforce approach is to keep adding divisor and counting it until it becomes greater than dividend.
     * - At last return the count as quotient.
     * - Here, we have to handle edge cases like negative numbers and overflow issue.
     * - Time complexity: O(dividend / divisor) as we are keep adding divisor until it is greater than dividend.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int dividend, int divisor) {
        int quotient = 0, div = Math.abs(divisor);
        while (div <= Math.abs(dividend)) {
            quotient++;
            div += Math.abs(divisor);
        }
        return divisor >= 0 ? quotient : -quotient;
    }

    /**
     * Approach 2 - Optimal approach
     * - Here, we are handling the edge cases like both dividend and divisor are equal, or divisor is equal to 1 or -1.
     * - We are also storing sign in boolean variable based on signs of dividend and divisor.
     * - Then, we are performing operations on absolute value of dividend and divisor.
     * - We are storing the result in long type variable.
     * - We are performing operations till numerator is less than denominator.
     * - We are left shifting denominator by bits times till numerator is less than that.
     * - We are storing the result by shift 1 till bits count, and also numerator is getting updating by reducing the values.
     * - At last, we are checking for overflow and handling that as well before returning the result.
     * - Time complexity: O(log(Dividend)) for outer loop * O(log(Dividend)) for inner loop = O(log(Dividend)^2)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int dividend, int divisor) {
        // handle overflow cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // store sign in boolean flag
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        // perform operations on the absolute values
        long numerator = Math.abs(dividend);
        long denominator = Math.abs(divisor);
        long res = 0;
        // reduce the powers of divisor from dividend
        while (numerator >= denominator) {
            int bits = 0;
            // calculate the max power of 2 that is less or equal to numerator
            while (numerator >= denominator << (bits + 1)) {
                bits++;
            }
            // store power of 2 in cumulative result
            res += 1L << bits;
            // update numerator, reduce max multiple of denominator, eg 21 / 3 = 3 << 2 = 12 <= 21 i.e. 21-12 = 9
            numerator -= denominator << bits;
        }
        return (int) (isNegative ? -res : res);
    }

}