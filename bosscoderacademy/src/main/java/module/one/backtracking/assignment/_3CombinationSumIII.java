package module.one.backtracking.assignment;

import java.util.List;
import java.util.ArrayList;

/**
 * LeetCode 216. Combination Sum III
 * Refer: https://leetcode.com/problems/combination-sum-iii/description/
 */
public class _3CombinationSumIII {

    public static void main(String[] args) {
        printCombinations(3, 7);
        printCombinations(3, 9);
        printCombinations(4, 1);
    }

    private static void printCombinations(int k, int n) {
        System.out.println(combinationSum(k, n, 1, new ArrayList<>()));
    }

    /**
     * Approach:
     * - The approach is similar to other combination sum problems mostly combination sum II problems.
     * - The only constraint added here is we have numbers from 1 to 9 only.
     * - So time and space complexity will be constant here.
     * - Time complexity: O(2^(9)) i.e. O(2^K) similar to other combination or subset problems.
     * - Space complexity: O(9) i.e. O(K) for recursion stack.
     */
    private static List<List<Integer>> combinationSum(int k, int target, int index, List<Integer> combination) {
        if (combination.size() == k) {
            return target == 0 ? new ArrayList<>(List.of(new ArrayList<>(combination))) : new ArrayList<>();
        }
        List<List<Integer>> combinationList = new ArrayList<>();
        for (int i = index; i <= 9; i++) {
            if (i <= target) {
                combination.add(i);
                combinationList.addAll(combinationSum(k, target - i, i + 1, combination));
                combination.removeLast();
            }
        }
        return combinationList;
    }

}