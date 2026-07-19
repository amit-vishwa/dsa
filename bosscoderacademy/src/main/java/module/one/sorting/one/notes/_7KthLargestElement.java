package module.one.sorting.one.notes;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in Array:
 * <p>
 * Given an integer array nums and an integer k, return the kth the largest element in the array. Note that it is the kth the
 * largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example
 * Input: nums = [3, 2, 1, 5, 6, 4], k = 2
 * Output: 5
 */
public class _7KthLargestElement {

    public static void main(String[] args) {
        printKthLargestElement(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    private static void printKthLargestElement(int[] arr, int k) {
        System.out.println(k + "th largest element by approach 1: " + approach1(arr, k));
        System.out.println(k + "th largest element by approach 2: " + approach2(arr, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple approach is to sort the array and then check the Kth largest element.
     * - Sort the array in non-decreasing or ascending order.
     * - Then return the N-K index to get the Kth largest element.
     * - Time complexity: O(N*logN) as we are sorting the using sorted in stream.
     * - Space complexity: O(N) as we are not performing in-place sorting here, can be reduced to O(1).
     */
    private static int approach1(int[] arr, int k) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        return sorted[sorted.length - k];
    }

    /**
     * Approach 2 - Better
     * - We are using a Priority Queue here that stores the Kth element.
     * - The approach is simple, we are adding element in priority queue first then checking is size is greater than K.
     * - If size is greater, then remove the root element by calling poll(), else do nothing.
     * - Repeat the process until whole array is traversed.
     * - At last, the Kth largest element will be there on top of priority queue, just return by calling peek().
     * - Time complexity: O(N) for traversing the array * log(K) for creating queue of size K = O(N*logK)
     * - Space complexity: O(K) for priority queue of size K.
     */
    private static int approach2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

}
