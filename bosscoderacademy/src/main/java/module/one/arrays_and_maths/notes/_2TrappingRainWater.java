package module.one.arrays_and_maths.notes;

/**
 * 2. Trapping Rain Water: [Leetcode 42. Trapping Rain Water]
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it can trap after rain.
 * <p>
 * Input: n=12 height= [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation:
 * The above elevation map (black section) is represented by an array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are trapped.
 */
public class _2TrappingRainWater {

    public static void main(String[] args) {
        approach1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        approach2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        approach3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    /**
     * Approach 1 - Bruteforce solution:
     * - A simple bruteforce solution here is to traver left and right from an index.
     * - Check for max element at left and right side, then get least among them.
     * - The reduce the current element from the result that we got above.
     * - Then add the final result to the cumulative capacity or sum counter.
     * - Space complexity - O(1), no extra auxiliary space is used.
     * - Time complexity - O(N^2), as we are traversing left and right to find max element.
     */
    private static void approach1(int[] arr) {
        int n = arr.length;
        int capacity = 0;
        for (int i = 0; i < n; i++) {
            int maxLeft = 0, maxRight = 0, j = i;
            while (j >= 0) {
                maxLeft = Math.max(maxLeft, arr[j]);
                j--;
            }
            j = i;
            while (j < n) {
                maxRight = Math.max(maxRight, arr[j]);
                j++;
            }
            capacity += (Math.min(maxRight, maxLeft) - arr[i]);
        }
        System.out.println("Approach 1: Max stored water capacity: " + capacity);
    }

    /**
     * Approach 2 - Better solution:
     * - A better solution than Bruteforce approach is that we can reduce time complexity.
     * - In this solution, we can calculate and store the max of left and right in an array.
     * - Then at last while iterating the array, we can calculate the final result.
     * - Space complexity - O(N), as storing of left and right max values require some space
     * - Time complexity - O(N), only one iteration of array is required each time i.e. maxLeft, maxRight, result
     */
    private static void approach2(int[] arr) {
        int n = arr.length;
        int waterStored = 0;
        // Space complexity - O(N)
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // store left max for each index
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) { // O(N)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        // store right max for each index
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) { // O(N)
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) { // O(N)
            // result is least among left and right max for each index minus that index value
            waterStored += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        // Time complexity - O(N) + O(N) + O(N) = O(3N) = O(N), excluding constants
        System.out.println("Approach 2: Max stored water capacity: " + waterStored);
    }

    /**
     * Approach 3 - Optimal solution:
     * - This solution is the most optimal one as it don't require any extra space.
     * - We can use the 2 pointer method to calculate and update left and right max value during storing result.
     * - The idea is to take 2 variables, keep at first and last index.
     * - Then create a while loop with condition of first <= last.
     * - Check if leftMax <= rightMax, do the calculation for left side and update first index value.
     * - Else do the same for right side.
     * - Space complexity - O(1), as only few variables are used that take constant auxiliary space.
     * - Time complexity - O(N), one iteration of loop is require, exactly it is O(N/2), but constant are removed.
     */
    private static void approach3(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                if (leftMax < arr[left]) {
                    leftMax = arr[left];
                } else {
                    waterTrapped += leftMax - arr[left];
                }
                left++;
            } else {
                if (rightMax < arr[right]) {
                    rightMax = arr[right];
                } else {
                    waterTrapped += rightMax - arr[right];
                }
                right--;
            }
        }
        System.out.println("Approach 3: Max stored water capacity: " + waterTrapped);
    }

}