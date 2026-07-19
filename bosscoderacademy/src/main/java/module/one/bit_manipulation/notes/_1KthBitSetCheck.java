package module.one.bit_manipulation.notes;

/**
 * Kth Bit is set or not:
 * <p>
 * Given a number N and a bit number K, check if the Kth bit of N is set or not. A bit is called set if it is 1.
 * <p>
 * Example
 * <p>
 * Input: n = 5, k = 1
 * Output: SET
 * Explanation: 5 is represented as 101 in binary and has its first bit set.
 * <p>
 * Approaches:
 * - It consist of two approaches, IthBitSetCheck.java file from lecture package can be referred for more.
 */
public class _1KthBitSetCheck {

    public static void main(String[] args) {
        System.out.println(isKthBitSet(5, 1));
    }

    private static boolean isKthBitSet(int n, int k) {
        return ((n >>> k - 1) & 1) == 1;
    }

}
