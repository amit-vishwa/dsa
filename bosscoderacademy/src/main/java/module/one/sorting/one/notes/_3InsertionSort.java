package module.one.sorting.one.notes;

import java.util.Arrays;

/**
 * Insertion Sort Algorithm:
 * <p>
 * Insertion Sort is a straightforward sorting method that arranges numbers in ascending or descending order. It is similar to
 * the way cards are sorted in hand during a card game. This in-place, comparison-based algorithm maintains a sorted sub-list
 * in the lower part of the array. As new elements are picked from the unsorted part, they are inserted into their correct
 * position within the sorted sub-list. While simple and intuitive, Insertion Sort is not efficient for large datasets due to
 * its O(n2) time complexity in both average and worst cases.
 * <p>
 * Steps of the Insertion Sort Algorithm:
 * 1. Initial Sorted Sub-list:
 * --> The first element is considered sorted by default.
 * 2. Pick Next Element:
 * --> Select the next element from the unsorted portion of the array.
 * 3. Compare and Shift:
 * --> Compare the selected element with the elements in the sorted sub-list.
 * --> Shift all elements in the sorted sub-list that are greater than the selected element to the right.
 * 4. Insert Element:
 * --> Insert the selected element into its correct position in the sorted sub-list.
 * 5. Repeat:
 * --> Continue the process until all elements are sorted.
 * <p>
 * - Time complexity: O(N) for best case, O(N^2) for average and worst case.
 * - Space complexity: O(1) as no extra space is required for sorting.
 * - It is an in-place, stable and comparison sorting algorithm.
 */
public class _3InsertionSort {

    public static void main(String[] args) {
        sort(new int[]{12, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
    }

    // Tutor's approach for playing cards arrangement
    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int usi = 1; usi < arr.length; usi++) {
            int key = arr[usi], curr;
            for (curr = usi - 1; curr >= 0 && arr[curr] > key; curr--) {
                arr[curr + 1] = arr[curr];
            }
            arr[curr + 1] = key;
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr) + "\n");
    }

}
