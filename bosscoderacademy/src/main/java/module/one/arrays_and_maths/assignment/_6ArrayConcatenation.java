package module.one.arrays_and_maths.assignment;

import java.util.Arrays;

/**
 * 6. Concatenation of Array: [Leetcode 1929. Concatenation of Array]
 * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i]
 * and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 * Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
 *
 * Input 1: nums = [1,2,1]
 * Output 1: [1,2,1,1,2,1]
 * Explanation 1: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * */
public class _6ArrayConcatenation {

    public static void main(String[] args) {
        printConcatenatedArray(new int[]{1, 2, 1});
        printConcatenatedArray(new int[]{1, 3, 2, 1});
    }

    private static void printConcatenatedArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            ans[i] = arr[i % n];
        }
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Array: " + Arrays.toString(ans));
    }

}