package module.one.exams.one;

/**
 * LeetCode 11. Container With Most Water
 * Refer: https://leetcode.com/problems/container-with-most-water/description/
 */
public class _3ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println("Max area: " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("Max area: " + maxArea(new int[]{1, 1}));
        System.out.println("Max area: " + maxArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    /**
     * Approach:
     * - Take the left height and right height as first and last elements, and max as -INF.
     * - Now, start the while and calculate height and width.
     * - Height is min of left and right heights, width is difference between height indices.
     * - Now, update max by checking whether the product of height and width is greater than max or not.
     * - Then, if left height is greater than right height then decrement right height index, else increment left index.
     * - Repeat the process until no search space is left.
     * - Time complexity: O(N) as we are iterating the array and calculating max area.
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int maxArea(int[] height) {
        int leftHeight = 0, rightHeight = height.length - 1, maxArea = Integer.MIN_VALUE;
        while (leftHeight < rightHeight) {
            int minHeight = Math.min(height[leftHeight], height[rightHeight]);
            int width = rightHeight - leftHeight;
            maxArea = Math.max(maxArea, minHeight * width);
            if (height[leftHeight] > height[rightHeight]) {
                rightHeight--;
            } else {
                leftHeight++;
            }
        }
        return maxArea;
    }

}
