package module.one.exams.milestone;

/**
 * LeetCode 198. House Robber
 * Refer: https://leetcode.com/problems/house-robber/description/
 */
public class _1HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    private static int rob(int[] nums) {
        int heist1 = 0, heist2 = 0;
        for (int i = 0; i < nums.length; i += 2) {
            heist1 += nums[i];
        }
        for (int i = 1; i < nums.length; i += 2) {
            heist2 += nums[i];
        }
        return Math.max(heist1, heist2);
    }

}
