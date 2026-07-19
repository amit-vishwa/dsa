package module.one.recursion.one.assignment;

import java.util.*;

/**
 * Permutations: [Leetcode 46. Permutations]
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class _1Permutations {

    public static void main(String[] args) {
        printPermutations(new int[]{1, 2, 3});
        printPermutations(new int[]{0, 1});
    }

    private static void printPermutations(int[] nums) {
        System.out.println("Permutations by approach 1: " + approach1(nums));
        System.out.println("Permutations by approach 2: " + approach2(nums));
        System.out.println("Permutations by approach 3: " + approach3(nums));
        System.out.println("Permutations by approach 4: " + approach4(nums));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple, here we are swapping the indexes to find all the permutations.
     * - Here, we are first checking if index is equal to array length, if yes then we got our permutation.
     * - We have to iterate from index to array length.
     * - We have to swap index and i, then explore permutation and then backtrack by swapping back.
     * - After completing the loop, we will be having all the permutations.
     * - Time complexity: O(N) for loop * O(N!) for finding permutation = O(N*N!)
     * - Space complexity: O(N) for recursion stack
     */
    private static List<List<Integer>> approach1(int[] nums) {
        return helper1(nums, 0);
    }

    private static List<List<Integer>> helper1(int[] nums, int index) {
        if (index == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(Arrays.stream(nums).boxed().toList())));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            permutationList.addAll(helper1(nums, index + 1));
            swap(nums, i, index);
        }
        return permutationList;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Approach 2:
     * - The approach is simple, here we are calculating permutation by exploring each indexes.
     * - Here, we are first checking if permutation length is equal to array length, if yes then we got our permutation.
     * - We have to iterate from index 0 to array length.
     * - We are first checking if permutations contain index, if we have already explored that, if not then get permutations.
     * - Now we are adding the index, then exploring permutation and then backtracking by removing index.
     * - After completing the loop, we will be having all the permutations.
     * - Time complexity: O(N) for loop * O(N) for contains method * O(N!) for finding permutation = O(N*N*N!)
     * - Space complexity: O(N) for recursion stack
     */
    private static List<List<Integer>> approach2(int[] nums) {
        return helper2(nums, new ArrayList<>());
    }

    private static List<List<Integer>> helper2(int[] nums, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int num : nums) {
            if (!permutation.contains(num)) {
                permutation.add(num);
                permutationList.addAll(helper2(nums, permutation));
                permutation.removeLast();
            }
        }
        return permutationList;
    }

    /**
     * Approach 3:
     * - The approach is similar to approach 2 only.
     * - Here we are using boolean array to check if element is already visited to calculate permutations.
     * - This reduces the time complexity to O(N*N!) and increases space by O(N+N) i.e. recursion and boolean array.
     */
    private static List<List<Integer>> approach3(int[] nums) {
        return helper3(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    private static List<List<Integer>> helper3(int[] nums, List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(nums[i]);
                permutationList.addAll(helper3(nums, permutation, visited));
                permutation.removeLast();
                visited[i] = false;
            }
        }
        return permutationList;
    }

    /**
     * Approach 4:
     * - This is another approach where we are using set instead of boolean array to mark index element as visited.
     * - The time and space complexity is similar to approach 3;
     */
    private static List<List<Integer>> approach4(int[] nums) {
        return helper4(nums, new ArrayList<>(), new HashSet<>());
    }

    private static List<List<Integer>> helper4(int[] nums, List<Integer> permutation, HashSet<Integer> set) {
        if (permutation.size() == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                permutation.add(nums[i]);
                ans.addAll(helper4(nums, permutation, set));
                permutation.removeLast();
                set.remove(nums[i]);
            }
        }
        return ans;
    }

}