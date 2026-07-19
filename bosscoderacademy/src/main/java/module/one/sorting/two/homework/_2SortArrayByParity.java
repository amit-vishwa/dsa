package module.one.sorting.two.homework;

import java.util.Arrays;

/**
 * LeetCode 905. Sort Array By Parity
 * Refer: https://leetcode.com/problems/sort-array-by-parity/description/
 */
public class _2SortArrayByParity {

    public static void main(String[] args) {
        printParitySortedArray(new int[]{3, 1, 2, 4});
        printParitySortedArray(new int[]{0});
    }

    private static void printParitySortedArray(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Parity sorted array by approach 1: " + Arrays.toString(approach1(arr)));
        System.out.println("Parity sorted array by approach 2: " + Arrays.toString(approach2(arr)));
        System.out.println();
    }

    /**
     * Approach 1 - Using extra space
     * - Here we are using an array of same size as input array.
     * - We are first adding the even elements in the result array, then re-iterating and adding odd element in result array.
     * - At last, we are just returning the result array.
     * - Time complexity: O(2N) for iterating twice, one for even and one for odd = O(N)
     * - Space complexity: O(N) for result array.
     */
    private static int[] approach1(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1) == 0) {
                res[index++] = arr[i];
            }
        }
        for (int i = 0, j = 0; i < n; i++) {
            if ((arr[i] & 1) == 1) {
                res[index++] = arr[i];
            }
        }
        return res;
    }

    /**
     * Approach 2 - Using 2 pointers
     * - This is a better approach than above one.
     * - Here, we are not using any extra space and in single array traversal we are placing the elements at correct position.
     * - Time complexity: O(N) in single iteration we are getting the result.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach2(int[] arr) {
        int i = 0, j = 0, n = arr.length - 1;
        while (i <= n) {
            if ((arr[i] & 1) == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return arr;
    }

}