package module.two.heaps.two.notes;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maximum possible difference of two subsets of an array of size k:
 * <p>
 * Given an array of n-integers. Find the Maximum possible difference between two subsets of an array of size k.
 * <p>
 * Example
 * Input: arr[] = {5, 8, -1, 4} , k=2
 * Output: Maximum Difference = 10
 * <p>
 * Approach:
 * - The approach is quite simple.
 * - We just have to insert elements in max and min heap based priority queues.
 * - We have to sum all the K largest and the K smallest elements using heap.
 * - Then we have to calculate the difference of largest and smallest to get the answer.
 * - Time complexity: O(N) as we are iterating over the array * O(log(K)) as inserting only K elements in queue = O(N*log(K))
 * - Space complexity: O(K) as heap will store only K elements.
 **/
public class _5MaxDiffKSizeSubsets {

    public static void main(String[] args) {
        printMaxDiff(new int[]{5, 8, -1, 4}, 2);
    }

    private static void printMaxDiff(int[] arr, int k) {
        int kSizeMaxSubsetSum = maxSubsetSum(arr, k);
        int kSizeMinSubsetSum = minSubsetSum(arr, k);
        int maxDiff = kSizeMaxSubsetSum - kSizeMinSubsetSum;
        System.out.println("Maximum possible difference between two subsets of an array of size " + k + " is " + maxDiff);
    }

    private static int maxSubsetSum(int[] arr, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int num : arr) {
            minPQ.offer(num);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        int sum = 0;
        while (!minPQ.isEmpty()) {
            sum += minPQ.poll();
        }
        return sum;
    }

    private static int minSubsetSum(int[] arr, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
            maxPQ.add(num);
            if (maxPQ.size() > k) {
                maxPQ.remove();
            }
        }
        int sum = 0;
        while (!maxPQ.isEmpty()) {
            sum += maxPQ.remove();
        }
        return sum;
    }

}
