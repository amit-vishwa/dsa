package module.one.recursion.one.assignment;

import java.util.Arrays;

/**
 * Predict The Winner: [Leetcode 486. Predict the Winner]
 * <p>
 * You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
 * <p>
 * Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn,
 * the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the
 * size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in
 * the array.
 * <p>
 * Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and
 * you should also return true. You may assume that both players are playing optimally.
 * <p>
 * Input: nums = [1,5,2]
 * Output: false
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left
 * with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return false.
 * <p>
 * Input: nums = [1,5,233,7]
 * Output: true
 * <p>
 * Constraints:
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 107
 */
public class _5PredictTheWinner {

    public static void main(String[] args) {
        printIfPlayerOneWins(new int[]{1, 5, 2});
        printIfPlayerOneWins(new int[]{1, 5, 233, 7});
    }

    private static void printIfPlayerOneWins(int[] nums) {
        System.out.println("Has player one won by approach 1? " + approach1(nums));
        System.out.println("Has player one won by approach 2? " + approach2(nums));
        System.out.println("Has player one won by approach 3? " + approach3(nums));
        System.out.println();
    }

    /**
     * Approach 1:
     * - The approach is simple, we are calculating the score of player 1 first.
     * - Then calculating score of player 2 by subtracting player 1 score from total score.
     * - If score of player one is greater than or equal to player two then return true else false.
     * - Time complexity: O(2^N) for DP logic.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach1(int[] nums) {
        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }
        int scoreOne = helper1(nums, 0, nums.length - 1);
        int scoreTwo = totalScore - scoreOne;
        return scoreOne >= scoreTwo;
    }

    /**
     * Performing DP here, calculating player 1 scores for both choices, then taking max of both.
     * The time complexity is O(2^N) here and space complexity is O(1).
     */
    private static int helper1(int[] nums, int s, int e) {
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return nums[s];
        }
        int score1 = nums[s] + Math.min(helper1(nums, s + 2, e), helper1(nums, s + 1, e - 1));
        int score2 = nums[e] + Math.min(helper1(nums, s, e - 2), helper1(nums, s + 1, e - 1));
        return Math.max(score1, score2);
    }

    /**
     * Approach 2:
     * - The approach is more optimal than approach 1.
     * - Here, we are reducing the score of player two from player one score.
     * - Then from both choices, we are taking the max of both scores.
     * - If score is not negative then player one won, else cannot win.
     * - Time complexity: O(N) for calculating score one * O(N) for score two = O(N*N) = O(N^2)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach2(int[] nums) {
        return helper2(nums, 0, nums.length - 1) >= 0;
    }

    /**
     * Here, we are reducing the score of player two from player one score.
     * Time complexity: O(N^2), Space complexity: O(1)
     */
    private static int helper2(int[] nums, int s, int e) {
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return nums[s];
        }
        int score1 = nums[s] - helper2(nums, s + 1, e);
        int score2 = nums[e] - helper2(nums, s, e - 1);
        return Math.max(score1, score2);
    }

    /**
     * Approach 3:
     * - This is similar to approach 2, only here we have used extra space.
     * - The 2D array is used for memoization, so that if result is already found then just return from stack.
     * - No need to make extra recursion calls.
     * - Time complexity is same to approach 2 but space complexity is O(N^2) due to 2D array for memoization.
     * - However, it reduces unnecessary stack calls resulting in more efficient performance.
     */
    private static boolean approach3(int[] nums) {
        int n = nums.length;
        int[][] mem = new int[n][n];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return helper3(nums, mem, 0, n - 1) >= 0;
    }

    private static int helper3(int[] nums, int[][] mem, int s, int e) {
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return nums[s];
        }
        if (mem[s][e] != -1) {
            return mem[s][e];
        }
        int score1 = nums[s] - helper3(nums, mem, s + 1, e);
        int score2 = nums[e] - helper3(nums, mem, s, e - 1);
        mem[s][e] = Math.max(score1, score2);
        return mem[s][e];
    }

}