package module.one.sorting.one.assignment;

/**
 * Reverse Pairs:
 * <p>
 * Given an integer array nums, return the number of reverse pairs in the array.
 * A reverse pair is a pair (i, j) where:
 * <p>
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 * <p>
 * Input: nums = [1,3,2,3,1]
 * Output: 2
 * Explanation: The reverse pairs are:
 * (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
 * (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
 * <p>
 * Input: nums = [2,4,3,5,1]
 * Output: 3
 * <p>
 * Constraints:
 * 1 <= nums.length <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 */
public class _2ReversePairs {

    private static int REVERSE_PAIR_COUNT = 0;

    public static void main(String[] args) {
        printReversePairCount(new int[]{1, 3, 2, 3, 1});
        printReversePairCount(new int[]{2, 4, 3, 5, 1});
    }

    private static void printReversePairCount(int[] arr) {
        System.out.println("Reverse pairs count by approach 1: " + approach1(arr));
        System.out.println("Reverse pairs count by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - The approach is a simple bruteforce one.
     * - We are using a simple nested loop to calculate the reverse pairs count.
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    private static int approach1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Approach 2 - Optimized
     * - This is a better solution than the bruteforce approach.
     * - Here, we are calculating the reverse pair count in merge function of merge sort, similar to inversion count.
     * - In merge function, first we are calculating the count by iterating through the arrays and checking for each element
     * if left element is twice of right element, increment 2nd pointer and just add in count.
     * - After both loops, will have our updated count.
     * - Then we can simply implement the merge function logic and complete the merge sort.
     * - Time complexity: O(N*logN) due to merge sort.
     * - Space complexity: O(N) due to merge sort.
     */
    private static int approach2(int[] arr) {
        REVERSE_PAIR_COUNT = 0;
        mergeSort(arr, 0, arr.length - 1);
        return REVERSE_PAIR_COUNT;
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
        // O(N + M) as i and j are initialized once
        while (i < n) { // O(N)
            while (j < m && left[i] > 2 * right[j]) { // O(M)
                j++;
            }
            REVERSE_PAIR_COUNT += j;
            i++;
        }
        int[] arr = new int[n + m];
        i = 0;
        j = 0;
        while (i < n && j < m) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
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