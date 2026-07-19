package module.two.exams.two;

import java.util.Arrays;

// Find the Kth largest in stream and create a new array of it.
public class _2KthLargestInStream {

    public static void main(String[] args) {
        System.out.println("K largest elements array: " + Arrays.toString(kLargestElementsArray(new int[]{1, 2, 3, 4, 5, 6}, 4)));
        System.out.println("K largest elements array: " + Arrays.toString(kLargestElementsArray(new int[]{3, 4}, 1)));
    }

    /**
     * Approach:
     * - This is a simple approach.
     * - We are adding -1 in a result array when index + 1 < K else array value at index i + 1 - k.
     * - At last, the result array is returned.
     * - Time complexity: O(N) as we are iterating over all array elements.
     * - Space complexity: O(N) as we are storing the elements in result array.
     */
    private static int[] kLargestElementsArray(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (i + 1 < k) ? -1 : arr[i + 1 - k];
        }
        return res;
    }

}
