package module.one.bit_manipulation.notes;

import java.util.Arrays;

/**
 * Single Number III: [Leetcode 260. Single Number III]
 * <p>
 * Given an array in which all numbers except two are repeated once. Find those two numbers.
 * <p>
 * Example
 * <p>
 * Input: n=6 ,a[]={1,1,2,2,3,4}
 * Output:3,4
 * <p>
 * Approaches are similar to other single number problems but for bitwise we have some different approach here.
 */
public class _5SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distinctNumbers(new int[]{1, 1, 2, 2, 3, 4})));
    }

    /**
     * Approach:
     * - This is the most optimal approach.
     * - Here, we have taken few variables initially that are required to find the two distinct numbers.
     * - Then we XOR all elements of the array to find remove duplicates.
     * - Then we are finding the first set bit of the result from XOR operation.
     * - Based on that set bit we are dividing or partitioning the array elements.
     * - After doing & operation if we are getting 0 or 1 based on that we are XORing x and y elements
     * - Then at last we will be having distinct element in each partition which will be our answer.
     * - Time complexity: O(N) as we are iterating over the array
     * - Space complexity: O(1) as not extra space is used
     */
    private static int[] distinctNumbers(int[] arr) {
        // step 1: xor all
        int xor = 0;
        for (int n : arr) {
            xor ^= n;
        } // xor == 7

        // step 2: rightmost set bit
        int setBit = xor & -xor; // setBit == 1

        // step 3: partition and xor each group
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } // group with set bit -> x == 3
            else {
                y ^= num;
            } // group without -> y == 4
        }

        // output: x and y are the two distinct numbers
        return new int[]{x, y}; // prints "3, 4"
    }

}

