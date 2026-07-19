package module.two._2pointers.assignment;

import java.util.Arrays;

/**
 * Valid Triangle Number:
 * <p>
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as
 * side lengths of a triangle.
 * <p>
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * <p>
 * Input: nums = [4,2,3,4]
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */
public class _7ValidTriangleNumber {

    public static void main(String[] args) {
        printValidTriangleNumber(new int[]{2, 2, 3, 4});
        printValidTriangleNumber(new int[]{4, 2, 3, 4});
    }

    private static void printValidTriangleNumber(int[] nums) {
        System.out.println("Valid triangle number by approach 1: " + approach1(nums));
        System.out.println("Valid triangle number by approach 2: " + approach2(nums));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach that involves three loops.
     * - The first loop is for starting element to third last element.
     * - Second one is for second element to second last element.
     * - Third loop is for third element to last element.
     * - Now for pointers, check the required triangle sides property.
     * - This means the sum of two sides must be greater than the third one, check this for all three pointers.
     * - If condition is true then increment the valid triangles count.
     * - At last, just return the count.
     * - Time complexity: O(N^3) due to three loops.
     * - Space complexity: O(1) as no extra space is used here that is dependent on input.
     */
    private static int approach1(int[] nums) {
        int validTrianglesCount = 0, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] + nums[j] > nums[k]) && (nums[j] + nums[k] > nums[i]) && (nums[i] + nums[k] > nums[j])) {
                        validTrianglesCount++;
                    }
                }
            }
        }
        return validTrianglesCount;
    }

    /**
     * Approach 2 - Optimized
     * - This is an optimized approach as compared to bruteforce one.
     * - We have sorted the array first.
     * - Here, we are not creating a separate loop for third pointer, instead initializing it before second loop.
     * - Then inside second loop we are just checking if triangle property is satisfied for any one condition.
     * - If yes, then increment third pointer till it goes out of the array.
     * - Now updating the counter by adding counter and difference of current third pointer and starting third pointer value.
     * - At last, just return the count.
     * - Time complexity: O(N^2) as we have optimized the third loop.
     * - Space complexity: O(1) similar to above.
     */
    private static int approach2(int[] nums) {
        int validTrianglesCount = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                validTrianglesCount += k - (j + 1);
            }
        }
        return validTrianglesCount;
    }

}