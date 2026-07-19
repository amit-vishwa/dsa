package module.two.linkedlist.one.assignment;

import java.util.Arrays;

/**
 * Maximum Units On A Truck:
 * <p>
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where
 * boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * <p>
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * <p>
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose
 * any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * <p>
 * Return the maximum total number of units that can be put on the truck.
 */
public class _9MaxUnitsOfTruck {

    public static void main(String[] args) {
        System.out.println("Maximum total number of units that can be put on the truck is " + maxUnits(new int[][]{
                {1, 3}, {2, 2}, {3, 1}
        }, 4));
        System.out.println("Maximum total number of units that can be put on the truck is " + maxUnits(new int[][]{
                {5, 10}, {2, 5}, {4, 7}, {3, 9}
        }, 10));
    }

    /**
     * Approach:
     * - The approach is a bit tricky we can say.
     * - First, reverse sort the 2D array in terms of box units i.e. index 1.
     * - Then iterate over the array and calculate total units i.e. nothing but min of truck size and boxes * box units.
     * - Then reduce that many boxes from truck and add total units to our result.
     * - Now check if truck size limit is reached, just break the loop if yes else proceed with the same process.
     * - At last just return the result after coming out of the loop.
     * - Time complexity: O(N*log(N)) for sorting + O(N) for calculating result = O(N*log(N))
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maxUnits(int[][] boxTypes, int truckSize) {
        // reverse sorting by box units
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;
        for (int[] boxType : boxTypes) {
            int boxes = boxType[0];
            int units = boxType[1];
            int maxBoxes = Math.min(truckSize, boxes);
            int totalUnits = maxBoxes * units;
            maxUnits += totalUnits;
            truckSize -= maxBoxes;
            if (truckSize <= 0) {
                break;
            }
        }
        return maxUnits;
    }

}