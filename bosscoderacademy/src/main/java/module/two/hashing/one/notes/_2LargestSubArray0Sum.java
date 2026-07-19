package module.two.hashing.one.notes;

import java.util.HashMap;

/**
 * Find the length of the largest subarray with 0 sum:
 * <p>
 * Given an array arr[] of length N, find the length of the longest sub-array with a sum equal to 0.
 * <p>
 * Example
 * Input: n = 8, arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
 * Output: 5
 */
public class _2LargestSubArray0Sum {

    public static void main(String[] args) {
        printLargestSubArraySize(new int[]{15, -2, 2, -8, 1, 7, 10, 23});
        printLargestSubArraySize(new int[]{15, -2, 2, 1, 7, 10, 23});
        printLargestSubArraySize(new int[]{15, 2, 2, 1, 7, 10, 23});
    }

    private static void printLargestSubArraySize(int[] arr) {
        System.out.println("Largest sub array size whose sum is 0 by approach 1: " + approach1(arr));
        System.out.println("Largest sub array size whose sum is 0 by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - We are simply performing the same logic as we are doing for sub array 0 sum problem.
     * - The only change here is, instead of returning true when sum is 0, we are calculating the max size of sub array.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr) {
        int maxSize = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    int size = j - i + 1;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal approach similar to sub array 0 sum problem.
     * - Here, we are updating the max size when sum is 0.
     * - Then we are checking in map if it contains sum, if yes then update max size else add sum with index in map.
     * - Time complexity: O(N) as we are iterating over the array only once.
     * - Space complexity: O(N) as we are using a HashMap here.
     */
    private static int approach2(int[] arr) {
        int maxSize = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxSize = i + 1;
            }
            if (map.containsKey(sum)) {
                maxSize = Math.max(maxSize, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxSize;
    }

}
