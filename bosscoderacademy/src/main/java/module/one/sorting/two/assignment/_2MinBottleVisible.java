package module.one.sorting.two.assignment;

import java.util.HashMap;

/**
 * Minimum Bottle Visible:
 * <p>
 * Given N bottles. The ith bottle has A[i] radius. Once a bottle is enclosed inside another bottle, it ceases to be visible.
 * The task is to minimize the number of visible bottles. You can put the ith bottle into a jth bottle if the following
 * condition is fulfilled.
 * <p>
 * ith bottle itself is not enclosed in another bottle.
 * jth bottle does not enclose any other bottle.
 * Radius of bottle i is smaller than bottle j ( i.e. A[i] < A[j] ).
 */
public class _2MinBottleVisible {

    public static void main(String[] args) {
        printBottleCount(new int[]{1, 1, 2, 3, 4, 5, 5, 4});
        printBottleCount(new int[]{1, 1, 2, 3, 4, 5, 5, 4, 4, 4});
    }

    private static void printBottleCount(int[] bottles) {
        System.out.println("Visible bottle count by approach 1: " + approach1(bottles));
        System.out.println("Visible bottle count by approach 2: " + approach2(bottles));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple nest loop approach, where are calculating the count of elements.
     * - We are maintaining the count at each pass and updating the max count.
     * - At last, we are just returning the max count.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] bottles) {
        int visibleBottleCount = 0;
        for (int i = 0; i < bottles.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < bottles.length; j++) {
                if (bottles[i] == bottles[j]) {
                    count++;
                }
            }
            visibleBottleCount = Math.max(visibleBottleCount, count);
        }
        return visibleBottleCount;
    }

    /**
     * Approach 2 - Optimal
     * - This is an optimal solution, here we are using a map to store bottle with its count.
     * - Here, we just have to iterate the array once and calculate the max count.
     * - Time complexity: O(N) as array is traversed only once.
     * - Space complexity: O(K) due to map that stores K distinct elements.
     */
    private static int approach2(int[] bottles) {
        int visibleBottleCount = 0;
        HashMap<Integer, Integer> bottleCountMap = new HashMap<>();
        for (int bottle : bottles) {
            bottleCountMap.put(bottle, bottleCountMap.getOrDefault(bottle, 0) + 1);
            visibleBottleCount = Math.max(visibleBottleCount, bottleCountMap.get(bottle));
        }
        return visibleBottleCount;
    }

}