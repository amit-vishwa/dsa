package module.two.exams.cohort;

import java.util.Deque;
import java.util.ArrayList;
import java.util.ArrayDeque;

// Refer _1SlidingWindowMaximum.java from package module.two.queues.assignment.
public class _4SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println("Max sliding window: " + maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        System.out.println("Max sliding window: " + maxSlidingWindow(new int[]{1}, 1));
    }

    private static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> maxSlidingWindow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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
