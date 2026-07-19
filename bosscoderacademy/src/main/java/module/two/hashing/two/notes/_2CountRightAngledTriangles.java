package module.two.hashing.two.notes;

import java.util.HashMap;

/**
 * Count of Right-Angled Triangle:
 * <p>
 * Count of Right-Angled Triangle formed from given N points whose base or perpendicular are parallel to X or Y axis
 * Given an array arr[] of N distinct integers points on the 2D Plane. The task is to count the number of Right-Angled
 * triangles from N points such that the base or perpendicular is parallel to the X or Y-axis.
 * <p>
 * Example
 * Input: n = 3, arr[][] = {{4, 2}, {2, 1}, {1, 3}}
 * Output: 0
 * <p>
 * Approach
 * The idea is to store the count of each coordinate having the same X and Y coordinates respectively. Now traverse each
 * given point and the count of a right-angled triangle formed by each coordinate (X, Y) is given by:
 * Count of right-angled triangles = (frequencies of X coordinates – 1) * (frequencies of Y coordinates – 1)
 * <p>
 * Below are the steps:
 * 1. Create two maps to store the count of points, one for having the same X-coordinate and another for having the same
 * Y-coordinate.
 * 2. For each value in the map of x-coordinate and in the map of y-coordinate choose that pair of points as pivot elements
 * and find the frequency of that pivot element.
 * 3. For each pivot element(say pivot) in the above step, the count of right-angled is given by:
 * (m1[pivot].second - 1) * (m2[pivot].second - 1)
 * 4. Similarly, calculate the total possible right-angled triangle for other N points given.
 * 5. Finally, sum all the possible triangles obtained which is the final answer.
 */
public class _2CountRightAngledTriangles {

    public static void main(String[] args) {
        System.out.println("Right angled triangles count: " + rightAngleTriangleCount(new int[][]{
                {4, 2}, {2, 1}, {1, 3}
        }));
        System.out.println("Right angled triangles count: " + rightAngleTriangleCount(new int[][]{
                {1, 2}, {2, 1}, {2, 2}, {2, 3}, {3, 2}
        }));
    }

    /**
     * Approach:
     * - The approach is little tricky.
     * - We have to create 2 sets for x and y co-ordinates.
     * - Then iterate over the points and store x and y co-ordinates frequencies.
     * - Now, re-iterate the points and check if both maps have frequencies greater than or equal to 1 i.e. that value
     * is present as x and y co-ordinate.
     * - Then update count by using above given formula, and at last just return the count.
     * - Time and space complexities are O(N).
     */
    private static int rightAngleTriangleCount(int[][] points) {
        int count = 0;
        HashMap<Integer, Integer> xPointsMap = new HashMap<>();
        HashMap<Integer, Integer> yPointsMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            xPointsMap.put(points[i][0], xPointsMap.getOrDefault(points[i][0], 0) + 1);
            yPointsMap.put(points[i][1], yPointsMap.getOrDefault(points[i][1], 0) + 1);
        }
        for (int i = 0; i < points.length; i++) {
            if (xPointsMap.get(points[i][0]) >= 1 && yPointsMap.get(points[i][1]) >= 1) {
                count += (xPointsMap.get(points[i][0]) - 1) * (yPointsMap.get(points[i][1]) - 1);
            }
        }
        return count;
    }

}
