package module.two.exams.one;

/**
 * Check If Array Pairs Are Divisible by k:
 * <p>
 * Given an array of integers arr of even length n and an integer k.
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 * Return true If you can find a way to do that or false otherwise.
 * <p>
 * Example 1:
 * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * Output: true
 * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * <p>
 * Example 2:
 * Input: arr = [1,2,3,4,5,6], k = 7
 * Output: true
 * Explanation: Pairs are (1,6),(2,5) and(3,4).
 * <p>
 * Example 3:
 * Input: arr = [1,2,3,4,5,6], k = 10
 * Output: false
 * Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible
 * by 10.
 * <p>
 * Constraints:
 * arr.length == n
 * 1 <= n <= 10^5
 * n is even.
 * -10^9 <= arr[i] <= 10^9
 * 1 <= k <= 10^5
 * <p>
 * Refer: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
 */
public class _5KDivisibleArrayPairs {

    public static void main(String[] args) {
        System.out.println("Array pairs are divisible by K? " + arrayPairsDivisibleByK(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
        System.out.println("Array pairs are divisible by K? " + arrayPairsDivisibleByK(new int[]{1, 2, 3, 4, 5, 6}, 7));
        System.out.println("Array pairs are divisible by K? " + arrayPairsDivisibleByK(new int[]{1, 2, 3, 4, 5, 6}, 10));
    }

    // A simple 2 pointer approach is used here with O(N) time complexity and O(1) space complexity.
    private static boolean arrayPairsDivisibleByK(int[] arr, int k) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if ((arr[i] + arr[j]) % k != 0) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
