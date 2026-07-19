package module.two.heaps.two.notes;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Nearly sorted:
 * <p>
 * Given an array of n elements, where each element is at most k away from its target position, you need to sort the array
 * optimally.
 * <p>
 * Example
 * Input: n = 7, k = 3 arr[] = {6,5,3,2,8,10,9}
 * Output: 2 3 5 6 8 9 10
 */
public class _2NearlySorted {

    public static void main(String[] args) {
        printSortedArray(new int[]{6, 5, 3, 2, 8, 10, 9}, 3);
    }

    private static void printSortedArray(int[] arr, int k) {
        System.out.println("Sorted array by approach 1: " + Arrays.toString(approach1(Arrays.copyOf(arr, arr.length))));
        System.out.println("Sorted array by approach 2: " + Arrays.toString(approach2(Arrays.copyOf(arr, arr.length), k)));
        System.out.println("Sorted array by approach 3: " + Arrays.toString(approach3(arr, k)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach using insertion sort.
     * - Insertion sort works best with partially sorted arrays.
     * - Time complexity: O(N^2) for worst case and O(N) for best case
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        return arr;
    }

    // Approach 2 - Same as approach 1, only here will process for K elements
    private static int[] approach2(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > Math.max(0, i - k) && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        return arr;
    }

    /**
     * Approach 3 - Optimized
     * - We are using heap here to sort the data at distance K.
     * - We are first storing the K+1 elements in the Heap.
     * - Then we are storing rest of the elements as well in the Heap.
     * - But before storing each element we are updating the array with correct elements.
     * - After adding rest of the elements in the heap, we are iterating over it to add elements in array at correct index.
     * - Time complexity: O(M) for iterating over the array in parts * O(log(K)) for insertion and removal in heap = O(M*log(K))
     * - Space complexity: O(K) as only K elements will be present at a time in Heap.
     */
    private static int[] approach3(int[] arr, int k) {
        int size = (arr.length == k) ? k : k + 1;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        // add only k or k + 1 elements in heap
        for (int i = 0; i < size; i++) {
            minPQ.add(arr[i]);
        }
        int index = 0;
        // update k array elements and add new remaining elements in heap
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minPQ.remove();
            minPQ.add(arr[i]);
        }
        // empty the queue and update the array
        while (!minPQ.isEmpty()) {
            arr[index++] = minPQ.remove();
        }
        return arr;
    }

}
