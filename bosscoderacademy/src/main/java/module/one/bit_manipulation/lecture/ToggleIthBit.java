package module.one.bit_manipulation.lecture;

/**
 * Toggle the Ith Bit:
 * - Approach is simple, just left the 1 from mask i times.
 * - Then perform XOR operation with mask and number to toggle the Ith bit.
 * - Time and space complexity: O(1)
 *
 * XOR property:
 * 1. a ^ 0 = a
 * 2. a ^ 1 = ~a // used to toggling
 * 3. a ^ a = 0
 */
public class ToggleIthBit {

    public static void main(String[] args) {
        System.out.println(toggleIthBit(105, 4));
    }

    private static int toggleIthBit(int n, int i) {
        int mask = 1 << i;
        return n ^ mask;
    }

}
