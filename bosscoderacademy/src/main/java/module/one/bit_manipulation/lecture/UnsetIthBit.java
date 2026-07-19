package module.one.bit_manipulation.lecture;

/**
 * Unset the Ith Bit:
 * - Approach is simple, just left the 1 from mask i times.
 * - Then perform AND operation with negation of mask and number to unset the Ith bit.
 * - Time and space complexity: O(1)
 * <p>
 * AND property:
 * 1. a & o = o
 * 2. a & 1 = a
 * <p>
 * NEGATION (1's complement) property: ~ of a = ~a i.e. ~1 = 0 and ~0 = 1.
 */
public class UnsetIthBit {

    public static void main(String[] args) {
        System.out.println(unsetIthBit(105, 5));
    }

    private static int unsetIthBit(int n, int i) {
        int mask = 1 << i;
        return n & ~mask;
    }

}
