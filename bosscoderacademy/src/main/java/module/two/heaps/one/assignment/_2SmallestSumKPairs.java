package module.two.heaps.one.assignment;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Find K Pairs With Smallest Sum:
 * <p>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k. Define a pair (u, v) which consists
 * of one element from the first array and one element from the second array. Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk)
 * with the smallest sums.
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 */
public class _2SmallestSumKPairs {

    public static void main(String[] args) {
        printKPairsWithSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        printKPairsWithSmallestSum(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
    }

    private static void printKPairsWithSmallestSum(int[] nums1, int[] nums2, int k) {
        System.out.println(k + " pairs with smallest sum by approach 1: " + approach1(nums1, nums2, k));
        System.out.println(k + " pairs with smallest sum by approach 2: " + approach2(nums1, nums2, k));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is a bruteforce and straightforward approach.
     * - Just store all the pairs in a list.
     * - Then sort the list based on the problem requirement.
     * - After that, just store the K pairs in the result list and return it.
     * - Time complexity: O(M*N) for generating all pairs + O((M*N)*log(M*N)) for sorting = O((N^2)*log(N^2)) when M == N
     * - Space complexity: O(M*N) due to an extra list of storing all the M*N pairs.
     */
    private static List<List<Integer>> approach1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> allPairsList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                allPairsList.add(List.of(nums1[i], nums2[j]));
            }
        }
        allPairsList.sort((list1, list2) -> (list1.get(0) + list1.get(1)) - (list2.get(0) + list2.get(1)));
        List<List<Integer>> kPairsList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kPairsList.add(allPairsList.get(i));
        }
        return kPairsList;
    }

    /**
     * Approach 2:
     * - This is a better approach using PriorityQueue.
     * - Here, we are updating the comparator logic of queue to store pairs as per the requirement.
     * - Then we are iterating over all pairs and trying to insert in the queue.
     * - When queue is getting filled more than its size, then we are populating the top and storing it in result list.
     * - After that, when result list becomes equal to K then we are just returning the list.
     * - Also, at last we are returning the same list.
     * - Time complexity: O(M*N) due to nested loops * O(log(K)) insertion and removal in priority  = O((N^2)*log(K)) when M==N
     * - Space complexity: O(K) at most K elements will be stored in the queue.
     */
    private static List<List<Integer>> approach2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> kPairsList = new ArrayList<>();
        PriorityQueue<List<Integer>> minPriorityQueue = new PriorityQueue<>((list1, list2) -> (list1.get(0) + list1.get(1)) - (list2.get(0) + list2.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                minPriorityQueue.add(List.of(nums1[i], nums2[j]));
                if (minPriorityQueue.size() > k) {
                    kPairsList.add(minPriorityQueue.remove());
                    if (kPairsList.size() == k) {
                        return kPairsList;
                    }
                }
            }
        }
        return kPairsList;
    }

}