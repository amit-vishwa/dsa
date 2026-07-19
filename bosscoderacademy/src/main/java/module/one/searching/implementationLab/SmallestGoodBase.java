package module.one.searching.implementationLab;

/**
 * Smallest Good Base:
 * Find the smallest good base of a given number.
 * Example: n = 13, res = 3 i.e. 13 base 3 is 111, which means after dividing 13 by 3 we get 111 as remainders.
 * In short all digits should be one if considered binary number system, but here number system can go from 2 to N-1.
 * Refer: https://leetcode.com/problems/smallest-good-base/description/
 */
public class SmallestGoodBase {

    public static void main(String[] args) {
        printSmalledGoodBase(13);
        printSmalledGoodBase(4681);
        printSmalledGoodBase(1000000000000000000L);
    }

    private static void printSmalledGoodBase(long n) {
//        System.out.println("Smallest good base by approach 1: " + approach1(n));
        System.out.println("Smallest good base by approach 2: " + approach2(n));
        System.out.println("Smallest good base by approach 3: " + approach3(n));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - The approach is simple bruteforce where we are iterating over the loops.
     * - The outer loop will be of base starting from 2 and ending with N-1.
     * - The inner loop will be constant of 63 iterations to check each bit in long data type.
     * - Now, do the calculation, calculate base result after finding all bits as 1 and calculating the result.
     * - The res == n, then just return the base, else if res > n, break and check for other bits or digits.
     * - At last, if no result found just return n-1 as answer as it will always be the answer like 12 will always be a good
     * base of 13 as like (13)base10 = (11)base12.
     * - Time complexity: O(N-2) for outer loop * O(63) for inner loop = O((N-2)*63) = O(N)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static long approach1(long n) {
        for (long base = 2; base < n; base++) {
//            for (int digit = 64; digit >= 2; digit--) {
            int count = 64;
            long num = base, res = 1;
            while (count > 0) {
                res += num;
                if (res == n) {
                    return base;
                }
                if (res > n) {
                    break;
                }
                num = num * base;
                count--;
            }
//            }
        }
        return n - 1;
    }

    /**
     * Approach 2:
     * - This is the optimal approach with little variation than the approach 1.
     * - Here, the outer loop we kept is of bits which will be constant i.e. 63 iterations.
     * - Inside we are performing binary search to calculate base.
     * - Also, we are using a formula:
     * N * (X - 1) = X^K - 1, where X is base and K is a bit position or digits.
     * - Time complexity: O(63) * O(log(N-2)) = O(logN)
     * - Space complexity: O(1)
     */
    private static long approach2(long n) {
//        long res = n - 1;
        for (int bit = 64; bit >= 2; bit--) {
            long l = 2, r = n - 1;
            while (l <= r) {
                long base = l + (r - l) / 2;
                long rhs = (long) Math.pow(base, bit) - 1;
                long lhs = n * (base - 1);
                if (lhs == rhs) { // good base found
                    return base;
                }
                if (lhs < rhs) { // base is too high
                    r = base - 1;
                } else { // base is too low
                    l = base + 1;
                }
            }
//            if (res != n - 1) {
//                break;
//            }
        }
        return n - 1;
    }

    /**
     * Approach:
     * - This is the most optimal, correct and expected solution.
     * - We have to find the smallest base where all bits are set.
     * - Since, we are dealing with long, we have to check for all bits from 1 to 60 as per constraints.
     * - Start from max bits and set lower and upper boundary.
     * - Lower will be 2 as mentioned in question, upper is max power of base which is less than number (i.e. nth root of num).
     * - Now, perform binary search by calculating base and finding the sum of all base powers.
     * - If no overflow i.e. sum <= num and all powers are less than equal to num then return base as answer.
     * - Else if overflow or sum > num, then reduce base i.e. high is updated, else lower boundary is updated.
     * - At last, just return num - 1 as answer, if nothing found.
     * - Time complexity: O(log(N)) for outer loop * O(log(N)) for binary search * O(log(N)) for inner loop = O(log(N))^3
     * but inner loop is mostly not much considered so it is O(log(N))^2, on LC constraints are fixed, so TC is constant O(1)
     * - Space complexity: O(1) as no extra space is used that is dependent on input.
     * */
    private static long approach3(long n) {
        for (int bit = 60; bit >= 1; bit--) {
            long low = 2;
            long high = (long) Math.pow(n, 1.0 / bit); // k^m = n i.e. k = n^(1/m)
            while (low <= high) {
                long base = low + (high - low) / 2;
                long cur = 1;
                long sum = 1;
                boolean overflow = false;
                for (int i = 1; i <= bit; i++) {
                    if (cur * base > n) {
                        overflow = true;
                        break;
                    }
                    cur *= base;
                    if (sum + cur > n) {
                        overflow = true;
                        break;
                    }
                    sum += cur;
                }
                if (!overflow && sum == n) {
                    return base;
                }
                if (overflow || sum > n) {
                    high = base - 1;
                } else {
                    low = base + 1;
                }
            }
        }
        return n - 1;
    }

}
