package module.one.arrays_and_maths.notes;

import java.util.Arrays;

/**
 * 1. Max Value: []
 * Given an array of N positive integers. The task is to find the maximum value of |arr[i] – arr[j]| + |i – j|,
 * where 0 <= i, j <= N – 1 and arr[i], arr[j] belong to the array.
 * <p>
 * Example
 * Input : N = 4, arr[] = { 4, 5, 6, 8 }
 * Output: 7
 * Explanation:
 * Choose i = 0 and j = 3. This will result in |4-8|+|0-3| = 7 which is the maximum possible value.
 */
public class _1MaxValue {

    public static void main(String[] args) {
        approach1(new int[]{4, 5, 6, 8});
        approach2(new int[]{4, 5, 6, 8});
    }

    /**
     * Approach 1 - Bruteforce solution:
     * - A simple bruteforce approach where we can simply iterate over the array twice.
     * - The outer loop will keep track of elements and inner loop will iterate whole array for each element.
     * - Space complexity: O(1), no extra or auxiliary space taken
     * - Time complexity: O(N^2), as we are using nested for loop
     */
    private static void approach1(int[] arr) {
        int arrLength = arr.length;
        int maxValue = 0;
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength; j++) {
                if (i == j) {
                    continue;
                }
                int value = Math.abs(arr[i] - arr[j]) + Math.abs(i - j);
                maxValue = Math.max(maxValue, value);
            }
        }
        System.out.println("\nArray: " + Arrays.toString(arr) + ", Max value: " + maxValue);
    }

    /**
     * Approach 2 - Optimal solution:
     * - In this solution we are trying to reduce the time complexity to O(N).
     * - For the same, we can remove the modulo from the given equation:
     * |arr[i] – arr[j]| + |i – j| = [ (arr[i] - arr[j]) + (i - j) ] and [ (arr[i] - arr[j]) - (i - j) ]
     * - We will get 2 equations now:
     * [ (arr[i] + i) - (arr[j] + j) ] and [ (arr[i] - i) - (arr[j] - j) ]
     * - The basic logic is to add and subtract indices from current element.
     * - Then keep track of max and min after addition and subtraction of indices.
     * - Then get the difference from max and min of addition and max-min of subtraction.
     * - The highest among both will be the maximum possible value here.
     * - Space complexity - O(1), no extra auxiliary space taken.
     * - Time complexity - O(N), as single iteration is enough to perform the operation.
     */
    private static void approach2(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp1 = arr[i] + i; // calculate element plus index value
            int temp2 = arr[i] - i; // calculate element minus index value
            max1 = Math.max(max1, temp1); // store max index addition value
            min1 = Math.min(min1, temp1); // store min index addition value
            max2 = Math.max(max2, temp2); // store max index subtraction value
            min2 = Math.min(min2, temp2); // store min index subtraction value
        }
        maxValue = Math.max(max1 - min1, max2 - min2);
        System.out.println("\nArray: " + Arrays.toString(arr) + ", Max value: " + maxValue);
    }

}
