package module.one.bit_manipulation.assignment;

import java.util.Arrays;

/**
 * Counting Bits:
 * <p>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of
 * 1's in the binary representation of i.
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * <p>
 * Constraints:
 * 1 <= n <= 10000
 * <p>
 * Approach:
 * - The approach is simple here, we just have to iterate numbers from 0 to given number.
 * - Now, for each number we have count the set bit and add that in the result array at that index.
 * - At last, simply return the array.
 * - Time complexity: O(N+1) as we have to iterate from 0 till given number = O(N)
 * - Space complexity: O(1) as no extra space is used, only result array is created with O(N+1) space.
 */
public class _8CountingBits {

    public static void main(String[] args) {
        System.out.println("Bit count array: " + Arrays.toString(bitCount(2)));
        System.out.println("Bit count array: " + Arrays.toString(bitCount(5)));
    }

    private static int[] bitCount(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int n = i;
            while (n != 0) {
                count += (n & 1);
                n >>>= 1;
            }
            res[i] = count;
        }
        return res;
    }

}