package module.two._2pointers.assignment;

/**
 * Container With Most Water:
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith
 * line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * <p>
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * <p>
 * Refer _5MaxWaterStored.java file from package module.two._2pointers.notes;
 */
public class _6ContainerMostWater {

    public static void main(String[] args) {
        printMaxStoredWater(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        printMaxStoredWater(new int[]{1, 1});
    }

    private static void printMaxStoredWater(int[] heights) {
        int left = 0, right = heights.length - 1, maxStoredWater = Integer.MIN_VALUE;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int storedWater = width * height;
            maxStoredWater = Math.max(maxStoredWater, storedWater);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Max water stored is " + maxStoredWater);
    }

}