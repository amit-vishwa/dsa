package module.one.maths.one.assignment;

import java.util.HashMap;

/**
 * Number Of Good Pairs: [Leetcode 1512. Number of Good Pairs]
 * <p>
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Input 1: nums = [1,2,3,1,1,3]
 * Output 1: 4
 * Explanation 1: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * <p>
 * Input 2: nums = [1,1,1,1]
 * Output 2: 6
 * <p>
 * Constraints:
 * 1 <= nums.length <= 102
 * 1 <= nums[i] <= 102
 */
public class _3GoodPairs {

    public static void main(String[] args) {
        printGoodPairsCount(new int[]{1, 2, 3, 1, 1, 3});
        printGoodPairsCount(new int[]{1, 1, 1, 1});
    }

    private static void printGoodPairsCount(int[] arr) {
        System.out.println("Good pairs count by approach 1: " + approach1(arr, arr.length));
        System.out.println("Good pairs count by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - A simple bruteforce approach is to iterate over the array using nested loop.
     * - Here, for each element we can check if elements are equal with i < j.
     * - Time complexity: O(N^2), Space complexity: O(1)
     */
    private static int approach1(int[] arr, int n) {
        int goodPairsCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    goodPairsCount++;
                }
            }
        }
        return goodPairsCount;
    }

    /**
     * Approach 2 - Optimal approach
     * - An optimal solution is to use a map and simply count the occurrence of elements.
     * - And then calculate the count using prefix sum logic, like count = count + newCount.
     * - Here, only one iteration takes place with and storing of unique elements take some space.
     * - Time complexity: O(N), as we have to iterate over the array to find the count.
     * - Space complexity: O(uniqueElements), as we are storing elements in hashmap.
     */
    private static int approach2(int[] arr) {
        int goodPairsCount = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : arr) {
            goodPairsCount += hashMap.getOrDefault(num, 0);
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        return goodPairsCount;
    }

}