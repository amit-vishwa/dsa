package module.one.sorting.one.notes;

import java.util.Arrays;

/**
 * Choose  array elements such that the difference between maximum and minimum<=k:
 * <p>
 * Choose  array elements such that the difference between maximum and minimum<=k
 * Select elements such that max-min<=k to find the maximum size possible.
 * <p>
 * Example
 * Input: n=7 arr[]={1,3,8,5,3,2,1},k=2
 * Output: 5
 * Explanation: 1,1,2,3,3 total elements 5
 */
public class _8MaxMinTillK {

    public static void main(String[] args) {
        printCount(new int[]{1, 3, 8, 5, 3, 2, 1}, 7, 2);
    }

    private static void printCount(int[] arr, int n, int k) {
        System.out.println("Element count by approach 1: " + approach1(arr, n, k));
        System.out.println("Element count by approach 2: " + approach2(arr, n, k));
        System.out.println();
    }

    private static int approach1(int[] arr, int n, int k) {
        int count = 0, i = 0, j = 0, maxCount = 0;
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        while (j < n) {
            if (sorted[j] - sorted[i] <= k) {
                j++;
                count++;
            } else {
                i++;
                maxCount = Math.max(maxCount, count);
                count--;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    private static int approach2(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int[] count = new int[arr[n - 1] + 1];
        for (int num : arr) {
            count[num]++;
        }
        int[] prefix = new int[arr[n - 1] + 1];
        prefix[0] = count[0];
        for (int i = 1; i <= arr[n - 1]; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }
        int i = 0, j = 0, c = 0, max = 0;
        while (j < n) {
            if (arr[j] - arr[i] <= k) {
                c = prefix[arr[j]] - (arr[i] > 0 ? prefix[arr[i] - 1] : 0);
                j++;
            } else {
                max = Math.max(c, max);
                c -= count[arr[i]];
                i++;
            }
        }
        max = Math.max(max, c);
        return max;
    }

}
