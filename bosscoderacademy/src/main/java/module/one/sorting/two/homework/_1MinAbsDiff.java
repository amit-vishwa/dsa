package module.one.sorting.two.homework;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * LeetCode 1200. Minimum Absolute Difference
 * Refer: https://leetcode.com/problems/minimum-absolute-difference/description/
 */
public class _1MinAbsDiff {

    public static void main(String[] args) {
        System.out.println("Minimum absolute difference pairs: " + minAbsDiffPairs(new int[]{4, 2, 1, 3}));
        System.out.println("Minimum absolute difference pairs: " + minAbsDiffPairs(new int[]{1, 3, 6, 10, 15}));
        System.out.println("Minimum absolute difference pairs: " + minAbsDiffPairs(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    /**
     * Approach:
     * - The approach is simple, first sort the array in ascending order.
     * - Then calculate the minimum absolute difference by traversing the array.
     * - Then check all pairs by traversing again and add them in the list of pairs.
     * - At last, just return the list.
     * - Time complexity: O(N*logN) for sorting + O(2N) for traversing twice = O(N*logN) + O(N) = O(N*logN)
     * - Space complexity: O(N) due to sorting.
     */
    private static List<List<Integer>> minAbsDiffPairs(int[] arr) {
        List<List<Integer>> pairs = new ArrayList<>();
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minAbsDiff = Math.min(minAbsDiff, arr[i] - arr[i - 1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minAbsDiff) {
                pairs.add(new ArrayList<>(List.of(arr[i - 1], arr[i])));
            }
        }
        return pairs;
    }

}