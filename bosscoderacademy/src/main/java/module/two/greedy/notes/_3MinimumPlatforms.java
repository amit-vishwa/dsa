package module.two.greedy.notes;

import java.util.Arrays;

/**
 * Minimum Platforms:
 * <p>
 * Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required
 * for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive at the same day and leave on the same day. Arrival and departure times can never be the
 * same for a train, but we can have the arrival time of one train equal to the departure time of the other. At any given
 * instance of time, the same platform can not be used for both departures of a train and the arrival of another train.
 * In such cases, we need different platforms
 * <p>
 * Example:
 * Input: n = 6
 * arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
 * dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
 */
public class _3MinimumPlatforms {

    public static void main(String[] args) {
        printMinimumNumberOfPlatforms(new int[]{900, 940, 950, 1100, 1500, 1800},
                new int[]{910, 1200, 1120, 1130, 1900, 2000});
        printMinimumNumberOfPlatforms(new int[]{900, 1235, 1100},
                new int[]{1000, 1240, 1200});
        printMinimumNumberOfPlatforms(new int[]{1000, 935, 1100},
                new int[]{1200, 1240, 1130});
    }

    private static void printMinimumNumberOfPlatforms(int[] arr, int[] dep) {
        System.out.println("Minimum number of platforms required by approach1: " + approach1(arr, dep));
        System.out.println("Minimum number of platforms required by approach2: " + approach2(arr, dep));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - The approach is simple using nested loops.
     * - We have to iterate over arrival and departure both arrays.
     * - If current arrival is greater than or equal to next arrival and less than or equal to departure then increase platform.
     * - Update the max platform as well.
     * - Time complexity: O(N^2) due to nest loops.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr, int[] dep) {
        int minPlatforms = 0;
        for (int i = 0; i < arr.length; i++) {
            int platforms = 0;
            for (int j = 0; j < dep.length; j++) {
                if (arr[i] >= arr[j] && dep[j] >= arr[i]) {
                    platforms++;
                }
            }
            minPlatforms = Math.max(minPlatforms, platforms);
        }
        return minPlatforms;
    }

    /**
     * Approach 2 - Optimized
     * - This is an optimized approach using 2 pointer with Greedy.
     * - We are sorting the both arrays first.
     * - Then we are iterating over arrays, if arrival is less than or equal to departure then increase platform and check for
     * next arrival.
     * - Else decrease platforms and check for next departures.
     * - After this just update the max platform count.
     * - Time complexity: O(N*log(N)) due to sorting
     * - Space complexity: O(1) as no extra space is used.
     */
    private static int approach2(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, platforms = 0, maxPlatforms = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }

}
