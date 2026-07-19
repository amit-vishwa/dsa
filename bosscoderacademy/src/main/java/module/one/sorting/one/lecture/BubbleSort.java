package module.one.sorting.one.lecture;

import java.util.Arrays;

/**
 * Bubble Sort:
 * - Sorting is nothing but arranging the data in given order, can be ascending (non-decreasing) or descending (non-increasing).
 * - The algorithm involves in swapping the adjacent elements in order to sort the array.
 * - After each pass the max element is bubbled to the right end side of the array.
 * - So from next pass the unsorted part gets reduced, and we simply perform swapping till second last element.
 * - We also have one boolean flag which becomes true when a swapping is perform in each pass.
 * - When the flag remains false after a pass, that means no swapping is performed and the array is sorted now.
 * - This flag results in giving Omega(N) time complexity for best case.
 * - This is an in-place sorting algorithm, that is no extra array or space is required for sorting.
 * - It is a stable sorting algorithm, that is if two duplicates are there then will maintain the position after sorting.
 * - Time complexity: O(N^2) due to nested loop for worst and average case, Omega(N) for best case due to boolean flag.
 * - Space complexity: O(1) due to in-place sorting.
 */
public class BubbleSort {

    public static void main(String[] args) {
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10, 8, 7});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int pass = 1; pass < arr.length; pass++) {
            boolean isSwapped = false;
            for (int curr = 0; curr < arr.length - pass; curr++) {
                if (arr[curr] > arr[curr + 1]) {
                    isSwapped = true;
                    int temp = arr[curr];
                    arr[curr] = arr[curr + 1];
                    arr[curr + 1] = temp;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}
