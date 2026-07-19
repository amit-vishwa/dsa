package module.one._1d_and_2d_array.assignment;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Rearrange Posneg Alternate:
 * <p>
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive
 * number is followed by a negative and vice-versa maintaining the order of appearance.
 * The number of positive and negative numbers need not be equal. If there are more positive numbers they appear
 * at the end of the array. If there are more negative numbers, they too appear at the end of the array.
 * <p>
 * Input: arr[] = {1, 2, 3, -4, -1, 4}
 * Output: arr[] = {-4, 1, -1, 2, 3, 4}
 * <p>
 * Input: arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 * <p>
 * Constraints:
 * 1<=N<=105
 * -105<=A[i]<=105
 */
public class _12RearrangeNegativeAlternatively {

    public static void main(String[] args) {
        System.out.println("Sorted array: " + Arrays.toString(sort(new int[]{1, 2, 3, -4, -1, 4})));
        System.out.println("Sorted array: " + Arrays.toString(sort(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8})));
    }

    /**
     * Approach:
     * - Create two array lists to store positive and negatives from given array by traversing once.
     * - Now create a result array that will have updated values, here just simple add negative first then
     * - positive, repeat this alternatively until positives or negatives are exhausted.
     * - Then add all remaining positives and negatives, if any, to the result array.
     * - Time and space complexity: O(N)
     */
    private static int[] sort(int[] input) {
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        for (int num : input) {
            if (num < 0) {
                negList.add(num);
            } else {
                posList.add(num);
            }
        }
        int[] sorted = new int[posList.size() + negList.size()];
        int i = 0, j = 0, k = 0;
        while (i < posList.size() && j < negList.size()) {
            // here, value of k is getting updated first hence odd even is reversed
            sorted[k++] = k % 2 != 0 ? negList.get(j++) : posList.get(i++);
        }
        while (i < posList.size()) {
            sorted[k++] = posList.get(i++);
        }
        while (j < negList.size()) {
            sorted[k++] = negList.get(j++);
        }
        return sorted;
    }

}