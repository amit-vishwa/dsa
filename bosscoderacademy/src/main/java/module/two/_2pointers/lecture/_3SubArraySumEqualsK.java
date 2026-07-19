package module.two._2pointers.lecture;

import java.util.HashMap;

/**
 * LeetCode 560. Subarray Sum Equals K
 * Refer: https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class _3SubArraySumEqualsK {

    public static void main(String[] args) {
        printSubArrayCount(new int[]{1, 1, 1}, 2);
        printSubArrayCount(new int[]{1, 2, 3}, 3);
    }

    private static void printSubArrayCount(int[] nums, int k) {
        System.out.println("Sub array count by approach 1: " + approach1(nums, k));
        System.out.println("Sub array count by approach 2: " + approach2(nums, k));
        System.out.println("Sub array count by approach 3: " + approach3(nums, k));
        System.out.println("Sub array count by approach 4: " + approach4(nums, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the worst bruteforce approach.
     * - Here, we are finding all the subsets using XOR logic.
     * - And while finding the subset, we are calculating the sum.
     * - If sum of subset is equal to k, then increase the counter.
     * - Time complexity: O(2^N) for outer loop * O(N) for inner sum = O(N*(2^N))
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach1(int[] nums, int k) {
        int count = 0;
        for (int bits = 0; bits < 1 << nums.length; bits++) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((bits & (1 << i)) > 0) {
                    sum += nums[i];
                }
            }
            if (sum == k) {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach 2 - Better Bruteforce
     * - This is the bruteforce approach better than above.
     * - Here, we are finding all the subsets using loops.
     * - And while finding the subset, we are calculating the sum.
     * - If sum of subset is equal to k, then increase the counter.
     * - Time complexity: O(N^3) for 3 loops, the first 2 will decide the start and end index and 3rd is for summing elements.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int x = i; x <= j; x++) {
                    sum += nums[x];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Approach 3 - Better approach
     * - This is better approach than the bruteforce one.
     * - Here, we are using the prefix sum logic to calculate the sum instead of iterating over the loop.
     * - This saves extra O(N) time complexity.
     * - Time complexity: O(N^2) for 2 loops.
     * - Space compelxity: O(N) due to prefix sum array.
     */
    private static int approach3(int[] nums, int k) {
        int count = 0, n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j] - prefix[i] + nums[i];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Approach 4 - Optimal approach
     * - This is the most optimal approach here.
     * - We are using the HashMap to store the prefix sum and its count.
     * - We are initializing the count and prefix values, then adding a 0 prefix sum with count value as 1.
     * - Then iterating over the array and in prefix we are adding the current element to get prefix sum.
     * - Now, we are checking the complement value, if it is there in the map then incrementing the sub array count.
     * - Also, we are adding the prefix sum value in the map by adding or incrementing its count if it is already there.
     * - Time complexity: O(N) as array is traversed only once.
     * - Space complexity: O(N) due to hashmap.
     */
    private static int approach4(int[] nums, int k) {
        int count = 0, prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefix += num;
            int complement = prefix - k;
            if (map.containsKey(complement)) {
                count++;
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

}
