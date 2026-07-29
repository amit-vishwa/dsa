package module.one.searching.two.assignment;

/**
 * Smallest Good Base: [Leetcode 483. Smallest Good Base]
 * <p>
 * Given an integer n represented as a string, return the smallest good base of n.
 * We call k >= 2 a good base of n, if all digits of n base k are 1's.
 * <p>
 * Input1: n = "13"
 * Output1: "3"
 * Explanation1: 13 base 3 is 111.
 * <p>
 * Input1: n = "4681"
 * Output1: "8"
 * Explanation1: 4681 base 8 is 11111.
 * <p>
 * Constraints:
 * n is an integer in the range [3, 1018].
 * n does not contain any leading zeros.
 */
public class _3SmallestGoodBase {

    public static void main(String[] args) {
        printSmallestGoodBase("13");
        printSmallestGoodBase("4681");
    }

    private static void printSmallestGoodBase(String numStr) {
        System.out.println("Smallest good base by approach 1: " + approach1(numStr));
        System.out.println("Smallest good base by approach 2: " + approach2(numStr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - The bruteforce approach consist of checking bases from 2 to number - 1.
     * - Checking each bases after making all digits as 1, if it is equal to number then return the base we got correct one.
     * - Time complexity: O(63) for the bit calculation * O(N-2) for bases from 2 to number - 1 = O(63)*O(N-2) = O(N)
     * - Space complexity: O(1) as no extra space is used.
     */
    private static String approach1(String numStr) {
        long num = Long.parseLong(numStr);
        for (int bits = 64; bits >= 2; bits--) {
            for (long base = 2; base < num; base++) {
                int count = bits;
                long res = 1, number = base;
                while (count > 0) {
                    res += number;
                    if (res == num) {
                        return String.valueOf(base);
                    }
                    if (res > num) {
                        break;
                    }
                    number *= base;
                    count--;
                }
            }
        }
        return String.valueOf(num - 1);
    }

    /**
     * Approach 2 - Optimal approach
     * - This approach is similar to approach 1, only here inner loop is calculated differently.
     * - The logic here is to calculate LHS and RHS, if both equal then we got correct smallest good base.
     * - If LHS < RHS then our base is too high we can check for lower ones, else increase base.
     * - LHS = Number * (CurrentBase - 1), RHS = CurrentBase ^ Bits - 1
     * - Time complexity: O(63) * O(log(N-2)) = O(logN)
     * - Space complexity: O(1) as no extra space is used.
     */
    private static String approach2(String numStr) {
        long num = Long.parseLong(numStr);
        for (int bits = 64; bits >= 2; bits--) {
            long leastBase = 2, maxBase = num - 1;
            while (leastBase <= maxBase) {
                long base = leastBase + (maxBase - leastBase) / 2;
                long lhs = num * (base - 1);
                long rhs = (long) Math.pow(base, bits) - 1;
                if (lhs == rhs) {
                    return String.valueOf(base);
                }
                if (lhs < rhs) {
                    maxBase = base - 1;
                } else {
                    leastBase = base + 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }

}