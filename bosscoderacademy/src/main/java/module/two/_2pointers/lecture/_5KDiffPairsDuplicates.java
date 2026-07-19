package module.two._2pointers.lecture;

import java.util.Arrays;

/**
 * Same problem of K Different Pairs, but with duplicates.
 * Solved similar problem as mentioned in _4KDiffPairs.java file, using 2 pointers approach only.
 */
public class _5KDiffPairsDuplicates {

    public static void main(String[] args) {
        System.out.println(uniquePairCount(new int[]{1, 1, 3, 3, 3, 3, 3, 4, 5}, 2));
    }

    private static int uniquePairCount(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, i = 0, j = 1;
        while (j < nums.length) {
            int diff = nums[j] - nums[i];
            if (diff == k) {
                // if previous j element is same that means it is already visited, just increase j
                if (nums[j] != nums[j - 1]) {
                    count++;
                    i++;
                }
                j++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

}
