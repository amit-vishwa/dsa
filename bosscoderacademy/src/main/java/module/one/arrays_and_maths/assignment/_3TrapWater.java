package module.one.arrays_and_maths.assignment;

import java.util.Arrays;

// Leetcode 42. Trapping Rain Water
public class _3TrapWater {

    public static void main(String[] args) {
        printWaterCapacity(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        printWaterCapacity(new int[]{4, 2, 0, 3, 2, 5});
    }

    private static void printWaterCapacity(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Approach 1: " + approach1(arr));
        System.out.println("Approach 2: " + approach2(arr));
        System.out.println("Approach 3: " + approach3(arr));
    }

    /**
     * 1. Bruteforce approach:
     * - Space complexity - O(1)
     * - Time complexity - O(N^2)
     * */
    private static int approach1(int[] arr) {
        int waterTrapped = 0;
        for (int i = 0; i < arr.length; i++) {
            int lMax = 0, rMax = 0, j = i;
            while (j >= 0) {
                lMax = Math.max(lMax, arr[j]);
                j--;
            }
            j = i;
            while (j < arr.length) {
                rMax = Math.max(rMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(lMax, rMax) - arr[i];
        }
        return waterTrapped;
    }

    /**
     * 2. Better approach:
     * - Space complexity - O(N)
     * - Time complexity - O(N)
     * */
    private static int approach2(int[] arr) {
        int waterTrapped = 0;
        int n = arr.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], arr[i]);
        }
        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            waterTrapped += Math.min(lMax[i], rMax[i]) - arr[i];
        }
        return waterTrapped;
    }

    /**
     * 3. Optimal approach:
     * - Space complexity - O(1)
     * - Time complexity - O(N)
     * */
    private static int approach3(int[] input) {
        int n = input.length;
        int l = 0, r = n - 1;
        int lMax = 0, rMax = 0;
        int waterTrapped = 0;
        while (l <= r) {
            if (lMax <= rMax) {
                if (lMax < input[l]) {
                    lMax = input[l];
                } else {
                    waterTrapped += lMax - input[l];
                }
                l++;
            } else {
                if (rMax < input[r]) {
                    rMax = input[r];
                } else {
                    waterTrapped += rMax - input[r];
                }
                r--;
            }
        }
        return waterTrapped;
    }

}