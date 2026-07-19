package module.two.heaps.one.notes;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * kth largest element:
 * - Given an integer array nums and an integer k, return the kth the largest element in the array.
 * - Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
public class _5KthLargestElement {

    public static void main(String[] args) {
        printKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    private static void printKthLargestElement(int[] arr, int k) {
        System.out.println(k + "th largest element by approach 1: " + approach1(arr, k));
        System.out.println(k + "th largest element by approach 2: " + approach2(arr, k));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is a simple bruteforce approach.
     * - Here, we are using merge sort first to sort the array.
     * - Then we are simply returning the kth largest index.
     * - Sorting takes N*log(N).
     * - Time complexity: O(N*log(N)) due to merge sort
     * - Space complexity: O(N) as new array is created by merge sort.
     */
    private static int approach1(int[] arr, int k) {
        int[] sorted = mergeSort(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sorted array: " + Arrays.toString(sorted));
        return sorted[sorted.length - k];
    }

    private static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        int m = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(arr, m, n));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int n = left.length, m = right.length, i = 0, j = 0, k = 0;
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            merged[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < n) {
            merged[k++] = left[i++];
        }
        while (j < m) {
            merged[k++] = right[j++];
        }
        return merged;
    }

    /**
     * Approach 2:
     * - This is an optimized approach.
     * - Here, we are using the min priority queue to insert k elements.
     * - We have to iterate over the array, add element in queue first then check if size greater than K then remove and element.
     * - Then at last we are just returning the top element.
     * - Time complexity: O(N) due to array iteration * O(log(K)) due to insertion in priority queue = O(N*log(K))
     * - Space complexity: O(K) as only K elements are inserted in the priority queue.
     */
    private static int approach2(int[] arr, int k) {
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        for (int num : arr) {
            minPriorityQueue.add(num);
            if (minPriorityQueue.size() > k) {
                minPriorityQueue.remove();
            }
        }
        return minPriorityQueue.isEmpty() ? -1 : minPriorityQueue.peek();
    }

}
