package module.one.searching.two.notes;

import java.util.Arrays;

/**
 * Aggressive Cows:
 * <p>
 * You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k
 * which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum
 * distance between any two of them is the maximum possible.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 5
 * k = 3
 * stalls = [1 2 4 8 9]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * - The first cow can be placed at stalls[0].
 * - The second cow can be placed at stalls[2].
 * - The third cow can be placed at stalls[3].
 * - The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
 * <p>
 * Refer: MaxOfMinForce.java from module.one.searching.two.lecture package as this problem is similar.
 */
public class _1AggressiveCows {

    public static void main(String[] args) {
        printMinDistance(5, 3, new int[]{1, 2, 4, 8, 9});
        printMinDistance(5, 3, new int[]{10, 1, 2, 7, 5});
        printMinDistance(6, 5, new int[]{2, 12, 11, 3, 26, 7});
    }

    private static void printMinDistance(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        System.out.println("Minimum distance that is maximum possible by approach 1: " + approach1(stalls, k, n));
        System.out.println("Minimum distance that is maximum possible by approach 2: " + approach2(stalls, k, n));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce approach
     * - This is a simple Bruteforce approach.
     * - We just have to iterate from difference between max and min stall till 1 in reverse order.
     * - And check for each distance whether the cows can be placed, if found any then return distance.
     * - Time complexity: O(Max-Min) for outer loop * O(N) check possible distance = O(N * (Max - Min)) + O(NlogN) for unsorted array
     * - Space complexity: O(1) as not extra space is used here.
     */
    private static int approach1(int[] stalls, int cows, int totalStalls) {
        for (int distance = stalls[totalStalls - 1] - stalls[0]; distance >= 1; distance--) {
            if (cowsCanBePlaced(stalls, cows, distance)) {
                return distance;
            }
        }
        return -1;
    }

    private static boolean cowsCanBePlaced(int[] stalls, int totalCows, int distance) {
        int cowsPlaced = 1, lastCowPlaced = stalls[0];
        for (int stall : stalls) {
            if (stall - lastCowPlaced >= distance) {
                lastCowPlaced = stall;
                cowsPlaced++;
                if (cowsPlaced == totalCows) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2 - Optimal approach
     * - This is an optimal approach where we are doing the similar checks as approach 1.
     * - But for finding the distance we are using the Binary Search algorithm.
     * - Time complexity: O(log(Max-Min)) for binary search * O(N) to check possible distance = O(log(Max-Min) * N) + O(NlogN) for unsorted array
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] stalls, int cows, int totalStalls) {
        int leftStall = 1, rightStall = stalls[totalStalls - 1] - stalls[0];
        while (leftStall <= rightStall) {
            int stall = leftStall + (rightStall - leftStall) / 2;
            if (cowsCanBePlaced(stalls, cows, stall)) {
                leftStall = stall + 1;
            } else {
                rightStall = stall - 1;
            }
        }
        return rightStall;
    }

}
