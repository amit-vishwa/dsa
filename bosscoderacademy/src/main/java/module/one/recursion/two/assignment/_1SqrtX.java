package module.one.recursion.two.assignment;

/**
 * LeetCode 69. Sqrt(x)
 * Refer: https://leetcode.com/problems/sqrtx/description/
 * <p>
 * Approaches:
 * 1. Solved using binary search in iterative way with O(logN) time complexity and O(1) space complexity.
 * 2. Solved using binary search in recursive way with O(logN) time complexity and O(logN) space complexity.
 */
public class _1SqrtX {

    public static void main(String[] args) {
        printSqrt(4);
        printSqrt(8);
        printSqrt(16);
        printSqrt(66);
    }

    private static void printSqrt(int x) {
        System.out.println("Square root by approach 1: " + approach1(x));
        System.out.println("Square root by approach 2: " + approach2(x));
        System.out.println();
    }

    private static int approach1(int x) {
        int l = 1, r = x / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) m * m == x) {
                return m;
            }
            if ((long) m * m < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    private static int approach2(int x) {
        return helper(x, 0, x / 2);
    }

    private static int helper(int x, int l, int r) {
        if (l > r) {
            return r;
        }
        int m = l + (r - l) / 2;
        if ((long) m * m == x) {
            return m;
        }
        if ((long) m * m < x) {
            return helper(x, m + 1, r);
        }
        return helper(x, l, m - 1);
    }

}