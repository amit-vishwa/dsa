package module.one.searching.one.assignment;

/**
 * Preimage Size Factorial:
 * <p>
 * Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3 * ... * x and by convention, 0! = 1.
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has two zeroes
 * at the end.
 * Given an integer k, return the number of non-negative integers x have the property that f(x) = k.
 * <p>
 * Input: k = 0
 * Output: 5
 * Explanation: 0!, 1!, 2!, 3!, and 4! end with k = 0 zeroes.
 * <p>
 * Input: k = 5
 * Output: 0
 * <p>
 * Constraints:
 * 0 <= k <= 109
 * <p>
 * Approach:
 * - The approach is simple and it uses binary search algorithm.
 * - The logic is simple, take upper and lower bounds as 0 and 6 times of give K.
 * - Then take the mid-number and find the trailing zeroes.
 * - If zeroes is equal to K then return answer as 5, if less then update lower limit, else update upper limit.
 * - If loop ends then return 0 as we do not have any number with K trailing zeroes.
 * - Time complexity: O(logN) for binary search * O(logN) for trailing zeroes = O(logN * logN) = O(logN)^2
 * - Space complexity: O(1) as no extra space is used here.
 */
public class _6PreimageSizeFactorial {

    public static void main(String[] args) {
        System.out.println(numbersWithKTrailingZeroes(0));
        System.out.println(numbersWithKTrailingZeroes(5));
        System.out.println(numbersWithKTrailingZeroes(6));
    }

    private static int numbersWithKTrailingZeroes(int k) {
        long low = 0, high = 6L * k;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long zeroes = trailingZeroes(mid);
            if (zeroes == k) {
                return 5;
            }
            if (zeroes < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private static long trailingZeroes(long num) {
        long count = 0;
        while (num > 0) {
            num /= 5;
            count += num;
        }
        return count;
    }


}