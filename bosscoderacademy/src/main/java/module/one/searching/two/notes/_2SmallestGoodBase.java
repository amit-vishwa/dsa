package module.one.searching.two.notes;

/**
 * Smallest Good Base:
 * <p>
 * Given an integer n represented as a string, return the smallest good base of n. We call k >= 2 a good base of n if all
 * digits of n base k are 1's.
 * <p>
 * Example:
 * Input: n = "13"
 * Output: "3"
 * <p>
 * Explanation: 13 base 3 is 111.
 * <p>
 * Refer: same problem from implementation lab package can be referred for approaches and complexities.
 */
public class _2SmallestGoodBase {

    public static void main(String[] args) {
        printSmallestGoodBase("13");
        printSmallestGoodBase("4681");
        printSmallestGoodBase("1000000000000000000");
    }

    private static void printSmallestGoodBase(String numString) {
        System.out.println("Smallest good base by approach 1: " + approach1(numString));
        System.out.println("Smallest good base by approach 2: " + approach2(numString));
        System.out.println();
    }

    private static long approach1(String numString) {
        long num = Long.parseLong(numString);
        for (int bits = 64; bits >= 2; bits--) {
            for (long base = 2; base < num; base++) {
                long res = 1, number = base, count = bits;
                while (count > 0) {
                    res += number;
                    if (res == num) {
                        return base;
                    }
                    if (res > num) {
                        break;
                    }
                    number *= base;
                    count--;
                }
            }
        }
        return num - 1;
    }

    private static long approach2(String numString) {
        long num = Long.parseLong(numString), res = num - 1;
        for (int bits = 64; bits >= 2; bits--) {
            long leftBase = 2, rightBase = num - 1;
            while (leftBase <= rightBase) {
                long base = leftBase + (rightBase - leftBase) / 2;
                long number = num * (base - 1); // actual base number
                long digits = (long) Math.pow(base, bits) - 1; // exponential power value
                if (number == digits) {
                    return base;
                }
                if (number < digits) { // we want smaller base as base is greater here
                    rightBase = base - 1;
                } else {
                    leftBase = base + 1;
                }
            }
        }
        return res;
    }

}
