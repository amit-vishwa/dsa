package module.one.bit_manipulation.assignment;

import java.util.Arrays;

/**
 * Single Number 3: [Leetcode 260. Single Number III]
 * <p>
 * The problem is similar to single number and single number 2 problems. Only the difference is here is that 2 distinct numbers
 * are there and rest numbers are repeated twice. So just return the 2 distinct numbers.
 * <p>
 * Approach:
 * - This can be solved similar to other SingleNumber problems, only XOR logic is different here.
 * - We have to do the XOR of all array, this will remove all duplicated only 2 distinct numbers XOR will be there.
 * - Then we can find the first set bit i.e. whether LSB is 0 or 1.
 * - Then we can iterate over the array again and check if they have LSB set to 1 or 0.
 * - Based on that we can XOR the elements and find distinct numbers.
 * - Time complexity: O(N) for iterating the array
 * - Space complexity: O(1) as no extra space is used.
 */
public class _9SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distinctNumbers(new int[]{1, 1, 2, 2, 3, 4})));
    }

    private static int[] distinctNumbers(int[] arr) {
        int xor = 0;
        for (int n : arr) {
            xor ^= n;
        }
        int firstSetBit = xor & -xor;
        int first = 0, second = 0;
        for (int n : arr) {
            if ((n & firstSetBit) == 1) {
                first ^= n;
            } else {
                second ^= n;
            }
        }
        return new int[]{first, second};
    }

}