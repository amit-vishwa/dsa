package module.one.recursion.one.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets: [Leetcode 78. Subsets]
 * <p>
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class _2Subsets {

    public static void main(String[] args) {
        printSubsets(new int[]{1, 2, 3});
        printSubsets(new int[]{0});
    }

    private static void printSubsets(int[] nums) {
        System.out.println("Subsets by approach 1: " + approach1(nums));
        System.out.println("Subsets by approach 2: " + approach2(nums));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple where are using iteration to find the subsets of given array.
     * - We are iterating over the array and calculating the subset by reiterating again.
     * - Time complexity: O(N) for outer loop * O(2^N) for inner loop to calculate subset = O(N*2^N)
     * - Space complexity: O(1) as no extra space is used, we are using list for output, else total space is O(N*2^N).
     */
    private static List<List<Integer>> approach1(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i));
                subset.add(num);
                subsets.add(subset);
            }
        }
        return subsets;
    }

    /**
     * Approach 2:
     * - This is an alternative approach to approach 1.
     * - Here we are working with bits to calculate all the subsets.
     * - We are first creating the mask and checking bits of all elements.
     * - If AND operation is not 0, then that element can be added in subset.
     * - After iterating elements, we are adding all the subsets.
     * - Time complexity: O(2^N) for creating masks for all subsets * O(N) for iterating array elements to check if bits are
     * set then those elements can be added in current subset = O(2^N * N)
     * - Space complexity: similar to approach 1.
     */
    private static List<List<Integer>> approach2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    subset.add(nums[i]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

}