package module.two.queues.assignment;

import java.util.Deque;
import java.util.Arrays;
import java.util.ArrayDeque;

// Refer _3SlidingWindowMaximum.java from package module.two.queues.lecture;
public class _1SlidingWindowMaximum {

    public static void main(String[] args) {
        printMaximumWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        printMaximumWindow(new int[]{1}, 1);
    }

    private static void printMaximumWindow(int[] nums, int k) {
        System.out.println("Sliding window maximum by approach 1: " + Arrays.toString(approach1(nums, k)));
        System.out.println("Sliding window maximum by approach 2: " + Arrays.toString(approach2(nums, k)));
        System.out.println();
    }

    private static int[] approach1(int[] nums, int k) {
        int n = nums.length;
        int[] maxWindow = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            maxWindow[i] = max;
        }
        return maxWindow;
    }

    private static int[] approach2(int[] nums, int k) {
        int n = nums.length;
        int[] maxWindow = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove indices that are out of bound
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // add nums[i]
            deque.offerLast(i);
            // add to result
            if (i >= k - 1 && !deque.isEmpty()) {
                maxWindow[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return maxWindow;
    }

}