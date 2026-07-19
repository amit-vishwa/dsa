package module.two._2pointers.lecture;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 1. Two Sum
 * Refer: https://leetcode.com/problems/two-sum/description/
 */
public class _2TwoSumUnsorted {

    public static void main(String[] args) {
        printIndices(new int[]{2, 7, 11, 15}, 9);
        printIndices(new int[]{3, 2, 4}, 6);
        printIndices(new int[]{3, 3}, 6);
        printIndices(new int[]{9, 3, 3}, 6);
        printIndices(new int[]{6, 2, 0, 1}, 6);
    }

    private static void printIndices(int[] nums, int target) {
        System.out.println("Two sum unsorted indices by approach 1: " + Arrays.toString(approach1(nums, target)));
        System.out.println("Two sum unsorted indices by approach 2: " + Arrays.toString(approach2(nums, target)));
        System.out.println("Two sum unsorted indices by approach 3: " + Arrays.toString(approach3(nums, target)));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - The bruteforce approach is simple.
     * - Just iterate over the array and for each element check the sum from next element.
     * - If sum is equal to target then return the indices, else proceed.
     * - Time complexity: O(N^2) due to nest loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach1(int[] nums, int target) {
        int[] indices = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    /**
     * Approach 2 - Better approach
     * - This approach is better than the bruteforce approach.
     * - Here, we are using a map and trying to store the element as key and its index as value.
     * - We are first checking if complement of target already exist in map.
     * - Return the map value as index and current index value as indices of two sum.
     * - Else simply add element and index.
     * - Time complexity: O(N) for iterating over the array.
     * - Space complexity: O(N) as we are storing the elements in a map.
     */
    private static int[] approach2(int[] nums, int target) {
        int[] indices = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                indices[0] = map.get(target - nums[i]);
                indices[1] = i;
                return indices;
            }
            map.put(nums[i], i);
        }
        return indices;
    }

    /**
     * Approach 3 - Optimal approach
     * - This is the most optimal solution.
     * - Here, we are using the 2 pointers approach.
     * - The pointers are placed at first 2 elements, if their sum is equal to the target then return indices.
     * - If first pointer element is greater than target or sum of both pointers is less than target then increment first pointer.
     * - At last, just increment second pointer.
     * - Repeat the process until second pointer traverses the array.
     * - Time complexity: O(N) as we are traversing the array only once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int[] approach3(int[] nums, int target) {
        int[] indices = {-1, -1};
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] + nums[j] == target) {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
            if (nums[i] > target || nums[i] + nums[j] < target) {
                i++;
            }
            j++;
        }
        return indices;
    }

}
