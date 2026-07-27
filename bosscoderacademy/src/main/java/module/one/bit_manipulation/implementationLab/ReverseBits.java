package module.one.bit_manipulation.implementationLab;

/**
 * Reverse the bit of given number. [Leetcode 190. Reverse Bits]
 * <p>
 * Approach:
 * - The logic is simple here, we have to check bits of number from LSB to MSB.
 * - If we encounter 1 then we have to calculate the new position for that bit in our result.
 * - Then we have to create mask by pushing 1 to left side by new position times.
 * - Then we can simply perform OR operations with the new result variable to get final result.
 * - Time complexity: O(32) for 32-bit integers = O(1)
 * - Space complexity: O(1)
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reversedBits(105));
    }

    private static int reversedBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int newPos = (31 - i);
            int bit = ((n >> i) & 1);
            if (bit == 1) {
                int mask = (1 << newPos);
                res |= mask;
            }
        }
        System.out.println(Integer.toBinaryString(res));
        return res;
    }

}
