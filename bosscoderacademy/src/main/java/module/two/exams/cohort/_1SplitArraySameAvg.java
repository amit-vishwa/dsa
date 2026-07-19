package module.two.exams.cohort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.IntStream;

// Refer https://leetcode.com/problems/split-array-with-same-average/
public class _1SplitArraySameAvg {

    public static void main(String[] args) {
        printIfSplitArrSameAvgPossible(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        printIfSplitArrSameAvgPossible(new int[]{3, 1});
    }

    private static void printIfSplitArrSameAvgPossible(int[] nums) {
        System.out.println("Split array have same average by approach1: " + approach1(nums));
        System.out.println("Split array have same average by approach2: " + approach2(nums));
        System.out.println("Split array have same average by approach3: " + approach3(nums));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is the bruteforce and easy to understand approach.
     * - Here, we are using a simple recursion approach.
     * - We are calculating the total first, then iterating over the array n-1 times.
     * - Now, checking if (total * k) is divisible by array length, if not skip.
     * - Else, proceed with calculating the target and explore dfs.
     * - In dfs, we are checking if k is 0, then returning if total is 0, return true false accordingly.
     * - Else, we are checking index >= nums.length, return false if true.
     * - Now, proceed with take and not take approach and return true false accordingly.
     * - Time complexity: O(2^N) due to skip and not skip choices.
     * - Space complexity: O(N) due to recursion depth.
     */
    private static boolean approach1(int[] nums) {
        int n = nums.length;
        int total = IntStream.of(nums).sum();
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);
        for (int k = 1; k < n; k++) {
            if ((total * k) % n != 0) {
                continue;
            }
            int target = (total * k) / n;
            if (dfs(arr, 0, k, target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int[] arr, int index, int k, int target) {
        if (k == 0) {
            return target == 0;
        }
        if (index >= arr.length) {
            return false;
        }
        if (target >= arr[index]) {
            if (dfs(arr, index + 1, k - 1, target - arr[index])) {
                return true;
            }
        }
        return dfs(arr, index + 1, k, target);
    }

    /**
     * Approach 2:
     * - This is similar to approach 1, but here we are using memoization to reduce time complexity.
     * - Time complexity: O(N) for array * O(K) for k * O(target) for total = O(N*N*Sum).
     * - Space complexity: O(N^2 * Sum) similar to TC.
     */
    private static boolean approach2(int[] nums) {
        int n = nums.length, t = IntStream.of(nums).sum();
        int[] arr = IntStream.of(nums).sorted().toArray();
        for (int k = 1; k < n; k++) {
            if ((t * k) % n != 0) {
                continue;
            }
            int target = (t * k) / n;
            if (memoization(arr, 0, k, target, new HashMap<>())) {
                return true;
            }
        }
        return false;
    }

    private static boolean memoization(int[] arr, int index, int k, int target, HashMap<String, Boolean> dp) {
        if (k == 0) {
            return target == 0;
        }
        if (index >= arr.length) {
            return false;
        }
        String key = index + "," + k + "," + target;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (target >= arr[index]) {
            if (memoization(arr, index + 1, k - 1, target - arr[index], dp)) {
                dp.put(key, true);
                return true;
            }
        }
        boolean res = memoization(arr, index + 1, k, target, dp);
        dp.put(key, res);
        return dp.get(key);
    }

    /**
     * Approach 3:
     * - This is better than both approach because we are reducing recursion stack here.
     * - Logic is simple, we are creating the dp set first then doing the same process using dp list.
     * - Time and space complexity is similar to approach 2, only recursion is reduced.
     */
    private static boolean approach3(int[] nums) {
        int n = nums.length, total = IntStream.of(nums).sum();
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(0).add(0);
        for (int num : nums) {
            for (int i = n - 1; i >= 1; i--) {
                for (int prevSum : dp.get(i - 1)) {
                    dp.get(i).add(prevSum + num);
                }
            }
        }
        for (int k = 1; k < n; k++) {
            if ((total * k) % n == 0) {
                continue;
            }
            int target = (total * k) / n;
            if (dp.get(k).contains(target)) {
                return true;
            }
        }
        return false;
    }

}
