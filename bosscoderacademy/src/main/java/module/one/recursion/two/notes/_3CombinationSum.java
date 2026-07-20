package module.one.recursion.two.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum: [Leetcode 39. Combination Sum]
 * <p>
 * Given an array of distinct integer candidates and a target integer target, return a list of all unique combinations of
 * candidates where the chosen numbers sum to the target. You may return the combinations in any order. The same number may be
 * chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the
 * chosen numbers is different.
 * <p>
 * Example
 * Input: n=4, candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class _3CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinations(new int[]{2, 3, 6, 7}, 7, 4, 0, new ArrayList<>()));
    }

    /**
     * Approach:
     * - We have an index starting with 0 on candidates array.
     * - If candidate element is less than or equal to target, then explore permutation for that element.
     * - Reduce candidate element from target but do not increase the index now, then again backtrack.
     * - Else, explore permutation without considering the candidate element that is do not reduce target, just increase index.
     * - When index is equal to array length and if target is 0 then we got our combination sum, else return empty list.
     * - Time complexity: O(N) for loop * O(2^T) for subsets of find combination sum = O(N* 2^T)
     * - Space complexity: O(T) for recursion stack.
     */
    private static List<List<Integer>> combinations(int[] candidates, int target, int n, int index, List<Integer> combination) {
        if (index == n) {
            if (target == 0) {
                return new ArrayList<>(List.of(new ArrayList<>(combination)));
            }
            return new ArrayList<>();
        }
        List<List<Integer>> combinationList = new ArrayList<>();
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            combinationList.addAll(combinations(candidates, target - candidates[index], n, index, combination));
            combination.removeLast();
        }
        combinationList.addAll(combinations(candidates, target, n, index + 1, combination));
        return combinationList;
    }

}
