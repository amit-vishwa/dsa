package module.two.exams.one;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array:
 * <p>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * <p>
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * Refer: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class _4KthLargestElement {

    public static void main(String[] args) {
        printKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2);
        printKthLargestElement(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    private static void printKthLargestElement(int[] nums, int k) {
        System.out.println("Kth largest element by approach 1: " + approach1(nums, k));
        System.out.println("Kth largest element by approach 2: " + approach2(nums, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach using sorting.
     * - We have applied merge sort here, then just returned the Kth largest element.
     * - Time complexity: O(N*log(N)) due to merge sort.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr, int k) {
        int[] nums = mergeSort(arr);
        return nums[nums.length - k];
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int m = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int n = left.length, m = right.length, i = 0, j = 0, k = 0;
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            merged[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
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
     * Approach 2 - Optimized
     * - This is better solution than the bruteforce one.
     * - Here, we are using a priority queue.
     * - We are keep on adding the elements in the queue and if size is greater than K, the just remove the top.
     * - In this way, at last we are left with Kth largest element on top.
     * - Time complexity: O(N) as we are iterating over the array once * O(log(K)) due to insertion in queue = O(N*log(K))
     * - Space complexity: O(K) due to priority queue.
     */
    private static int approach2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

}
