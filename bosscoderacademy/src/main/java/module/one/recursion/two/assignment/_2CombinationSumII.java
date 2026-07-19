package module.one.recursion.two.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 40. Combination Sum II
 * Refer: https://leetcode.com/problems/combination-sum-ii/description/
 */
public class _2CombinationSumII {

    public static void main(String[] args) {
        printCombinations(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        printCombinations(new int[]{2, 5, 2, 1, 2}, 5);
    }

    private static void printCombinations(int[] combinations, int target) {
        Arrays.sort(combinations);
        System.out.println(combinationList(combinations, target, 0, new ArrayList<>()));
    }

    /**
     * Approach:
     * - The first step is to sort the array.
     * - Then proceed with taking elements from combinations array.
     * - If index is smaller than i then check if current and previous elements are same.
     * - Skip that element if it is similar to previous one as we want distinct elements only.
     * - If current element is greater than target then break the loop, we don't want to proceed with this element.
     * - Now first add element in our result, then explore the solution by reducing target and updating index.
     * - If target is 0 then we got our combination and then after that just backtrack.
     * - Time complexity: O(N*logN) for sorting + O(N) for loop * O(2^T) for subset combination = O(N*2^T), T is the target
     * - Space complexity: O(N*2T) for recursive stack
     */
    private static List<List<Integer>> combinationList(int[] combinations, int target, int index, List<Integer> res) {
        if (target == 0) {
            return new ArrayList<>(List.of(new ArrayList<>(res)));
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = index; i < combinations.length; i++) {
            if (i > index && combinations[i] == combinations[i - 1]) {
                continue;
            }
            if (combinations[i] > target) {
                break;
            }
            res.add(combinations[i]);
            resList.addAll(combinationList(combinations, target - combinations[i], i + 1, res));
            res.removeLast();
        }
        return resList;
    }

}