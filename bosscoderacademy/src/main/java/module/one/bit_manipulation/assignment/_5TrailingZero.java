package module.one.bit_manipulation.assignment;

/**
 * Trailing Zero:
 * <p>
 * Given an integer N, the task is to find the number of trailing zeroes in the binary representation of the given number.
 * <p>
 * Input 1: N = 12
 * Output 1: 2
 * Explanation 1: The binary representation of the number 13 is “1100”. Therefore, there are two trailing zeros in the 12.
 * <p>
 * Input 2: -56
 * Output 2: 3
 * <p>
 * Constraints:
 * -106 <= N <= 106
 * <p>
 * Approach:
 * - The approach is simple.
 * - Just perform AND operation on LSB, if it is 0 then increment the counter and right shift by 1, else return counter.
 * - Time complexity: O(32) as shifting will be done 32 bits only here = O(1) i.e. constant time
 * - Space complexity: O(1) as we are not using any extra space.
 */
public class _5TrailingZero {

    public static void main(String[] args) {
        System.out.println("Trailing zeroes count: " + trailingZeroesCount(12));
        System.out.println("Trailing zeroes count: " + trailingZeroesCount(-56));
    }

    private static int trailingZeroesCount(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                return count;
            }
            count++;
            n >>>= 1;
        }
        return count;
    }

}