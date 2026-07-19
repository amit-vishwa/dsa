package module.one.sorting.implementationLab;

import java.util.Arrays;

/**
 * Quick Sort:
 * - The quick sort algorithm involves selecting the pivot and then placing it at correct position.
 * - Then repeating the process for left and right side of the pivot.
 * - Repeat this only when start is less than end index, else break.
 * - Also, finding the pivot index by placing it at its correct position is the main algorithm logic here.
 * - The two pointers will start from the start index and pivot we are taking as the last element.
 * - Now, when start is less than or equal to end perform 2 pointers logic of placing the element in relevant region.
 * - At last, just return the j-1 as pivot index.
 * - Time complexity: O(N*log(N)) for average and best case, O(N^2) for worst case.
 * - Space complexity: O(1) as no extra space is required here due to in-place sorting.
 * - This is a comparison based, unstable and in-place sorting algorithm.
 */
public class QuickSort {

    public static void main(String[] args) {
        sort(new int[]{2, 3, 1, 4, 5, 8, 7, 6, 9});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10, 8, 7});
        sort(new int[]{2, 4, 5, 6, 7, 8, 10});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr) + "\n");
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pi = partition(arr, start, end);
        quickSort(arr, start, pi - 1);
        quickSort(arr, pi + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start, j = start, pivot = arr[end];
        while (i <= end) {
            if (arr[i] <= pivot) {
                swap(arr, i++, j++);
            } else {
                i++;
            }
        }
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
