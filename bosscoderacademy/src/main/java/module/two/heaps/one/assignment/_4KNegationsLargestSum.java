package module.two.heaps.one.assignment;

import java.util.PriorityQueue;

/**
 * Largest Sum After K Negations:
 * <p>
 * Given an integer array nums and an integer k, modify the array in the following way:
 * choose an index i and replace nums[i] with -nums[i].
 * <p>
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 * Return the largest possible sum of the array after modifying it in this way.
 * <p>
 * Input: nums = [4,2,3], k = 1
 * Output: 5
 * Explanation: Choose index 1 and nums becomes [4,-2,3].
 * <p>
 * Input: nums = [3,-1,0,2], k = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 */
public class _4KNegationsLargestSum {

    public static void main(String[] args) {
        printLargestSumAfterKNegations(new int[]{4, 2, 3}, 1);
        printLargestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
    }

    /**
     * Approach:
     * - The approach is quite simple using PriorityQueue.
     * - We have to add all elements in the min heap based priority queue first.
     * - Then we have to iterate over queue exactly K times.
     * - While iterating we have to remove top element, negate it and add it again in the queue.
     * - After K iterations, just calculate the sum of all queue elements by iterating over it.
     * - And at last, just return the final answer.
     * - Time complexity: O(N) add all elements in queue + O(K) iterating over queue K times + O(N) iterating over queue = O(N)
     * - Space complexity: O(N) due to priority queue.
     */
    private static void printLargestSumAfterKNegations(int[] nums, int k) {
        int largestSum = 0;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int num : nums) {
            minPQ.add(num);
        }
        while (k > 0) {
            int top = minPQ.remove();
            int negation = top * -1;
            minPQ.add(negation);
            k--;
        }
        while (!minPQ.isEmpty()) {
            largestSum += minPQ.remove();
        }
        System.out.println("Largest sum after " + k + " negations is " + largestSum);
    }

}