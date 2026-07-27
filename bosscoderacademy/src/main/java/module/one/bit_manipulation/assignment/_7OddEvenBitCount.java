package module.one.bit_manipulation.assignment;

import java.util.Arrays;

/**
 * Number Of Even And Odd Bits: [Leetcode 2595. Number of Even and Odd Bits]
 * <p>
 * You are given a positive integer n.
 * Let even denote the number of even indices in the binary representation of n (0-indexed) with value 1.
 * Let odd denote the number of odd indices in the binary representation of n (0-indexed) with value 1.
 * Return an integer array answer where answer = [even, odd].
 * <p>
 * Input: n = 17
 * Output: [2,0]
 * <p>
 * Input: n = 2
 * Output: [0,1]
 * <p>
 * Constraints:
 * 1 <= n <= 1000
 * <p>
 * Approach:
 * - The approach is simple, just do the right shift by 1 position and count the set bit for the position.
 * - If bit is set and position is odd then increment odd counter, else if bit is set and position is even the update even counter.
 * - Repeat the process until number becomes 0.
 * - Time complexity: O(32) i.e. for integers = O(1) i.e.constant time
 * - Space complexity: O(1) no extra space is used only the array for returning the result which is of fixed constant size.
 */
public class _7OddEvenBitCount {

    public static void main(String[] args) {
        System.out.println("Odd even bit count: " + Arrays.toString(oddEvenBitCount(17)));
        System.out.println("Odd even bit count: " + Arrays.toString(oddEvenBitCount(2)));
    }

    private static int[] oddEvenBitCount(int num) {
        int odd = 0, even = 0;
        for (int pos = 0; pos < 32; pos++) {
            if (((num >> pos) & 1) == 1) {
                if ((pos & 1) == 1) {
                    odd++;
                } else {
                    even++;
                }
            }
        }
        return new int[]{even, odd};
    }

}