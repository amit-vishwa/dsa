package module.one.searching.two.assignment;

import java.util.Arrays;

/**
 * Magnetic Force Between Balls: [Leetcode 1552. Magnetic Force Between Two Balls]
 * <p>
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his
 * new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to
 * distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 * <p>
 * Input1: position = [1,2,3,4,7], m = 3
 * Output1: 3
 * Explanation1: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6].
 * The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 * <p>
 * Input2: position = [5,4,3,2,1,1000000000], m = 2
 * Output2: 999999999
 * Explanation2: We can use baskets 1 and 1000000000.
 * <p>
 * Constraints:
 * n == position.length
 * 2 <= n <= 105
 * 1 <= position[i] <= 109
 * All integers in position are distinct.
 * 2 <= m <= position.length
 */
public class _2MagneticForce {

    public static void main(String[] args) {
        printMaxMagneticForce(new int[]{1, 2, 3, 4, 7}, 3);
        printMaxMagneticForce(new int[]{5, 4, 3, 2, 1, 1000000000}, 2);
    }

    private static void printMaxMagneticForce(int[] buckets, int balls) {
        System.out.println("Approach 1: Max magnetic force between balls is " + approach1(buckets, balls));
        System.out.println("Approach 2: Max magnetic force between balls is " + approach2(buckets, balls));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is the simple bruteforce approach where we are checking for all distances in linear manner.
     * - We are first sorting the array.
     * - We are calculating the least and max distance and setting the initial and conditional statements in loop.
     * - Then checking for each distance whether balls can be placed.
     * - Since, here we have been asked to calculate the max of min distance where balls can be placed, so we are
     * checking if distance between balls is greater than or equal to current distance.
     * - If found any such distance then return that distance.
     * - Time complexity: O(N*logN) for sorting + [O(max-min) calculating distance * O(N) checking each distance possibility]
     * = O(N*logN) + O(N*(max-min))
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach1(int[] buckets, int balls) {
        Arrays.sort(buckets);
        for (int distance = buckets[buckets.length - 1] - buckets[0]; distance > 0; distance--) {
            if (ballsCanBePlaced(buckets, balls, distance)) {
                return distance;
            }
        }
        return -1;
    }

    private static boolean ballsCanBePlaced(int[] buckets, int balls, int distance) {
        int ballsPlaced = 1, lastPlacedBall = buckets[0];
        for (int bucket : buckets) {
            if (bucket - lastPlacedBall >= distance) {
                ballsPlaced++;
                lastPlacedBall = bucket;
                if (ballsPlaced == balls) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is more optimal approach than bruteforce as here we are checking distances using binary search.
     * - Everything is similar to bruteforce approach, only checking the distance possibility is done using binary search.
     * - Time complexity: O(N*logN) + O(N * log(max-min)) here log is added due to binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] buckets, int balls) {
        Arrays.sort(buckets);
        int leastDistance = 1, maxDistance = buckets[buckets.length - 1] - buckets[0];
        while (leastDistance <= maxDistance) {
            int distance = (leastDistance + maxDistance) / 2;
            if (ballsCanBePlaced(buckets, balls, distance)) {
                leastDistance = distance + 1;
            } else {
                maxDistance = distance - 1;
            }
        }
        return maxDistance;
    }

}