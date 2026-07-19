package module.one.bit_manipulation.notes;

/**
 * Least Significant Bit which is set:
 * <p>
 * Find the position of the first 1 from right to left, in the binary representation of an Integer.
 * <p>
 * Examples:
 * <p>
 * Input: n = 18
 * Output: 2
 * Explanation: Binary Representation of 18 is 010010, hence the position of the first set bit from the right is 2.
 * <p>
 * Approach:
 * - The approach is simple, we have to check the bit at LSB position if it is 1 or not by doing AND operation with 1.
 * - If we get 1 we return the counter, else increment the counter and shift the bits by 1 position until N becomes 0.
 * - Time complexity: O(32) as 32-bit integer number is there = O(1) as it is finite so constant
 * - Space complexity: O(1), not using any extra space.
 */
public class _2FirstSetFromLSB {

    public static void main(String[] args) {
        System.out.println(firstSetBitPos(18));
    }

    private static int firstSetBitPos(int n) {
        int count = 1; // 1-based indexing
        while (n > 0) {
            if ((n & 1) == 1) {
                return count;
            }
            n >>>= 1;
            count++;
        }
        return count;
    }

}
