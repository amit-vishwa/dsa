package module.one.recursion.one.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations Ii: [Leetcode 47. Permutations II]
 * <p>
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * <p>
 * Input: nums = [1,1,2]
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * Approach:
 * - The approach is simple, we are using a boolean array to keep track of visited elements.
 * - When current element is already visited or index is greater than 0 and current previous elements are equal and previous
 * element is not visited that means we won't be getting a new permutation, so skip it.
 * - Else, just mark the index as visited and add current element in permutation list, then backtrack it.
 * - At last after completing the loop we will be having all the distinct permutations.
 * - Time complexity: O(N) for iterating over array * O(N!) for calculating permutations = O(N*N!)
 * - Space complexity: O(N) for recursion stack + O(N) for boolean array length = O(N+N) = O(N)
 */
public class _3PermutationsII {

    public static void main(String[] args) {
        System.out.println(permutations(new int[]{1, 1, 2}));
        System.out.println(permutations(new int[]{1, 2, 3}));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        Arrays.sort(nums);
        return helper(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    private static List<List<Integer>> helper(int[] nums, List<Integer> permutation, boolean[] visited) {
        if (permutation.size() == nums.length) {
            return new ArrayList<>(List.of(new ArrayList<>(permutation)));
        }
        List<List<Integer>> permutationList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            permutationList.addAll(helper(nums, permutation, visited));
            permutation.removeLast();
            visited[i] = false;
        }
        return permutationList;
    }

}