package module.two.hashing.two.lecture;

import java.util.HashMap;

/**
 * LeetCode 149. Max Points on a Line:
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points
 * that lie on the same straight line.
 * <p>
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * <p>
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 */
public class _2MaxPointsOnLine {

    public static void main(String[] args) {
        printMaxPoints(new int[][]{
                {1, 1}, {2, 2}, {3, 3}
        });
        printMaxPoints(new int[][]{
                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}
        });
    }

    private static void printMaxPoints(int[][] points) {
        System.out.println("Max points on a line by approach 1: " + approach1(points));
        System.out.println("Max points on a line by approach 2: " + approach2(points));
        System.out.println("Max points on a line by approach 3: " + approach3(points));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - This is a simple bruteforce approach.
     * - Here, we are checking the slope for two points first.
     * - Then inside nested loops, we also have one loop to check other points on the same line.
     * - Again, we are calculating the slope and comparing it with previous slope.
     * - If both are equal then increase the count of points.
     * - After the completion of 3rd loop, just check compare the points count with final result, store max among them.
     * - After all 3 loops, just return the result that has the max points on a line.
     * - Time complexity: O(N^3) due to 3 loops.
     * - Space complexity: O(1) as we are not using any extra space here.
     */
    private static int approach1(int[][] points) {
        int result = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 2; // at least 2 points are there
                int dx = points[j][0] - points[i][0]; // x2 - x1
                int dy = points[j][1] - points[i][1]; // y2 - y1
                for (int k = 0; k < n; k++) { // checking points other than above 2 on same line
                    if (k == i || k == j) {
                        continue;
                    }
                    int dx_ = points[k][0] - points[i][0]; // x2 - x1
                    int dy_ = points[k][1] - points[i][1]; // y2 - y1
                    if (dx_ * dy == dy_ * dx) { // checking is slopes are equal with formula dy1/dx1 = dy2/dx2 i.e. dy1 * dx2 = dy2 * dx1
                        count++;
                    }
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimized approach.
     * - Here, we are using a hashmap to store the slopes and it occurrence count.
     * - The default value for any slope is 1 here, if slope already exist in map then increment occurrence value.
     * - Then, update the result by storing the max slope occurrence in it.
     * - We are also taking care of the case where denominator can be 0 to avoid getting divide by zero exception.
     * - At last, just return the result.
     * - Time complexity: O(N^2) as we are using 2 loops only.
     * - Space complexity: O(N) due to HashMap.
     */
    private static int approach2(int[][] points) {
        int result = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                // if denominator is 0 then get max val else get slope
                double slope = points[j][0] - points[i][0] == 0 ? Double.MAX_VALUE : (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                result = Math.max(result, map.get(slope));
            }
        }
        return result;
    }

    /**
     * Approach 3 - LeetCode optimal
     * - This is similar to approach 2, but here we are handling few more edge cases as per leetcode.
     * - We are considering the duplicate points and negative co-ordinates.
     * - Time and space complexity is similar to approach 2.
     */
    private static int approach3(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int maxPointsOnLine = 0;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int duplicates = 1, maxPoints = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                dx = dx / gcd;
                dy /= gcd;
                String key = dy + "/" + dx;
                map.put(key, map.getOrDefault(key, 0) + 1);
                maxPoints = Math.max(maxPoints, map.get(key));
            }
            maxPointsOnLine = Math.max(maxPointsOnLine, maxPoints + duplicates);
        }
        return maxPointsOnLine;
    }

    private static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

}
