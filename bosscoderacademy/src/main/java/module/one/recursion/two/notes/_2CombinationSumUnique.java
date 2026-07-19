package module.one.recursion.two.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum Unique:
 * <p>
 * Given a collection of candidates, numbers (candidates), and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to the target. Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * <p>
 * Example
 * Input: n=7 candidates = [10,1,2,7,6,1,5], target = 8
 * Output: [ [1,1,6], [1,2,5], [1,7], [2,6] ]
 */
public class _2CombinationSumUnique {

    public static void main(String[] args) {
        System.out.println(combinations(new int[]{10, 1, 2, 7, 6, 1, 5}, 7, 8));
        System.out.println(combinations(new int[]{1, 1, 1, 2, 2}, 5, 4));
    }

    /**
     * Approach:
     * - The approach is similar to finding the subsets of given array.
     * - Here, we are calculating the subsets and checking whether its sum is equal to target to get combination sum.
     * - We are iterating over the array for each element we are checking if it is equal to previous then skip it.
     * - Also, it current element it greater than target then termite permutation finding process for the same.
     * - After than we can simply proceed with finding the permutation and backtracking.
     * - Time complexity: O(N) for looping given array * O(2^T) for calculating subset whose sum is target = O(N*2^T)
     * - Space complexity: O(T) for recursion stack, O(N*2T) for array list.
     */
    private static List<List<Integer>> combinations(int[] candidates, int n, int target) {
        Arrays.sort(candidates);
        return helper(candidates, n, target, 0, new ArrayList<>());
    }

    private static List<List<Integer>> helper(int[] candidates, int n, int target, int index, List<Integer> combination) {
        if (target == 0) {
            return new ArrayList<>(List.of(new ArrayList<>(combination)));
        }
        List<List<Integer>> combinationList = new ArrayList<>();
        for (int i = index; i < n; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            combination.add(candidates[i]);
            combinationList.addAll(helper(candidates, n, target - candidates[i], i + 1, combination));
            combination.removeLast();
        }
        return combinationList;
    }

}
