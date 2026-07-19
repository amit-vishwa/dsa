package module.one.searching.two.lecture;

import java.util.Arrays;

/**
 * Magnetic force between two balls:
 * We have been provided with m number of balls and array of buckets placed at element position.
 * We have to find the maximum of minimum distance at which the balls can be placed.
 */
public class MaxOfMinForce {

    public static void main(String[] args) {
        printRequiredForce(new int[]{10, 1, 2, 7, 5}, 4);
    }

    private static void printRequiredForce(int[] arr, int m) {
        Arrays.sort(arr);
        System.out.println("Required force to get max of min magnetic force by approach 1: " + approach1(arr, m));
        System.out.println("Required force to get max of min magnetic force by approach 2: " + approach2(arr, m));
        System.out.println();
    }

    /**
     * Approach 1
     * - The bruteforce approach to solve this problem is to find all possible combination of array.
     * - Then find minimum distance in all distances.
     * - Finding all possible combinations will take O(N!) time complexity and O(M) will be spent on finding min distance.
     * - So, total complexity here would be O(N!*M).
     * - We have better bruteforce approach here.
     * - First sort the given array, time complexity would be O(N*logN).
     * - We can take 1 as min distance and max distance would be max element - min element after sorting the array.
     * - Now, just iterate from max to 1 distance and check whether balls can be placed.
     * - If the first distance at which the give m balls can be placed is found, return the distance.
     * - Time complexity: O(N*logN) for sorted array + O(N*(Max-Min)) to find distance = O(N*logN) + O(N*(Max-Min))
     * - Space complexity: O(1) as not extra space is used here.
     */
    private static int approach1(int[] buckets, int balls) {
        for (int ballDistance = buckets[buckets.length - 1] - buckets[0]; ballDistance >= 1; ballDistance--) { // O(Max-Min)
            if (ballsCanBePlaced(buckets, balls, ballDistance)) {
                return ballDistance;
            }
        }
        return -1;
    }

    /**
     * Approach 2:
     * - This is similar to above approach, only the change here is that we are using binary search to check distance.
     * - Instead of iterating from 1 to difference between max and min, we are performing binary search and calculating
     * the mid-element, then checking for that distance, if balls can be placed.
     * - If balls can be placed then check for large distance, else reduce the distance.
     * - Time complexity: O(N*logN) sorted array + O(log(Max-Min) * N) binary search on distance possibility
     * i.e. O(N * logN) + O(log(Max-Min) * N)
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach2(int[] buckets, int balls) {
        int leftBucket = 1, rightBucket = buckets[buckets.length - 1] - buckets[0];
        while (leftBucket < rightBucket) {
            int ballDistance = leftBucket + (rightBucket - leftBucket) / 2;
            if (ballsCanBePlaced(buckets, balls, ballDistance)) {
                leftBucket = ballDistance + 1;
            } else {
                rightBucket = ballDistance - 1;
            }
        }
        return rightBucket;
    }

    private static boolean ballsCanBePlaced(int[] buckets, int balls, int ballDistance) {
        int ballsPlaced = 1, lastBallPlaced = buckets[0];
        for (int bucket : buckets) { // O(N)
            if (bucket - lastBallPlaced >= ballDistance) {
                lastBallPlaced = bucket;
                ballsPlaced++;
                if (ballsPlaced == balls) {
                    return true;
                }
            }
        }
        return false;
    }

}
