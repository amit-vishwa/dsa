package module.one.searching.one.notes;

/**
 * Find Peak Element: [Leetcode 162. Find Peak Element]
 * <p>
 * A peak element is an element that is strictly greater than its neighbours. Given a 0-indexed integer array nums[],
 * find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * Example
 * <p>
 * Input:  nums = [1,2,3,1]
 * Output: 2
 */
public class _3PeakElement {

    public static void main(String[] args) {
        printPeakElement(new int[]{1, 2, 3, 1});
        printPeakElement(new int[]{1, 2, 3});
        printPeakElement(new int[]{3, 2, 1});
        printPeakElement(new int[]{3, 3, 3});
    }

    private static void printPeakElement(int[] arr) {
        System.out.println("Peak element by approach 1: " + approach1(arr));
        System.out.println("Peak element by approach 2: " + approach2(arr));
        System.out.println("Peak element by approach 3: " + approach3(arr));
        System.out.println();
    }

    /**
     * Approach 1 - Bruteforce
     * - A simple bruteforce approach where we are checking the max element and returning its index.
     * - Time complexity: O(N), Space complexity: O(1)
     */
    private static int approach1(int[] arr) {
        int peakElement = Integer.MIN_VALUE, index = 0, peakIndex = 0;
        for (int num : arr) {
            if (num > peakElement) {
                peakElement = num;
                peakIndex = index;
            }
            index++;
        }
        return peakIndex;
    }

    /**
     * Approach 2 - Better Bruteforce
     * - A simple bruteforce approach where we are checking any max element which is greater than its right neighbour
     * and returning its index.
     * - Time complexity: O(N), Space complexity: O(1)
     */
    private static int approach2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    /**
     * Approach 3 - Optimal
     * - This is the optimal approach where we are using the Binary Search algorithm.
     * - The logic is simple, we just have to find the mid-element and compare it with its right neighbour,
     * if it is greater, then definitely peak element will be in left so update r to m.
     * - If mid is less than mid + 1, then our peak element will lie in right side, so update l to mid + 1.
     * - Repeat the process until left and right both are equal.
     * - At last, both will have the index of peak element.
     * - Time complexity: O(logN) as it is simple binary search.
     * - Space complexity: O(1) as no extra space is used here.
     */
    private static int approach3(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r; // l and r both will point to mid i.e. answer
    }

}
