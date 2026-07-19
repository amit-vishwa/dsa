package module.one.bit_manipulation.notes;

/**
 * Single Number II:
 * <p>
 * Given an array of integers arr[] of length N, every element appears thrice except for one which occurs once.
 * Find that element which occurs once.
 * <p>
 * Example:
 * Input: N = 4 arr[] = {1, 10, 1, 1}
 * Output: 10
 * <p>
 * Approaches:
 * - All approaches are similar to SingleNumber problem, only the bitwise approach is updated here but time and space
 * complexity remains the same.
 */
public class _4SingleNumberII {

    public static void main(String[] args) {
        System.out.println(distinctNumber(new int[]{1, 10, 1, 1}));
        System.out.println(distinctNumber(new int[]{0, 10, 10, 0, 0, 2, 10}));
    }

    /**
     * Approach:
     * - Most optimal approach with O(N) time complexity and O(1) space complexity.
     * - Here, we are checking for each bit of all the elements of array.
     * - We are first count the bits.
     * - Then if we get bit count in multiples of 3 then we are not updating the result.
     * - Else we are creating a mask by left shifting 1 by bit position times and then performing OR on result to set bit.
     */
    private static int distinctNumber(int[] arr) {
        int res = 0;
        // perform the bit operation for all positions
        for (int pos = 0; pos < 32; pos++) {
            int bitCount = 0;
            // count bits that are set
            for (int num : arr) {
                bitCount += (num >> pos & 1);
            }
            // if count is divisible by 3 then create mask and update result
            if (bitCount % 3 != 0) {
                // mask = 1 found at position that the pos variable
                int mask = 1 << pos;
                res |= mask; // performing OR for setting ith bit
            }
        }
        return res;
    }

}
