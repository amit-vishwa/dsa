package module.one.sorting.two.lecture;

import java.util.Arrays;

/**
 * Merge 2 sorted arrays:
 * <p>
 * Give two sorted arrays, merge them into a single sorted array.
 * Input: arr1 = [2, 4, 6, 7, 12, 18], arr2 = [1, 3, 4, 8, 9, 10, 11]
 * Output: arr = [1, 2, 3, 4, 4, 6, 7, 8, 9, 10, 11, 12, 18]
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        printMergedArray(new int[]{2, 4, 6, 7, 12, 18}, new int[]{1, 3, 4, 8, 9, 10, 11});
    }

    private static void printMergedArray(int[] arr1, int[] arr2) {
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Merged array by approach 1: " + Arrays.toString(approach1(arr1, arr2)));
        System.out.println("Merged array by approach 2: " + Arrays.toString(approach2(arr1, arr2)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - Here, we are first merge the both arrays into a single array.
     * - This array will have first array elements first then second array elements.
     * - This is an unsorted array, so will be performing sorting operation on this.
     * - Now, finally we are left with sorted merged array.
     * - Time complexity: O(N+M) for copying both array + O((N+M) * log(N+M) for sorting = O(N+M) + O((N+M) * log(N+M))
     * = O((N+M)*log(N+M))
     * - Space complexity: O(1) as no extra space is required additionally.
     */
    private static int[] approach1(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] arr = new int[n + m];
        System.arraycopy(arr1, 0, arr, 0, n);
        for (int i = n; i < n + m; i++) {
            arr[i] = arr2[i - n];
        }
        Arrays.sort(arr);
        return arr;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal solution here.
     * - First we have created the new array of length equal to the sum of lengths of both sorted array.
     * - Then we are keeping 2 pointers on starting element of both the arrays.
     * - We are comparing now, if element in first array is greater than element at second array.
     * - If yes then choose element from 2nd array, else choose from 1st.
     * - Repeat it until one of the array visited completely.
     * - Then visit the remaining part of the array whose elements are yet to be visited.
     * - At last, will be having all the elements sorted in the new array.
     * - Time complexity: O(N+M) as we are visiting both the array once.
     * - Space complexity: O(1) as no extra space is required here.
     */
    private static int[] approach2(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length, i = 0, j = 0, k = 0;
        int[] arr = new int[n + m];
        while (i < n && j < m) {
            arr[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (i < n) {
            arr[k++] = arr1[i++];
        }
        while (j < m) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }

}
