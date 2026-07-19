package module.two.hashing.two.notes;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Check if array elements are consecutive:
 * <p>
 * Given an unsorted array of numbers, write a function that returns true if the array consists of consecutive numbers.
 * <p>
 * Example
 * Input:  n = 5 ,arr[] = 5,3,4,2,1
 * Output: True
 */
public class _1ConsecutiveArrayElements {

    public static void main(String[] args) {
        printConsecutiveNumberCheckResult(new int[]{5, 4, 3, 2, 1});
        printConsecutiveNumberCheckResult(new int[]{1, 2, 3, 4, 5});
        printConsecutiveNumberCheckResult(new int[]{5, 4, 3, 2, 1, 10});
    }

    private static void printConsecutiveNumberCheckResult(int[] arr) {
        System.out.println("Is array consist of consecutive numbers by approach 1: " + approach1(Arrays.copyOf(arr, arr.length)));
        System.out.println("Is array consist of consecutive numbers by approach 2: " + approach2(arr));
        System.out.println("Is array consist of consecutive numbers by approach 3: " + approach3(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - Here, we are sorting the array first as it is unsorted.
     * - Then we are checking the difference between adjacent elements.
     * - If it is not 1, then just return false.
     * - Else at last, after traversing the whole array just return true.
     * - Time complexity: O(N*logN) due to sorting + O(N) to check consecutive numbers = O(N*logN)
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static boolean approach1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal solution using hashset.
     * - We are adding all elements from array to set the iterating over the set.
     * - Now, we are checking if previous element is not present in the set or simply we are finding the first element of array.
     * - Then we are iterating from that array till array length and checking in set if it contains the number.
     * - If it does not contain number then just return false.
     * - Else, at last, after iterating the whole set just return true.
     * - Time complexity: O(N) iterating over array to create set + O(N) iterating over set = O(N)
     * - Space complexity: O(N) due to hashset.
     */
    private static boolean approach2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int number = num;
                int n = arr.length;
                while (n > 0) {
                    if (!set.contains(number)) {
                        return false;
                    }
                    number++;
                    n--;
                }
            }
        }
        return true;
    }

    /**
     * Approach 3 - Optimal
     * - This is another version of approach 2 using min and max values.
     * - We are iterating over the set using the min and max boundary of the set.
     * - If set contains any number in between then simply return false.
     * - Else, at last, after iterating the whole set, just return true.
     * - Time & space complexity is similar to approach 2.
     */
    private static boolean approach3(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
            set.add(num);
        }
        for (int num = min; num <= max; num++) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }

}
