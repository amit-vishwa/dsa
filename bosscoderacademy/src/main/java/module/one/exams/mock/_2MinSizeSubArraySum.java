package module.one.exams.mock;

import java.util.ArrayDeque;
import java.util.Deque;

// Refer: https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=binary-search
public class _2MinSizeSubArraySum {

    public static void main(String[] args) {
        printMinSubArraySize(7, new int[]{2, 3, 1, 2, 4, 3});
        printMinSubArraySize(4, new int[]{1, 4, 4});
        printMinSubArraySize(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        printMinSubArraySize(11, new int[]{1, 2, 3, 4, 5});
        printMinSubArraySize(3, new int[]{2, -1, 2});
    }

    private static void printMinSubArraySize(int target, int[] nums) {
        System.out.println("Minimum sub array size whose sum is target by approach 1: " + approach1(target, nums));
        System.out.println("Minimum sub array size whose sum is target by approach 2: " + approach2(target, nums));
        System.out.println("Minimum sub array size whose sum is target by approach 3: " + approach3(target, nums));
        System.out.println();
    }

    // TC: O(N), SC: O(1)
    private static int approach1(int target, int[] nums) {
        int i = 0, sum = 0, n = nums.length, minSubArraySize = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                minSubArraySize = Math.min(j - i + 1, minSubArraySize);
                sum -= nums[i];
                i++;
            }
        }
        return minSubArraySize == Integer.MAX_VALUE ? 0 : minSubArraySize;
    }

    // TC: O(N * log(N)), SC: O(N)
    private static int approach2(int target, int[] nums) {
        int n = nums.length, minSize = Integer.MAX_VALUE;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int required = prefix[i] + target;
            int j = binarySearch(prefix, required);
            if (j != -1) {
                minSize = Math.min(minSize, j - i);
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    private static int binarySearch(int[] arr, int target) {
        int s = 0, e = arr.length - 1, result = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] >= target) {
                result = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return result;
    }

    // TC: O(N), SC: O(N)
    private static int approach3(int target, int[] nums) {
        int n = nums.length, minSize = Integer.MAX_VALUE;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= target) {
                minSize = Math.min(minSize, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

}
