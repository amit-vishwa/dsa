package module.one.searching.one.assignment;

import java.util.Arrays;

/**
 * First Last Position Sorted Array:
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input 1:
 * nums = [5,7,7,8,8,10], target = 8
 * Output 1:
 * [3, 4]
 * Explanation 1:
 * 8 is present from 3rd index to 4th index
 * <p>
 * Input 2:
 * nums = [5,7,7,8,8,10], target = 6
 * Output 2:
 * [-1, -1]
 * <p>
 * Constraints:
 * n == nums.length
 * 0 <= n <= 105
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * <p>
 * Approaches:
 * 1. Bruteforce approach - Linear search can be used here to find the first and last positions in O(N) time complexity.
 * 2. Optimal approach - Binary search can be performed on sorted array here to find the first and last positions in O(logN) time complexity.
 */
public class _1FirstLastPosition {

    public static void main(String[] args) {
        System.out.println("First and last positions: " + Arrays.toString(firstLastPosition(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println("First and last positions: " + Arrays.toString(firstLastPosition(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    private static int[] firstLastPosition(int[] nums, int target) {
        int firstIndex = binarySearch(nums, target, true);
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{firstIndex, binarySearch(nums, target, false)};
    }

    private static int binarySearch(int[] arr, int target, boolean isFirstIndex) {
        int l = 0, r = arr.length - 1, index = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                index = m;
                if (isFirstIndex) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return index;
    }

}