package module.one.bit_manipulation.assignment;

/**
 * Reverse Bits: [Leetcode 190. Reverse Bits]
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Input 1: n = 00000010100101000001111010011100
 * Output 1: 964176192
 * Explanation 1: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
 * so return 964176192 whose binary representation is 00111001011110000010100101000000.
 * <p>
 * Input 2: n = 11111111111111111111111111111101
 * Output 2: 3221225471
 * <p>
 * Constraints:
 * The input must be a binary string of length 32.
 */
public class _2ReverseBits {

    public static void main(String[] args) {
        printReverseBitsNumber("00000010100101000001111010011100");
        printReverseBitsNumber("11111111111111111111111111111101");
    }

    private static void printReverseBitsNumber(String bits) {
        System.out.println(approach1(bits));
        System.out.println(approach2(bits));
        System.out.println();
    }

    /**
     * Approach:
     * - Here, we are converting the binary string to long first by doing the conversion from binary to decimal.
     * - Then we are iterating for 32 bits and adding the bits at reversed position in the new result.
     * - Time complexity: O(N) to iterate the binary string + O(32) for placing the bits at correct position = O(N)
     * - Space complexity: O(1) no extra input dependent space is used.
     */
    private static long approach1(String bits) {
        long num = 0, res = 0;
        for (int i = bits.length() - 1; i >= 0; i--) {
            num += (bits.charAt(i) - '0') * (long) Math.pow(2, bits.length() - 1 - i);
        }
        for (int pos = 0; pos < 32; pos++) {
            long bit = (num >>> pos) & 1;
            long newPos = bit << (31 - pos);
            res |= newPos;
        }
        return res;
    }

    /**
     * - The is similar to above approach only with same time and space complexity.
     * - Only, here we are not converting the binary string to number first and then reversing the bits.
     * - We are in the first iteration itself reversing the bits and updating the result.
     */
    private static long approach2(String bits) {
        long res = 0;
        for (int i = 0; i < bits.length(); i++) {
            long bit = (bits.charAt(i) - '0') & 1;
            res |= (bit << i);
        }
        return res;
    }

}