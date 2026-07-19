package module.one.searching.one.notes;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array:
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example
 * <p>
 * Input:  nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class _1FirstAndLastIndex {

    public static void main(String[] args) {
        printPositions(new int[]{5, 7, 7, 8, 8, 8, 10}, 8);
        printPositions(new int[]{5, 7, 7, 8, 8, 8, 10}, 18);
    }

    private static void printPositions(int[] arr, int t) {
        System.out.println("First and last positions by approach1: " + Arrays.toString(approach1(arr, t)));
        System.out.println("First and last positions by approach2: " + Arrays.toString(approach2(arr, t)));
        System.out.println("First and last positions by approach3: " + Arrays.toString(approach3(arr, t)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - The approach is simple.
     * - We have to iterate over the array once and find the first and last index in one go.
     * - We just have to update the first index once and last index everytime we find the target element in the array.
     * - Time complexity: O(N) for array iteration.
     * - Space complexity: O(1) as we are not taking any extra input dependent space.
     */
    private static int[] approach1(int[] arr, int t) {
        int[] pos = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                if (pos[0] == -1) {
                    pos[0] = i;
                    pos[1] = i;
                } else {
                    pos[1] = i;
                }
            }
        }
        return pos;
    }

    /**
     * Approach 2 - Optimal approach
     * - This approach uses the simple binary search algorithm.
     * - Here, we are performing binary search and storing the possible indexes in index array.
     * - At last, we are just returning the array.
     * - Time complexity: O(logN) as it is a simple binary search.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int[] approach2(int[] arr, int t) {
        int[] index = {-1, -1};
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
                if (arr[m] == t) {
                    index[0] = m;
                }
            }
        }
        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
                if (arr[m] == t) {
                    index[1] = m;
                }
            }
        }
        return index;
    }

    /**
     * Approach 3 - Another version of approach 2
     * - This is similar to approach 2 only.
     * - Here, we are not using any extra variable to store the possible index.
     * - We are returning the right pointer at last as it will always have the answer.
     * - Time and space complexities are similar to approach 2.
     */
    private static int[] approach3(int[] arr, int t) {
        int firstIndex = binarySearch(arr, t, true);
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }
        int lastIndex = binarySearch(arr, t, false);
        return new int[]{firstIndex, lastIndex};
    }

    private static int binarySearch(int[] arr, int t, boolean isFirstIndex) {
        int l = 0, r = arr.length - 1;
        while (isFirstIndex ? l < r : l <= r) {
            int m = l + (r - l) / 2;
            if (isFirstIndex) {
                if (arr[m] >= t) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (arr[m] > t) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return arr[r] == t ? r : -1;
    }

}
