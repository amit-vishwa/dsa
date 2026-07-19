package module.two.exams.milestone;

import java.util.Arrays;
import java.util.PriorityQueue;

// This is a new problem, and below is the correct-optimized solution.
public class _2KthLargestInStream {

    public static void main(String[] args) {
        System.out.println("Kth largest in a stream: " + Arrays.toString(kthLargestArray(new int[]{1, 2, 3, 4, 5, 6}, 4)));
        System.out.println("Kth largest in a stream: " + Arrays.toString(kthLargestArray(new int[]{3, 4}, 1)));
    }

    // TC: O(N* log(N)), SC: O(K)
    private static int[] kthLargestArray(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n];
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minPQ.offer(arr[i]);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
            res[i] = minPQ.size() < k ? -1 : minPQ.peek();
        }
        return res;
    }
}
