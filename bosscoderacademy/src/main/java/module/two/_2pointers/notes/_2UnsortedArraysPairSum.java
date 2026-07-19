package module.two._2pointers.notes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two unsorted arrays, find all pairs whose sum is x:
 * <p>
 * Given two unsorted arrays of distinct elements, the task is to find any pair from both arrays whose sum is equal to X.
 * Example
 * Input:  arr1[] = {-1, -2, 4, -6, 5, 7}
 * arr2[] = {6, 3, 4, 0}
 * x = 8
 * Output :
 * 4 4 5 3
 */
public class _2UnsortedArraysPairSum {

    public static void main(String[] args) {
        printPairs(new int[]{-1, -2, 4, -6, 5, 7}, new int[]{6, 3, 4, 0}, 8);
    }

    private static void printPairs(int[] arr1, int[] arr2, int x) {
        System.out.println("Pairs by approach 1: " + approach1(arr1, arr2, x));
        System.out.println("Pairs by approach 2: " + approach2(arr1, arr2, x));
    }

    /**
     * Approach 1 - Bruteforce
     * - The approach is quite simple.
     * - We just have to iterate over both arrays and check the pair sum.
     * - If it is equal to given x, then we are adding the pairs in a list.
     * - Time complexity: O(N^2) due to nested loops.
     * - Space complexity: O(1) as no extra space is used here, list is just for returning the result.
     */
    private static ArrayList<ArrayList<Integer>> approach1(int[] arr1, int[] arr2, int x) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] + arr2[j] == x) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(arr1[i]);
                    pair.add(arr2[j]);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    /**
     * Approach 2 - Better approach
     * - We have a better approach than above bruteforce one.
     * - Here, we are sorting both arrays first.
     * - Then we are iterating the first array from left and second from right, it can be vice versa.
     * - Here we are checking for each pair whose sum is x.
     * - If we get a pair, we are adding that to the list by updating both pointers, if sum is less, then left pointer is
     * increased else right is decreased.
     * - Time complexity: O(max(N*logN, M*logM)) for sorting both arrays + O(max(N,M)) for 2 pointers
     * = O(max(N*logN, M*logM)) after ignoring lower complexities
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static ArrayList<ArrayList<Integer>> approach2(int[] arr1, int[] arr2, int x) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0, j = arr2.length - 1; i < arr1.length && j >= 0; ) {
            int sum = arr1[i] + arr2[j];
            if (sum == x) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr1[i]);
                pair.add(arr2[j]);
                pairs.add(pair);
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }

}
