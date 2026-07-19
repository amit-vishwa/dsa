package module.one.bit_manipulation.assignment;

import java.math.BigInteger;

/**
 * Number Of One Bit:
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Input 1: n = 00000000000000000000000000001011
 * Output 1: 3
 * Explanation 1: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * Input 2: n = 00000000000000000000000010000000
 * Output 2: 1
 *
 * Constraints:
 * The input must be a binary string of length 32.
 * */
public class _4CountOneBit {

    public static void main(String[] args) {
        printOneBitCount("00000000000000000000000000001011");
        printOneBitCount("00000000000000000000000010000000");
    }

    private static void printOneBitCount(String bits) {
        System.out.println("One bit count by approach1: " + approach1(bits));
        System.out.println("One bit count by approach2: " + approach2(bits));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - Here, we are simply iterating over the string and counting bits.
     * - If bit is 1 then we are updating the ones counter and at last returning the result.
     * - Time complexity: O(N) where N is the length of the string
     * - Space complexity: O(1) as we are not using any extra space.
     * */
    private static int approach1(String bits) {
        int count = 0;
        for (char c : bits.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach 2 - Optimal approach
     * - Here, we are converting the binary string to BigInteger first.
     * - Then we are performing AND operation on LSB and finding the bit and incrementing counter if it is 1.
     * - After that we are shifting the bits towards right by 1 and repeating the process until number becomes 0.
     * - Since the maximum bit can be 32 here so complexity is O(32).
     * - Time complexity: O(32)
     * - Space complexity: O(1)
     * */
    private static int approach2(String bits) {
        BigInteger num = new BigInteger(bits, 2);
        int count = 0;
        while (!num.equals(BigInteger.ZERO)) {
            if (num.and(BigInteger.ONE).equals(BigInteger.ONE)) {
                count++;
            }
            num = num.shiftRight(1);
        }
        return count;
    }

}