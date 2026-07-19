package module.one.maths.one.notes;

/**
 * Find Greatest Common Divisor of Array:
 * <p>
 * Given an integer array nums, return the greatest common divisor of the smallest number and the largest number in nums.
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,9,10]
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * The smallest number in nums is 2.
 * The largest number in nums is 10.
 * The greatest common divisor of 2 and 10 is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [3,3]
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The smallest number in nums is 3.
 * The largest number in nums is 3.
 * The greatest common divisor of 3 and 3 is 3.
 * <p>
 * The GCD of three or more numbers equals the product of the prime factors common to all the numbers, but it can
 * also be calculated by repeatedly taking the GCDs of pairs of numbers.
 * gcd(a, b, c) = gcd(a, gcd(b, c)) = gcd(gcd(a, b), c) = gcd(gcd(a, c), b)
 */
public class _4GcdOfArray {

    public static void main(String[] args) {
        System.out.println("Array gcd: " + arrayGcd(new int[]{2, 5, 6, 9, 10}));
        System.out.println("Array gcd: " + arrayGcd(new int[]{3, 3}));
    }

    /**
     * Approach:
     * - A simple approach is to find gcd of all array elements one by one.
     * - First find gcd of first two elements, store result and use it when finding next element gcd.
     * - Repeat the process until whole array is traversed, or we found gcd as 1 in between.
     * - Then return the result at last.
     * - Time complexity: O(N * log(M)), M is second-highest number.
     * - Space complexity: O(1), as not auxiliary space is used here.
     */
    private static int arrayGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(arr[i], result);
            // avoid unnecessary calls if gcd is 1, as it will remain 1
            if (result == 1) {
                return result;
            }
        }
        return result;
    }

    /**
     * Recursive approach to find GCD of two numbers using Euclidean algorithm.
     * Time and space complexities: O(log(min(a,b))) due to stack memory used by recursion
     */
    private static int gcd(int num1, int num2) {
        return num1 == 0 ? num2 : gcd(num2 % num1, num1);
    }

}