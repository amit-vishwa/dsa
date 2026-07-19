package module.two._2pointers.lecture;

import java.util.*;

/**
 * LeetCode 532. K-diff Pairs in an Array
 * Refer: https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 */
public class _4KDiffPairs {

    public static void main(String[] args) {
        printCount(new int[]{3, 1, 4, 1, 5}, 2);
        printCount(new int[]{1, 1, 3, 4, 5}, 2);
        printCount(new int[]{1, 2, 3, 4, 5}, 1);
        printCount(new int[]{1, 3, 1, 5, 4}, 0);
    }

    private static void printCount(int[] nums, int k) {
        System.out.println("The number of unique k-diff pairs count by approach 1: " + approach1(nums, k));
        System.out.println("The number of unique k-diff pairs count by approach 2: " + approach2(nums, k));
        System.out.println("The number of unique k-diff pairs count by approach 3: " + approach3(nums, k));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the simplest approach but still works properly on sorted array.
     * - We are simply using the nested loops and storing the pair in a hashset if found.
     * - Time complexity: O(N^2) for nested loops.
     * - Space complexity: O(N^2) as hashset can store all pairs.
     */
    private static int approach1(int[] nums, int k) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    set.add(new ArrayList<>(List.of(nums[i], nums[j])));
                }
            }
        }
        return set.size();
    }

    /**
     * Approach 2 - Better approach
     * - This is a better approach than the bruteforce one.
     * - Here, we are sorting the array then using the two pointers to count the pairs.
     * - Time complexity: O(N*logN) for sorting + O(N) for 2 pointers logic = O(N*logN)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] nums, int k) {
        int count = 0, i = 0, j = 1;
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        while (j < arr.length) {
            if (i == j) {
                j++; // both are same, increase window size
                continue; // skip further steps to check if j is a valid index
            }
            int diff = arr[j] - arr[i];
            if (diff == k) {
                count++;
                i++;
                j++;
            } else if (diff < k) {
                j++; // diff less, increase the window
            } else {
                i++; // diff more, decrease the window
            }
        }
        return count;
    }

    /**
     * Approach 3 - Optimal approach
     * - This is the most optimal solution.
     * - Here, we are using a hashmap to store the element with its occurrence count.
     * - Then iterating over the map and checking for k == 0, if occurrence count > 1 then increase the counter.
     * - Or for k > 0, if map contains key (k + currKey) then increase the counter.
     * - At last, just return the counter value completing map iteration.
     * - Time complexity: O(N) as we are iterating the array once, then iterating the map.
     * - Space complexity: O(N) due to hashmap.
     */
    private static int approach3(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // if k > 0, then (k + num) must be there in map, if k == 0 then duplicate elements should be there
            if ((k > 0 && map.containsKey(k + entry.getKey())) || (k == 0 && entry.getValue() > 1)) {
                count++;
            }
        }
        return count;
    }
}
