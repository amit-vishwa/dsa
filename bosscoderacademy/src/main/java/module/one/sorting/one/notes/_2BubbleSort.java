package module.one.sorting.one.notes;

import java.util.Arrays;

/**
 * Bubble Sort Algorithm:
 * <p>
 * Bubble Sort is a straightforward, comparison-based sorting algorithm. It repeatedly steps through the list, compares
 * adjacent pairs of elements, and swaps them if they are in the wrong order. The process is repeated until the list is sorted.
 * While easy to understand and implement, Bubble Sort is not efficient for large datasets due to its O(n2) time complexity in
 * both average and worst cases.
 * <p>
 * Steps of the Bubble Sort Algorithm:
 * 1. Compare Adjacent Elements:
 * --> Start from the beginning of the array and compare the first element with the next one.
 * 2. Swap Elements if Necessary:
 * --> If the first element is greater than the next element, swap them.
 * 3. Move Forward:
 * --> Move to the next pair of adjacent elements and repeat the comparison and swapping process.
 * 4. Repeat the Process:
 * --> Continue this process until you reach the end of the array.
 * 5. Check for Sorted Array:
 * --> After each complete pass through the array, check if any swaps were made.
 * --> If no swaps were made, the array is sorted.
 * 6. Iterate Until Sorted:
 * --> If the array is not sorted, repeat the process from step 1 until the entire array is sorted.
 * <p>
 * - Time complexity: Omega(N) for best case, O(N^2) for average and worst case.
 * - Space complexity: O(1) due to in-place sorting algorithm.
 * - It is an in-place, stable and comparison sorting algorithm.
 */
public class _2BubbleSort {

    public static void main(String[] args) {
        sort(new int[]{12, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int pass = 1; pass < arr.length; pass++) {
            boolean swapped = false;
            for (int curr = 0; curr < arr.length - pass; curr++) {
                if (arr[curr] > arr[curr + 1]) {
                    swap(arr, curr, curr + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
