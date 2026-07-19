package module.two._2pointers.assignment;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Find K Pairs with Smallest Sums:
 * <p>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k. Define a pair (u, v) which
 * consists of one element from the first array and one element from the second array. Return the k pairs (u1, v1), (u2, v2),
 * ..., (uk, vk) with the smallest sums.
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * <p>
 * Constraints: 1 <= nums1.length, nums2.length <= 105 -109 <= nums1[i], nums2[i] <= 109 nums1 and nums2 both are sorted in
 * ascending order. 1 <= k <= 104
 */
public class _9KPairsSmallestSums {

    public static void main(String[] args) {
        System.out.println("The first K pairs are " + kPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println("The first K pairs are " + kPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }

    /**
     * Approach:
     * - A simple bruteforce approach.
     * - Here, we are first finding all the pairs from two arrays and adding them in the list.
     * - Then sorting the list in ascending order.
     * - After that creating a result of list of K size and returning the same.
     * - Time complexity: O(N^2) for two loops iteration + O(N*logN) for sorting + O(K) for result list = O(N^2)
     * - Space complexity: O(N^2) for all pairs + O(K) for result list = O(N^2)
     */
    private static ArrayList<ArrayList<Integer>> kPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<ArrayList<Integer>> pairsList = new ArrayList<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                ArrayList<Integer> pairs = new ArrayList<>();
                pairs.add(n1);
                pairs.add(n2);
                pairsList.add(pairs);
            }
        }
        Collections.sort(pairsList, (list1, list2) -> (list1.get(0) + list1.get(1)) - (list2.get(0) + list2.get(1)));
        ArrayList<ArrayList<Integer>> kPairs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kPairs.add(pairsList.get(i));
        }
        return kPairs;
    }

}