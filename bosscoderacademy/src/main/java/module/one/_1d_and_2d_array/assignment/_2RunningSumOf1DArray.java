package module.one._1d_and_2d_array.assignment;

/**
 * [Leetcode 1480. Running Sum of 1d Array]
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 * <p>
 * Input 1: nums = [1,2,3,4]
 * Output 1: [1,3,6,10]
 * Explanation 1: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * <p>
 * Input 2: nums = [1,1,1,1,1]
 * Output 2: [1,2,3,4,5]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 1000
 * -106 <= nums[i] <= 106
 */
public class _2RunningSumOf1DArray {

    public static void main(String[] args) {
        printRunningSumArray(new int[]{1, 2, 3, 4});
        printRunningSumArray(new int[]{1, 1, 1, 1, 1});
    }

    /**
     * Approach:
     * - A simple approach that requires traversal of whole array to update elements from 1st index.
     * - Time complexity: O(N), to update array elements.
     * - Space complexity: O(1), as we are not taking any extra space or memory.
     */
    private static void printRunningSumArray(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}