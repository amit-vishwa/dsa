package module.two.greedy.lecture;

import java.util.Arrays;

// Refer https://leetcode.com/problems/maximum-product-of-three-numbers/description/
public class _3MaxProductOfThree {

    public static void main(String[] args) {
        System.out.println("Maximum product of 3 numbers is " + maxProductOfThreeNums(new int[]{1, 2, 3}));
        System.out.println("Maximum product of 3 numbers is " + maxProductOfThreeNums(new int[]{1, 2, 3, 4}));
        System.out.println("Maximum product of 3 numbers is " + maxProductOfThreeNums(new int[]{-1, -2, -3}));
        System.out.println("Maximum product of 3 numbers is " + maxProductOfThreeNums(new int[]{-10, -10, 1, 2, 3}));
    }

    /**
     * Approach:
     * - The approach is quite straightforward.
     * - We just have to sort the array first.
     * - Then take product of both cases, all positives/negatives and partially negatives.
     * - Return the max among them.
     * - Time complexity: O(N*log(N)) due to sorting.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maxProductOfThreeNums(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int product2 = nums[n - 1] * nums[0] * nums[1];
        return Math.max(product1, product2);
    }

}
