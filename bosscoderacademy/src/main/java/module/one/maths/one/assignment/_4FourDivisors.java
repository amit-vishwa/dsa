package module.one.maths.one.assignment;

/**
 * Four Divisors:
 * <p>
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 * If there is no such integer in the array, return 0.
 * <p>
 * Input 1: nums = [21,4,7]
 * Output 1: 32
 * Explanation 1: 21 has 4 divisors: 1, 3, 7, 21. 4 has 3 divisors and 7 has 2 divisors.
 * The answer is the sum of divisors of 21 only.
 * <p>
 * Input 2: nums = [21,21]
 * Output 2: 64
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 104
 * 1 <= nums[i] <= 105
 * <p>
 * Approach:
 * - A simple Bruteforce approach here is to iterate over the array.
 * - Check the factor count for each element and calculate the cumulative sum.
 * - If the factor count is exactly 4 then only return the sum, else return 0 for that particular element.
 * - Now add all these sum value in the final sum variable and return it.
 * - Time complexity: O(N) for iterating the array * O(sqrt(M)) for calculating the factors = O(N * sqrt(M))
 * - Space complexity: O(1) as no extra space has been taken.
 */
public class _4FourDivisors {

    public static void main(String[] args) {
        System.out.println("Four divisors sum: " + getFourDivisorsSum(new int[]{21, 4, 7}));
        System.out.println("Four divisors sum: " + getFourDivisorsSum(new int[]{21, 21}));
    }

    private static int getFourDivisorsSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += getContributions(num);
        }
        return sum;
    }

    private static int getContributions(int num) {
        int sum = 0, count = 0;
        for (int i = 1; i * i <= num && count <= 4; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    return 0; // as it is a perfect square i.e. odd factors
                }
                sum = sum + i + num / i;
                count = (i != num / i) ? count + 2 : count + 1;
            }
        }
        return (count == 4) ? sum : 0;
    }

}