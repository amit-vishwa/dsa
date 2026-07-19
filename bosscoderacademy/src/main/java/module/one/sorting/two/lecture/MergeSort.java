package module.one.sorting.two.lecture;

import java.util.Arrays;

/**
 * Merge Sort:
 * - The sorting algorithm involves keep on partitioning of array until the array length becomes 1.
 * - When we are left with a single element then we return that element for both parts.
 * - Then in merge function, we merge the two sorted arrays into a single sorted array.
 * - The partitioning takes O(log(N)) time and merging takes O(N) using 2 pointers.
 * - Time complexity: O(N*log(N))
 * - Space complexity: O(N) as it is not an in-place sorting algorithm
 * - The algorithm is not an in-place sorting algorithm as we are creating new array in merge function.
 * - The algorithm is a stable sorting algorithm due to the element picking logic in merge function.
 * - It performs comparison then picks the elements, hence it is comparison based sorting algorithm.
 */
public class MergeSort {

    public static void main(String[] args) {
        sort(new int[]{2, 5, 1, 4, 3});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        arr = mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
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
