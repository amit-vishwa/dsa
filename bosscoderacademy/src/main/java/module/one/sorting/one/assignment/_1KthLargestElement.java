package module.one.sorting.one.assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Kth Largest Element:
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * You must solve it in O(n) time complexity.
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 4
 */
public class _1KthLargestElement {

    public static void main(String[] args) {
        printKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2);
        printKthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    private static void printKthLargestElement(int[] arr, int k) {
        if (k > arr.length) {
            return;
        }
        System.out.println(k + "th largest element by approach 1: " + approach1(arr, k));
        System.out.println(k + "th largest element by approach 2: " + approach2(arr, k));
        System.out.println();
    }

    /**
     * Approach 1 - Optimized
     * - Here, we are using a PriorityQueue that internally uses min heap by default i.e. min element is added on top.
     * - The logic is to simply keep on adding the elements, if size is greater than K, then remove the element.
     * - After traversing the whole loop, at last will be left with the Kth largest element on top, just return it.
     * - Time complexity: O(N) for traversing array * O(logK) for priorityQueue of size K = O(N*logK).
     * - Space complexity: (K) for priority queue.
     */
    private static int approach1(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : arr) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }

    /**
     * Approach 2 - Bruteforce
     * - The approach is the simplest here.
     * - We are just sorting the whole array in non-decreasing or ascending order using built-in sort function.
     * - At last, we just have to return the element at (N - K) index, N is array length and K is provided.
     * - Time complexity: O(N*logN) due to the sort method that uses Dual-Pivot QuickSort.
     * - Space complexity: O(logN) as QuickSort is an in-place sorting algorithm but uses recursion stack of logN.
     */
    private static int approach2(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }

}