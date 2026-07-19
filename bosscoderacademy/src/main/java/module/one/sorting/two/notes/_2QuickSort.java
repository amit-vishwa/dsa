package module.one.sorting.two.notes;

import java.util.Arrays;

/**
 * Quick Sort:
 *
 * Quick Sort is a highly efficient sorting algorithm that employs a divide-and-conquer strategy to sort elements in an array
 * or list. It operates by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays
 * according to whether they are less than or greater than the pivot. The pivot is then placed in its correct sorted position.
 * This process is recursively applied to the sub-arrays, resulting in the entire array being sorted. Quick Sort is favored for
 * its average-case time complexity of O(nlog(n)) and its in-place sorting mechanism, though its worst-case time complexity can
 * degrade to O(n2) if poor pivot choices are made. Nevertheless, with good pivot selection strategies, Quick Sort is one of the
 * fastest and most efficient general-purpose sorting algorithms.
 *
 * Quick Sort Partition Algorithm
 * 1. Choose Pivot:
 * --> Select the highest index value as the pivot element.
 * 2. Initialize Pointers:
 * --> Set left to point to the low index of the list.
 * --> Set right to point to the high index minus one (excluding the pivot).
 * 3. Partitioning Process:
 * - Repeat the following steps until left is greater than or equal to right:
 * --> Move the left pointer to the right as long as the value at left is less than or equal to the pivot.
 * --> Move the right pointer to the left as long as the value at right is greater than or equal to the pivot.
 * --> If left is still less than right, swap the values at left and right.
 * 4. Place Pivot in Correct Position:
 * --> Swap the pivot element with the element at the left index.
 * --> The left index now represents the new position of the pivot.
 *
 * The running time complexity of quicksort for the best case and the average case is O(N*logN). Whereas the time complexity is
 * for the worst case is O(N^2). Coming to the space complexity, since the quick sort algorithm doesn’t require any additional
 * space other than that to store the original array, therefore, the space complexity of the quick sort algorithm is O(N). N is
 * the size of the input array.
 *
 * Advantages of Quicksort
 * - The average-case time complexity to sort an array of n elements is O(n log n).
 * - Generally, it runs very fast. It is even faster than merge sort.
 * - No extra storage is required.
 *
 * - Time complexity: O(N*log(N)) for average and best case, O(N^2) for worst case.
 * - Space complexity: O(1) as no extra space is required here due to in-place sorting.
 * - This is a comparison based, unstable and in-place sorting algorithm.
 * */
public class _2QuickSort {

    public static void main(String[] args) {
        sort(new int[]{1, 2, 3, 4, 5});
        sort(new int[]{5, 4, 3, 2, 1});
    }

    private static void sort(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr) + "\n");
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
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
