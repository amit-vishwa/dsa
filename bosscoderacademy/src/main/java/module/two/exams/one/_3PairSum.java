package module.two.exams.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Find pairs in array whose sums already exist in array:
 * <p>
 * Given an array of n distinct and positive elements, the task is to find pair whose sum already exists in the given array.
 * <p>
 * Examples :
 * <p>
 * Input : arr[] = {2, 8, 7, 1, 5};
 * Output : 2 5
 * 7 1
 * <p>
 * Input : arr[] = {7, 8, 5, 9, 11};
 * Output : Not Exist
 * <p>
 * Refer: https://www.geeksforgeeks.org/dsa/find-pairs-in-array-whose-sums-already-exist-in-array/
 */
public class _3PairSum {

    public static void main(String[] args) {
        printPairs(new int[]{2, 8, 7, 1, 5});
        printPairs(new int[]{7, 8, 5, 9, 11});
    }

    private static void printPairs(int[] arr) {
        System.out.println("Pairs whose sum already exist in array by approach 1: " + approach1(arr));
        System.out.println("Pairs whose sum already exist in array by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A Naive Approach is to run three loops to find pair whose sum exists in an array.
     * - Time complexity: O(N^3)
     * - Auxiliary space: O(1)
     */
    private static List<List<Integer>> approach1(int[] arr) {
        List<List<Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i] + arr[j] == arr[k]) {
                        pairList.add(List.of(arr[i], arr[j]));
                    }
                }
            }
        }
        return pairList;
    }

    /**
     * Approach 2 - Optimized
     * - An Efficient solution is to store all elements in a hash table (unordered_set in C++) and check one by one all pairs
     * and check its sum exists in set or not.
     * - If it exists in the set then print pair.
     * - If no pair found in the array then print not exists.
     * - Time Complexity: O(N^2)
     * - Auxiliary Space: O(N)
     */
    private static List<List<Integer>> approach2(int[] arr) {
        List<List<Integer>> pairList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[i] + arr[j])) {
                    pairList.add(List.of(arr[i], arr[j]));
                }
            }
        }
        return pairList;
    }

}
