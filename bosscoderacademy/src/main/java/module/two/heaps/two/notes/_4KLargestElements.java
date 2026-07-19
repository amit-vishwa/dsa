package module.two.heaps.two.notes;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * K largest element:
 * Given an array, Arr of N positive integers and an integer K, find K largest elements from the array.
 * The output elements should be printed in decreasing order.
 * <p>
 * Example
 * Input: N = 5, K = 2 Arr[] = {12, 5, 787, 1, 23}
 * <p>
 * Output: 787 23
 */
public class _4KLargestElements {

    public static void main(String[] args) {
        printKLargestElements(new int[]{12, 5, 787, 1, 23}, 2);
        printKLargestElements(new int[]{12, 5, 787, 1, 23}, 5);
    }

    private static void printKLargestElements(int[] arr, int k) {
        System.out.println(k + " largest elements by approach 1: " + Arrays.toString(approach1(Arrays.copyOf(arr, arr.length), k)));
        System.out.println(k + " largest elements by approach 2: " + Arrays.toString(approach2(arr, k)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - Here, we are sorting the array first then storing the result in array.
     * - After that, we are just returning the result array.
     * - Time complexity: O(N*log(N)) due to sorting logic
     * - Space complexity: O(N) due to merge sort
     */
    private static int[] approach1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        int n = arr.length;
        for (int i = n - 1; i >= 0 && k > 0; i--, k--) {
            res[n - 1 - i] = arr[i];
        }
        return res;
    }

    /**
     * Approach 2 - Optimized
     * - This is an optimized approach using Heaps.
     * - We are first storing all elements in min heap based priority queue.
     * - When heap size becomes greater than K, then just remove the top element i.e. smallest one.
     * - Then iterating over queue till K times and removing the top and storing in result array in reverse order.
     * - At last, just return the result array.
     * - Time complexity: O(N) to iterate over array * O(log(K)) due to insertion in heap
     * - Space complexity: O(K) as at max K elements will be there in Heap.
     */
    private static int[] approach2(int[] arr, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int num : arr) {
            minPQ.offer(num);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minPQ.poll();
        }
        return res;
    }

}
