package module.one.sorting.one.assignment;

/**
 * Inversion Count:
 * <p>
 * Given an array a[]. The task is to find the inversion count of a[]. Where two elements a[i] and a[j] form an inversion if
 * a[i] > a[j] and i < j.
 * <p>
 * Input: arr[] = {8, 4, 2, 1}
 * Output: 6
 * Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
 * <p>
 * Input: arr[] = {1, 20, 6, 4, 5}
 * Output: 5
 * Explanation: Given array has five inversions: (20, 6), (20, 4), (20, 5), (6, 4), (6, 5).
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class _4InversionCount {

    private static int INVERSION_COUNT;

    public static void main(String[] args) {
        printInversionCount(new int[]{8, 4, 2, 1});
        printInversionCount(new int[]{1, 20, 6, 4, 5});
    }

    private static void printInversionCount(int[] arr) {
        System.out.println("Inversion count by approach 1: " + approach1(arr));
        System.out.println("Inversion count by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple bruteforce approach using nested loops to count the inversions.
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    private static int approach1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Approach 2 - Optimized
     * - An optimized approach is to use the merge sort algorithm and calculate the count in merge function.
     * - When array element at index i is greater than j simply update the inversion count which count + left array left - index.
     * - Time complexity: O(N*logN) due to merge sort.
     * - Space complexity: O(N) due to merge sort.
     */
    private static int approach2(int[] arr) {
        INVERSION_COUNT = 0;
        mergeSort(arr, 0, arr.length - 1);
        return INVERSION_COUNT;
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
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                INVERSION_COUNT += n - i;
                merged[k++] = right[j++];
            }
        }
        while (i < n) {
            merged[k++] = left[i++];
        }
        while (j < m) {
            merged[k++] = right[j++];
        }
        return merged;
    }

}