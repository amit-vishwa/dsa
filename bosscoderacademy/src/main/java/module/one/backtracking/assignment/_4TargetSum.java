package module.one.backtracking.assignment;

/**
 * LeetCode 494. Target Sum
 * Refer: https://leetcode.com/problems/target-sum/description/
 */
public class _4TargetSum {

    public static void main(String[] args) {
        printCount(new int[]{1, 1, 1, 1, 1}, 3);
        printCount(new int[]{1}, 1);
    }

    private static void printCount(int[] nums, int target) {
        System.out.println("Expressions count: " + expressionCount(nums, target, 0));
    }

    /**
     * Approach:
     * - This mostly deals with recursion only, no proper backtracking is used but can be implemented easily using this only.
     * - The approach is simple, we just have to iterate the array from 0 till end.
     * - Try exploring by reducing the element from target i.e. adding '+' in front of it.
     * - Then try exploring by adding the element to target i.e. adding '-' in front of it.
     * - When index is nums length then we got one expression so return count as 1 when target is 0 else return 0.
     * - Time complexity: O(2^N) as we have two choices here for getting the expression count.
     * - Space complexity: O(N) for recursion stack.
     */
    private static int expressionCount(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int count = expressionCount(nums, target - nums[index], index + 1);
        count += expressionCount(nums, target + nums[index], index + 1);
        return count;
    }

}