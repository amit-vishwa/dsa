package module.one.sorting.two.assignment;

import java.util.Arrays;

/**
 * Sort Colors:
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * <p>
 * Approach:
 * - A simple 3 pointer approach is used here where we are putting 0 at region 1, 1 at region 2 and 2 at region 3.
 * - The breaking condition i<=k should be remembered as it is always missing.
 * - Time complexity: O(N) as we are iterating the array only once.
 * - Space complexity: O(1) as no extra space is used here.
 */
public class _1SortColors {

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
        sortColors(new int[]{2, 0, 1});
    }

    private static void sortColors(int[] arr) {
        System.out.println("Colors: " + Arrays.toString(arr));
        int n = arr.length, i = 0, j = 0, k = n - 1;
        while (i <= k) {
            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, k);
                k--;
            }
        }
        System.out.println("Sorted Colors: " + Arrays.toString(arr) + "\n");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}