package module.one.maths.one.assignment;

/**
 * Subtract Sum And Product Of Digit: [Leetcode 1281. Subtract the Product and Sum of Digits of an Integer]
 * <p>
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * Input 1: n = 234
 * Output 1: 15
 * Explanation 1: Product of digits = 2 * 3 * 4 = 24.
 * Sum of digits = 2 + 3 + 4 = 9 .
 * Result = 24 - 9 = 15
 * <p>
 * Input 2: n = 4421
 * Output 2: 21
 * <p>
 * Constraints:
 * 1 <= n <= 105
 * <p>
 * Approach:
 * - The approach is simple here, we just have to iterate over digit of given number and calculate digit's sum and product.
 * - And at last we have to return the difference between digit product and digit sum.
 * - Time complexity: O(M), M is the digit count of given number
 * - Space complexity: O(1), as we are not using any extra space.
 */
public class _6DigitProdSumDiff {

    public static void main(String[] args) {
        System.out.println("Digit product and sum difference: " + getDifference(234));
        System.out.println("Digit product and sum difference: " + getDifference(4421));
    }

    private static int getDifference(int num) {
        int sum = 0, prod = 1;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            prod *= rem;
            num /= 10;
        }
        return prod - sum;
    }

}