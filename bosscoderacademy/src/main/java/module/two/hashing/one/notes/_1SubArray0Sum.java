package module.two.hashing.one.notes;

import java.util.HashSet;

/**
 * Find if there is a sub array with a 0 sum:
 *
 * Given an array of positive and negative numbers, find if there is a subarray (of size at least one) with 0 sum.
 * <p>
 * Example
 * Input: n=5 ,arr[]={4, 2, -3, 1, 6}
 * Output: true
 */
public class _1SubArray0Sum {

    public static void main(String[] args) {
        printResult(new int[]{4, 2, -3, 1, 6});
        printResult(new int[]{4, 2, -3, 2, 6});
    }

    private static void printResult(int[] arr) {
        System.out.println("Is sub array 0 sum exist by approach 1: " + approach1(arr));
        System.out.println("Is sub array 0 sum exist by approach 2: " + approach2(arr));
        System.out.println("Is sub array 0 sum exist by approach 3: " + approach3(arr));
        System.out.println("Is sub array 0 sum exist by approach 4: " + approach4(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is the worst bruteforce approach.
     * - Here, we are calculating the sum of each sub array, and each time we are checking if sum is 0.
     * - If it is 0 then we are returning true, else after all sub array checks we are returning false.
     * - We are using 3 arrays, 2 arrays define the start and end of array and 3rd array is iterating in between and
     * calculating the sum.
     * - Time complexity: O(N^3) due to 3 loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2 - Better Bruteforce
     * - This is a better bruteforce approach.
     * - Here, we are using a prefix sum array and checking the sum from start to end of sub arrays.
     * - If it is 0 then we are returning true, else after all sub array checks we are returning false.
     * - We are using 2 arrays that define the start and end of array and prefix sum array that stores sum till index.
     * - Time complexity: O(N^2) due to 2 loops + O(N) for prefix sum = O(N^2)
     * - Space complexity: O(N) due to prefix sum array
     */
    private static boolean approach2(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j] - prefix[i] + arr[i];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 3 - More Better Bruteforce
     * - This is more better bruteforce approach.
     * - Here, we are achieving the same result as of approach 2 but without using any extra space.
     * - We are using two loops and inside 2nd loop while iterating we are calculating cumulative sum.
     * - If sum becomes 0, then we are returning true, else at last we are returning false after the loops.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach3(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 4 - Optimal
     * - This is an optimal solution.
     * - Here we are using HashSet, we can also use a HashMap.
     * - The logic is simple, just iterate over the array and calculate cumulative sum.
     * - If sum is 0 or set already contains the sum value, then return true else add sum to the set.
     * - At last, just return false after iterating the whole array.
     * - Time complexity: O(N) as we are iterating over the array just once.
     * - Space complexity: O(N) as we are using a set here.
     */
    private static boolean approach4(int[] arr) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            sum += num;
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

}
