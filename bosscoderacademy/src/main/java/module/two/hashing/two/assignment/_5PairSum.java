package module.two.hashing.two.assignment;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * Find pairs in array whose sums already exist in array:
 * <p>
 * Given an array of n distinct and positive elements, the task is to find pair whose sum already exists in the given array.
 * <p>
 * Input : arr[] = {2, 8, 7, 1, 5};
 * Output :
 * 2 5
 * 7 1
 * <p>
 * Input : arr[] = {7, 8, 5, 9, 11};
 * Output : Not Exist
 * <p>
 * Constraints:
 * n == arr.length
 * 1 <= n <= 200000
 */
public class _5PairSum {

    public static void main(String[] args) {
        System.out.println("Pairs in array whose sum already exist in array: " + pairSumList(new int[]{2, 8, 7, 1, 5}));
        System.out.println("Pairs in array whose sum already exist in array: " + pairSumList(new int[]{7, 8, 5, 9, 11}));
    }

    /**
     * Approach:
     * - The approach is a simple bruteforce one.
     * - We are adding all the array elements in a hashset.
     * - The iterating over the array and for each element we are iterating from next element and calculating pair sum.
     * - If sum already exist in hashset, then just add those elements in the result list.
     * - At last, just return the list.
     * - Time complexity: O(N) for adding elements in hashset + O(N^2) nested loops for pair sum = O(N^2)
     * - Space complexity: O(N) due to hashset.
     */
    private static List<List<Integer>> pairSumList(int[] arr) {
        List<List<Integer>> pairList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum)) {
                    pairList.add(List.of(arr[i], arr[j]));
                }
            }
        }
        return pairList;
    }

}