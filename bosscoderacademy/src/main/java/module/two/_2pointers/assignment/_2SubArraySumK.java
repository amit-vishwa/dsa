package module.two._2pointers.assignment;

/**
 * Subarray Sum K:
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * Refer _3SubArraySumEqualsK.java from package module.two._2pointers.lecture;
 */
public class _2SubArraySumK {

    public static void main(String[] args) {
        System.out.println("Sub array sum count is " + subArrayCount(new int[]{1, 1, 1}, 2));
        System.out.println("Sub array sum count is " + subArrayCount(new int[]{1, 2, 3}, 3));
    }

    private static int subArrayCount(int[] nums, int k) {
        int subArrayCount = 0, n = nums.length;
        int[] prefixSumArray = new int[n];
        prefixSumArray[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefixSumArray[j] - prefixSumArray[i] + nums[i];
                if (sum == k) {
                    subArrayCount++;
                }
            }
        }
        return subArrayCount;
    }

}