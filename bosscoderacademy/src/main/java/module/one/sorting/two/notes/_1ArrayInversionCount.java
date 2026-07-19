package module.one.sorting.two.notes;

/**
 * Inversion Count of Array:
 * <p>
 * Given an array a[]. The task is to find the inversion count of a[]. Where two elements a[i] and a[j] form an inversion
 * if a[i] > a[j] and i < j.
 * <p>
 * Example
 * Input : N = 5,  array[] = {1,2,3,4,5}
 * Output: 0
 */
public class _1ArrayInversionCount {

    private static int INVERSION_COUNT = 0;

    public static void main(String[] args) {
        printInversionCount(new int[]{1, 2, 3, 4, 5});
        printInversionCount(new int[]{5, 4, 3, 2, 1});
    }

    private static void printInversionCount(int[] arr) {
        System.out.println("Inversion count by approach 1: " + approach1(arr));
        System.out.println("Inversion count by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple bruteforce approach is to use nested loop and check if arr[i] > arr[j].
     * - If it is greater, then increment the count else proceed with next check.
     * - At last, just return the count.
     * - Time complexity: O(N^2) due to nested loop on 1D array.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Approach 2 - Optimized approach
     * - This is better than the bruteforce approach in terms of time complexity.
     * - Here, we are using the merge sort algorithm, and inside merge function we are counting inversions.
     * - If arr[i] > arr[j], then we are incrementing the static variable that is used for storing the inversion count.
     * - Inversion count is nothing but sum of inversion count and left array length - left array index.
     * i.e. InversionCount += left[].length - leftIndex
     * - Because if first left element is greater than first element of right array, then whole elements of left array are
     * greater due to the merge sort logic, so inversion count will be length of left array.
     * - If any index is visited then left array length - left array index.
     * - Time complexity: O(N*logN) due to merge sort.
     * - Space complexity: O(N) similar to merge sort.
     */
    private static int approach2(int[] arr) {
        INVERSION_COUNT = 0;
        mergeSort(arr, 0, arr.length - 1);
        return INVERSION_COUNT;
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
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                INVERSION_COUNT += n - i;
            }
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
