package module.one.bit_manipulation.implementationLab;

/**
 * [Leetcode 191. Number of 1 Bits]
 * Count the number of set bits for given number.
 */
public class CountSetBits {

    public static void main(String[] args) {
        countSetBits(105);
    }

    private static void countSetBits(int n) {
        System.out.println("Set bit count by approach1: " + approach1(n));
        System.out.println("Set bit count by approach2: " + approach2(n));
        System.out.println();
    }

    /**
     * Approach 1 - Left shift operator:
     * - We can use left shift operator and shift 1 from 0 to 31 times left side.
     * - For each shift we will AND it with number and check if it is greater than 0.
     * - Increment the counter if number is not 0, else proceed.
     * - Time complexity: O(32) as we are doing for 32 bits = O(1)
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((n & mask) != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach 2 - Triple right shift operator:
     * - We can use triple right shift operator and shift 1 from right side.
     * - For each shift we will AND 1 with LSB and check if it is 1.
     * - Increment the counter if result is not 0, else proceed.
     * - Time complexity: O(32) as we are doing for 32 integer bits = O(1)
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach2(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

}
