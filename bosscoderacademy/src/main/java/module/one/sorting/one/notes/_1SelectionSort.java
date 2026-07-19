package module.one.sorting.one.notes;

import java.util.Arrays;

/**
 * Selection Sort:
 * <p>
 * Selection Sort is a straightforward sorting algorithm that operates by repeatedly selecting the smallest (or largest)
 * element from the unsorted portion of the array and swapping it with the first unsorted element. This process continues until
 * the entire array is sorted. While simple, Selection Sort is not efficient for large datasets due to its O(n2) time
 * complexity in both average and worst cases.
 * <p>
 * Steps of the Selection Sort Algorithm:
 * 1. Initialize the Minimum Index:
 * --> Start with the first element of the array and set it as the minimum (MIN).
 * 2. Find the Minimum Element:
 * --> Traverse the unsorted part of the array to find the smallest element.
 * 3. Swap Elements:
 * --> Swap the found minimum element with the element at the current minimum index (MIN).
 * 4. Move to the Next Element:
 * --> Increment MIN to point to the next element in the array.
 * 5. Repeat:
 * --> Continue this process until the entire array is sorted.
 * <p>
 * - Time complexity: O(N^2) for all cases.
 * - Space complexity: O(1) due to in-place sorting.
 * - It is an in-place, unstable, comparison sorting algorithm.
 */
public class _1SelectionSort {

    public static void main(String[] args) {
        sort(new int[]{2, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        for (int usi = 0; usi < arr.length - 1; usi++) {
            int minIdx = usi; // un-sorted index
            for (int curIdx = usi + 1; curIdx < arr.length; curIdx++) {
                if (arr[minIdx] > arr[curIdx]) {
                    minIdx = curIdx;
                }
            }
            swap(arr, minIdx, usi);
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
