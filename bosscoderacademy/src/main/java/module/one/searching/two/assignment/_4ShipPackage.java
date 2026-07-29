package module.one.searching.two.assignment;

/**
 * Capacity To Ship Package: [Leetcode 1011. Capacity To Ship Packages Within D Days]
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor
 * belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped
 * within D days.
 * <p>
 * Input1: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output1: 15
 * Explanation1: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into
 * parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * <p>
 * Input2: weights = [3,2,2,4,1,4], days = 3
 * Output2: 6
 * <p>
 * Constraints:
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 */
public class _4ShipPackage {

    public static void main(String[] args) {
        System.out.println("Minimum ship capacity: " + minShipCapacity(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println("Minimum ship capacity: " + minShipCapacity(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    /**
     * Approach:
     * - The approach is similar to Split Array problem.
     * - We have to take the lower and upper boundary, lower will be max of array and upper will be sum of all elements.
     * - Then we have to calculate mid and check if ship weights can be shipped with given days.
     * - If that is possible then we have the potential answer so just keep upper limit till mid, else increase lower to mid+1.
     * - Repeat the process till both least and upper limits become equal.
     * - At last, return any limit as that will have the answer.
     * - Time complexity: O(N) to calculate lower and upper bounds + [O(log(upperLimit)) binary search logic * O(N) for minDays]
     * = O(N) + O(log(S) * N) = O(N * log(S)) here S is sum of all elements.
     * - Space complexity: O(1) as no extra space is used
     */
    private static int minShipCapacity(int[] weights, int days) {
        long leastCapacity = 0, maxCapacity = 0;
        for (int weight : weights) {
            leastCapacity = Math.max(weight, leastCapacity);
            maxCapacity += weight;
        }
        while (leastCapacity < maxCapacity) {
            long capacity = leastCapacity + (maxCapacity - leastCapacity) / 2;
            int minDays = minDays(weights, capacity);
            if (minDays <= days) {
                maxCapacity = capacity;
            } else {
                leastCapacity = capacity + 1;
            }
        }
        return (int) maxCapacity % 1000000008;
    }

    private static int minDays(int[] weights, long capacity) {
        int minDays = 1;
        long weightsTillNow = 0;
        for (int weight : weights) {
            if (weightsTillNow + weight > capacity) {
                weightsTillNow = 0;
                minDays++;
            }
            weightsTillNow += weight;
        }
        return minDays;
    }

}