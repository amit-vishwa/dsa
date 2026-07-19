package module.one.sorting.one.assignment;

import java.util.Arrays;

/**
 * Count Smaller Number After Self:
 * <p>
 * Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the
 * right of nums[i].
 * <p>
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * <p>
 * Input: nums = [-1]
 * Output: [0]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class _3SmallerAfterSelf {

    public static void main(String[] args) {
        printSmallerAfterSelf(new int[]{8, 4, 2, 1});
        printSmallerAfterSelf(new int[]{1, 20, 6, 4, 5});
        printSmallerAfterSelf(new int[]{5, 2, 6, 1});
        printSmallerAfterSelf(new int[]{-1});
    }

    private static void printSmallerAfterSelf(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Smaller after self by approach 1: " + Arrays.toString(approach1(arr)));
        System.out.println("Smaller after self by approach 2: " + Arrays.toString(approach2(arr)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple bruteforce approach where we are counting using nested loops.
     * - Time complexity: O(N^2)
     * - Space complexity: O(1)
     */
    private static int[] approach1(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        res[n - 1] = 0;
        return res;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "{ " + this.value + ", " + this.index + " }";
        }
    }

    /**
     * Approach 2 - Optimized
     * - The approach is quite similar to a normal merge sort.
     * - Here, we are using an object to keep track of original indexes of given elements.
     * - We are sorting the object array and in merge function we are updating the count if right is less than left.
     * - Time complexity: O(N*logN) similar to merge sort.
     * - Space complexity: O(N) as we are using extra arrays + O(N) for recursion stack.
     */
    private static int[] approach2(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n];
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }
        System.out.println(Arrays.toString(mergeSort(pairs, 0, arr.length - 1, counts)));
        return counts;
    }

    private static Pair[] mergeSort(Pair[] pairs, int start, int end, int[] counts) {
        if (start == end) {
            return new Pair[]{pairs[start]};
        }
        int mid = start + (end - start) / 2;
        Pair[] left = mergeSort(pairs, start, mid, counts);
        Pair[] right = mergeSort(pairs, mid + 1, end, counts);
        return merge(left, right, counts);
    }

    private static Pair[] merge(Pair[] left, Pair[] right, int[] counts) {
        int n = left.length, m = right.length, i = 0, j = 0, k = 0;
        while (i < n) {
            while (j < m && right[j].value < left[i].value) {
                j++;
            }
            counts[left[i].index] += j;
            i++;
        }
        i = 0;
        j = 0;
        Pair[] merged = new Pair[n + m];
        while (i < n && j < m) {
            merged[k++] = left[i].value <= right[j].value ? left[i++] : right[j++];
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