package module.one.bit_manipulation.lecture;

/**
 * Check if the Ith Bit is set or not:
 * - There are approaches for this, we can use left shift or triple right operators.
 * - Approach is simple, just shift left or triple right shift the 1 from mask i times.
 * - Then perform AND operation with mask and number, if result is > 0 then the bit is set else unset.
 * - Time and space complexity: O(1)
 * <p>
 * LEFT SHIFT (<<):
 * - It is used to shift the bit on left side by adding 0s in the RHS side i.e. LSB (The Least Significant Bit).
 * - It is mostly used to multiply the number by 2.
 * <p>
 * RIGHT SHIFT (>>):
 * - It is used to shift the bit on right side by adding signed bit numbers in the LHS side i.e. MSB (The Most Significant Bit).
 * - The MSB decides if the number is positive or negative, it is 0 for positive and 1 negative.
 * - It is mostly used to divide the number by 2.
 * <p>
 * TRIPLE RIGHT SHIFT (>>>):
 * - It is similar to RIGHT SHIFT operator only, but it is added in Java only so that only 0s can be added in LHS,
 * and it can be independent of MSBs sign.
 */
public class IthBitSetCheck {

    public static void main(String[] args) {
        printIthBitSetResult(105, 4);
        printIthBitSetResult(105, 3);
    }

    private static void printIthBitSetResult(int n, int i) {
        System.out.println(approach1(n, i));
        System.out.println(approach2(n, i));
    }

    private static boolean approach1(int n, int i) {
        int mask = 1 << i;
        return (n & mask) > 0;
    }

    private static boolean approach2(int n, int i) {
        n >>>= i; // triple right shift can be used as it won't add 1s from MSB in case of negative numbers
        return (n & 1) == 1;
    }
}
