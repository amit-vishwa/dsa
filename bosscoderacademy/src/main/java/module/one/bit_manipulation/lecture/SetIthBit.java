package module.one.bit_manipulation.lecture;

/**
 * Set the Ith Bit:
 * - Approach is simple, just left the 1 from mask i times.
 * - Then perform OR operation with mask and number to set the Ith bit.
 * - Time and space complexity: O(1)
 *
 * OR property:
 * 1. a | o = a
 * 2. a | 1 = 1
 */
public class SetIthBit {

    public static void main(String[] args) {
        System.out.println(setIthBit(105, 4));
    }

    private static int setIthBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }

}
