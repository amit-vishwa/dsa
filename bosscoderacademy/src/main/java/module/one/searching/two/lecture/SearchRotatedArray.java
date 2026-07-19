package module.one.searching.two.lecture;

/**
 * Find the given element in rotated sorted array:
 * Given a rotated array, find the index of the target element.
 * Example: arr = [30, 40, 50, 10, 20], target = 40, ans = 1.
 */
public class SearchRotatedArray {

    public static void main(String[] args) {
        printTargetIndex(new int[]{30, 40, 50, 10, 20}, 40);
        printTargetIndex(new int[]{40, 50, 10, 20, 30}, 40);
        printTargetIndex(new int[]{50, 10, 20, 30, 40}, 40);
        printTargetIndex(new int[]{50, 10, 20, 30, 40}, 400);
    }

    private static void printTargetIndex(int[] arr, int t) {
        System.out.println("Target element index by approach 1: " + approach1(arr, t));
        System.out.println("Target element index by approach 2: " + approach2(arr, t));
        System.out.println();
    }

    /**
     * Approach 1 - Linear search
     * - This is a simple Bruteforce approach where we are using the Linear Search algorithm to iterate over the array and
     * find the index of the target element.
     * - Time complexity: O(N) as it requires an array traversal.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach1(int[] arr, int t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2 - Binary search
     * - This is an optimal approach where we are using the Binary Search algorithm to find the target element index.
     * - The approach here is simple, we are first finding the pivot element index.
     * - Then checking if that is target, if yes then return pivot index.
     * - After that we are checking if target is greater than or equal to first element, if yes then we are performing
     * binary search on left part of the pivot element.
     * - Else we are searching in the pivot area.
     * - Time complexity: O(logN) as it is a simple binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach2(int[] arr, int t) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }
        int p = pivot(arr);
        if (arr[p] == t) {
            return p;
        }
        if (t >= arr[0]) {
            return binarySearch(arr, t, 0, p - 1);
        }
        return binarySearch(arr, t, p, n - 1);
    }

    private static int pivot(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }

    private static int binarySearch(int[] arr, int t, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == t) {
                return m;
            }
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}
