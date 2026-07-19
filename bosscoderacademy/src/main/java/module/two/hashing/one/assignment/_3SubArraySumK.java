package module.two.hashing.one.assignment;

import java.util.HashMap;

// Also refer _3SubArraySumEqualsK.java from package module.two._2pointers.lecture;
public class _3SubArraySumK {

    public static void main(String[] args) {
        printSubArrayCount(new int[]{1, 1, 1}, 2);
        printSubArrayCount(new int[]{1, 2, 3}, 3);
        printSubArrayCount(new int[]{1, 2, 3}, 4);
        printSubArrayCount(new int[]{1, 1, 1}, 1);
    }

    private static void printSubArrayCount(int[] nums, int k) {
        System.out.println("Sub array count by approach 1: " + approach1(nums, k));
        System.out.println("Sub array count by approach 2: " + approach2(nums, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the simple bruteforce approach using nested loops.
     * - For second loop, check the cumulative sum and if it is equal to K then increase the count.
     * - At last, just return the count.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] nums, int k) {
        int subArrayCount = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    subArrayCount++;
                }
            }
        }
        return subArrayCount;
    }

    /**
     * Approach 2 - Optimal
     * - This is similar to HashMap approach of _3SubArraySumEqualsK.java.
     */
    private static int approach2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            int complement = prefixSum - k;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}