package module.one.bit_manipulation.assignment;

/**
 * Single Number 2:
 * <p>
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Input 1:
 * nums = [2,2,3,2]
 * Output 1:
 * 3
 * Explanation 1:
 * 3 is present only once.
 * <p>
 * Input 2:
 * nums = [0,1,0,1,0,1,99]
 * Output 2:
 * 99
 * <p>
 * Constraints:
 * 1 <= nums.length <= 3*104
 * -231 <= nums[i] <= 231-1
 * <p>
 * Approaches - It can be solved with same approaches as of SingleNumberI, but for XOR the logic is different here.
 */
public class _3SingleNumberII {

    public static void main(String[] args) {
        System.out.println(distinctNumber(new int[]{2, 2, 3, 2}));
        System.out.println(distinctNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(distinctNumber(new int[]{0, 1, 0, 1, 0, 1, 9, 9, 5, 9}));
    }

    /**
     * Approach:
     * - This is the most optimal approach.
     * - Here, we are counting the bits at each position from 0 to 31.
     * - If bitCount is not a multiple of 3, then that bit is set in the result at that position.
     * - We are repeating this process for all elements.
     * - At last, just simply return the result.
     * - Time complexity: O(32) 32 bits * O(N) array length = O(32) * O(N) = O(32*N) = (N) as constants can be ignored.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int distinctNumber(int[] arr) {
        int res = 0;
        for (int pos = 0; pos < 32; pos++) {
            int bitCount = 0;
            for (int num : arr) {
                bitCount += (num >> pos) & 1;
            }
            if (bitCount % 3 != 0) {
                int newPos = (1 << pos);
                res |= newPos;
            }
        }
        return res;
    }

}