package module.one.bit_manipulation.notes;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Number:
 * <p>
 * Given an array of integers. All numbers occur twice except one number which occurs once. Find the number.
 * <p>
 * Example :
 * <p>
 * Input:  n=7, arr[] = {2, 3, 5, 4, 5, 3, 4}
 * Output: 2
 * <p>
 * Approaches:
 * 1.Bruteforce using nest loop - Time complexity: O(N^2), Space complexity: O(1)
 * 2.Better solution using two pointer - Time complexity: O(N*logN) as array must be sorted first, Space complexity: O(1)
 * 3.Optimal solution using map or hashing - Time complexity: O(N), Space complexity: O(N)
 * 4.Most optimal solution using bitwise xor - Time complexity: O(N), Space complexity: O(1)
 */
public class _3SingleNumber {

    public static void main(String[] args) {
        printSingleOccurredNumber(new int[]{2, 3, 5, 4, 5, 3, 4});
    }

    private static void printSingleOccurredNumber(int[] arr) {
        System.out.println("Single occurrence by approach1: " + approach1(arr));
        System.out.println("Single occurrence by approach2: " + approach2(arr));
        System.out.println("Single occurrence by approach3: " + approach3(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is the simplest approach where we have to check occurrence for each element by using nested loop.
     * - We can use the counter to increment whenever the number is encountered.
     * - If after one pass, the counter is 1, that means the element is present only one time, so return that element.
     * - Else, repeat the process for all elements.
     * - Time complexity: O(N^2) as we are using nested loops
     * - Space complexity: O(1) as we are not using any extra space.
     */
    private static int approach1(int[] arr) {
        for (int k : arr) {
            int count = 0;
            for (int i : arr) {
                if (k == i) {
                    count++;
                }
            }
            if (count == 1) {
                return k;
            }
        }
        return -1;
    }

    /**
     * Approach 2 - Optimal approach
     * - In this approach, we are using a map to store element, and it's occurrence count.
     * - This is more optimal than bruteforce as we are getting the result in O(N) time and space complexity.
     */
    private static int approach2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * Approach 3 - Most optimal solution
     * - This solution uses the Bitwise XOR operator.
     * - As per XOR property if we XOR two same numbers then result is 0, and if we XOR number with 0 result is number only.
     * - So, here all numbers occurring twice will get cancelled out and result will be 0 for them.
     * - Then, only the number that occurred single time will get XORed with 0 and final result will be that number itself.
     * - Time complexity: O(N) as we are iterating over the array;
     * - Space complexity: O(1) as we are not taking any extra space.
     */
    private static int approach3(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

}
