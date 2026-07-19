package module.two._2pointers.assignment;

import java.util.Arrays;

/**
 * K Diff Pairs In Array:
 * <p>
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 * <p>
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * <p>
 * Notice that |val| denotes the absolute value of val.
 * <p>
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the input, we should
 * only return the number of unique pairs.
 * <p>
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 * <p>
 * Refer _4KDiffPairs.java and _4KDiffPairsDuplicates.java from package module.two._2pointers.lecture.
 */
public class _4KDiffPairs {

    public static void main(String[] args) {
        System.out.println("K difference pairs count is " + pairsCount(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println("K difference pairs count is " + pairsCount(new int[]{1, 2, 3, 4, 5}, 1));
    }

    private static int pairsCount(int[] nums, int k) {
        Arrays.sort(nums);
        int pairCount = 0, i = 0, j = 1;
        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            int diff = nums[j] - nums[i];
            if (diff == k) {
                if (nums[j] != nums[j - 1]) {
                    pairCount++;
                    i++;
                }
                j++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        return pairCount;
    }

}