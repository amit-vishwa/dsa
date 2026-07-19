package module.two.queues.lecture;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Sliding Window Maximum:
 * <p>
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
 * to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * <p>
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class _3SlidingWindowMaximum {

    public static void main(String[] args) {
        printMaxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        printMaxSlidingWindow(new int[]{1}, 1);
    }

    private static void printMaxSlidingWindow(int[] nums, int k) {
        System.out.println("Max sliding window by approach 1: " + approach1(nums, k));
        System.out.println("Max sliding window by approach 2: " + approach2(nums, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce:
     * - This is simple bruteforce approach.
     * - Here, we are iterating from 0 to array length - k.
     * - We are keeping the max as first element, then calculating max from that index to index + k.
     * - After that we are just adding the max to the result list.
     * - Time complexity: O(N) for outer loop * O(K) for inner loop = O(N*K)
     * - Space complexity: O(1) not including the resulting array.
     */
    private static ArrayList<Integer> approach1(int[] nums, int k) {
        ArrayList<Integer> maxSlidingWindow = new ArrayList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxSlidingWindow.add(max);
        }
        return maxSlidingWindow;
    }

    /**
     * Approach 2 - Optimal
     * - This is more optimal solution than the bruteforce one.
     * - Here, we are using array deque to keep track of max elements in K size window.
     * - We are iterating over the array and for each element we are performing some steps.
     * - First check if deque is empty and first right element of deque is less than or equal to index - k.
     * - Until the above condition is true, just keep on removing the elements from right of the deque.
     * - Then keep on removing elements from left if array at left index is less than or equal to current element.
     * - After while loop ends, just add index at left most side of the deque.
     * - Now, if index is greater than or equal window size i.e. k - 1, then just add right indexed deque element to result list.
     * - At last, after iterating over the array, just return the result.
     * - Time complexity: O(N) as we are iterating the array only once.
     * - Space complexity: O(K) due to deque of K size.
     */
    private static ArrayList<Integer> approach2(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> maxSlidingWindow = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                maxSlidingWindow.add(nums[deque.peekFirst()]);
            }
        }
        return maxSlidingWindow;
    }

}
