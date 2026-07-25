package module.one.maths.one.assignment;

/**
 * Max Consecutive Ones: [Leetcode 485. Max Consecutive Ones]
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Input 1:
 * nums = [1,1,0,1,1,1]
 * Output 1:
 * 3
 * Explanation 1:
 * The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Input 2:
 * nums = [1,0,1,1,0,1]
 * Output 2:
 * 2
 *
 * Constraints:
 * n == nums.length
 * 2 <= n <= 105
 * nums[i] is either 0 or 1.
 *
 * Approach:
 * - The problem consist of a simple approach that requires a one time array traversal.
 * - Intuition is to take 2 vars one for counting ones, and one var for keep track of max consecutive ones count.
 * - For every element as 1, just increment counter and update max count.
 * - When element is 0, just set the counter to 0.
 * - Time complexity: O(N), Space complexity: O(1)
 * */
public class _8MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println("Maximum consecutive ones: " + maxConsecutiveOnesCount(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println("Maximum consecutive ones: " + maxConsecutiveOnesCount(new int[]{1, 0, 1, 1, 0, 1}));
    }

    private static int maxConsecutiveOnesCount(int[] arr) {
        int maxConsecutiveOnesCount = 0, consecutiveOnesCount = 0;
        for (int num : arr) {
            if (num == 1) {
                consecutiveOnesCount++;
                maxConsecutiveOnesCount = Math.max(maxConsecutiveOnesCount, consecutiveOnesCount);
            } else {
                consecutiveOnesCount = 0;
            }
        }
        return maxConsecutiveOnesCount;
    }

}