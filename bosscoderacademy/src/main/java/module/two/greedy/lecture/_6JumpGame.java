package module.two.greedy.lecture;

// Refer https://leetcode.com/problems/jump-game/description/
public class _6JumpGame {

    public static void main(String[] args) {
        System.out.println("Last index can be reached: " + canReachLastIndex(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Last index can be reached: " + canReachLastIndex(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * Approach:
     * - The approach is little tricky.
     * - We have to keep track of maximum reachable index.
     * - We have to iterate over the array and while iterating do some checks.
     * - If current index is out of reach, then return false.
     * - Else update max reachable index value.
     * - The maximum reachable index value is greater than or equal to last index, then just return true.
     * - At last, after traversal just return true.
     * - Time complexity: O(N) as we are traversing the array only once.
     * - Space complexity: O(1) as no extra space dependent on input is used here.
     */
    private static boolean canReachLastIndex(int[] nums) {
        int n = nums.length, maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return true;
    }

}
