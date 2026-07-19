package module.one.bit_manipulation.assignment;

/**
 * Alternate Bit:
 * <p>
 * Check if a number has bits in an alternate pattern.
 * <p>
 * Input 1: 10
 * Output 1: true
 * Explanation 1: 10 in binary = (1010), has an alternate pattern.
 * <p>
 * Input 2: 12
 * Output 2: false
 * <p>
 * Constraints:
 * 1 <= N <= 109
 * <p>
 * Approach:
 * - The approach is simple, just store the lsb of given number in a variable.
 * - Then perform right shift in while loop and check if new bit is same as lsb.
 * - If true then return false, else update lsb to its negation value.
 * - Now, again repeat the process by shift right by 1 until number becomes 0 and at last return true.
 * - Time complexity: O(32) as maximum 32 bits are there for integer input = O(1) i.e. constant time.
 * - Space complexity: O(1) as no extra space is used.
 */
public class _6AlternateBit {

    public static void main(String[] args) {
        System.out.println("Has alternate bits? " + hasAlternateBit(10));
        System.out.println("Has alternate bits? " + hasAlternateBit(12));
        System.out.println();
    }

    private static boolean hasAlternateBit(int n) {
        int lsb = (n & 1);
        while (n != 0) {
            n >>>= 1;
            if (lsb == (n & 1)) {
                return false;
            }
            lsb = ~lsb;
        }
        return true;
    }

}