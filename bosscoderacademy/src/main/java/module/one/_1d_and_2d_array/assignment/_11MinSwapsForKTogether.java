package module.one._1d_and_2d_array.assignment;

/**
 * Minimum Swaps To Bring K Together:
 * <p>
 * Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all
 * the numbers less than or equal to k together.
 * <p>
 * Input: arr[] = {2, 1, 5, 6, 3}, k = 3
 * Output: 1
 * Explanation: To bring elements 2, 1, 3 together, swap element ‘5’ with ‘3’ such that final array will be
 * arr[] = {2, 1, 3, 6, 5}
 * <p>
 * Input: arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
 * Output: 2
 * <p>
 * Constraints:
 * 1<=N<=105
 * 1<=A[i], K<=105
 */
public class _11MinSwapsForKTogether {

    public static void main(String[] args) {
        System.out.println("Min swaps to bring K together: " + solve(new int[]{2, 1, 5, 6, 3}, 3));
        System.out.println("Min swaps to bring K together: " + solve(new int[]{2, 7, 9, 5, 8, 7, 4}, 5));
    }

    /**
     * Approach:
     * - The approach is little complex, but it is quite efficient.
     * - First we have to count numbers that are less than or equal to K.
     * - Now, create a variable for count number greater than K within previously counter window.
     * - Also, we have to consider minimum swap as valid counter value.
     * - Now iterate over the array and increase invalid number count if element is greater than K.
     * - When index reaches till count-1, just update minimum swap value checking invalid counter value.
     * - When index exceeds count-1, then reduce invalid counter value as we are removing left most value
     * from sliding window.
     * - Now, again update the minimum swap value by comparing with invalid counter valid and itself.
     * - Repeat the process until array traversal is complete.
     * - Time complexity: O(N), Space complexity: O(1)
     */
    private static int solve(int[] input, int k) {
        int validNumbersCount = 0;
        for (int num : input) {
            if (num <= k) {
                validNumbersCount++;
            }
        }
        int invalidNumbersCount = 0, minSwap = validNumbersCount;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > k) {
                invalidNumbersCount++;
            }
            if (i == validNumbersCount - 1) {
                minSwap = Math.min(minSwap, invalidNumbersCount);
            } else if (i >= validNumbersCount) {
                if (input[i - validNumbersCount] > k) {
                    invalidNumbersCount--;
                }
                minSwap = Math.min(minSwap, invalidNumbersCount);
            }
        }
        return minSwap;
    }

}