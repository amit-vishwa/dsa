package module.one.bit_manipulation.implementationLab;

/**
 * Single Number II: [Leetcode 137. Single Number II]
 * <p>
 * The problem is similar to single number but with variation, here numbers occurred thrice except 1 which we have to find.
 * Refer: _4SingleNumberII.java from notes for more information.
 */
public class SingleNumberII {

    public static void main(String[] args) {
        System.out.println(distinctNumber(new int[]{0, 1, 0, 0}));
        System.out.println(distinctNumber(new int[]{0, 10, 2, 0, 2, 2, 0}));
    }

    private static int distinctNumber(int[] arr) {
        int res = 0;
        for (int pos = 0; pos < 32; pos++) {
            int bitCount = 0;
            for (int num : arr) {
                bitCount += (num >> pos) & 1;
            }
            if (bitCount % 3 != 0) {
                int mask = 1 << pos;
                res |= mask;
            }
        }
        return res;
    }

}
