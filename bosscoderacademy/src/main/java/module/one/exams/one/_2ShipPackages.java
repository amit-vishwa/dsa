package module.one.exams.one;

/**
 * LeetCode 1011. Capacity To Ship Packages Within D Days
 * Refer: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 */
public class _2ShipPackages {

    public static void main(String[] args) {
        System.out.println("Ship within given days: " + shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println("Ship within given days: " + shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println("Ship within given days: " + shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    /**
     * Approach:
     * - The approach is similar to Split Array Largest Sum.
     * - Here, we have to take lower bound as max of weight and upper bound as sum of all weights.
     * - Now, perform binary search using these two bounds.
     * - Go through the code and understand each step, we just have to load cargo and increase ship size accordingly.
     * - Complete the until left and right becomes equal to produce the answer.
     * - At last, return left or right as both will have the same answer.
     * - Time complexity: O(log(sum(N)) for binary search * O(N) for iterating over array = O(log(M))*O(N) = O(N*logM)
     * - Space complexity: O(1) as we are not taking any extra space here.
     */
    private static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            // left is smaller ship size
            left = Math.max(weight, left);
            // right is maximum ship size
            right += weight;
        }
        while (left < right) { // start with smaller ship size to max ship size
            int mid = left + (right - left) / 2; // check for current ship
            int cargo = 1, currCargo = 0; // initially 1 day is taken, cargo loaded 0
            for (int weight : weights) { // iterate over shipments and start loading
                if (currCargo + weight > mid) { // curr capacity + new if greater than allowed
                    currCargo = 0; // then increase ship size and remove current cargo from this ship
                    cargo++;
                }
                currCargo += weight; // load the weight on the ship
            }
            // loading cargo takes more days, increase ship size as it is small
            if (cargo > days) {
                left = mid + 1;
            } else { // ship is big, we can add more cargo
                right = mid;
            }
        }
        return left;
    }

}
