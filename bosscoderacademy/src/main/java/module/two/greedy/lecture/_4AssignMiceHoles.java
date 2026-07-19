package module.two.greedy.lecture;

import java.util.Arrays;

// Refer https://www.geeksforgeeks.org/dsa/assign-mice-holes/
public class _4AssignMiceHoles {

    public static void main(String[] args) {
        System.out.println("Time taken by last mouse to reach its hole is " + maxTimeTakenToReachHole(new int[]{4, -4, 2}, new int[]{4, 0, 5}));
        System.out.println("Time taken by last mouse to reach its hole is " + maxTimeTakenToReachHole(new int[]{1, 2}, new int[]{20, 10}));
    }

    /**
     * Approach:
     * - The approach is quite straightforward.
     * - Just sort both the arrays.
     * - Iterate over arrays and calculate absolute difference of mices and holes.
     * - Get the max of difference and return it.
     * - Time complexity: O(2*(N*log(N))) due to sorting + (N) due to array traversal = O(N*log(N))
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int maxTimeTakenToReachHole(int[] mices, int[] holes) {
        Arrays.sort(mices);
        Arrays.sort(holes);
        int maxTimeTaken = 0;
        for (int i = 0; i < mices.length; i++) {
            int timeTaken = Math.abs(mices[i] - holes[i]);
            maxTimeTaken = Math.max(maxTimeTaken, timeTaken);
        }
        return maxTimeTaken;
    }

}
