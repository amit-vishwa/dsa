package module.one.sorting.implementationLab;

import java.util.Arrays;

/**
 * Partition the Array: [Leetcode 2161. Partition Array According to Given Pivot]
 *
 * Give an array and a pivot, partition the array in such a way that elements less than or equal to pivot is placed on the
 * left side of the pivot in the array, and the elements greater than pivot comes right side of the pivot.
 *
 * Input: arr = [4, 3, 2, 1, 6, 8, 7, 9, 5], pivot = 5
 * Output: arr = [4, 3, 2, 1, 5, 8, 7, 9, 6] or sorted array [1, 2, 3, 4, 5, 6, 7, 8, 9] is also valid.
 */
public class ArrayPartition {

    public static void main(String[] args) {
        printPartitionedArray(new int[]{4, 3, 2, 1, 6, 8, 7, 9, 5}, 5);
    }

    private static void printPartitionedArray(int[] arr, int pivot) {
        System.out.println("Array: " + Arrays.toString(arr) + ", Pivot: " + pivot);
        System.out.println("Partitioned array by approach 1: " + Arrays.toString(approach1(Arrays.copyOf(arr, arr.length))));
        System.out.println("Partitioned array by approach 2: " + Arrays.toString(approach2(arr, pivot)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce:
     * - This is a simple bruteforce approach, here we are simply performing sorting on the given array.
     * - By doing this, the pivot will by default going to come at its correct position.
     * - Time complexity: O(N*logN) as we are using in-place merge sort here.
     * - Space complexity: O(N) due to merge sort.
     */
    private static int[] approach1(int[] arr) {
        mergeSort(arr, 0, arr.length);
        return arr;
    }

    private static void mergeSort(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int m = s + (e - s) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m, e);
        merge(arr, s, m, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] res = new int[e - s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            res[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i < m) {
            res[k++] = arr[i++];
        }
        while (j < e) {
            res[k++] = arr[j++];
        }
        for (int x = 0; x < res.length; x++) {
            arr[s + x] = res[x];
        }
    }

    /**
     * Approach 2 - Optimal
     * - The approach is optimal than the bruteforce solution.
     * - Here, we are using the 2 pointers approach.
     * - We have i and j pointers pointing at first element of the array.
     * - We are comparing it with pivot element, if it is greater, then only increment i pointer else swap i and j and increment
     * both the pointers.
     * - Repeat it until i becomes array length, or we have traversed the array.
     * - At last, we will be left with an array where elements greater than pivot are placed after it and rest before it.
     * - Time complexity: O(N) as we are traversing the array only once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach2(int[] arr, int pivot) {
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
