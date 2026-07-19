package module.two._2pointers.notes;

/**
 * Maximum water that can be stored between two buildings:
 * <p>
 * Given an integer array that represents the heights of N buildings. The task is to delete N – 2 buildings such that the water
 * that can be trapped between the remaining two buildings is maximum. The total water trapped between two buildings is a gap
 * between them (the number of buildings removed) multiplied by the height of the smaller building.
 * Example
 * Input: n=1, arr[] = {1, 3, 4}
 * Output: 1
 */
public class _5MaxWaterStored {

    public static void main(String[] args) {
        printMaxStorage(new int[]{1, 3, 4});
    }

    private static void printMaxStorage(int[] arr) {
        System.out.println("Maximum water stored by approach 1: " + approach1(arr));
        System.out.println("Maximum water stored by approach 2: " + approach2(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - Check for all possible pairs and the pair which can hold the maximum water will be the answer.
     * - Water stored between two buildings of heights h1 and h2 would be equal to the minimum(h1, h2)*(distance between the
     * buildings – 1), maximize this value to get the answer.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr) {
        int maxStorage = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int width = j - i - 1;
                int height = Math.min(arr[i], arr[j]);
                int storage = height * width;
                maxStorage = Math.max(maxStorage, storage);
            }
        }
        return maxStorage;
    }

    /**
     * Approach 2 - Optimal
     * - Take two pointers i and j pointing to the first and the last building respectively and calculate the water that can be
     * stored between these two buildings.
     * - Now increment I if height[i] < height[j] else decrement j.
     * - This is because the water that can be trapped is dependent on the height of the small building and moving from the
     * greater height building will just reduce the amount of water instead of maximising it.
     * - In the end, print the maximum amount of water calculated so far.
     * - Time complexity: O(N) as we are iterating over the array only once.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] arr) {
        int maxStorage = Integer.MIN_VALUE, l = 0, r = arr.length - 1;
        while (l < r) {
            int width = r - (l + 1);
            int height = Math.min(arr[l], arr[r]);
            int storage = height * width;
            maxStorage = Math.max(maxStorage, storage);
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxStorage;
    }

}
