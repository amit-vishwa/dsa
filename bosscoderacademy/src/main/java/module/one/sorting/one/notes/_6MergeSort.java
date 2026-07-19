package module.one.sorting.one.notes;

import java.util.Arrays;

/**
 * Merge Sort Algorithm:
 * <p>
 * Merge Sort is an efficient, stable, and comparison-based sorting algorithm that follows the divide and conquer paradigm. It
 * has a worst-case time complexity of O(nlogn), making it suitable for sorting large datasets. The algorithm works by
 * continuously dividing the list into smaller sub-lists until each sub-list contains only one element, which is inherently
 * sorted. These sub-lists are then merged back together in sorted order.
 * <p>
 * Steps of the Merge Sort Algorithm:
 * 1. Base Case:
 * --> If the list contains only one element, it is already sorted and returned.
 * 2. Divide:
 * --> Recursively split the list into two halves until sub-lists contain only one element.
 * 3. Conquer (Merge):
 * --> Merge the smaller sorted sub-lists to form new sorted sub-lists until the entire list is sorted.
 * <p>
 * - Time complexity: O(log(N)) for keep on dividing the array till only 1 element is left * O(N) for merge function = O(N*logN)
 * - Space complexity: O(N) as it is not in-place sorting algorithm.
 * - It is a comparison based, stable and not in-place sorting algorithm.
 */
public class _6MergeSort {

    public static void main(String[] args) {
        sort(new int[]{12, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
        sort(new int[]{-3, -1, 2, 4, -2, -2, 5, 6});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sorted Array: " + Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
        System.out.println();
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return new int[]{arr[start]};
        }
        int mid = start + (end - start) / 2;
        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid + 1, end);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int n = left.length, m = right.length, i = 0, j = 0, k = 0;
        int[] arr = new int[n + m];
        while (i < n && j < m) {
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < n) {
            arr[k++] = left[i++];
        }
        while (j < m) {
            arr[k++] = right[j++];
        }
        return arr;
    }

}
