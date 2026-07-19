package module.one.sorting.two.homework;

/**
 * LeetCode 769. Max Chunks To Make Sorted
 * Refer: https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 */
public class _3MaxChunksSortedArray {

    public static void main(String[] args) {
        printChunksCount(new int[]{4, 3, 2, 1, 0});
        printChunksCount(new int[]{1, 0, 2, 3, 4});
    }

    private static void printChunksCount(int[] arr) {
        System.out.println("Max chunks to make array sorted by approach 1: " + approach1(arr));
        System.out.println("Max chunks to make array sorted by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1:
     * - This is the simple and most optimal solution.
     * - However, it only works with 0 to (N-1) or 1 to N range of numbers.
     * - We just have to consider max till now and check with index is max then increment counter.
     * - At last, just return the count.
     * - Time complexity: O(N)
     * - Space complexity: O(1)
     */
    private static int approach1(int[] arr) {
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

    /**
     * Approach 2:
     * - This is modified version of approach 2 to work with any numbers.
     * - Here, we have to consider the leftMax and rightMin of particular element.
     * - We have to create arrays to store left max and right min values.
     * - Ensure that first element of leftMax is -INF and last element of rightMin is last element.
     * - When leftMax <= rightMin then increment counter and at last just return the count.
     * - Time complexity: O(3N) as we are iterating array thrice = O(N)
     * - Space complexity: O(2N) for storing leftMax and rightMin values = O(N)
     */
    private static int approach2(int[] arr) {
        int n = arr.length, count = 0;
        int[] leftMax = new int[n];
        leftMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }
        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (leftMax[i] <= rightMin[i]) {
                count++;
            }
        }
        return count;
    }

}