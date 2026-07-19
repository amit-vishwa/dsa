package module.two.exams.one;

import java.util.Arrays;

/**
 * Largest Perimeter Triangle:
 * <p>
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these
 * lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 * <p>
 * Example 1:
 * Input: nums = [2,1,2]
 * Output: 5
 * Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
 * <p>
 * Example 2:
 * Input: nums = [1,2,1,10]
 * Output: 0
 * Explanation:
 * You cannot use the side lengths 1, 1, and 2 to form a triangle.
 * You cannot use the side lengths 1, 1, and 10 to form a triangle.
 * You cannot use the side lengths 1, 2, and 10 to form a triangle.
 * As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
 * <p>
 * Constraints:
 * 3 <= nums.length <= 104
 * 1 <= nums[i] <= 106
 * <p>
 * Refer: https://leetcode.com/problems/largest-perimeter-triangle/description/
 */
public class _2LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println("Largest perimeter of given triangle is " + largestPerimeter(new int[]{2, 1, 2}));
        System.out.println("Largest perimeter of given triangle is " + largestPerimeter(new int[]{1, 2, 1, 10}));
    }

    /**
     * Approach:
     * - The approach is simple, first sort the array.
     * - Then iterate over the array in reverse order till 3rd last element.
     * - Now, check if current element is less than the sum of previous 2 elements.
     * - If this is true, then just return the largest perimeter of triangle.
     * - Else, at last just return 0 as no triangle can be formed.
     * - Time complexity: O(N*log(N)) due to sorting of array + O(N) as we are iterating over the array once = O(N*log(N))
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

}
