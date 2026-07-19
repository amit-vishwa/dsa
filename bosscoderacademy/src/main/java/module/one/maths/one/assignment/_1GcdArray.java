package module.one.maths.one.assignment;

/**
 * Gcd Array:
 * <p>
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * <p>
 * Input 1: nums = [2,5,6,9,10]
 * Output 1: 2
 * Explanation 1: The smallest number in nums is 2. The largest number in nums is 10. The greatest common divisor of
 * 2 and 10 is 2.
 * <p>
 * Input 2: nums = [7,5,6,8,3]
 * Output 2: 1
 * <p>
 * Approach:
 * - A simple approach of finding GCD, find the max and min elements from the given array.
 * - Find their GCD using the Euclidean theorem or algorithm.
 * - Time complexity: O(N) finding max & min + O(log(M)) for finding gcd M is second highest i.e.min here = O(N)
 * - Space complexity: O(1)
 */
public class _1GcdArray {

    public static void main(String[] args) {
        System.out.println("Gcd: " + gcd(new int[]{2, 5, 6, 9, 10}));
        System.out.println("Gcd: " + gcd(new int[]{7, 5, 6, 8, 3}));
    }

    private static int gcd(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return arr[0];
        }
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MIN_VALUE;
        for (int num : arr) {
            num1 = Math.min(num1, num);
            num2 = Math.max(num2, num);
        }
        while (num1 > 0) {
            int temp = num1;
            num1 = num2 % num1;
            num2 = temp;
        }
        return num2;
    }
}